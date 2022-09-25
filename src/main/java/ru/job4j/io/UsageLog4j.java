package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean isCorrect = true;
        char symbol = 'A';
        int intNum = 333999;
        short shortNum = 359;
        byte byteNum = 1;
        float floatNum = 4.9876f;
        double doubleNum = 456.34242d;
        long longNum = 123456789L;

        LOG.debug("Info boolean : {}", isCorrect);
        LOG.debug("Info char : {}", symbol);
        LOG.debug("Info int : {}", intNum);
        LOG.debug("Info short : {}", shortNum);
        LOG.debug("Info byte : {}", byteNum);
        LOG.debug("Info float : {}", floatNum);
        LOG.debug("Info double : {}", doubleNum);
        LOG.debug("Info long : {}", longNum);
    }
}
