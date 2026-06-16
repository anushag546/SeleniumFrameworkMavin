package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {

        String path = System.getProperty("user.dir")
                + "/screenshots/" + name + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}