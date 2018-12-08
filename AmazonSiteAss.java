package com.ibm.seleniumconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSiteAss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		List<WebElement> linksEle=driver.findElements(By.tagName("a"));
		int noOfLinks=linksEle.size();

		System.out.println(noOfLinks);

		WebElement linkEle1=linksEle.get(0);

		String text1=linkEle1.getText();
		System.out.println(text1);

	}

}
