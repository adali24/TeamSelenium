package TeamPackage.day15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C01 extends TestBase {
    @Test
    public void test01() {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over  Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement box= driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(box).perform();


        // 3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        link1.sendKeys(Keys.ENTER);

        // 4- Popup mesajini yazdirin
        System.out.println("popum mesaji ="+driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
wait(2);
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement click = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(click).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHold= driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println("click and hold ="+clickAndHold.getText());


        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doobleClik= driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doobleClik).perform();

        WebElement dogrumaTikalamsi = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(dogrumaTikalamsi.isDisplayed());
    }
}
