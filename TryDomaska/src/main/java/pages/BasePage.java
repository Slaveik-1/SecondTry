package pages;

import managers.DriverManager;
import managers.PageManager;
import managers.PropManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class    BasePage {

    @FindBy(xpath = "//a[@class='navbar-brand']")
    protected WebElement home;

    @FindBy(xpath = "//*[@id='navbarDropdown']")
    protected WebElement sandBox;

    @FindBy(xpath = "//*[text()='Товары']")
    protected WebElement goodsButton;

    private final PropManager propManager = PropManager.getPropInstance();
    protected DriverManager driverManager = DriverManager.getDriverInstance();


    protected PageManager pageManager = PageManager.getPageManagerInstance();

    protected WebDriverWait wait  = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(5));

    BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement waitClic(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void fillInput(String text, WebElement element) {
        waitClic(element).click();
        element.sendKeys(text);
    }


}
