package github.dev.xero.config;

import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void info(String msg) {
        logger.info(msg);
    }
}
