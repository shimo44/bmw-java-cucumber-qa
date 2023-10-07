/**
 Author: Carl Jones III
 Date: 8/4/22
 Description: n/a
 **/
package StepDefinitions;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NavSteps {

    WebDriver driver;
    Document webApp;

    @Given("user has started a web browser")
    public void user_generates_browser(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }
    @And("user navigates to application home")
    public void user_navigated_to_home_page() {

        try{
            driver.navigate().to("https://www.bmw.com/en/index.html");
            System.out.println("Step Detail - user is navigated to web application");
        }catch (Exception e){
            System.out.println("Step Detail - failed to navigate user to web application");

            System.out.println(e);
        }

    }

    @Then("cookie overlay appears")
    public void page_loads_cookie_accept_or_deny(){
//        driver.findElement(By.cssSelector(".accept-button.button-primary")).click();
//        driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();

        try {
            webApp = Jsoup.connect("https://www.bmw.com/en/index.html").get();
            System.out.println("Step Detail - lets turn BMW.com into a bowl of soup!");

            String title = webApp.title();
            System.out.println("Page Title: " + title);


            Elements elements = webApp.getElementsByTag("Button");

            for (Element element : elements){
                System.out.println("Scraped Button Elements: " + element);
            }

            try {
                Element element = elements.get(0);
                System.out.println("Button Element: " + element);
                System.out.println("Step Detail - user has accepted all cookies");

            }catch (Exception e){
                System.out.println("Step Detail - user was unable to accept all cookies");

            }

        }catch (IOException e){
            System.out.println("Step Detail - failed to turn BMW.com into a bowl of soup!");
            System.out.println(e);
        }
    }

    @And("home screen is clear")
    public void user_ready_on_home_page(){
        System.out.println("Step Detail - user is ready");

    }

    @Then("user clicks on tab home")
    public void user_clicks_home_tab(){
        System.out.println("Step Detail - user clicks home tab within topnav");
    }

    @Then("user is redirected to the current page of the web application")
    public void user_links_to_home(){
        System.out.println("Step Detail - user is returned to homepage");
    }
}
