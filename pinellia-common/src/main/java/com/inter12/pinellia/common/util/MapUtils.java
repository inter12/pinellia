package com.inter12.pinellia.common.util;

import java.util.Map;

public class MapUtils {

    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map) {

        if (map == null || map.isEmpty()) {
            return false;
        }

        return true;
    }

}
