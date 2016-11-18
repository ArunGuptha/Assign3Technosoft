package assignment2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Task3Flight extends Initialization {
	/*
	 * Step 1: Click on Flight Button Step 2: Enter "New York" on Flying from
	 * text field and select "LaGuardia" from suggestion Step 3: Enter "Las" on
	 * Flying to text field and select Las Vegas fro suggestion Step 4: Select
	 * Tomorrows Date as Departing date field Step 5: Select Day after tomorrows
	 * date in Returning date field Step 6: Select 4 adults Step 7: Select 1
	 * children Step 8: Select age Step 9: Click on Search Step 10: Verify this
	 * text "Select your departure to Las Vegas"
	 */

	@Test
	public void TravelDetailsAutofill() throws InterruptedException {

		getDriver().findElement(By.xpath(".//*[@class='tab-label' and text()='Flights']")).click();
		getDriver().findElement(By.id("flight-origin")).sendKeys("New york");
		Thread.sleep(4000);
		List<WebElement> Departingsuggestions = getDriver().findElements(By.className("results-item"));

		for (WebElement lis : Departingsuggestions) {
		
			if (lis.getText().contains("LaGuardia")) {
				
				lis.click();
				Thread.sleep(4000);
				break;
			}
		}

		getDriver().findElement(By.id("flight-destination")).sendKeys("las");
		List<WebElement> destinationSuggestion2 = getDriver().findElements(By.className("results-item"));
		for (WebElement lis2 : destinationSuggestion2) {
			if (lis2.getText().contains("McCarran")) {
				lis2.click();
				break;
			}
		}

		getDriver().findElement(By.id("flight-departing-wrapper")).click();

		List<WebElement> departingdate = getDriver().findElements(By.xpath(".//*[@id='package-departing-wrapper']/div/div/div[2]/table/tbody/tr/td"));
		
		for (WebElement Ddate : departingdate) {
			if (Ddate.getText().equals("25")) {
				Ddate.click();
				break;
			}
		}

	
		
		List<WebElement> Returndate = getDriver().findElements(By.className(".//*[@id='flight-returning-wrapper']/div/div/div[2]/table/tbody/tr/td"));

		for (WebElement Rdate : Returndate) {
			if (Rdate.getText().equals("37")) {
				Rdate.click();
				break;
			}
		}

		WebElement NumOfAdults = getDriver().findElement(By.cssSelector("#flight-adults"));
		Select dropdownAdults= new Select(NumOfAdults);
		dropdownAdults.selectByVisibleText("3");
		Thread.sleep(3000);
		
		WebElement NumOfChilds = getDriver().findElement(By.cssSelector("#flight-children"));
		Select dropdownchild= new Select(NumOfChilds);
		dropdownchild.selectByVisibleText("1");
		Thread.sleep(3000);
	
		WebElement NumOfChildage = getDriver().findElement(By.cssSelector("#flight-age-select-1"));
		Select dropdownchildage= new Select(NumOfChildage);
		dropdownchildage.selectByVisibleText("12");
		Thread.sleep(3000);
				
		getDriver().findElement(By.id("search-button")).click();
	}
}
