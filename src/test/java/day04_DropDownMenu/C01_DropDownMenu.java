package day04_DropDownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {



    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin

        driver.get("https://www.amazon.com");

        // dropdown'dan "Books" secenegini secin
WebElement ddmAmazon=driver.findElement(By.xpath("// select[@id='searchDropdownBox']"));
Select select =new Select(ddmAmazon);
select.selectByVisibleText("Books");


// arama cubuguna "Java" aratın

     WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")) ;
     aramaKutusu.sendKeys("Java"+ Keys.ENTER);




// arama sonuclarinin Java icerdigini test edin
      WebElement aramaSonuc=  driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonuc.getText().contains("Java"));



    }














}
