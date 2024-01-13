package pages;

import org.testng.Assert;

public class PageHome extends BasePage{

    public PageGoods goToGoods() {
        waitClic(sandBox).click();
        waitClic(goodsButton).click();

        return pageManager.getGoodsInstance();
    }

    public PageHome assertPageTitle() {
        Assert.assertEquals(home.getText(), "QualIT","Invalid page title / Incorrect page opened");
        return this;
    }

}
