package com.inter12.pinellia.common.util;

import org.springframework.util.Assert;

public abstract class CheckUtils {

    public static void nullCheck(Object... param) {
        for (Object p : param) {
            Assert.notNull(p, "[Assertion failed] - this argument " + p + " is required; it must not be null");
        }
    }

    public static void zeroCheck(int... param) {
        for (int value : param) {
            if (value == 0) {
                throw new IllegalArgumentException(
                                                   "[Assertion failed] - this argument is required; it must not be null");
            }
        }
    }
}
