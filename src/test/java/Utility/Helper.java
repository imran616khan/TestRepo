package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		String screenshotPath =  "./Screenshots/Sample_" + getCurrentDateAndTime() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot" + e.getMessage());
		}
		return screenshotPath;
	}

	public static String getCurrentDateAndTime() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
	}

}
