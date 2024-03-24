package com.automationexercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserManager {

    public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if
        (name.equalsIgnoreCase("edge")) {

            String pathExtension = PropertiesLoader.loadProperty("edge.extension.adblock.path");

            System.setProperty("webdriver.chrome.silentOutput", "true");
            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("load-extension=" + pathExtension); //uBlock Origin
            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {

//            String pathExtension1 = PropertiesLoader.loadProperty("firefox.extension.adblock.path");

            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("load-extension=" + pathExtension1);
//            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--private");
            driver = new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }
}
