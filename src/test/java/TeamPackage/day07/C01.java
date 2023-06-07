package TeamPackage.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {


//After method'u ile başlıkları yazdırınız


    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");
    }

    @Test
    public void test1() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("The God Father");
        aramaKutusu.submit();

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(sonucSayisi[1]);


    }

    @Test
    public void test2() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Lord of the Rings");
        aramaKutusu.submit();

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(sonucSayisi[1]);

    }

    @Test
    public void test3() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Kill Bill");
        aramaKutusu.submit();

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println(sonucSayisi[1]);


    }




    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız

        String TheGodfather = driver.getTitle();
        System.out.println("TheGodfather Title = " + TheGodfather);

        String LordOfTheRings = driver.getTitle();
        System.out.println("LordOfTheRings Title = " + LordOfTheRings);

        String KillBill = driver.getTitle();
        System.out.println("KillBill Title = " + KillBill);


    }
    @AfterClass
    public static void afterClass() throws Exception {

        //AfterClass ile browser'ı kapatınız
        driver.close();


    }
}