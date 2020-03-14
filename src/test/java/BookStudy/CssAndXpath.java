package BookStudy;

import FrameWork.GetDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import static org.testng.AssertJUnit.assertTrue;

public class CssAndXpath {

    public static void main(String[] args) {
//create a Webdriver
        WebDriver driver= GetDriver.driverReturn();
//navigate to website
        driver.get("http://cookbook.seleniumacademy.com/Locators.html");
//css find by whole id
        driver.findElement(By.cssSelector("#username")).sendKeys("ilhan");
//css tag name + attribute combo
        driver.findElement(By.cssSelector("input#password")).sendKeys("12345");
//css when we have to be more specific
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
        // x path version of previous
       // driver.findElement(By.xpath("//input[@type='submit][@value='login']"))


// Find the table which has id = users
        WebElement table1= driver.findElement(By.id("users"));
// Place all of table rows into a list
        List<WebElement> rows = table1.findElements(By.tagName("tr"));
// Iterate through rows and find what you need
        for (int i = 0; i <rows.size() ; i++) {
            if(rows.get(i).getText().contains("@"))
            System.out.println(rows.get(i).getText());
        }
//css Depending on font color we can find text
        System.out.println(driver.findElement(By.cssSelector("font[color='red']")).getText());

//css where the tag is p , find id starting with character c
        System.out.println(driver.findElement(By.cssSelector("p[id^='c']")).getText());

        //===  XPATH  ===


//xpath in the website there are 3 text with h3 tag but I need the third one
        System.out.println(driver.findElement(By.xpath("//h3[3]")).getText());
//xpath find the image where the alt text is equal to Previous
        WebElement previousButton = driver.findElement(By.xpath("//img[@alt='Previous']"));
//xpath find element with input tag and if any of its attribute has username value
        WebElement username = driver.findElement(By.xpath("//input[@*='username']"));
//xpath find the text where we have it in table and it's class name is model
        System.out.println(driver.findElement(By.xpath("//td[@class='model']")).getText());
//xpath Let's put previous query in List and check second Appearance
        List<WebElement> Models = driver.findElements(By.xpath("//td[@class='model']"));
        System.out.println(Models.get(1).getText());

        //When Some super Clever developer do not assign any attribute but we still have to access
        //Sometimes we can use different path
        //Find the table where is is items and follow the path (static table)
        WebElement cell = driver.findElement(By.xpath("//table[@id='items']/tbody/tr[2]/td[1]"));
        System.out.println(cell.getText());


        //===  ADVANCED CSS  ==

        // Username , Password and Login button is in form

//css Find the element under Form Parent (which has id of loginForm) which is first input child
       driver.findElement(By.cssSelector("form#loginForm>input")).sendKeys("ilhan");
//css 5th child of the form parent is password input so we can send keys
        driver.findElement(By.cssSelector("form#loginForm :nth-child(5)")).sendKeys("12345");
// When we have sibling elements find where tag is div and it's id is top5 and we need the second sibling of p element
        System.out.println(driver.findElement(By.cssSelector("div#top5 >p + p")).getText());
//css you can get the third sibling by skipping with asterisks
        System.out.println(driver.findElement(By.cssSelector("div#top5 >p + * + p")).getText());

        //===  JQUERY  ===

        List<String> checked = Arrays.asList(new String[]{"user128_admin","user220_browser"});
// Instance of JavaScript Executor from our driver
        JavascriptExecutor test=(JavascriptExecutor) driver;
// Locate checkboxes which are checked already on the website by JQuery find method it returns elements in array
        List<WebElement> elements =(List<WebElement>)test.executeScript("return jQuery.find(':checked')");
int count=0;  //just a simple counter
        //Iterate through elements where we have elements with checked boxes listed
        for (int i = 0; i <elements.size() ; i++) {
            //Compare our check list (expected result) with the above list
            // if it contains WebElement with Id attribute of matching
            if(checked.contains(elements.get(i).getAttribute("id")))
                count++;
        }
        //Basically, if number of matches equals to the check list then we are good
        if(count==checked.size())
            System.out.println(count+" numbers of boxes are checked correctly");


        //=== TABLE AND ROW OPERATIONS ===

// Let's get the simpleTable on the pointer
            WebElement simpleTable = driver.findElement(By.id("items"));
// We have the table in hand , let's create List which includes Rows on the table
            List<WebElement> Rows = simpleTable.findElements(By.tagName("tr"));
// This is like 2 - dimensional Array with Nested for loop where we have columns in rows
        //Basically, each row hold some columns
            for(WebElement row:Rows) {
                List<WebElement> Columns = row.findElements(By.tagName("td"));
                for (WebElement col : Columns) {
                    System.out.print(col.getText() + "\t");
                }
                System.out.println();
            }

            //=== CHILD ELEMENTS IN TABLE USING CSS AND XPATH ===


// Let's give John Admin access and remove it's browser access
        WebElement adminCheck = driver.findElement(By.xpath("//td[contains(text(),'John')]/following-sibling::td/descendant::div/label[contains(text(),'Admin')]/following-sibling::input"));
            adminCheck.click();
          driver.findElement(By.cssSelector("#user220_browser")).click();

        }
            }










