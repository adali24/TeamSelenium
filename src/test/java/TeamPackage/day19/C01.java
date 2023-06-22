package TeamPackage.day19;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void test01() {
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

// 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

// 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();

// 5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[2]")).isDisplayed());



// 6. Enter name, email, subject and message
        driver.findElement(By.xpath("(//*[@class='form-control'])[1]")).sendKeys("Hamit");
        driver.findElement(By.xpath("(//*[@class='form-control'])[2]")).sendKeys("Hamit@gmail.com");
        driver.findElement(By.xpath("(//*[@class='form-control'])[3]")).sendKeys("Merhaba");
        driver.findElement(By.xpath("(//*[@class='form-control'])[4]")).sendKeys("Nasilsin ?");


// 7. Upload file
        //C:\Users\sadec\OneDrive\Masaüstü\Yeni Text Document.tx
        WebElement file = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
      //  String farkliYol = System.getProperty("user.home");
       // String ortakYol = "\\Masaustu\\Yeni Text Document.txt";
        String yol = "C:\\Users\\sadec\\OneDrive\\Masaüstü\\Yeni Text Document.txt";
        file.sendKeys(yol);;

// 8. Click 'Submit' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).submit();

// 9. Click OK button
        driver.switchTo().alert().accept();

// 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement sonuc = driver.findElement(By.xpath("//div[@class= 'status alert alert-success']"));
        Assert.assertTrue(sonuc.isDisplayed());

// 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();

    }
}
