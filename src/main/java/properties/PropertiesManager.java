package properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties props= new Properties();
    private static FileInputStream file;
    private static FileOutputStream fileOutputStream;

    public static Properties getProp(){
        try {
            file = new FileInputStream(
                    "src/test/resources/project.properties");
            props.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static int getTimeout(){
        String timeoutS;
        timeoutS = getProp().getProperty("prop.timeout");
        assert timeoutS != null;
        return Integer.parseInt(timeoutS);
    }

    public static String getBuildNumber(){
        String build ;
        build = getProp().getProperty("build.number");
        assert build != null;
        return build;
    }

    public static void addBuildNumber(){
        int buildNumber = Integer.parseInt(getBuildNumber())+1;
        int timeOut = getTimeout();
        try {
            getProp();
            file.close();
            fileOutputStream = new FileOutputStream("src/test/resources/project.properties");
            getProp().setProperty("prop.timeout", String.valueOf(timeOut));
            getProp().setProperty("build.number", String.valueOf(buildNumber));
            getProp().store(fileOutputStream,null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
