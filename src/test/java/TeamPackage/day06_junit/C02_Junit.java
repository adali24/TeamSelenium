package TeamPackage.day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Junit {

      //    *** Aşağıdaki Task'i Junit framework'u ile yapınız
      //- Before methodu ile drive'i olusturup ayarlamalari yapiniz
      //  ebay sayfasına gidiniz
      //- electronics bölümüne tıklayınız
      //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
      //- Her sayfanın sayfa başlığını yazdıralım
      //- After methodu ile sayfayı kapatalım

      WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }



    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("(//*[.='Electronics'])[3]")).click();

       List<WebElement> image= driver.findElements(By.xpath("//*[@width='225' and @height= '225']"));
        for (int i = 0; i < image.size() ; i++) {
            image = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            image.get(i).click();
            Thread.sleep(1000);
            String title = driver.getTitle();
            System.out.println("sayfa basligi" + title);
            driver.navigate().back();
        }


    }
    @After
    public void tearDown() throws Exception {
        driver.close();

    }
}
