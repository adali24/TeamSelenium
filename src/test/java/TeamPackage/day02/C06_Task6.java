package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Task6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //.Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Normal Page position = "+driver.manage().window().getPosition());
        System.out.println("Normal Page size = "+driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();


       //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

       //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("max position"+driver.manage().window().getPosition());
        System.out.println("max size"+driver.manage().window().getSize());

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("full screen position"+driver.manage().window().getPosition());
        System.out.println("full screen size"+driver.manage().window().getSize());


        //Sayfayi kapatin
        driver.close();
    }
}
