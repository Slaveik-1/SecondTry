package Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import managers.DriverManager;
import managers.InitManager;
import managers.PageManager;
import managers.PropManager;
import utils.Const.*;

import static utils.Const.BASE_URL;

public class TestBase {
    private final DriverManager driverManager = DriverManager.getDriverInstance();

    protected PageManager pageManager = PageManager.getPageManagerInstance();

    @BeforeClass
    public static void beforeAll() {
        InitManager.init();
    }

    @BeforeTest
    public void beforeEach() {
        driverManager.getDriver().get(PropManager.getPropInstance().getProp(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quit();
    }

}

