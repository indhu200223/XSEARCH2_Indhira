
package apTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.BrowserType;
///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {
    RemoteWebDriver driver;

    public TestCases() throws MalformedURLException {
        System.out.println("Constructor: TestCases");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);


        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test Case : TestCase01");

        driver.get("https://www.wikipedia.org");

        String currenturl = driver.getCurrentUrl();

        String expectedurlTitle = "wikipedia";

        if (currenturl.contains(expectedurlTitle)) {

            System.out.println("Printing the Title of url: " + expectedurlTitle);

        } else {
            System.out.println("Page doesn't contain: " + expectedurlTitle);
        }


        System.out.println("end Test case: testCase01");
    }


    public void testCase02() {

        System.out.println("Start Test Case : TestCase02");

        driver.get("https://www.wikipedia.org");

        WebElement headerName = driver.findElement(By.xpath("//h1"));
        String currentHeaderText = headerName.getText();

        String actualHeader = "Wikipedia";

        if (currentHeaderText.trim().contains(actualHeader)) {
            System.out.println("Printing Header Name: " + actualHeader);
        } else {
            System.out.println("Header name is not : " + actualHeader);
        }

        String termsOfUseLinkText = driver.findElementByLinkText("Terms of Use").getText();
        String PrivacyPolicyLinkText = driver.findElementByLinkText("Privacy Policy").getText();


        if (!termsOfUseLinkText.isEmpty() && !PrivacyPolicyLinkText.isEmpty()) {

             System.out.println("Verify Wikipedia Header and Footer: Header and footer LinkText is found");
        } else {

            System.out.println("Verify Wikipedia Header and Footer: Header and footer LinkText not found");
        }
         System.out.println("end Test case: testCase02");
       }


       public void testCase03(){

        driver.get("https://www.wikipedia.org");
     
        driver.findElementByName("search").sendKeys("apple");
     
        WebElement appleinc = driver.findElement(By.xpath("(//h3)[2]"));
        appleinc.click();
     
       WebElement steveJobs = driver.findElement(By.xpath("//div[@id='mw-content-text']//*[contains(text(),'Steve Jobs')]"));
        
       if(steveJobs.isDisplayed()){
         System.out.println("Steve jobs is listed as a founder");
       }
       else{
     
         System.out.println("Steve jobs is not listed as a founder");
       }
     
       System.out.println("end Test case: testCase03");
     }

     
     public void testCase04(){

        driver.get("https://www.wikipedia.org");
    
        driver.findElementByName("search").sendKeys("microsoft");
    
        WebElement microsoft = driver.findElement(By.xpath("(//a[@class='suggestion-link'])[1]"));
        microsoft.click();
    
        WebElement billgates = driver.findElement(By.xpath("//a[@title='Bill Gates']"));
        billgates.click();
    
    
        String currenturl = driver.getCurrentUrl();
    
        if(currenturl.contains("Bill_Gates")){
            System.out.println("Opened URL contains Bill_Gates");
    
        }
        else{
            System.out.println("Opened URL does not contains Bill_Gates");
    
        }
        System.out.println("end Test case: testCase04");
    }
    

    
    public void testCase05(){

        driver.get("https://en.wikipedia.org/");
    
        WebElement sidebar = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        sidebar.click();
    
    
        WebElement mainmenu = driver.findElement(By.xpath("(//button[text()='move to sidebar'])[1]"));
        mainmenu.click();
    
        WebElement aboutWikipedia = driver.findElement(By.xpath("//a[text()='About Wikipedia']"));
    
        String currentUrl = driver.getCurrentUrl();
    
        if(currentUrl.contains("About")){
    
            System.out.println("opened URL contains About");
        }
        else{
            System.out.println("opened URL does not contain About");
        }
    
    System.out.println("end Test case: testCase05");
    
    }
    
    
    
    }









