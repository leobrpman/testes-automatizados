package br.senai.sp.automatcaoteste1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
	private WebDriver driver;
	
	@Before
	public void SetUpTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome-driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void NavGoogleTeste () {
		driver.get("https://online.sp.senai.br/");
		
		String id = "Busca1_txtFiltro";
		WebElement input = driver.findElement(By.id(id));
		
		input.sendKeys("gest?o");
		// input.sendKeys(Keys.ENTER);
		driver.findElement(By.id("Busca1_btnBusca")).click();
				
	}
	
//	@After
//	public void CloseWindow () {
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		driver.close();
//	}
}
