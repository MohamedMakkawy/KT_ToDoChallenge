package WK_ToDoChallenge.WK_ToDoChallenge;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class VerifyPostiveTests extends TestBase {

	ToDoPOM toDoPOM;
  @BeforeTest
  public void beforeTest() {
	  toDoPOM = new ToDoPOM(driver);
  }
  //Verify that user is allowed to add new item
  @Test
  public void VerifyAddingNewItemTest(){
	  
	  toDoPOM.addNewToDoItem("Run");
	  assertEquals(toDoPOM.getFirstItemName(), "Run");
	  //clean up
	  toDoPOM.deleteAllItems();
  }
  
  //Verify that user is allowed to remove single item
  @Test
  public void VerifyRemovingNewItemTest(){
	  
	  toDoPOM.addNewToDoItem("Run");
	  toDoPOM.deleteSingleItem();
	  toDoPOM.verifyListIsEmpty();
	  
  }
  
  //Verify that the item count will increase when the user add new item to the list 
  @Test
  public void VerifyThatItemsCountIncreaseTest(){
	  
	  toDoPOM.addNewToDoItem("Run");
	  int countBefore = Integer.parseInt(toDoPOM.getItemsCount());
	  toDoPOM.addNewToDoItem("Run");
	  int countAfter = Integer.parseInt(toDoPOM.getItemsCount());
	  assertEquals(countAfter, countBefore+1);
	  //clean up
	  toDoPOM.deleteAllItems();
  }
  
  //Verify that user is allowed to check all items then delete
  @Test
  public void DeleteAllTest(){
	  
	  toDoPOM.addNewToDoItem("Run");
	  toDoPOM.addNewToDoItem("Run");
	  toDoPOM.deleteAllItems();
	  toDoPOM.verifyListIsEmpty();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
