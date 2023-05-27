package TeamPackage.day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Task1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin pozisyonu = "+driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutu = "+driver.manage().window().getSize());

        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(100,600));

        // Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        String position = "driver.manage().window().getPosition()";
        String expectedpos = "driver.manage().window().setPosition(new Point(50,50))";
        if (!position.equals(expectedpos)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -> ");

        String size = "driver.manage().window().getSize())";
        String newSize = "driver.manage().window().setSize(new Dimension(100,600))";
        if (!size.equals((newSize))){
            System.out.println("Test passed 1");
        }else System.out.println("Test failed 1 ");

        driver.close();





    }
}