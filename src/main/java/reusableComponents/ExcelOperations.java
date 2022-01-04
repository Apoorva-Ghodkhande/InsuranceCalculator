package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	String testdatapath;
	Sheet sh;
	public ExcelOperations(String Sheetname) {
    try {
		testdatapath= System.getProperty("user.dir")+PropertiesOperations.getPropertiesValue("excelpath");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	File f= new File(testdatapath);
	Workbook wb = null;
	try {
		wb = WorkbookFactory.create(f);
	
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	sh=wb.getSheet(Sheetname);
	}
	
	public HashMap<String, String> getDataFromExcel(int RowNo) throws EncryptedDocumentException, IOException
	{
		

     HashMap<String,String> h= new HashMap<String,String>();
      for(int i=0;i< sh.getRow(0).getLastCellNum();i++)
        {
	    sh.getRow(RowNo).getCell(i).setCellType(CellType.STRING);
	    h.put(sh.getRow(0).getCell(i).toString(), sh.getRow(RowNo).getCell(i).toString());
	
        }
      return h;

	}
	
	public int getColCount()
	{
		
		return sh.getRow(0).getLastCellNum();
	}
	
	public int getRowCount()
	{
		
		return sh.getLastRowNum();
	}
}
