package TeamPackage.day22;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {
        driver.get("https://amazon.com");

        WebElement sell = driver.findElement(By.xpath("//*[text()='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sell);

        WebElement isim = driver.findElement(By.xpath("//*[@id='suc_sup_protect_brand']"));
        js.executeScript("arguments[0].scrollIntoView(true);",isim);

        WebElement isim1 = driver.findElement(By.xpath("//*[text()='New Seller Incentives']"));
        js.executeScript("arguments[0].scrollIntoView(true);",isim1);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        wait(2);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        wait(2);


    }
}
