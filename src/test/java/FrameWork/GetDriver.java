package FrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDriver {

    public static WebDriver driverReturn ()

    {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();}


    }




