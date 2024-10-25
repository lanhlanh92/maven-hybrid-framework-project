package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	private WebDriver driver;
	
	protected final Logger log;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browserList) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case CHROME_HEADLESS:
			ChromeOptions chOption = new ChromeOptions();
			chOption.addArguments("--headless");
			chOption.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(chOption);
			break;
		case FIREFOX_HEADLESS:
			FirefoxOptions ffOption = new FirefoxOptions();
			ffOption.addArguments("--headless");
			ffOption.addArguments("windown-size=1920x1080");
			driver = new FirefoxDriver(ffOption);
			break;
		case EDGE_HEADLESS:
			EdgeOptions egOption = new EdgeOptions();
			egOption.addArguments("--headless");
			egOption.addArguments("windown-size=1920x1080");
			driver = new EdgeDriver(egOption);
			break;
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		Path path = null;
		File extensionFilePath = null;
		switch (browserList) {
		case CHROME:
//			File chFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
//			ChromeOptions choption = new ChromeOptions();
//			choption.addExtensions(chFile);
			
//			ChromeOptions options = new ChromeOptions();
//			path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
//			extensionFilePath = new File(path.toUri());
//			options.addExtensions(extensionFilePath);
			driver = new ChromeDriver();
			break;
		case FIREFOX:
//			FirefoxProfile profile = new FirefoxProfile();
//			File ffFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.xpi");
//			profile.addExtension(ffFile);
//			
//			FirefoxOptions ffoption = new FirefoxOptions();
//			ffoption.setProfile(profile);
//			driver = new FirefoxDriver(ffoption);
//			
			driver = new FirefoxDriver();
//			Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.xpi");
//			FirefoxDriver ffDriver = (FirefoxDriver) driver;
//			ffDriver.installExtension(xpiPath);
//			driver = ffDriver;
			
			break;
		case EDGE:
//			File edgeFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
//			EdgeOptions edgeoption = new EdgeOptions();
//			path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
//			extensionFilePath = new File(path.toUri());
//			edgeoption.addExtensions(extensionFilePath);
			driver = new EdgeDriver();
			break;
		case CHROME_HEADLESS:
			ChromeOptions chOption = new ChromeOptions();
			chOption.addArguments("--headless");
			chOption.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(chOption);
			break;
		case FIREFOX_HEADLESS:
			FirefoxOptions ffOption = new FirefoxOptions();
			ffOption.addArguments("--headless");
			ffOption.addArguments("windown-size=1920x1080");
			driver = new FirefoxDriver(ffOption);
			break;
		case EDGE_HEADLESS:
			EdgeOptions egOption = new EdgeOptions();
			egOption.addArguments("--headless");
			egOption.addArguments("windown-size=1920x1080");
			driver = new EdgeDriver(egOption);
			break;
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	protected WebDriver getBrowserEnvironment(String browserName, String serverName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid");
		}
		System.out.println("Servername:" + serverName);
		driver.get(getUrlByServerName(serverName));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	private String getUrlByServerName(String serverName) {
		ServerList server = ServerList.valueOf(serverName.toUpperCase());
		switch (server) {
		case DEV:
			serverName = "https://www.saucedemo.com/";
			break;
		case TEST:
			serverName = "https://www.saucedemo.com/";
			break;
		case STAGING:
			serverName = "https://www.saucedemo.com/";
			break;
		default:
			new IllegalAccessException("Unexpected value:" + serverName);
		}
		return serverName;
	}
	protected String getEmailAdress() {
		Random rand = new Random();
		return "emily" + rand.nextInt(9999) + "@gmail.com";
	}
	
	protected String getEmailAddress(String prefix) {
		Random rand = new Random();
		return prefix + rand.nextInt(9999) + "@gmail.com";
	} 
	protected void quitBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI 'IMAGENAME eq " + browserDriverName + "*'";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("------------------- PASSED ---------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED ---------------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("------------------- PASSED ---------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED ---------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------------------- PASSED ---------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED ---------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeSuite
	public void deleteFileInReport() {
		// Remove all file in ReportNG screenshot (image)
		deleteAllFileInFolder("reportNGImage");

		// Remove all file in Allure attachment (json file)
		deleteAllFileInFolder("allure-json");
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
