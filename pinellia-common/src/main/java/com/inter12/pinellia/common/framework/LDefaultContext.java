package com.inter12.pinellia.common.framework;

import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class LDefaultContext {

    private final Logger                logger     = Logger.getLogger(LDefaultContext.class.getName());

    public static final String          USER_ID    = "userId";
    static ThreadLocal<LDefaultContext> contexts   = new ThreadLocal<LDefaultContext>();
    private Map<String, Object>         paramMap   = new HashMap<String, Object>();
    private Map<String, Object>         resultMap  = new HashMap<String, Object>();
    private List<LProcessor>            processors = new ArrayList<LProcessor>();

    public LDefaultContext(int userId) {
        paramMap.put(USER_ID, userId);
        setContext(this);
    }

    public LDefaultContext() {
    }

    public static LDefaultContext getContext() {
        return (LDefaultContext) contexts.get();

    }

    public static void setContext(LDefaultContext context) {
        contexts.set(context);
    }

    public Integer getUserId() {
        Object userId = paramMap.get(USER_ID);
        return null == userId ? null : (Integer) userId;
    }

    public void setContextMap(Map<String, Object> contextMap) {
        getContext().paramMap = contextMap;
    }

    public Object getParam(String key) {
        return paramMap.get(key);
    }

    public void setParam(String key, Object value) {
        paramMap.put(key, value);
    }

    public int getTotalCount() {
        return processors.size();
    }

    public void addResult(String key, Object value) {
        resultMap.put(key, value);
    }

    public Iterator<LProcessor> processorsIterator() {

        logger.info("total processor size:" + processors.size());
        return processors.iterator();
    }

    public LDefaultContext addLProcessor(LProcessor lProcessor) {
        processors.add(lProcessor);
        return this;
    }

    public Set<Entry<String, Object>> resultEntrySet() {

        logger.info("total result size:" + resultMap.size());
        return resultMap.entrySet();
    }

}
