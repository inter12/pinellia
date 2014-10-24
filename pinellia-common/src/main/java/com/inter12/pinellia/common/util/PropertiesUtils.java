package com.inter12.pinellia.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <pre>
 * Created by zhaoming on 14-5-30 上午11:27
 * </pre>
 */
public abstract class PropertiesUtils {

    // private static final String linuxPropertiesDir = "/home/admin/im-config/im-server.properties";
    // private static final String windowsPropertiesDir = "C:\\im-config/im-server.properties";

    public static final String DEFAULT_APPLICATION_FILE_PATH = "config.properties";

    public static Properties getPropertiesByClasspath(String fileName) throws IOException {
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(fileName);

        Properties properties = new Properties();
        // properties.load(new FileInputStream(ResourceUtils.getFile(fileName)));
        properties.load(systemResourceAsStream);

        return properties;
    }

    public static Properties getPropertiesByFile(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(fileName)));
        return properties;
    }

}
