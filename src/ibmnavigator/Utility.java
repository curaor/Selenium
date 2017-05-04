package ibmnavigator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
// https://sourceforge.net/projects/jexcelapi/files/jexcelapi/2.6.12/jexcelapi_2_6_12.zip/download
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utility {

public static String[][] getExcelData(String fileName, String sheetName) {
String[][] arrayExcelData = null;
try {
FileInputStream fs = new FileInputStream(fileName);
Workbook wb = Workbook.getWorkbook(fs);
Sheet sh = wb.getSheet(sheetName);

int totalNoOfCols = sh.getColumns();
int totalNoOfRows = sh.getRows();

arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];

for (int i= 1 ; i < totalNoOfRows; i++) {

for (int j=0; j < totalNoOfCols; j++) {
arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
}

}
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
e.printStackTrace();
} catch (BiffException e) {
e.printStackTrace();
}
return arrayExcelData;
}

}