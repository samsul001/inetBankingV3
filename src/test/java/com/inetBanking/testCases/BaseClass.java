package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsrName();
	public String password = readconfig.getPwd();
	public String chromepath = readconfig.getChromePath();
	public String firefoxpath = readconfig.getFirefoxPath();
	public String edgepath = readconfig.getEdgePath();

	public static WebDriver driver;
	//public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		/*
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		*/

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", edgepath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		//logger.info("URL entered");	
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// Screenshot method
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//Alert present method
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	//Random String
	public static String randomString(int num) {
		String stringGenerator = RandomStringUtils.randomAlphabetic(num);
		return stringGenerator;
	}
	
	//random number
	public static String randomNumber(int num) {
		String intGenerator = RandomStringUtils.randomNumeric(num);
		return intGenerator;
	}
	
	
	
	//Random integer

}
