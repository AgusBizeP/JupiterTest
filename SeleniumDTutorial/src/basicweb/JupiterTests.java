package basicweb;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;

public class JupiterTests {
	//System.setProperty("webdriver.chrome.driver", "/Users/agusbize25/Desktop/selenium. work/selenium-java-3.141.59/libs/drivers/chromedriver");
	private WebDriver driver;
	private String baseURL;


	@Before
	public void SetUp() throws Exception {
		baseURL = "https://jupiter.cloud.planittesting.com/#/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);

	}


	@Test
	public void testCase1() {
		String baseURL = "https://jupiter.cloud.planittesting.com/#/";
		driver.get(baseURL);
		String expectedTitle = "Jupiter Toys";
		String expectedEmailError = "Email is required";
		String expectedForenameError = "Forename is required";
		String expectedMessageError = "Message is required";



		String actualTitle = "";
		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test case 1 - Step 1: Passed!");
		} else {
			System.out.println("Test case 1 - Step 1: Failed");
		}


		//Click on Contact page
		driver.findElement(By.id("nav-contact")).click();


		//Click on Submit
		driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();


		//validate errors

		String emailError = driver.findElement(By.id("email-err")).getText();

		if (emailError.contentEquals(expectedEmailError)){
			System.out.println("Test case 1 - Step 3: Email error message --> Passed!");
		}
		else {
			System.out.println("Test case 1 - Step 3: Email error message --> Failed");
		}


		String forenameError = driver.findElement(By.id("forename-err")).getText();

		if (forenameError.contentEquals(expectedForenameError)){
			System.out.println("Test case 1 - Step 3: Forename error message --> Passed!");
		}
		else {
			System.out.println("Test case 1 - Step 3: Forename error message --> Failed");
		}


		String messageError = driver.findElement(By.id("message-err")).getText();

		if (messageError.contentEquals(expectedMessageError)){
			System.out.println("Test case 1 - Step 3: 'Message' error message --> Passed!");
		}
		else {
			System.out.println("Test case 1 - Step 3: 'Message' error message --> Failed");
		}



		//Populate fields

		driver.findElement(By.id("forename")).click();

		driver.findElement(By.id("forename")).sendKeys("Agustina");


		driver.findElement(By.id("email"));
		driver.findElement(By.id("email")).sendKeys("agusbize25@gmail.com");

		driver.findElement(By.id("message"));
		driver.findElement(By.id("message")).sendKeys("This is a test");


		//validate errors are gone

		ArrayList<WebElement> errorMessages = (ArrayList<WebElement>) driver.findElements(By.className("help-inline"));
		boolean isDisplayed = false;
		int size = errorMessages.size();
		System.out.println("Size of the list: " + size);
		for(int i=0; i<size; i++) {
			isDisplayed = errorMessages.get(i).isSelected();

		}
		int expextedErrorMessages = 0;

		Assert.assertEquals(size, expextedErrorMessages);

		System.out.println("Test case 1 --> PASSED");


		//Assert.assertNotSame(size, expextedErrorMessages);

		//System.out.println("Test case1 --> FAILED");

	}




	@Test
	public void testCase2() {
		String expectedMessagesSuccessful = "Thanks Agustina, we appreciate your feedback.";


		//Click on Contact page
		driver.findElement(By.id("nav-contact")).click();

		//Populate fields

		driver.findElement(By.id("forename")).click();
		driver.findElement(By.id("forename")).sendKeys("Agustina");


		driver.findElement(By.id("email"));
		driver.findElement(By.id("email")).sendKeys("agusbize25@gmail.com");

		driver.findElement(By.id("message"));
		driver.findElement(By.id("message")).sendKeys("This is a test");

		//Click on Submit

		driver.findElement(By.xpath("/html/body/div[2]/div/form/div/a")).click();

		//Validate Successful submission message
		String messageValidation = driver.findElement(By.className("alert-success")).getText();

		if (messageValidation.contentEquals(expectedMessagesSuccessful)){
			System.out.println("Test Case 2 --> PASSED");
		}
		else {
			System.out.println("Test Case 2 --> FAILED");
		}


	}

	@Test
	public void testCase3() {

		//Click on Shop page
		driver.findElement(By.id("nav-shop")).click();

		//Add items
		driver.findElement(By.xpath("//*[@id=\"product-6\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-6\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();


		//Click on Cart page
		driver.findElement(By.id("nav-cart")).click();


		ArrayList<WebElement> itemsInCart = (ArrayList<WebElement>) driver.findElements(By.xpath("/html/body/div[2]/div/form/table/tbody/tr"));
		boolean isDisplayed = false;
		int size = itemsInCart.size();
		System.out.println("Size of the list: " + size);
		for(int i=0; i<size; i++) {
			isDisplayed = itemsInCart.get(i).isSelected();

		}
		int expecteditemsCart = 1;

		Assert.assertEquals(size, expecteditemsCart);
		System.out.println("Test case 3 --> PASSED");

		Assert.assertNotSame(size, expecteditemsCart);

		System.out.println("Test case1 --> FAILED");
	}




	@Test
	public void testCase4() {


		//Click on Shop page
		driver.findElement(By.id("nav-shop")).click();

		//Add items
		driver.findElement(By.xpath("//*[@id=\"product-2\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-2\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-4\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();
		driver.findElement(By.xpath("//*[@id=\"product-7\"]/div/p/a")).click();

		//Click on Cart page
		driver.findElement(By.id("nav-cart")).click();


		String expectedPriceStuffedFrog = "$10.99";
		String actualPriceStuffedFrog = "";

		//Verify prices frog
		actualPriceStuffedFrog = driver.findElement(By.xpath("/html/body/div[2]/div/form/table/tbody/tr[1]/td[2]")).getText();


		if (actualPriceStuffedFrog.contentEquals(expectedPriceStuffedFrog)){
			System.out.println("Test case 4 - Step 1: Passed!");
		}

		else {
			System.out.println("Test case 1 - Step 1: Failed");
		}


	}
}