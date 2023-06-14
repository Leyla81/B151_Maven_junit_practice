package task_grupCalismasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_task {
    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//Before methodunda http://www.google.com adresine gidin

    @Before
    public void setUp() throws Exception {

        driver.get("https://www.google.com");
    }
    @Test
    public void test1() {
        WebElement aramaKutusu2= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        driver.navigate().refresh();
        aramaKutusu2.sendKeys("lord of the rings"+Keys.ENTER);
        WebElement sonucYazisi2=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println( "Lord ="+sonucYazisi2.getText());
    }
    @Test
    public void test02() {
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        WebElement aramaKutusu1= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        driver.navigate().refresh();
               aramaKutusu1.sendKeys("the god father"+ Keys.ENTER);
               WebElement  sonucYazisi1=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("god Father ="+sonucYazisi1.getText());


    }

    @Test
    public void test3() {
        WebElement aramaKutusu3= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        driver.navigate().refresh();
        aramaKutusu3.sendKeys("kill bill"+Keys.ENTER);
        WebElement sonucYazisi2=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("kill bill ="+sonucYazisi2.getText());
    }
    //Üç farklı test methodu ile;

//arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//After method'u ile başlıkları yazdırınız
//AfterClass ile browser'ı kapatınız


    @After
    public void tearDown() throws Exception {
        System.out.println(driver.getTitle());

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
