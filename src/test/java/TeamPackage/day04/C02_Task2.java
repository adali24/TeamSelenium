package TeamPackage.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");


        //  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        // Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String guncelBaslik = driver.getTitle();
        if (guncelBaslik.contains("Spend less")){
            System.out.println("Test passed");
        }else System.out.println("test failed");

        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("// * [.='Gift Cards']")).click();

        //Birthday butonuna basin
        driver.findElement(By.xpath("//*[@aria-label='Birthday']")).click();

        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath(" // *[@aria-label='Best Sellers']")).click();
        driver.findElement(By.xpath(" //*[@alt='Amazon Reload']")).click();

        // Gift card details'den 50 $'i secin
        WebElement actualDeger =driver.findElement(By.xpath("(//*[@type='button'])[2]"));
        actualDeger.click();
        System.out.println(actualDeger.getText());



        //  Urun ucretinin 50$ oldugunu test edin
        if(actualDeger.getText().equals("$50")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

       // 10-Sayfayi kapatin
        driver.close();
    }
}
