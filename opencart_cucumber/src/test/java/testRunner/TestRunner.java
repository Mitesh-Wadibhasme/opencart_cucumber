package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		          //features= {".//Features/"},
                  //features= {".//Features/Login.feature"},
                  //features= {".//Features/LoginDDTExcel.feature"},
                  features= {".//Features/Login.feature",".//Features/Registration.feature"},
                  //features= {"@target/rerun.txt"},   //when you want to execute only failure test cases 
                  glue="stepDefinitions",
                  plugin= {"pretty", "html:reports/myreport.html",     //by this command jUnit reports will be created
                		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" , //to generate extent report
    					    "rerun:target/rerun.txt",   //Contains only failure scenario and store in target folder
    					   },
                 dryRun=false,    //by default it is false. checks mapping between scenario steps and step definition methods
				 monochrome=true,    // to avoid junk characters in output
				 publish=true   // to publish report in cucumber server and share  with your team member
				 //tags="@sanity"  // this will execute scenarios tagged with @sanity
				 //tags="@regression"
				 //tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
				 //tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
				 //tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
 
                  
		           )









public class TestRunner {

}
