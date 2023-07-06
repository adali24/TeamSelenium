package TeamPackage.day21;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Random;

public class C02 extends TestBase {
    @Test
    public void test() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

//Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        List<WebElement> number = driver.findElements(By.xpath("(//*[@class='btn btn-outline-primary'])[position()<11]"));

        Random rnm = new Random();
        int rnm1 = rnm.nextInt(10);
        int rnm2 = rnm.nextInt(11);
        driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])[position()<11][" + rnm1 + "]")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])[position()<11][" + rnm2 + "]")).click();

        List<WebElement> isaretler = driver.findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
        int isaretlerIndex = rnm.nextInt(isaretler.size());

        isaretler.get(isaretlerIndex).click();
        wait(1);

        int rnm3 = rnm.nextInt(11);
        int rnm4 = rnm.nextInt(11);
        driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])[position()<11][" + rnm3 + "]")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])[position()<11][" + rnm4 + "]")).click();

        wait(1);

        driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();

// rastgele sayi urettik

    }
}
