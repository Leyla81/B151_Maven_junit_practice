package day04_DropDownMenu;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void name() {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");

//customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("53920");

//submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//cıkan alert mesajını yazdırın
        String alertMsj=driver.switchTo().alert().getText(); //sag tık inceleme yapamadıgımız icin switchTo()
        // ile alert() e cevirdik ve getText ile msj aldık
        System.out.println("alertMsj = " + alertMsj);

//alerti kabul edin
        driver.switchTo().alert().accept();
//cıkan 2. alert mesajını yazdırın
        String msj2=driver.switchTo().alert().getText();
        System.out.println("msj2 = " + msj2);

//cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();



    }



}
