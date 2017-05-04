package ibmnavigator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

//import ibmnavigator.ReadExcel;
public class ReadExcelLoop {

public static void main(String[] args) throws Exception,FileNotFoundException {

String driverPath = "C:\\Selenium\\";
File src = new File(driverPath + "ReadExcel.xlsx");	

FileInputStream fis = new FileInputStream(src);

XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet1 = wb.getSheetAt(0);

int rowcount = sheet1.getLastRowNum();
System.out.println("The total row is = " +rowcount);

for(int i=0; i<rowcount; i++)
{
String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
System.out.println("Data from row " + i +" is " +data0);

String data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
System.out.println("Data from row is " +data1);
}

wb.close();

}

}