package ui;

import ui.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ui.pages.utils.ApiUtils;

public class AddUserTest extends BaseTest {

    @BeforeMethod
    public void setUpEnvironment() throws Exception {
        ApiUtils.sendDeleteRequest("https://test-api-one-gamma.vercel.app/users");
    }
    @AfterMethod
    public void tearDownEnvironment() throws Exception {
        ApiUtils.sendDeleteRequest("https://test-api-one-gamma.vercel.app/users");
    }

    @Test
    public void testAddingUser(){
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        String name = "Andrew Black";
        String email = "andrew.black@icanbreakit.eu";
        String age = "20";
        String role = "admin";
        userManagementPage.goToUserManagementPage()
                .enterName(name)
                .enterEmail(email)
                .enterAge(age)
                .enterRole(role)
                .clickAdd();

        Assert.assertEquals(userManagementPage.getNameAdded(name), name);
        Assert.assertTrue(userManagementPage.isAddingSuccessful());
        Assert.assertEquals(userManagementPage.getNumberOfUsers(), 1);

    }
}
