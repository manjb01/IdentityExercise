package webUtility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

import static webUtility.BaseTest.getDriver;

public class LogFileMessage {
    private static Logger logger= null;

    public static void info(String info) {
        logger.info(info);
    }

    public static void displayMesage(String message) {
        System.out.println(message);

    }

    public static void startAndCloseTest(String message) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("~~~~~~~~~~~~" + message + "~~~~~~~~~~~~");
        System.out.println("------------------------------------------------------------------------");
    }

    public static void printStackTrace(Exception e) {
        takeScreenShot(e);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|       Cause     |  " + e.getCause());
        System.out.println("|       Class     |  " + e.getClass().getSimpleName());
        System.out.println("|       Message   |  " + WordUtils.wrap(e.getMessage(), 70));
        System.out.println("-----------------------------------------------------------------------");
        StackTraceElement[] elementList = e.getStackTrace();
        System.out.println("ATTENTION ! Below are the lines of code where the test fails");
        System.out.println("------------------------------------------------------------------------");
        for (int j = 0; j < elementList.length; j++) {
            if (elementList[j].getClassName().contains("com.mg")) {
                System.out.println(elementList[j]);
            }
        }
        System.out.println("------------------------------------------------------------------------");

        Assert.fail("Some exception occurred.");
    }

    public static void takeScreenShot(Throwable t) {
        try {

            String screenshotName = "snapshot_" + System.currentTimeMillis() + ".jpg";
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String pathName = System.getProperty("user.dir") + "/src/screenshots/" + screenshotName;
            FileUtils.copyFile(screenshot, new File(pathName));
            System.out.println("SnapshotName -> " + screenshotName);
            String targetPath = "../target/downloads/" + screenshotName;
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }

    public static void takeScreenShot() {
        try {

            String screenshotName = "snapshot_" + System.currentTimeMillis() + ".jpg";
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String pathName = System.getProperty("user.dir") + "/src/screenshots/" + screenshotName;
            FileUtils.copyFile(screenshot, new File(pathName));
            System.out.println("SnapshotName -> " + screenshotName);
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
    }

    public void error(String info) {
        logger.error(info);
    }


}
