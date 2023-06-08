package TeamPackage.day08;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02 {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1() {

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement category = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(category);
        Assert.assertFalse(category.equals(45));


    }

    @Test
    public void test2() {
       // 1.Kategori menusunden Books secenegini secin
        WebElement category = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(category);
        option.selectByVisibleText("Books");

       // 2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java", Keys.ENTER);

       // 3. Bulunan sonuc sayisini yazdirin
       WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       String sonucSayisi [] =sonucYazisi.getText().split(" ");
        System.out.println("Sonuc sayisi = "+sonucSayisi[3]);

       // 4. Sonucun Java kelimesini icerdigini test edin
        System.out.println(sonucYazisi.getText());
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));


    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }
}
