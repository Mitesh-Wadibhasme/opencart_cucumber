package utilities;   //this particular file will convert excel data into hash map format

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static HashMap<String, String> storeValues = new HashMap();

	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		
		List<HashMap<String, String>> mydata = new ArrayList<>();     //inside the list collection we store the data in form of hashmap andd key and value pair will be there so string only 
		
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			Row HeaderRow = sheet.getRow(0);   //we are getting header row as header row name use as a keys 
			
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)  
				{
				Row currentRow = sheet.getRow(i);   //we are getting a first row from the sheet 
				
				HashMap<String, String> currentHash = new HashMap<String, String>();  //we are creating one hash map 
				
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
					{
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) 
						{
							case STRING:
								currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
							break;
						}
					}
				mydata.add(currentHash);
				}
			fs.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
}
