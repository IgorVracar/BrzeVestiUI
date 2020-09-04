package base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Configuration;
import java.io.IOException;

public class BaseTest {
    protected static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        // Initialize driver
        driver = new ChromeDriver();
        // Maximize Chrome window
        driver.manage().window().maximize();
        // Go to LoginPage
        driver.get("http://bvtest.school.cubes.rs/login");
        
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }  
}
