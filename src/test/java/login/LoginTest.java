package login;

import org.junit.Test;
import base.BaseTest;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/admin";
        String actualURL = driver. getCurrentUrl();
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        DashboardPage dashboardPage = new DashboardPage(driver);
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();        
        assertTrue("Failed - Panel Heading text does not match", expectedPanelHeadingText.equals(actualPanelHeadingText));
        
        dashboardPage.logout();
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @Test
    public void testEmptyFieldsLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email messages do not match", expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testInvalidEmailInvalidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email messages do not match", expectedEmailMessage.equals(actualEmailMessage));        
    }
    
    @Test
    public void testValidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        
        //Thread.sleep(5000);
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email messages do not match", expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testInvalidEmailValidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Failed - Email messages do not match", expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testCustomDataLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("hello@igor.rs");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
    }
    
    @Test
    public void testValidEmailEmptyPasswordLogin (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedURL = "http://bvtest.school.cubes.rs/login";
        String actualURL = driver. getCurrentUrl();        
        assertEquals("URLs do not match.", expectedURL, actualURL);
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getPasswordMessageText();
        Assert.assertTrue("Failed - Email messages do not match", expectedPasswordMessage.equals(actualPasswordMessage));
    }
}
