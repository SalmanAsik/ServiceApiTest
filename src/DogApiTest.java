import java.io.IOException;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.apache.http.client.ClientProtocolException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("deprecation")
public class DogApiTest {
	private WebDriver driver;
	public static String driverPath = "E:\\Chrome\\";
	public static final String listalldogbreeds = "https://dog.ceo/api/breeds/list/all";
	public static final String lisrretrieverbreed = "https://dog.ceo/api/breed/retriever/list";
	public static final String listgoldenretrieverrandomimages = "https://dog.ceo/api/breed/retriever/golden/images/random";
	private String baseUrl;
	@Before
	public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		  driver = new ChromeDriver();
		    baseUrl = "https://dog.ceo/dog-api/";
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	
	
	@After
	public void tearDown() throws Exception {
		 driver.close();
		 driver.quit();
	}
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		driver.get(baseUrl);
		driver.navigate().to(listalldogbreeds);
		driver.navigate().to(lisrretrieverbreed);
		driver.navigate().to(listgoldenretrieverrandomimages);
	 WebElement webElement = driver.findElement(By.tagName("pre"));
	 DogApiResponse DogApiResponse = new DogApiResponse();
	 //get string response of listalldogbreeds
	 String ExpectedString=DogApiResponse.GetResponse();
	 //get string response of lisrretrieverbreed
	 String ExpectedStringforretriever = DogApiResponse.GetResponseforretriever();
	//get string response of listgoldenretrieverrandomimages
	 String ExpectedStringforretrievergolden = DogApiResponse.GetResponseforretrievergolden();
	 //verify the response of listalldogbreeds
	 Assert.assertTrue(webElement.getText().equals(ExpectedString));
	//verify the response of lisrretrieverbreed
	 Assert.assertTrue(webElement.getText().equals(ExpectedStringforretriever));
	//verify the response of listgoldenretrieverrandomimages
	 Assert.assertTrue(webElement.getText().equals(ExpectedStringforretrievergolden));
	}
}