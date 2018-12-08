package com.ibm.seleniumconcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableSalaryAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://datatables.net");
		List<WebElement> rowList=driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int Rsize=rowList.size();
		List<WebElement> clmns=driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
		int Csize=clmns.size();
		System.out.println("Row Size:"+Rsize+"Coulumn Size:"+Csize);
		int total=0;

		for(int i=1;i<=Rsize;i++)
		{
		int j=0;
		j=i+1;
		WebElement nameEle=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
		nameEle.click();
		WebElement salEle=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[1]/descendant::span)[2]"));

		String salary=salEle.getText().trim().replace("$","").replace(",","");
		total=total+Integer.parseInt(salary);
		nameEle.click();
		}
		System.out.println("Total of salary in Page 1"+total);
	}

}
