package TeamPackage.day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_windowHandel extends TestBase {
    @Test
    public void test() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //Sayfa'nin window handle degerini String bir degiskene atayin
        String handelDeger= driver.getWindowHandle();
        System.out.println(handelDeger);

        //Sayfa title'nin "Amazon" icerdigini test edin
        String actuelTitle= driver.getTitle();
        Assert.assertTrue(actuelTitle.contains("Amazon"));

        //Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");


        //Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        String techproTitle= driver.getTitle();
        Assert.assertFalse(actuelTitle.contains("TECHPROEDUCATION"));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //Sayfa title'nin "Walmart" icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(handelDeger);


    }


}
