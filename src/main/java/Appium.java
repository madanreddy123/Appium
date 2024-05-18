import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.messages.Messages;
import io.cucumber.plugin.event.Node;
import net.bytebuddy.implementation.Implementation;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
//                cap.setCapability("devicename", "sdk_gphone64_x86_64");
//                cap.setCapability("automationName", "UiAutomator2");
////                cap.setCapability("udid", "emulator-5554");
////                cap.setCapability("udid", "192.168.1.122:33045");
//                cap.setCapability("platformName", "Android");
//                cap.setCapability("platformVersion", "13.0 (T) - API 33");

                cap.setCapability("devicename", "Lenovo");
                cap.setCapability("automationName", "UiAutomator2");
                cap.setCapability("udid", "HGR4T8AG");
//                cap.setCapability("udid", "192.168.1.122:33045");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "13");

//                String apkUrl = "http://localhost:8000/shared/app.apk";
//                String localApkPath = "app.apk";
                
//                File myFile = new File("app.apk");
//                String escaped = myFile.getAbsolutePath();
//                System.out.println(escaped);

                cap.setCapability("app", "/home/AndroidApps/app.apk");
                cap.setCapability("appium:autoGrantPermissions", true);
                cap.setCapability("appWaitForLaunch", "false");
               cap.setCapability("remoteAdbHost", "host.docker.internal");
                // Initialize Appium driver
                AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/"), cap);

                driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

                driver.findElement(By.xpath("//android.widget.TextView[@text=\"Get started\"]")).click();
                Thread.sleep(3000);

                driver.findElement(By.xpath("//android.widget.TextView[@text=\"Accept all cookies\"]")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//android.widget.TextView[@text=\"Share location\"]")).click();

                Thread.sleep(3000);


                System.out.println("driver initiated");

            }
    }

}