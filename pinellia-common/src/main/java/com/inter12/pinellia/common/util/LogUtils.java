package com.inter12.pinellia.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

/**
 * <pre>
 * Created by zhaoming on 14-5-29 下午7:25
 * 日志初始化的工具类
 * </pre>
 */
public abstract class LogUtils {

    /**
     * 初始化日志信息
     */
    public static void initLogback(String path) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            lc.reset();
            configurator.setContext(lc);
            configurator.doConfigure(ResourceUtils.getURL(path));
        } catch (Exception je) {
            je.printStackTrace();
        }

    }

    public static void initLog4j(String path) {

        try {
            PropertyConfigurator.configure(ResourceUtils.getURL(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // URL url = ResourceUtils.getURL("classpath:Logback.xml");

        // URL url = ResourceUtils.getURL("classpath:log/log4j.properties");
        // LogUtils.initLog4j("log/log4j.properties");
        LogUtils.initLogback("classpath:log/Logback.xml");
        LogUtils.initLog4j("classpath:log/lo4j.properties");

    }
}
