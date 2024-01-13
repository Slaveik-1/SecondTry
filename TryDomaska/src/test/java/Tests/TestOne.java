package Tests;

import Base.TestBase;
import org.testng.annotations.Test;
import utils.foodType;


@Test (priority = 1)
public class TestOne extends TestBase {
    public void runTest() throws InterruptedException {
        pageManager.getHomeInstance() //+
                .assertPageTitle()  //+
                .goToGoods()
                .assertPageTitle()
                .addItem("Цукини#$/", foodType.VEGETABLE, true)
                .resetData()
                .goHome()
                .assertPageTitle();
    }
}