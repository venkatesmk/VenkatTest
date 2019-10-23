import java.io.FileInputStream;
import java.util.Properties;

public class DeployTester {

	private Properties configProps = new Properties();
	private String endpointName;

	protected void initializeModified() {
		try {
			String systemProperties = System.getProperty("cs.config");
			systemProperties = verifySystemProperties(systemProperties);
			FileInputStream fis = new FileInputStream(systemProperties+ "/CSAAdvantageWS.properties");
			configProps.load(fis);
			System.out.println(configProps);
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	protected void initialize() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("cs.config") + "/CSAAdvantageWS.properties");
            configProps.load(fis);
    		System.out.println(configProps);

            fis.close();
        } catch (Throwable e) {
            System.exit(-1);
        }
    }
	
	
	private  String verifySystemProperties(String aString) {
	    if (aString == null) return null;
	    String cleanString = "";
	    for (int i = 0; i < aString.length(); ++i) {
	        cleanString += cleanChar(aString.charAt(i));
	    }
	    return cleanString;
	}

	private  char cleanChar(char aChar) {

	    // 0 - 9
	    for (int i = 48; i < 58; ++i) {
	        if (aChar == i) return (char) i;
	    }

	    // 'A' - 'Z'
	    for (int i = 65; i < 91; ++i) {
	        if (aChar == i) return (char) i;
	    }

	    // 'a' - 'z'
	    for (int i = 97; i < 123; ++i) {
	        if (aChar == i) return (char) i;
	    }

	    // other valid characters
	    switch (aChar) {
	        case '/':
	            return '/';
	        case '\\':
	            return '\\';
	        case '.':
	            return '.';
	        case '-':
	            return '-';
	        case '_':
	            return '_';
	        case ':':
	            return ':';
	        case ' ':
	            return ' ';
	    }
	    return '%';
	}

	public static void main(String[] args) {
		DeployTester tester = new DeployTester();
		tester.initializeModified();

	}

}
