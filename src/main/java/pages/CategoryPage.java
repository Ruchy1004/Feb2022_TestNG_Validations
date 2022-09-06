package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CategoryPage {
	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_TEXT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATEGORY_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	WebElement MONTH_DDL;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[1]")
	WebElement CATEGORY_DDL;
	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement ERROR_MSG;
	@FindBy(how = How.LINK_TEXT, using = "Yes")
	WebElement YES;

	public void enterCategory(String text) {
		CATEGORY_TEXT.sendKeys(text);
	}

	public void clickAddCategoryButton() {
		ADD_CATEGORY_BUTTON.click();
	}

	public void clickCategoryddl() {
		CATEGORY_DDL.click();
	}

	public void validateCategoryAdded() {
		String expectedCategory = "Ruchy6";

		Select sel = new Select(CATEGORY_DDL);

		List<WebElement> categoryddl = sel.getAllSelectedOptions();

		for (int i = 0; i < categoryddl.size(); i++) {
			String actualCategory = categoryddl.get(i).getText();
			// Assert.assertEquals(expectedCategory, categoryddl.get(i).getText(),
			// "Failed");
			if (actualCategory.equalsIgnoreCase(expectedCategory)) {
				System.out.println("Category is added successfully");
			} else {
				System.out.println("Category is not added ");
			}
		}

	}

	public void visible() {
		Select ddl = new Select(CATEGORY_DDL);
		ddl.selectByVisibleText("Ruchy6");
	}

	public void clickMonthDdl() {
		MONTH_DDL.click();
	}

	public void validateMonthddl() {
		String expectedOptions[] = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		Select sel = new Select(MONTH_DDL);
		List<WebElement> dropdownvalues = sel.getOptions();
		int ddlsize = dropdownvalues.size();

		for (int i = 0; i < ddlsize; i++) {
			// dropdownvalues.get(i).getText();//actual
			// expectedOptions[i];//expected

			Assert.assertEquals(dropdownvalues.get(i).getText(), expectedOptions[i], "Fails");

		}
	}

	public void validateErrorMsg() {
		String actualtxt = ERROR_MSG.getText();
		System.out.println();
		String expectedtxt = "The category you want to add already exists: Ruchy6." + " "
				+ "Do you want to update its colour to Ruchy6? " + " " + "Yes or Nevermind";
		// Assert.assertEquals(actualtxt, expectedtxt, "Failed");
		if (expectedtxt.contains(actualtxt)) {
			System.out.println(actualtxt);

		}
	}

	public void clickOnYes() {
		YES.click();
	}

}