package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * Fetching data from Excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 * @author Reshma
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
        Workbook book = WorkbookFactory.create(fes);
		
       
        Sheet sheet = book.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        String Value = cell.getStringCellValue();
		return Value;
	}
	
	/*DataFormatter format=new DataFormatter();
	String data=format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;*/
	
	/**
	 * Fetchin gdata  from Excel by using DataFormatter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Reshma
	 */
	
	public String getExcelUsingDataFormatterString(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
        Workbook book1 = WorkbookFactory.create(fes);
        DataFormatter format=new DataFormatter();
    	String data = format.formatCellValue(book1.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
    	return data;  
	}
	
	public Object[][] readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		
		Sheet sheet=book.getSheet(SheetName);
		int lastRow=sheet.getLastRowNum()+1;
		int lastCell=sheet.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
