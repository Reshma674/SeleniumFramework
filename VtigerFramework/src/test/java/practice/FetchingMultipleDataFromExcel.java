package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcel {

	public static void main(String[] args) throws IOException   
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Campaign");
		
		for(int i=0; i< sheet.getLastRowNum(); i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				Cell cell=row.getCell(j);
				DataFormatter format=new DataFormatter();
				String data = format.formatCellValue(cell);
				System.out.println(data);
			}
			
		}
	}

}
