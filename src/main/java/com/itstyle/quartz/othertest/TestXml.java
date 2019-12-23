package com.itstyle.quartz.othertest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.alibaba.fastjson.JSONObject;

/**
 * XML解析
 */
public class TestXml {
	public static Map<String, String> protoMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Protocol id=\"{70badc18-8f7e-438d-95c6-f0e6179cec04}\">\r\n" + "  <Command>\r\n"
				+ "    <baseProtocolInfo>\r\n" + "      <namezh>aaaa</namezh>\r\n" + "      <name>aaaa</name>\r\n"
				+ "      <type>aaaa</type>\r\n" + "      <id>{70badc18-8f7e-438d-95c6-f0e6179cec04}</id>\r\n"
				+ "      <maxOrderNo>11</maxOrderNo>\r\n" + "      <length>15</length>\r\n"
				+ "      <datetime>空</datetime>\r\n" + "      <constraint />\r\n" + "      <idents />\r\n"
				+ "    </baseProtocolInfo>\r\n" + "    <setList>\r\n" + "      <set>\r\n"
				+ "        <id>xf349d435274c43ff96b2ca424368d9d4</id>\r\n" + "        <repeat>1</repeat>\r\n"
				+ "        <orderNo>0</orderNo>\r\n" + "      </set>\r\n" + "    </setList>\r\n"
				+ "    <parent>m_sParentId</parent>\r\n" + "    <children>\r\n"
				+ "      <child>m_sChildrenID</child>\r\n" + "    </children>\r\n"
				+ "    <defaultmsg1>00000065 00000066 0067 68 00000069</defaultmsg1>\r\n"
				+ "    <defaultmsg>ffffff9b00000066ff999800000069</defaultmsg>\r\n" + "  </Command>\r\n"
				+ "  <set id=\"xf349d435274c43ff96b2ca424368d9d4\">\r\n" + "    <baseInfo>\r\n"
				+ "      <name>eeee</name>\r\n" + "      <note />\r\n" + "      <type />\r\n"
				+ "      <maxOrderNo>5</maxOrderNo>\r\n" + "      <length>15</length>\r\n" + "      <constraint />\r\n"
				+ "      <repeat>1</repeat>\r\n" + "    </baseInfo>\r\n" + "    <fields>\r\n"
				+ "      <field key=\"a\">\r\n" + "        <orderNo>0</orderNo>\r\n" + "        <key>a</key>\r\n"
				+ "        <fieldDescripId />\r\n" + "        <note />\r\n" + "        <fieldType>int</fieldType>\r\n"
				+ "        <size>1</size>\r\n" + "        <bitFilled>0</bitFilled>\r\n"
				+ "        <fieldLength>4</fieldLength>\r\n" + "        <fieldStartByte>0</fieldStartByte>\r\n"
				+ "        <defaultValue>101</defaultValue>\r\n" + "        <judge>0</judge>\r\n"
				+ "        <FieldSituationType>0</FieldSituationType>\r\n" + "        <info />\r\n"
				+ "      </field>\r\n" + "      <field key=\"b\">\r\n" + "        <orderNo>1</orderNo>\r\n"
				+ "        <key>b</key>\r\n" + "        <fieldDescripId>-b</fieldDescripId>\r\n"
				+ "        <note />\r\n" + "        <fieldType>uint</fieldType>\r\n" + "        <size>1</size>\r\n"
				+ "        <bitFilled>0</bitFilled>\r\n" + "        <fieldLength>4</fieldLength>\r\n"
				+ "        <fieldStartByte>4</fieldStartByte>\r\n" + "        <defaultValue>102</defaultValue>\r\n"
				+ "        <judge>0</judge>\r\n" + "        <FieldSituationType>0</FieldSituationType>\r\n"
				+ "        <info />\r\n" + "      </field>\r\n" + "      <field key=\"c\">\r\n"
				+ "        <orderNo>2</orderNo>\r\n" + "        <key>c</key>\r\n"
				+ "        <fieldDescripId>-c</fieldDescripId>\r\n" + "        <note />\r\n"
				+ "        <fieldType>short</fieldType>\r\n" + "        <size>1</size>\r\n"
				+ "        <bitFilled>0</bitFilled>\r\n" + "        <fieldLength>2</fieldLength>\r\n"
				+ "        <fieldStartByte>8</fieldStartByte>\r\n" + "        <defaultValue>103</defaultValue>\r\n"
				+ "        <judge>0</judge>\r\n" + "        <FieldSituationType>0</FieldSituationType>\r\n"
				+ "        <info />\r\n" + "      </field>\r\n" + "      <field key=\"d\">\r\n"
				+ "        <orderNo>3</orderNo>\r\n" + "        <key>d</key>\r\n"
				+ "        <fieldDescripId>-d</fieldDescripId>\r\n" + "        <note />\r\n"
				+ "        <fieldType>char</fieldType>\r\n" + "        <size>1</size>\r\n"
				+ "        <bitFilled>0</bitFilled>\r\n" + "        <fieldLength>1</fieldLength>\r\n"
				+ "        <fieldStartByte>10</fieldStartByte>\r\n" + "        <defaultValue>104</defaultValue>\r\n"
				+ "        <judge>0</judge>\r\n" + "        <FieldSituationType>0</FieldSituationType>\r\n"
				+ "        <info />\r\n" + "      </field>\r\n" + "      <field key=\"e\">\r\n"
				+ "        <orderNo>4</orderNo>\r\n" + "        <key>e</key>\r\n"
				+ "        <fieldDescripId>-e</fieldDescripId>\r\n" + "        <note />\r\n"
				+ "        <fieldType>long</fieldType>\r\n" + "        <size>1</size>\r\n"
				+ "        <bitFilled>0</bitFilled>\r\n" + "        <fieldLength>4</fieldLength>\r\n"
				+ "        <fieldStartByte>11</fieldStartByte>\r\n" + "        <defaultValue>105</defaultValue>\r\n"
				+ "        <judge>0</judge>\r\n" + "        <FieldSituationType>0</FieldSituationType>\r\n"
				+ "        <info />\r\n" + "      </field>\r\n" + "    </fields>\r\n" + "  </set>\r\n"
				+ "  <fieldDesciptionDict />\r\n" + "  <formulas>\r\n" + "    <formula>\r\n"
				+ "      <name>newFormulas1</name>\r\n" + "      <inputs />\r\n" + "      <outputs />\r\n"
				+ "      <formulaStr />\r\n" + "    </formula>\r\n" + "  </formulas>\r\n" + "</Protocol>\r\n" + "\r\n"
				+ "";
		protoMap.put("xmlProto", s);
		TestXml t = new TestXml();
		String protomsg = "0000006500000066006768ffffd6fc";
		String path = "C:\\Users\\ZHANGJX\\Desktop\\rong.xml";
		String p = t.getProto(path, "xmlProto", protoMap, protomsg);
		System.out.println(p);

	}

	/**
	 * 解析报文
	 * 
	 * @param path     xml文件路径
	 * @param protomsg 报文
	 * @throws Exception
	 */
	public String getProto(String path, String mapKey, Map<String, String> protoMap, String protomsg) {
		Map<String, String> resMap = new HashMap<String, String>();
		List<Map<Object, Object>> proto = new ArrayList<Map<Object, Object>>();
		if (protoMap != null) {
			if (protoMap.size() > 0 && protoMap.get(mapKey) != null) {
				System.out.println("使用  Map  规则");
				proto = getProtoRule(protoMap.get(mapKey));
			} else {
				System.out.println("使用  文件  规则");
				String fileProto = getFileProto(path, "UTF-8");
				proto = getProtoRule(fileProto);
				protoMap.put(mapKey, fileProto);
			}
			if (!proto.isEmpty()) {
				for (Map<Object, Object> map : proto) {
					// boolean postive = !((String) map.get("fieldDescripId")).trim().contains("-");
					String key = (String) map.get("key");
					String value = "";
					String type = (String) map.get("fieldType");
					int length = Integer.parseInt((String) map.get("fieldLength"));
					int startbyte = Integer.parseInt((String) map.get("fieldStartByte"));
					String m = protomsg.substring(startbyte * 2, (startbyte + length) * 2);
					// System.out.println(m);

					if (type.contains("int")) {
						BigInteger bi = new BigInteger(m, 16);
						int intVal = bi.intValue();
						value = String.valueOf(intVal);
						// System.out.println(bi.intValue());
					} else if (type.equals("short")) {
						// System.out.println(byte2short(toByteArray(m)));
						short shortVal = byte2short(toByteArray(m));
						value = String.valueOf(shortVal);
					} else if (type.equals("char")) {
						// System.out.println(toByteArray(m)[0]);
						value = String.valueOf(toByteArray(m)[0]);
					} else if (type.equals("long")) {
						// 4个字节最多为2^32 -1 ，int的最大值
						BigInteger bi = new BigInteger(m, 16);
						long longVal = bi.intValue();
						value = String.valueOf(longVal);
						// System.out.println(bi.intValue());
					}
					resMap.put(key, value);
				}
			}
		}

		return JSONObject.toJSONString(resMap);
	}

	private static short byte2short(byte[] b) {
		short l = 0;
		for (int i = 0; i < 2; i++) {
			l <<= 8; // <<=和我们的 +=是一样的，意思就是 l = l << 8
			l |= (b[i] & 0xff); // 和上面也是一样的 l = l | (b[i]&0xff)
		}
		return l;
	}

	private static byte[] toByteArray(String hexString) {
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
	 * hex转byte数组 也能用
	 * 
	 * @param hex
	 * @return
	 */
	// private static byte[] hexToByte(String hex) {
	// int m = 0, n = 0;
	// int byteLen = hex.length() / 2; // 每两个字符描述一个字节
	// byte[] ret = new byte[byteLen];
	// for (int i = 0; i < byteLen; i++) {
	// m = i * 2 + 1;
	// n = m + 1;
	// int intVal = Integer.decode("0x" + hex.substring(i * 2, m) + hex.substring(m,
	// n));
	// ret[i] = Byte.valueOf((byte) intVal);
	// }
	// return ret;
	// }

	/**
	 * 解析字符串规则
	 * 
	 * @param xmlProto
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<Map<Object, Object>> getProtoRule(String xmlProto) {
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(new StringReader(xmlProto));			
			// 获取根节点
			Element rootElement = document.getRootElement();
			// 获取子节点
			List<Element> children = rootElement.getChildren();
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
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 从文件获取报文解析规则
	 * @param path xml文件路径
	 * @param encode xml文件编码
	 * @return
	 */
	private String getFileProto(String path, String encode) {
		String resStr = "";
		InputStream isFile = null;
		ByteArrayOutputStream bo = null;
		try {
			// 1.创建SAXBuilder对象
			SAXBuilder saxBuilder = new SAXBuilder();
			// 2.创建输入流
			isFile = new FileInputStream(new File(path));
			// 3.将输入流加载到build中
			Document document = saxBuilder.build(isFile);
			Format format = Format.getCompactFormat();
			format.setEncoding(encode);// 设置xml文件的字符为UTF-8，解决中文问题
			XMLOutputter xmlout = new XMLOutputter();
			bo = new ByteArrayOutputStream();
			xmlout.output(document, bo);
			resStr = bo.toString().trim();
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isFile != null) {
					isFile.close();
				}
				if (bo != null) {
					bo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resStr;
	}
}
