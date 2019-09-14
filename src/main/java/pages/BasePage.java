package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {

    protected final Logger logger = LogManager.getRootLogger();

    public BasePage() {
        waitForPageToBeLoaded();
    }

    protected abstract void waitForPageToBeLoaded();
}
