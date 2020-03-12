package BookStudy;

import FrameWork.GetDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindingLinks {

    public static void main(String[] args) {

        WebDriver driver = GetDriver.driverReturn();

        driver.get("http://cookbook.seleniumacademy.com/#");

        List<WebElement> alllinks = driver.findElements(By.tagName("a"));

        for (int i = 0; i <alllinks.size() ; i++) {
           if(alllinks.get(i).getAttribute("href").contains("html"))
               System.out.println(alllinks.get(i).getText());

        }


    }
}
