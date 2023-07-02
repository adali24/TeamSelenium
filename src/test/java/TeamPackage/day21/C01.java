package TeamPackage.day21;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01 extends TestBase {
    @Test
    public void test01() {
        //  2. Navigate to url 'http://automationexercise.com'
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

//  6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='image']")).isDisplayed());

//  7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        wait(1);
//  8. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='text-center'])[3]")).isDisplayed());

    }
}
