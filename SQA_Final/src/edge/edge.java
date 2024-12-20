package edge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class edge {

    public static void main(String[] args) {
        // Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Add ChromeOptions to maximize the browser on startup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver); // Actions for hover

        try {
            // Navigate to Login Page
            driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Wait for Username, Password and Login button to be visible and enter credentials
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            username.sendKeys("jahidulislamsupta9@gmail.com");
            password.sendKeys("Carelogix24!!");
            loginButton.click();

            // Wait for 5 seconds after login
            Thread.sleep(5000);  // 5-second delay after sign-in

            // Locate and click the Group button using XPath
            WebElement groupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[1]/div[2]/div[1]/button[2]")));
            groupButton.click();
            System.out.println("Group button clicked successfully!");

            // Locate and click the specific group using XPath
            WebElement specificGroup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[2]/div/div/div[1]/div[1]")));
            specificGroup.click();
            System.out.println("Specific group clicked successfully!");

            // Hover over the message using XPath
            WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/div/div/div[2]/section/div/div/div/div[2]/div/div[9]/div[1]/div[1]/div[2]")));
            actions.moveToElement(message).perform();
            System.out.println("Hovered over the message successfully!");

            // Locate and click the three-dot message button using XPath
            WebElement messageThreeDot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/div/div/div[2]/section/div/div/div/div[2]/div/div[9]/div[1]/div[2]/div/div/button")));
            messageThreeDot.click();
            System.out.println("Three-dot message button clicked successfully!");
            WebElement reactOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/ul/li[3]/span/div")));
            reactOption.click();
            System.out.println("React option clicked successfully!");
            WebElement greatJobReact = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/main/div/div/div/div[2]/section/div/div/div/div[2]/div/div[9]/div[1]/div[1]/div[2]/div[1]/div[1]/div")));
            greatJobReact.click();
            System.out.println("Great Job react clicked successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Test completed!");
            // Properly close the browser
        }
    }
}
