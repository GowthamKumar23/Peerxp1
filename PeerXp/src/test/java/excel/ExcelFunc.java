package excel;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunc 
{
	static String dataPath = "C:/Users/Admin/eclipse-workspace1/PeerXp/resources/PeerXp.xlsx";
 public Object getCellData(int rowNum,int cellNum) throws IOException
{
	XSSFWorkbook wb = new XSSFWorkbook(dataPath);
	XSSFSheet sheet = wb.getSheetAt(0);
	XSSFRow row = sheet.getRow(rowNum);  
	String cellValue = "";
	String cellType = row.getCell(cellNum).getCellType().toString();
		
	if(cellType.equalsIgnoreCase("String"))
		cellValue = cellValue + row.getCell(cellNum).getStringCellValue();
	if(cellType.equalsIgnoreCase("Numeric"))
		cellValue = cellValue + row.getCell(cellNum).getNumericCellValue();
	wb.close();
	
	return cellValue;
	
}
	
	}


