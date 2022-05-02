package expandgraph

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver

import internal.GlobalVariable

public class inputgraph {

	@Keyword
	def resizegraph() {
		WebDriver driver = DriverFactory.getWebDriver()
		Actions move = new Actions(driver);

		WebElement slider=driver.findElement(By.xpath('//div[contains(@class,"move-adorner secondary-50-fill")]'));
		move.dragAndDropBy(slider,-100, -100).build().perform()
		WebUI.delay(4)
		WebElement slider1=driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[5]'));
		move.dragAndDropBy(slider1,200, 0).build().perform()


		WebUI.delay(4)
		WebElement slider2=driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[9]'));
		move.dragAndDropBy(slider2,-100, 0).build().perform()

		WebUI.delay(4)
		WebElement slider3=driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[2]'));
		move.dragAndDropBy(slider3,0, -200).build().perform()


		WebUI.delay(4)

		WebUI.click(findTestObject('expand_graph/scrollable_content'))
	}
}
