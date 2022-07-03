package WK_ToDoChallenge.WK_ToDoChallenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoPOM extends ElementHelper{
	
	public ToDoPOM(WebDriver driver) {
		super(driver);
	}
	//Locators
	private By ItemTextFieldPath = By.xpath("//input[@placeholder='What needs to be done?']");
	private By FirstItemPath = By.xpath("//div[@class= 'view']/label");
	private By DeleteSingleItemPath = By.xpath("//button[@class='destroy']");
	private By ItemsCountPath = By.xpath("//span[@class='todo-count']/strong");
	private By ItemsCheckBoxPath = By.className("toggle");
	private By ClearAllButtonPath = By.xpath("//button[@class='clear-completed']");
	private By FirstItemTextFieldPath = By.xpath("//input[@class = 'edit']");
	private By FirstItemRowFieldPath = By.xpath("//div[@class='view']/label");
	
	
	//Action Methods
	public void addNewToDoItem(String item)
	{
		sendKeysElement(ItemTextFieldPath, item);
		pressOnEnterButton(ItemTextFieldPath);
	}
	public void EditFirstToDoItem(String item)
	{
		doubleClickOnElement(FirstItemPath);
		clearTextField(FirstItemTextFieldPath);
		doubleClickOnElement(FirstItemRowFieldPath);
		sendKeysElement(FirstItemTextFieldPath, item);
		pressOnEnterButton(FirstItemTextFieldPath);
	}
	public String getFirstItemName()
	{
		return getText(FirstItemPath);
	}
	public void deleteSingleItem()
	{
		hoverOnElement(FirstItemPath);
		clickElement(DeleteSingleItemPath);
	}
	public void verifyListIsEmpty()
	{
		waitForElementToBeInvisible(FirstItemPath);
	}
	public String getItemsCount()
	{
		return getText(ItemsCountPath);
	}
	public void deleteAllItems()
	{
		List<WebElement> elementsList= findListOfElements(ItemsCheckBoxPath);
		System.out.print(elementsList.size());
		for(WebElement element : elementsList) {
            clickElement(element);
        }
		clickElement(ClearAllButtonPath);
	}
	
	
}
