package configurationfilepath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.constant.TestConstant;
import com.report.Log;

public class ConfigurationFile {

	/*
	 * Initialize properties.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void initializeProperties() throws IOException {
		// TODO Auto-generated method stub

		TestConstant.properties = new Properties();

		try {
			TestConstant.input = new FileInputStream(TestConstant.xpath_file);

		} catch (FileNotFoundException e) {
			Log.error(TestConstant.xpath_file + "file is missing");
			e.printStackTrace();

		}
		try {
			TestConstant.properties.load(TestConstant.input);
		} catch (IOException e) {
			Log.error("unable to load properties from " + TestConstant.xpath_file);
			e.printStackTrace();
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 * @throws Exception the exception
	 */
	public static String getProperty(String key) throws Exception {
		// TODO Auto-generated method stub
		if (TestConstant.properties == null) {
			initializeProperties();
		}
		String value = TestConstant.properties.getProperty(key);
		if (value == null) {
			throw new Exception("Porperty: " + value + " not defined in " + TestConstant.xpath_file);
		}

		return value;
	}

}
