package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.CategoryPage;
import util.BrowserFactory;

public class CategoryTest {
	WebDriver driver;

	@Test
	public void CategoryIsAdded() throws InterruptedException {
		driver = BrowserFactory.init();
		CategoryPage category = PageFactory.initElements(driver, CategoryPage.class);

		category.enterCategory("Ruchy6");
		Thread.sleep(3000);
		category.clickAddCategoryButton();
		category.validateCategoryAdded();
		category.clickCategoryddl();
		category.visible();
		Thread.sleep(2000);

		category.clickMonthDdl();
		category.validateMonthddl();
		Thread.sleep(3000);

		category.enterCategory("Ruchy6");
		Thread.sleep(2000);
		category.clickAddCategoryButton();
		category.validateErrorMsg();
		Thread.sleep(2000);
		category.clickOnYes();
		BrowserFactory.teardown();

	}

}
