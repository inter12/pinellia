package com.inter12.pinellia.common.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class CommonServiceLocator extends SpringObjFactory {

    public static ThreadPoolTaskExecutor getThreadPools() {
        return getBean("commonThreadPool");
    }

}
