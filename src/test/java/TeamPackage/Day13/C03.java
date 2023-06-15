package TeamPackage.Day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void name() {

               //  1-"hepsiburada.com" adresine gidelim
        driver.get("https://hepsiburada.com");
        String handel1 = driver.getWindowHandle();

               //  2-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        System.out.println("Hepsiburda Title = "+driver.getTitle());
        System.out.println("Hepsiburada Url = "+driver.getCurrentUrl());

               //  3-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(driver.getTitle().contains("Oto") );
        Assert.assertFalse(driver.getCurrentUrl().contains("Oto") );

               //  4-Ardindan "trendyol.com" yeni sekmede acalim
        driver.switchTo().newWindow(WindowType.TAB).get("https://trendyol.com");
        String handel2 = driver.getWindowHandle();
        wait(2);

               //  5-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        driver.getTitle();
        Assert.assertFalse(driver.getTitle().contains("Sitesi"));
        wait(2);

               //  6-Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(handel1);
        wait(2);


               //  7-sayfayi yenileyelim
        driver.navigate().refresh();
        wait(2);
               //  8-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(handel2).close();
        wait(2);
               //  9-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
