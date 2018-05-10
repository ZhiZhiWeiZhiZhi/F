package com.f.test;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Created by F on 2016/11/28 14:15.
 */
public class Log4jTest extends BaseTest {
    @Test
    public void printLog() {
        Logger logger = Logger.getLogger(Log4jTest.class);
        // DEBUG、INFO、WARN、ERROR、FATAL
        logger.debug("this is debug");
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is error");
        logger.fatal("this is fatal");
    }
}
