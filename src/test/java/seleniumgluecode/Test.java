package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    private ChromeDriver driver = Hooks.getDriver();

    @Given("^that the user is on the home page$")
    public void that_the_user_is_on_the_home_page() throws Throwable {
        String title = "imalittletester";
        WebElement titleMain = driver.findElement(By.xpath("//span[contains(text(),'imalittletester')]"));
        Assert.assertEquals(title, titleMain.getText());
    }

    @When("^he clicks on the Comics tab$")
    public void he_clicks_on_the_Comics_tab() throws Throwable {
        WebElement comicNav = driver.findElement(By.id("comp-iiyocj9v5label"));
        comicNav.click();
    }

    @Then("^the page displays several comics$")
    public void the_page_displays_several_comics() throws Throwable {
        WebElement comicPage = driver.findElement(By.xpath("//span[contains(text(),'HE LITTLE TESTER COMICS SERIES')]"));
        Assert.assertTrue("The text is not display", comicPage.isDisplayed());
        Assert.assertEquals("HE LITTLE TESTER COMICS SERIES", comicPage.getText());
    }
}
