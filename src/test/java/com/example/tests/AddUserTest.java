package com.example.tests;

import com.example.tests.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.tests.utils.ApiUtils;

public class AddUserTest extends BaseTest{

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
        userManagementPage.goToUserManagementPage()
                .enterName(name)
                .enterEmail(email)
                .clickAdd();

        Assert.assertEquals(userManagementPage.getNameAdded(name), name);
        Assert.assertTrue(userManagementPage.isAddingSuccessful());
        Assert.assertEquals(userManagementPage.getNumberOfUsers(), 1);

    }
}
