package ibmnavigator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IBMNavigatorSelenium {

static WebDriver driver;

public static void main(String[] args) throws InterruptedException {
String driverPath = "C:\\Selenium\\";
//  System.setProperty("webdriver.chrome.driver", driverPath +"chromedriver.exe");
//   driver=new ChromeDriver();
System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://devas400.lexington.ibm.com:2004/ibm/console/login.do?action=secure");

System.out.println(driver.getTitle());

driver.findElement(By.id("j_username")).sendKeys("MSODC");
driver.findElement(By.id("j_password")).sendKeys("derick01");
driver.findElement(By.id("other")).click();

Thread.sleep(5000);
//driver.close();

}

}
