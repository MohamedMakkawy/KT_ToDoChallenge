package WK_ToDoChallenge.WK_ToDoChallenge;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
	
	private WebElement element;
	private WebDriver driver; 
	private WebDriverWait wait;
	private Actions actions;
	
	public ElementHelper(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(10));
		actions = new Actions(driver);
	}
	public void clickElement(By by){
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.click();
	}
	public void clickElement(WebElement element){
		element.click();
	}
	public void clearTextField(By by){
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.clear();
	}
	public void sendKeysElement(By by , String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.sendKeys(value);
	}
	public void hoverOnElement(By by)
	{
		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(element).perform();
	}
	public void doubleClickOnElement(By by)
	{
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(by));
        actions.doubleClick(element).perform();
	}
	
	public void waitForElementToBeInvisible(By by){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	public void waitForElementToBeVisible(By by){
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void assertion (By by , String expected)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
	  assertEquals(element.getText(),expected);
	}
	public void pressOnEnterButton (By by)
	{
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element = driver.findElement(by);
		element.sendKeys(Keys.ENTER);
	}
	
	public String getText(By by) {
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.getText();
	}
	public List<WebElement>findListOfElements(By by) {

		//element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		List<WebElement>mylist = driver.findElements(by);
		return mylist;
	}
	
	


	
	
	
	
}
