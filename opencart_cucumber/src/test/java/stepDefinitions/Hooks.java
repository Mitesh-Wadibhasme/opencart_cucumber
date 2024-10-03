package stepDefinitions;   //Hooks will be automatically trigger as soon as any steps are executed -before executing the steps setup method will trigger and complting all the steps tear down method will be executed
                             //Hooks are nothing but reusable methods
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();    //it will load the property file load the environment get the url from basclass and will return the driver and thats the purpose of initilizeBrowser method 
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));    //will launch the browser
    	driver.manage().window().maximize();
    
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep     //this method will execute for every step and if particular scenario got failed then only this will take ss 
    public void addScreenshot(Scenario scenario) {     //we have to pass scenario as parameter as as featured file contaions everything in scenario
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);   //here we are not taking as file format we directly can see this ss in JUnit report
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
   
}
