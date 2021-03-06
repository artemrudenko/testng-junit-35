package by.stqa.pft.quick;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by artemr on 1/31/2017.
 */
public class SeleniumAssertion extends Assertion{
  protected static WebDriver driver;
  public SeleniumAssertion(WebDriver driver) {
    super();
    this.driver = driver;
    this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  abstract private class SeleniumAssert implements IAssert{
    private final String message;
    public SeleniumAssert(String message){
      this.message = message;
    }
    @Override
    public String getMessage(){
      return message;
    }
    @Override
    public Object getActual(){
      return null;
    }
    @Override
    public Object getExpected(){
      return null;
    }
    @Override
    abstract public void doAssert();
  }

  public void asserPresentElementLocated(final By locator) {
    doAssert(new SeleniumAssert("There are no elements located by " + locator) {
      @Override
      public void doAssert() {
        assertTrue(driver.findElements(locator).size()>0, getMessage());
      }
    });
  }

  public void assertDisplayed(final WebElement element) {
    doAssert(new SeleniumAssert("Element " + element + " is not displayed") {
      @Override
      public void doAssert() {
        try {
          assertTrue(element.isDisplayed(), getMessage());
        }catch (StaleElementReferenceException ex){
          fail(getMessage());
        }
      }
    });
  }
}

