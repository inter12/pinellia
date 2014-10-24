package com.inter12.pinellia.test;

import com.inter12.pinellia.common.util.LogUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.inter12.pinellia.test.Hello.Hello;

/**
 * <pre>
 * Created by xuezhaoming-inter12 on 14-10-24.下午1:41
 * </pre>
 */
@ContextConfiguration(locations = "classpath:spring-context-test.xml")
public class BaseTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private Hello hello;

    @Before
    public void init() {

    }

    @Test
    public void testspring() {

        LogUtils.initLog4j("classpath:log/lo4j.properties");
        hello.sayHi();
    }
}
