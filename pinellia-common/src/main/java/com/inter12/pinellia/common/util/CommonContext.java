package com.inter12.pinellia.common.util;

import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: zhaoming Date: 13-6-9 Time: 下午5:13 To change this template use File | Settings |
 * File Templates.
 */
public class CommonContext {

    static ThreadLocal  actionContext = new ThreadLocal();

    Map<String, Object> context;

    public static CommonContext getContext() {
        return (CommonContext) actionContext.get();

    }

    public static void setContext(CommonContext context) {
        actionContext.set(context);
    }

    public void setContextMap(Map<String, Object> contextMap) {
        getContext().context = contextMap;
    }

    public Map<String, Object> getContextMap() {
        return context;
    }

    public Object get(String key) {
        return context.get(key);
    }

    public void put(String key, Object value) {
        context.put(key, value);
    }

}
