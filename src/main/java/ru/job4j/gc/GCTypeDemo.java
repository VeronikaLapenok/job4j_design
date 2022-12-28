package ru.job4j.gc;

import java.util.Random;

/**
 * -Xlog:gc*
 * - Serial => -XX:+UseSerialGC
 *
 * - Parallel => -XX:+UseParallelGC
 *
 * - CMS => -XX:+UseConcMarkSweepGC (доступен до JDK 14)
 *
 * - G1 => -XX:+UseG1GC
 *
 * - ZGC => -XX:+UseZGC
 */
public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}
