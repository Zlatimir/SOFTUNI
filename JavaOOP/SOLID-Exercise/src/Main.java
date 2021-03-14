import controllers.ConsoleAppender;
import controllers.SimpleLayout;
import interfaces.Appender;
import interfaces.Layout;
import logger.Logger;
import logger.MessageLogger;

/**
 * Created by Zlatimir Ivanov on 14.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

    }
}
