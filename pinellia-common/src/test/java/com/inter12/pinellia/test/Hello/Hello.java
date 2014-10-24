package com.inter12.pinellia.test.Hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Created by xuezhaoming-inter12 on 14-10-24.下午1:48
 * </pre>
 */
public class Hello {

    private Logger logger = LoggerFactory.getLogger("trace");

    public void sayHi() {
        logger.info("start execute sayHi method!");

        System.out.println("hello world!");

        logger.info("end  execute sayHi method!");
    }
}
