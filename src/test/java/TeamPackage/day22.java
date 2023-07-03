package TeamPackage;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class day22 {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/java/TeamPackage/excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim

       String satirBirSutunIki= workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(satirBirSutunIki);

 // 3 satir 4.cell'in Arnavutluk'in baskenti oldugunu test  edelim
        String satirIkiSutunDort= workbook.getSheet("Sayfa1").getRow(2).getCell(3).toString();
        System.out.println(satirIkiSutunDort);
        Assert.assertEquals("Tiran",satirIkiSutunDort);

 // Satir sayisini bulalim
        int satirSayisi= workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satir sayisi = "+satirSayisi);

 // Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi= workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("kullanilan satir sayisi = "+kullanilanSatirSayisi);

// Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim


        Map<String,String> ulkeBaskent= new HashMap<>();
        for (int i = 0; i < satirSayisi; i++) {
            String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String sehir = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");
            System.out.println(ulke+"-->"+sehir);
        }
        //System.out.println(ulkeBaskent);

    }

    @Test
    public void test02() throws IOException {
        String dosyaYolu = "src/test/java/TeamPackage/excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

     //  Adimlari takip ederek 1.satira kadar gidelim  5.hucreye yeni bir cell olusturalim Olusturdugumuz hucreye "Nufus" yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        //  2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);
        //  10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);
        //  15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(50);

     //  Dosyayi kaydedelim
        FileOutputStream fos =new FileOutputStream("src/test/java/TeamPackage/excel/ulkeler.xlsx");
        workbook.write(fos);

     //  Dosyayi kapatalim
        fos.close();
        workbook.close();
    }
}
