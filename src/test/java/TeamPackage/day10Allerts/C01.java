package TeamPackage.day10Allerts;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {
        driver.get("https://demoqa.com/alerts");
        wait(2);
        driver.findElement(By.xpath("(//button)[2]")).click();
        wait(1);
        alertAccept();
    }

    @Test
    public void test02() {
        driver.get("https://demoqa.com/alerts");
        wait(2);
        driver.findElement(By.xpath("(//button)[4]")).click();
        wait(1);
        dismissAllert();
        System.out.println(driver.findElement(By.xpath("(//*[@class='text-success'])[1]")).getText());

    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        wait(2);
        driver.findElement(By.xpath("(//button)[5]")).click();
        wait(1);
        sendKeys("Hamit");
        wait(2);
        alertAccept();

    }
}
