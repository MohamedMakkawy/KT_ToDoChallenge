package WK_ToDoChallenge.WK_ToDoChallenge;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class VerifyNegativeTests extends TestBase {

	ToDoPOM toDoPOM;
  @BeforeTest
  public void beforeTest() {
	  toDoPOM = new ToDoPOM(driver);
  }
  
  //Verify that user is not allowed to add empty item
  @Test
  public void VerifyAddingEmptyItemNotAllowedTest(){
	  
	  toDoPOM.addNewToDoItem("");
	  toDoPOM.verifyListIsEmpty();
  }
  //Verify that user is not allowed to add item has the name as spaces only
  @Test
  public void VerifyAddingSpacesOnlyItemNotAllowedTest(){
	  
	  toDoPOM.addNewToDoItem("        ");
	  toDoPOM.verifyListIsEmpty();
	  
  }
  //Verify that the system will trim any extra spaces in beginning or at the end of the item name
  @Test
  public void VerifyTrimExtraSpacesTest(){
	  
	  toDoPOM.addNewToDoItem("    Run    ");
	  assertEquals(toDoPOM.getFirstItemName(), "Run");
  }
  
  //Verify that user is not allowed to edit existing item and make the name equal to spaces only
  @Test
  public void VerifyEditingAlreadyExisitingItemWithSpacesTest(){
	  
	  toDoPOM.addNewToDoItem("Run");
	  toDoPOM.EditFirstToDoItem("");
	  toDoPOM.verifyListIsEmpty();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
