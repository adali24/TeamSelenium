package TeamPackage.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    @Test
    public void test1() {
//    Test01 :
// 1- amazon gidin
        driver.get("https://amazon.com");

//2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select option = new Select(ddm);
        List<WebElement> categoryMenu = option.getOptions();
        categoryMenu.stream().forEach(t-> System.out.println(t.getText()));

//3. dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println("Dropdown eleman sayisi "+categoryMenu.size());
        Assert.assertFalse(categoryMenu.size()==40);
    }

    @Test
    public void test02() {
//            Test02
        // 1- amazon gidin
        driver.get("https://amazon.com");
//1. dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select option = new Select(ddm);
        option.selectByIndex(10);

//2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);


//3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
    WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Yazisi ="+sonucYazisi.getText());
        String sonuc []= sonucYazisi.getText().split(" ");
        System.out.println("sonucumuz = "+sonuc[3]);
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));

//4. ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();

//5. ürünün title'ni ve fiyatını variable'a assign edip ürünü sepete ekleyelim
        System.out.println("Title = "+driver.getTitle());
        WebElement fiyat = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        System.out.println("Fiyat ="+fiyat.getText());
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
    }

    @Test
    public void test03() {
        //    Test03

        driver.get("https://amazon.com");
        wait(1);
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        wait(1);

//2. dropdown'dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select option = new Select(ddm);
        option.selectByVisibleText("Baby");



//3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("bebek puset", Keys.ENTER);


//4. sonuç yazsının puset içerdiğini test edin
       WebElement sonucYazisi=  driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
      String pusetYazisi = sonucYazisi.getText();
       Assert.assertTrue(pusetYazisi.contains("puset"));

//5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();


//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        System.out.println("Title = "+driver.getTitle());
        WebElement fiyat = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        System.out.println("Fiyat ="+fiyat.getText());
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

    }

    @Test
    public void test04() {

        //    Test 4
//            1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.get("https://amazon.com");
driver.findElement(By.xpath("//*[@id='nav-cart-count']")).click();
    }
}
