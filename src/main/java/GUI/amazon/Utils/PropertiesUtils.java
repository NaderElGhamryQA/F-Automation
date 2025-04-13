package GUI.amazon.Utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties LoadProperties(String filepath) {
        File file = new File(filepath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        } catch (IOException e) {
            throw new RuntimeException("couldn't load the properties");
        }
    }
}
