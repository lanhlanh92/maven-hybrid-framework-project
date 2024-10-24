package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 40;
	public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD = "admin";
	public static final String ADMIN_ORANGE_HRM_USERNAME = "Admin";
	public static final String ADMIN_ORANGE_HRM_PASSWORD = "admin123";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
	public static final String REPORT_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGImage" + File.separator ;
	public static final String BROWSER_EXTENSIONS = RELATIVE_PROJECT_PATH + File.separator + "browserExtensions" + File.separator ;
	public static final String EXTENT_PATH = null;
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String RESOURCES_PATH = RELATIVE_PROJECT_PATH + File.separator + "resources" + File.separator ;
	public static final String DATA_FILE_PATH = RELATIVE_PROJECT_PATH + File.separator + "dataTest" + File.separator ;
	public static final String ENVIRONMENT_CONFIG_PATH =  RELATIVE_PROJECT_PATH + File.separator + "environmentConfig" + File.separator ;
			
}
