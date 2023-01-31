package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EXcelFileUtility {
	 private Workbook workbook;
	public void excelInitialization(String excelpath) {
		FileInputStream fis =null;
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String fetchDataFromExcel( String sheetName,int row,int cell) {
		
		return workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	}
	
	
	public List<String> fetchDataFromExcel( String sheetName){
		List <String> list = new ArrayList<>();
		Sheet sheet = workbook.getSheet(sheetName);
		for(int i=0;i<4;i++) {
			String data = sheet.getRow(i).getCell(1).getStringCellValue();
			list.add(data);
			
		}
		return list;
	}
	
	public void closeworkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
