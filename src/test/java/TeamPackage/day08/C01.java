package TeamPackage.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class C01 {
// Bir class oluşturun: DropDown



    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        //  https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement  ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option = new Select(ddm);
        option.selectByIndex(1);
        System.out.println("Option 1 yazdirma ="+option.getFirstSelectedOption().getText());

        System.out.println("***************************************************************");
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        option.selectByValue("2");
        System.out.println("Option 2 yazdirma ="+option.getFirstSelectedOption().getText());

        System.out.println("***************************************************************");
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        option.selectByVisibleText("Option 1");
        System.out.println("Option 3 yazdirma ="+option.getFirstSelectedOption().getText());

        System.out.println("***************************************************************");
        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tagname = driver.findElements(By.tagName("option"));
        tagname.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("*********************** 2. way **************************");
        List<WebElement> tagname1 =option.getOptions();
        tagname1.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("***************************************************************");
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.
        int tagname2 = option.getOptions().size();

        if (tagname2 == 4){
            System.out.println("True");
        }else{
            System.out.println("false");
        }
        Assert.assertFalse(tagname2==4);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }
}

