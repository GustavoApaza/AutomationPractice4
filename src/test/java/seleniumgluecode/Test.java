package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {
    private ChromeDriver driver;

    @Given("^that the user is on the home page$")
    public void that_the_user_is_on_the_home_page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imalittletester.com/");
    }

    @When("^he clicks on the Comics tab$")
    public void he_clicks_on_the_Comics_tab() throws Throwable {
        WebElement comicNav = driver.findElement(By.id("comp-iiyocj9v5label"));
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        comicNav.click();
    }

    @Then("^the page displays several comics$")
    public void the_page_displays_several_comics() throws Throwable {
        WebElement comicPage = driver.findElement(By.xpath("//div[@id='comp-lc61aui31']/h2/span/span/span"));
        Assert.assertTrue("The text is not display", comicPage.isDisplayed());
        Assert.assertEquals("HE LITTLE TESTER COMICS SERIES", comicPage.getText());
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.quit();
    }
}
