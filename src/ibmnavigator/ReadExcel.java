package ibmnavigator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

public static void main(String[] args) throws Exception,FileNotFoundException {
String driverPath = "C:\\Selenium\\";
File src = new File(driverPath + "ReadExcel.xlsx");
FileInputStream fis = new FileInputStream(src);

XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet1 = wb.getSheetAt(0);

String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
System.out.println("Data from Excel is = " +data0);

String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
System.out.println("Data from Excel is = " +data1);

String data2 = sheet1.getRow(1).getCell(0).getStringCellValue();
System.out.println("Data from Excel is = " +data2);

String data3 = sheet1.getRow(1).getCell(1).getStringCellValue();
System.out.println("Data from Excel is = " +data3);

String data4 = sheet1.getRow(2).getCell(0).getStringCellValue();
System.out.println("Data from Excel is = " +data4);

String data5 = sheet1.getRow(2).getCell(1).getStringCellValue();
System.out.println("Data from Excel is = " +data5);

wb.close();

}

}