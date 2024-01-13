package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import utils.foodType;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static managers.DriverManager.driver;

public class PageGoods extends BasePage {

    @FindBy(xpath = "//a[@class='dropdown-item'][@id='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//*[text()='Добавить']")
    private WebElement add;

    @FindBy(xpath = "//div[@class='container-fluid']/*[1]")
    private WebElement goodsTitle;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameI;

    @FindBy(xpath = "//select[@id='type']")
    private WebElement modalDropDown;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement modalCheckBox;

    @FindBy(xpath = "//button[@id='save']")
    private WebElement modalSave;

    @FindBy(xpath = "//div[@class='container-fluid']/table/tbody")
    private WebElement tableRoot;
    @FindBy(xpath = "//h5[@class='modal-title']")
    private WebElement modalTitle;
    @FindBy(xpath = "//div[@id='editModal']")
    private WebElement modalWrapper;

    private WebElement waitForTableLoad() {
        Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        tableRoot = stubbornWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver e) {
                return driverManager.getDriver().findElement(By.xpath(
                        "//div[@class='container-fluid']/table/tbody"));
            }
        });

        return null;
    }


    public PageGoods assertPageTitle() {
        Assert.assertEquals(goodsTitle.getText(), "Список товаров",
                "Invalid page title / Incorrect page opened");

        return this;
    }
    public PageGoods openModal() {
        waitClic(add).click();
        if (!modalIsVisible())
            Assert.fail("Modal is not visible!");

        return this;
    }
    private boolean modalIsVisible() {
        waitForVisible(modalTitle).isDisplayed();
        Assert.assertEquals(modalTitle.getText(), "Добавление товара", "Modal title does not match expected!");
        if(modalWrapper.getAttribute("class").equals("modal fade show")) {
            return true;
        }

        return false;
    }

    public PageGoods addItem(String name, foodType obj, boolean exotic) {
        openModal();
        waitClic(nameI).click();
        nameI.sendKeys(name);

        waitForVisible(modalDropDown);
        Select dropdown = new Select(modalDropDown);

        switch (obj) {
            case FRUIT -> dropdown.selectByValue(String.valueOf(foodType.FRUIT));
            case VEGETABLE -> dropdown.selectByValue(String.valueOf(foodType.VEGETABLE));

        }
        if(exotic && !modalCheckBox.isSelected())
            waitClic(modalCheckBox).click();
        else if(!exotic && modalCheckBox.isSelected())
            waitClic(modalCheckBox).click();

        waitClic(modalSave).click();
        return this;


    }
    public PageGoods resetData() throws InterruptedException {
        Thread.sleep(1000);

        waitClic(sandBox).click();
        waitClic(resetButton).click();

        tableRoot = waitForTableLoad();

        return this;
    }
    public PageHome goHome() {
        waitClic(home).click();

        return pageManager.getHomeInstance();
    }
    public PageGoods tablechesk(){

        return this;
    }


}