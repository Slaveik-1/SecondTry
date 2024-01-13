package Tests;

import Base.TestBase;
import org.testng.annotations.Test;
import utils.foodType;

@Test (priority = 2)
    public class TestTwo extends TestBase {
        public void runTest() throws InterruptedException {
            pageManager.getHomeInstance()
                    .assertPageTitle()
                    .goToGoods()
                    .assertPageTitle()
                    .addItem("Груша256/", foodType.FRUIT, false)
                    .resetData()
                    .goHome()
                    .assertPageTitle();
        }
    }

