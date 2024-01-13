package managers;

import utils.Const;
import java.util.concurrent.TimeUnit;

public class InitManager {

    private static final DriverManager driverManager = DriverManager.getDriverInstance();


    private static final PropManager propManager = PropManager.getPropInstance();

    public static void init() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(propManager.getProp(Const.IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(propManager.getProp(Const.LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }

    public static void quit() {

        driverManager.quitDriver();
    }
}