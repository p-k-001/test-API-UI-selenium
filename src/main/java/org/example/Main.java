package org.example;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        URL url = new URL("https://test-api-one-gamma.vercel.app/users");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");

        WebDriver driver = new ChromeDriver();
        driver.get("https://test-api-ui-teal.vercel.app/");
        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));



        WebElement name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        WebElement submit = driver.findElement(By.cssSelector("button"));

        name.sendKeys("Lorenzo Lamas");
        email.sendKeys("lorenzo.lamas@gmail.com");
        submit.click();
    }
}