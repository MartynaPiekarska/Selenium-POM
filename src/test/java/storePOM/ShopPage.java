package storePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShopPage extends BasePage {

    @FindBy(css = "h1.page-title")
    WebElement pageTitle;

    public ShopPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String text) {
        driver.findElement(By.cssSelector("img[alt='" + text + "']")).click();
        assertEquals(shopPage.pageTitle.getText(), text, "Incorrect category name");
    }

    public void isProductVisibleOnTheCategory(String text) {
        assertTrue(driver.findElement(By.xpath("//h2[text()='" + text + "']")).isDisplayed(), "Selected product is not visible");
    }
}
