package TeamPackage.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //   2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]")).sendKeys("standard_user");

        //  3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("(//*[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");

        Thread.sleep(1500);


        //  4. Login tusuna basin
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();


        //  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        System.out.println(driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText());
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(1000);


        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).click();


        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement gorunuyormu = driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        if (gorunuyormu.isDisplayed()) {
            System.out.println("Gorunuyor");
        } else {
            System.out.println("Gorunmuyor");
        }


        // 9. Sayfayi kapatin
        driver.close();
    }
}