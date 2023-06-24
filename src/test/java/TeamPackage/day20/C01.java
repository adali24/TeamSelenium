package TeamPackage.day20;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01 extends TestBase {

    @Test
    public void test01() throws IOException {
        // https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        wait(2);


        // Kutucuk içindeki rengi kırmızı oldugunda ekran goruntusu alalim
        WebElement iframe= driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement birincitus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        WebElement ikincitus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement ucuncutus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(birincitus).moveByOffset(70,0).release().perform();
        actions.clickAndHold(ikincitus).moveByOffset(-160,0).release().perform();
        actions.clickAndHold(ucuncutus).moveByOffset(-70,0).release().perform();



        // sonra sarı yapıldiktan sonra tekrar ekran goruntusu alalim

        String date = new SimpleDateFormat("hh.mm.ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("screenshot/TakesScreenshot"+date+".jpeg"));

        //Kendi olusturdugumuz packege nin icine ekran goruntusu kaydetme
        String dosyaYolu = "src/test/java/TeamPackage/day20/screenShot/ekranGoruntusu"+date+".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        // Sarı olduğunu test edelim
        actions.clickAndHold(ikincitus).moveByOffset(320,0).release().perform();

    }
}
