package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    private WebDriver driver;
    private Actions action;

    // Abrir o Chrome Driver
    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Ir para url
    public void visit(String url) {
        this.driver.get(url);
    }

    // Verifica url atual
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    // Fechar o Chrome Driver
    public void quitWebDriver() {
        this.driver.quit();
    }

    // Reralizar Busca de Element
    public WebElement findElement(By locator) {
        return this.driver.findElement(locator);
    }

    //
    public void type(String input, By locator) {
        this.driver.findElement(locator).sendKeys(input);
    }

    //
    public Boolean isDisplayed(By locator) {
        try {
            return this.driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(By locator) {
        this.driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return this.driver.findElement(locator).getText();
    }

    public void actionMoveToElementPerform(By locator) {
        if (this.action == null) {
            this.action = new Actions(this.driver);
        }
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public void actionMoveToElementClickPerform(By locator) {
        if (this.action == null) {
            this.action = new Actions(this.driver);
        }
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).click().build().perform();
    }

}