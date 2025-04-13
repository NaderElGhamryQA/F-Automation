package GUI.amazon.Utils;

import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties =
                PropertiesUtils.LoadProperties("src/main/resources/Data/Data/data.properties");
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }

    public String getItemsUrl() {
        String prop = properties.getProperty("itemsUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find ItemURL in Property file");
    }

    public String getPhoneNumber() {
        String prop = properties.getProperty("phoneNumber");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find Phone Number in Property file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find password in Property file");
    }

    public String getDropDownAssertionXpath() {
        String prop = properties.getProperty("dropDownAssertionXpath");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find dropdown xpath in Property file");
    }

    public String getDropDownAssertionText() {
        String prop = properties.getProperty("dropDownAssertionText");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find dropdown xpath in Property file");
    }

    public String getFullName() {
        String prop = properties.getProperty("fullName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find full name in Property file");
    }

    public String getMobileNumber() {
        String prop = properties.getProperty("mobileNumber");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find mobile number in Property file");
    }

    public String getStreetName() {
        String prop = properties.getProperty("streetName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find street name in Property file");
    }

    public String getBuildingNo() {
        String prop = properties.getProperty("buildingNo");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find building number in Property file");
    }

    public String getNearestLandmark() {
        String prop = properties.getProperty("nearestLandmark");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find nearest landmark in Property file");
    }

    public String getCityName() {
        String prop = properties.getProperty("City");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find city name in Property file");
    }

    public String getDistrict() {
        String prop = properties.getProperty("district");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find district name in Property file");
    }
    public String getApiName() {
        String prop = properties.getProperty("APIName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find API name in Property file");
    }
    public String getJob() {
        String prop = properties.getProperty("APIJob");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find API name in Property file");
    }
}
