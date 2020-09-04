import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Helper;


public class FirstJUnitTest {
    private static WebDriver driver;
    
    public FirstJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Initialize driver
        driver = new ChromeDriver();
        
        // Maximize Chrome window
        driver.manage().window().maximize();
        
        // Test step 1: Go to URL
        driver.get("http://bvtest.school.cubes.rs/login");
        
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Title: " + driver.getCurrentUrl());
        
        // Test step 2: Enter email in the email field
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        //Test step 3: Enter password in the password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        //Test step 4: Click on the LogIn button
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
        // end of login
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        System.out.println("Hi I am setUp method");   
    }
    
    @After
    public void tearDown() {
        System.out.println("Hi I am tearDown method");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    
    @Test
    public void testLogin (){             
              
        String expectedURL = "http://bvtest.school.cubes.rs/admin";
        String actualURL = driver. getCurrentUrl();
        
        assertEquals("URLs do not match.", expectedURL, actualURL);
    }
    
    @Test
    public void testAddNewCategory(){              
             
        // Test Case: Add new category
        
        // Test step 1: Go to categories page        
        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        
        // Test step 2: Click on "Add category" button
        WebElement addCategoryLink = driver.findElement(By.className("pull-right"));
        addCategoryLink.click();
        
        // Test step 3: Enter new title in the title field
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
        
        // Test step 4: Click on the Save button
        
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Title: " + driver.getCurrentUrl());
        
        
        //System.out.println("alert message is: " + alertMessage.getText());
        
        String expectedURL = "http://bvtest.school.cubes.rs/admin/categories";
        String actualURL = driver. getCurrentUrl();
        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedMessageSnipet = "Igor-";
        WebElement alertMessageElement = driver.findElement(By.className("alert-success"));
        String alertMessageText = alertMessageElement.getText();
        
        assertTrue("Alert message does not contain expected string", alertMessageText.contains(expectedMessageSnipet));
                        
    }
}
