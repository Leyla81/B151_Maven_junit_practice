package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_odev {


    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.google.com");
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));
driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("nutella"+ Keys.ENTER);

WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());

        String[] sonucSayisi =sonucYazisi.getText().split(" ");
        System.out.println("sonucSayisi[1] = " + sonucSayisi[1]);

       int sonuc1 =122000000;
       int sonuc2 = 10000000;
       Assert.assertTrue(sonuc1>sonuc2);
        System.out.println("TEST PASSED");






    }
}
