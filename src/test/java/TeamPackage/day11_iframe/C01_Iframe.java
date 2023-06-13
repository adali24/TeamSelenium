package TeamPackage.day11_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe() {
       //1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

       //2) sayfadaki toplam iframe sayısını bulunuz.

      int sayi=driver.findElements(By.tagName("iframe")).size();
        System.out.println(sayi);

       //3) Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
       String actuelTitle = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actuelTitle.contains("Editor"));

       //4) Paragrafdaki yaziyi silelim
       WebElement iframe= driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//p")).clear();
        wait(2);



       //5) Sonrasinda paragrafa "iframe icindeyim"" yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys("iframe icindeyim");
        driver.switchTo().defaultContent();

        wait(2);


       //6) Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        WebElement sonYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonYazi.isDisplayed());
    }
}
