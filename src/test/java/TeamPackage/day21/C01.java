package TeamPackage.day21;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01 extends TestBase {
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

    @Test
    public void test01() throws IOException {

        //  2. Navigate to url 'http://automationexercise.com'
        String dosyaYolu = "testOutput/extendReport.html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Hamit");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentTest = extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("http://automationexercise.com");
        wait(1);


//  3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        wait(1);

//  4. Add products to cart
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN);
        wait(1);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();

//  5. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

        //ekran goruntusu alalim
        String date = new SimpleDateFormat("hh.mm.ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("screenshot/TakesScreenshot" + date + ".jpeg"));
        extentTest.info("sayfaya gidildi urun eklendi");


//  6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='image']")).isDisplayed());
        extentTest.info("sayfaya gidildi dogrumala yapildu");

//  7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        wait(1);
        extentTest.info("sayfaya gidildi eklenen urun silindi");

        //Kendi olusturdugumuz packege nin icine ekran goruntusu kaydetme
        String dosyaYolu1 = "src/test/java/TeamPackage/screenShot/ekranGoruntusu" + date + ".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu1));


//  8. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='text-center'])[3]")).isDisplayed());
        extentTest.info("eklenen urunun silindigi test edildi");
        extentReports.flush();

    }
}
