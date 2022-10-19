package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class ScreenshotUtil extends TestBase{

public static String getScreenshot(String screenshotName) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
		File DestFile=new File(destPath);
		try {
			FileUtils.copyFile(sourceFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}                       
		System.out.println("Screenshot Captured");		
		return destPath;
	}
}
