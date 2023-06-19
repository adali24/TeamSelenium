package TeamPackage.day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test1() {
// - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

// - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
       WebElement page = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));

        Actions actions= new Actions(driver);
        actions.clickAndHold(page).moveByOffset(50,20).moveByOffset(20,10)
                .moveByOffset(40,55).moveByOffset(35,25).release().perform();

        wait(2);
// - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();

// - Sayfayi kapatiniz
        driver.quit();
    }
}
