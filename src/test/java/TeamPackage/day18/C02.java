package TeamPackage.day18;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C02 extends TestBase {
    @Test
    public void test() {
// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

// 3. Verify that home page is visible successfully

WebElement homePage= driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

// 4. Click 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
wait(3);

        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();


// 5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        wait(1);

// 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

// 7. Hover over second product and click 'Add to cart'

        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();


// 8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

// 9. Verify both products are added to Cart


// 10. Verify their prices, quantity and total price

    }
}
