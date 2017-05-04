package ibmnavigator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadData {

WebDriver driver;

@BeforeClass
public void setUpDriver() {
String driverPath = "C:\\Selenium\\";
//System.setProperty("webdriver.chrome.driver", driverPath +"chromedriver.exe");
//driver=new ChromeDriver();
System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
driver = new FirefoxDriver();
}
@AfterClass
public void pageClose(){
driver.close();
}


@Test(dataProvider="login")
public void login(String username, String password) throws Exception{

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://devas400.lexington.ibm.com:2004/ibm/console/login.do?action=secure");

driver.findElement(By.name("j_username")).sendKeys(new String[]{username});
driver.findElement(By.name("j_password")).sendKeys(new String[]{password});

driver.findElement(By.id("other")).click();
Thread.sleep(2000);
}

@DataProvider(name="login")
public Object [] [] passData(){

Object [] [] data = new Object [3] [2];

data [0] [0] = "user1";
data [0] [1] = "pass1";

data [1] [0] = "user2";
data [1] [1] = "pass2";

data [2] [0] = "MSODC";
data [2] [1] = "derick01";

return data;
}
}