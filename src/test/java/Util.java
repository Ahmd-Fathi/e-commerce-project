import com.google.common.io.Files;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Util {

    public static void screenshotAfterTest_Pass(WebDriver driver, String screenshotName) throws IOException {

        var camera = (TakesScreenshot) driver;

        File recording = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(recording, new File("E:\\IdeaProjects\\Automation_F\\screenshotAfterTest_Pass" + screenshotName + ".png"));
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
