package storePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.testng.Assert.*;

public class MainPage extends BasePage {


    @FindBy(css = "a[class*='dismiss-link']")
    WebElement noticeDismissLink;

    @FindBy(className = "demo_store")
    WebElement textStoreNotice;

    @FindBy(css = "img[alt='FakeStore']")
    public WebElement logoFakeStore;

    @FindBy(css = "h1.entry-title")
    public WebElement headerTitle;



    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public static void open() {
        driver.get("https://fakestore.testelka.pl/");
        mainPage = new MainPage();
    }

    public void dismissStoreNotice(String text) {
        assertEquals(textStoreNotice.getText(), text, "Store notice different than expected");
        noticeDismissLink.click();
        assertFalse(textStoreNotice.isDisplayed(), "Store notice is still visible on the Main page");
    }

    public void verifyAmountOfImages(int amount) {
        int totalAmountOfImages = driver.findElements(By.cssSelector("img[alt='Wspinaczka Via Ferraty']")).size();
        assertEquals(totalAmountOfImages, amount, "Incorrect amount of selected image");
    }

    public void goToPage(String text) {
        driver.findElement(By.xpath("//div[@class='primary-navigation']//a[text()='" + text + "']")).click();
        shopPage = new ShopPage();
        assertEquals(shopPage.pageTitle.getText(), text, "Incorrect page name");
    }
}
