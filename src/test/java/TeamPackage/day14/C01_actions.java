package TeamPackage.day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_actions extends TestBase {
    @Test
    public void name() {

//https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        wait(2);

        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

//Sayfanin altına doğru gidelim
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.END);
        actions.perform();
        wait(2);

//Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.HOME);
        actions.perform();
    }
}
