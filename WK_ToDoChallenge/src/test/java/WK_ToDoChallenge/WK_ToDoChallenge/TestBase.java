package WK_ToDoChallenge.WK_ToDoChallenge;


import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class TestBase {
	
	protected WebDriver driver;
	
	
	public TestBase() {
		ChromeOptions options = new ChromeOptions();
		String file = "TestData\\environment.json";
		JSONObject jsonObject = JsonReader.jsonReader(file);
		String url = (String)jsonObject.get("url");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"/chromedriver.exe");
		options.addArguments("--disable-blink-features=AutomationControlled");
		driver=new ChromeDriver(options);
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
}
