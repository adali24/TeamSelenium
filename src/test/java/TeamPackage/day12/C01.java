package TeamPackage.day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test() {

        //http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();


        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println("yazi : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        wait(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        wait(1);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();


        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Hamit");
        driver.switchTo().alert().accept();


        //-Çıkan mesajı konsola yazdırınız
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='demo1']"));
        System.out.println(mesaj.getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertTrue(mesaj.isDisplayed());

    }
}
