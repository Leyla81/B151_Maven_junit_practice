package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {





WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void bestbuy() {
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com");

        // sayfa Title'ini alın "Best" içerdigini test edin
        String baslikBestBuy=driver.getTitle();
        Assert.assertTrue(baslikBestBuy.contains("Best"));

        // BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

        // Canada logosunun görüntülendigini test edin
WebElement canadalogosu=driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
Assert.assertTrue(canadalogosu.isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
