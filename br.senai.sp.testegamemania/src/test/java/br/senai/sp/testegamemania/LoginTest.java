package br.senai.sp.testegamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private WebDriver driver;
	
	@Before
	public void SetUpTestGM() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome-driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void LoginTestGM () throws InterruptedException {
		driver.get("http://localhost:4200/");
		Thread.sleep(2000);
		String path1 = "/html/body/app-root/app-header/header/div[1]/nav/a[2]/img";
		WebElement input1 = driver.findElement(By.xpath(path1));
		input1.click();
		
		// Primeiro teste: senha incorreta
		driver.findElement(By.id("email")).sendKeys("leonardo@email.com");
		driver.findElement(By.id("password")).sendKeys("discodefreio");
		driver.findElement(By.xpath("/html/body/app-root/app-login/main/form/button")).click();
		WebElement message1 = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));
		System.out.println(message1.getText());
		
		// Segundo teste: email não encontrado
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("leonardo@gmail.com");
		driver.findElement(By.id("password")).sendKeys("batatagratinada");
		driver.findElement(By.xpath("/html/body/app-root/app-login/main/form/button")).click();	
		WebElement message2 = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));	
		System.out.println(message2.getText());
		
		// Terceiro teste: sucesso no login
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("leonardo@email.com");
		driver.findElement(By.id("password")).sendKeys("batatagratinada");
		driver.findElement(By.xpath("/html/body/app-root/app-login/main/form/button")).click();
		Thread.sleep(1000);
		WebElement message3 = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));	
		System.out.println(message3.getText());
		// O texto exibido "Você está logado!" aparece após o Thread.sleep; sem ele, trazia de novo o "Cannot find user"
		
		//Re-teste
		Thread.sleep(2000);
		String path2 = "/html/body/app-root/app-home/header/div[1]/nav/a[2]";
		WebElement input2 = driver.findElement(By.xpath(path2));
		input2.click();
		
		String[] listaEmail = {"leonardo@email.com", "leonardo@gmail.com", "leonardo@email.com"};
		String[] listaPassword = {"discodefreio", "batatagratinada", "batatagratinada"};
		
		for (int tentativas = 0; tentativas < 3; tentativas++) {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("email")).sendKeys(listaEmail[tentativas]);
			driver.findElement(By.id("password")).sendKeys(listaPassword[tentativas]);
			driver.findElement(By.xpath("/html/body/app-root/app-login/main/form/button")).click();	
			WebElement message = driver.findElement(By.xpath("/html/body/app-root/app-login/main/p"));
			Thread.sleep(1000);
			System.out.println(message.getText());
		}
		
		
	}
	
//	@After
//	public void CloseWindow () {
//		driver.close();
//	}
}
