package TeamPackage.day14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void name() {
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.perform();


        //3. Verify that categories are visible on left side bar
        WebElement categories =driver.findElement(By.xpath("//*[@class='panel-group category-products']"));
        Assert.assertTrue(categories.isDisplayed());
wait(2);
      //4. Click on 'Women' category
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();

wait(2);
      //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("(//*[text()='Dress '])[1]")).click();
        driver.findElement(By.xpath("//*[@aria-hidden='true']")).click();// reklami kapatmak icin

      //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'



      //7. On left side bar, click on any sub-category link of 'Men' category


      //8. Verify that user is navigated to that category page


    }
}
