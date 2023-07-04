package utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBAse;

public class CaptureScreenshot extends TestBAse
{
/*public static Date getDate()	
{
	Date date1 = new Date();
	return date1;
	}*/

	

//public static void screenShot(String nameofmethod) throws IOException
public static void screenShot(String nameofMethod) throws IOException
{ 
//	Date date1=getDate();
	
File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File Dest=new File("D:\\sel framework prog loc\\21stBatchTesting\\ScreenShot1\\"+nameofMethod+".jpeg");//for single

//File Dest=new File("D:\\sel framework prog loc\\21stBatchTesting\\ScreenShot1\\ss1.jpeg");//for single
//File Dest=new File("D:\\sel framework prog loc\\21stBatchTesting\\ScreenShot1\\" +nameofmethod+ ".jpeg");//for series
FileHandler.copy(source,Dest);

}}