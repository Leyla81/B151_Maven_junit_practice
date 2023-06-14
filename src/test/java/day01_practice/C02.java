package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {





WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void techpro() {
        // https://www.techproeducation.com/ sayfasina gidin
        driver.get(" https://www.techproeducation.com");
        String baslık =driver.getTitle();
        System.out.println("baslık = " + baslık);
        // Title ve Url'ini alın ve yazdırın
        String url =driver.getCurrentUrl();
        System.out.println("url = " + url);
        /*if (baslık.contains("techpro")){
            System.out.println("test passed");
        }else System.out.println("test failed");

        if (url.contains("techproeducation")){
            System.out.println("test passed");

        }else System.out.println("test failed");*/

        // Title'in "techpro" kelimesini içerip içermedigini test edin
        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(baslık.contains("Techpro"));
        Assert.assertTrue(url.contains("techproeducation"));

        // https://www.amazon.com/ sayfasına gidin

        driver.get("https://amazon.com");
        String amazonBaslık = driver.getTitle();

        // Title'ini alın ve yazdırın
        System.out.println("amazonBaslık = " + amazonBaslık);

        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonBaslık.contains("more"));

        // techproeducation.com'a geri dönün
        driver.navigate().back();
        // sayfayı yenileyin
        driver.navigate().refresh();
        // amazon.com'a tekrar gelin
        driver.navigate().forward();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
