import org.testng.annotations.Test;
import storePOM.MainPage;

import static org.testng.Assert.assertTrue;
import static storePOM.BasePage.*;

public class firstTest extends BaseTest {

    @Test
    public void fakeStoreMainPageTest() {
        MainPage.open();
        mainPage.dismissStoreNotice(
                "To jest wersja demonstracyjna sklepu do celów testowych— Zamówienia nie będą realizowane.\n" + "Ukryj");
        assertTrue(mainPage.logoFakeStore.isDisplayed(), "Fake Store logo is not displayed on the page");
        assertTrue(mainPage.headerTitle.isDisplayed(), "Header title is not displayed on the page");
        mainPage.verifyAmountOfImages(3);
    }

    @Test
    public void fakeStoreShopPageTest() {
        mainPage.goToPage("Sklep");
        shopPage.selectCategory("Windsurfing");
        shopPage.isProductVisibleOnTheCategory("Grecja – Limnos");
        // cena to 3200
        // kliknij dodaj do koszyka
        // asercje na widoczność potwierdzeń że produkt został dodany do koszyka
        // idź do koszyka
        // potwierdź, że jest tam produkt Grecja o wartości 3200
    }
}
