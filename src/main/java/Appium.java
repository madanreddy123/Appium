import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;

public class Appium {

    /// launch the appium
    // connect the device to the machine

    @Test

    public void dd() throws IOException, InterruptedException {

            String[] command = {"adb", "devices"};
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("ANDROID_ADB_SERVER_HOST", "host.docker.internal");
            Process process = processBuilder.start();

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            // Wait for the command to finish and get the exit code
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                String devicesInfo = output.toString();
                System.out.println(devicesInfo);
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability("devicename", "Lenovo");
                cap.setCapability("automationName", "UiAutomator2");
//                cap.setCapability("udid", "HGR4T8AG");
                cap.setCapability("udid", "192.168.1.122:33045");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "13");
                cap.setCapability("appPackage", "com.google.android.apps.youtube.music");
                cap.setCapability("appActivity", "com.google.android.apps.youtube.music.activities.MusicActivity");
               cap.setCapability("remoteAdbHost", "host.docker.internal");
                // Initialize Appium driver
                AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/"), cap);

                driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
            }

            System.out.println("driver initiated");


    }

}