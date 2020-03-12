package BookStudy;

import FrameWork.GetDriver;
import FrameWork.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Chapter1 {
    public static void main(String[] args) {

        WebDriver driver = GetDriver.driverReturn();
driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");


driver.findElement(By.id("heightCMS")).sendKeys("190");
driver.findElement(By.name("weightKg")).sendKeys("86");
driver.findElement(By.id("Calculate")).click();
        Wait.wait(3);


        driver.close();



    }
}
