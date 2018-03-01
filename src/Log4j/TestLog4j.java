package Log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yejunyu
 * @date 18-3-1.
 */
public class TestLog4j {
    static Logger logger = LogManager.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
