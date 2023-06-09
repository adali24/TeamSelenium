package TeamPackage.day09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test01() {


        //Amazon sayfasına gidelim


        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select =new Select(aramaKutusu);
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
       for (int i= 1 ; i<6 ; i++) {

           WebElement element1 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
           Select select1 = new Select(element1);
           select1.selectByIndex(i);
           driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).submit();
           System.out.println(i+" sayfa basligi = " + driver.getTitle());
       }

        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        //Not: Slect Class'ı kullanalım
    }

    @After
    public void tearDown() throws Exception {

    }
}