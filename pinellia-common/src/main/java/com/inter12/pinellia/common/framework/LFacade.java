package com.inter12.pinellia.common.framework;

/**
 * 外观的门面
 * 
 * @author inter12
 */
public class LFacade {

    private static LFacade instance = new LFacade();

    private LFacade() {

    }

    public static LFacade getInstance() {
        return instance;
    }

    private static LManager manager = new LManager();

    public void invoke(LDefaultContext context) throws Exception {
        manager.execute(context);
    }

    public void invokeUnlimit(LDefaultContext context) throws Exception {
        manager.executeUnlimit(context);
    }

}
