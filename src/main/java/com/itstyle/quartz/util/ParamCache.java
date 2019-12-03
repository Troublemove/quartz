package com.itstyle.quartz.util;
/**
 * 存储推送软件的待执行操作
 * @ClassName: ParamCache.java
 * @Description:TODO
 * @version v1.0
 * @Date 2018年10月22日
 * @author libertymc
 */

import java.util.Map;

public class ParamCache {
    
    //内部类
    private static class ParamCacheHandler{
        private static ParamCache paramCache = new ParamCache();
    }
    
    // 构造函数
    private ParamCache() {}
    
    public static ParamCache getInstance() {
        return ParamCacheHandler.paramCache;
    }
    
    // key:被推送设备ip  value:待执行操作(下载、解压、移动文件、执行脚本、生成快捷方式等)
    Map<String, Object> paramMap = null;
    
    // key:被推送设备ip  value:软件编号和sys_agentlog的主键的键值对
    Map<String, Object> idMap = null;
    
    public Map<String, Object> getParamCache(){
        return paramMap;
    }
    
    public void setParamCache(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getIdMap() {
        return idMap;
    }

    public void setIdMap(Map<String, Object> idMap) {
        this.idMap = idMap;
    }
    
    
}
