package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
public static String readProperfile(String value) throws IOException
{
Properties prop=new Properties();
FileInputStream file = new FileInputStream("D:\\sel framework prog loc\\21stBatchTesting\\TestData\\config.properties");

prop.load(file);
return prop.getProperty(value);  
}

public static String readExcel(int rowNum, int colNum) throws EncryptedDocumentException, IOException
{
	FileInputStream file = new FileInputStream("D:\\sel framework prog loc\\21stBatchTesting\\TestData\\frameworkexcel1.xlsx");
	Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
	String value =es.getRow(rowNum).getCell(colNum).getStringCellValue();
	return value;
}
}