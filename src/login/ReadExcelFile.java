package login;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;	
	
	public ReadExcelFile(String excelPath) 
	{
		try 
		{
			//Load new File
			File src = new File(excelPath); 
			//Reads data from File
			FileInputStream fis = new FileInputStream(src);
			//Load Particular Excel File, set up new workbook
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetnumber, int row, int column)
	{
		//Gets Sheet Number
		sheet = wb.getSheetAt(sheetnumber);
		//Gets the row, column and Value in cell
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		//Count number of rows in Sheet
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
}
