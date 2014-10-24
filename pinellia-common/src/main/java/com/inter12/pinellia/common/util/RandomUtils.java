package com.inter12.pinellia.common.util;

import java.util.Random;

/**
 * <pre>
 * Created by zhaoming on 14-6-23 下午2:13
 * </pre>
 */
public abstract class RandomUtils {

    public static int randomInt(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            long jj = randomInt(10);
            System.out.println(jj);
        }
    }
}
