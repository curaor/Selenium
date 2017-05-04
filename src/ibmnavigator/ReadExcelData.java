package ibmnavigator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class ReadExcelData {

WebDriver driver;
String driverPath = "C:\\Selenium\\";

@BeforeClass
public void setUpDriver() {

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

driver.findElement(By.id("j_username")).sendKeys(username);
driver.findElement(By.id("j_password")).sendKeys(password);
driver.findElement(By.id("other")).click();
}

@DataProvider(name="login")
public Object[][] excelData() {
Object[][] data = Utility.getExcelData(driverPath + "ReadExcel.xls", "Sheet1");
return data;
}
}