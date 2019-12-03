package com.itstyle.quartz.othertest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.alibaba.fastjson.JSONObject;

/**
 * XML解析
 */
public class TestXml {
	public static void main(String[] args) throws Exception {
		TestXml t = new TestXml();
		String protomsg = "0000006500000066006768ffffd6fc";
		String path = "C:\\Users\\ZHANGJX\\Desktop\\rong.xml";
		String p = t.getProto(path, protomsg);
		System.out.println(p);
	}
	
	/**
	 * 解析报文
	 * @param path xml文件路径
	 * @param protomsg 报文
	 * @throws Exception
	 */
	public String getProto(String path, String protomsg) throws Exception {
		List<Map<Object, Object>> proto = getProtoRule(path);
		Map<String, String> resMap = new HashMap<String, String>();
		if (!proto.isEmpty()) {
			for (Map<Object, Object> map : proto) {
//				boolean postive = !((String) map.get("fieldDescripId")).trim().contains("-");
				String key = (String) map.get("key");
				String value = "";
				String type = (String) map.get("fieldType");
				int length = Integer.parseInt((String) map.get("fieldLength"));
				int startbyte = Integer.parseInt((String) map.get("fieldStartByte"));
				String m = protomsg.substring(startbyte * 2, (startbyte + length) * 2);
//				System.out.println(m);

				if (type.contains("int")) {
					BigInteger bi = new BigInteger(m, 16);
					int intVal = bi.intValue();
					value = String.valueOf(intVal);
//					System.out.println(bi.intValue());
				} else if (type.equals("short")) {
//					System.out.println(byte2short(toByteArray(m)));
					short shortVal = byte2short(toByteArray(m));
					value = String.valueOf(shortVal);
				} else if (type.equals("char")) {
//					System.out.println(toByteArray(m)[0]);
					value = String.valueOf(toByteArray(m)[0]);
				} else if (type.equals("long")) {
					// 4个字节最多为2^32 -1 ，int的最大值
					BigInteger bi = new BigInteger(m, 16);
					long longVal = bi.intValue();
					value = String.valueOf(longVal);
//					System.out.println(bi.intValue());
				}
				resMap.put(key, value);
			}
		}
		
		return JSONObject.toJSONString(resMap);
	}
	
	public static short byte2short(byte[] b) {
		short l = 0;
		for (int i = 0; i < 2; i++) {
			l <<= 8; // <<=和我们的 +=是一样的，意思就是 l = l << 8
			l |= (b[i] & 0xff); // 和上面也是一样的 l = l | (b[i]&0xff)
		}
		return l;
	}

	public static byte[] toByteArray(String hexString) {
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * hex转byte数组
	 * 也能用
	 * @param hex
	 * @return
	 */
//	private static byte[] hexToByte(String hex) {
//		int m = 0, n = 0;
//		int byteLen = hex.length() / 2; // 每两个字符描述一个字节
//		byte[] ret = new byte[byteLen];
//		for (int i = 0; i < byteLen; i++) {
//			m = i * 2 + 1;
//			n = m + 1;
//			int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m, n));
//			ret[i] = Byte.valueOf((byte) intVal);
//		}
//		return ret;
//	}


	/**
	 * 获取报文以及报文规则
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<Map<Object, Object>> getProtoRule(String path) throws Exception {
		// 1.创建SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();
		// 2.创建输入流
		InputStream is = new FileInputStream(new File(path));
		// 3.将输入流加载到build中
		Document document = saxBuilder.build(is);
		// 4.获取根节点
		Element rootElement = document.getRootElement();
		// 5.获取子节点
		List<Element> children = rootElement.getChildren();
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
//		List<Object> resList = new ArrayList<Object>();
		for (Element child : children) {
			List<Element> childrenList = child.getChildren();
			for (Element fields : childrenList) {
				if ("fields".equals(fields.getName())) {
					List<Element> fieldList = fields.getChildren();
					for (Element e : fieldList) {// 第三层取值
						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						for (Object element : e.getContent()) {// 最后取值
							if (element instanceof Element) {
								map.put(((Element) element).getName(), ((Element) element).getText());
							}
						}
						list.add(map);
					}
				} else if ("defaultmsg".equals(fields.getName())) {
				}
			}
		}
		return list;
	}
}
