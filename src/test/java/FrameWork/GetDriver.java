package FrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDriver {

    public WebDriver GetDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
        }

    }



