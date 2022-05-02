package image_Comparision

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCaseimport static com.kms.katalon.core.testdata.TestDataFactory.findTestDataimport static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.relevantcodes.extentreports.LogStatus as LogStatus
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


import org.openqa.selenium.WebElement;
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.exception.StepErrorException as StepErrorException

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver


import internal.GlobalVariable

public class Compare_Screenshots {
	@Keyword
	def  compare_graphs(idname,extentTest,graphlocation) {

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement logo1= driver.findElement(By.id(idname));
		//	Shutterbug.shootElement(driver,logo1).withName("graph1").save("D:\\copydata\\screenshots")
		WebUI.delay(5)
		def filePath = (RunConfiguration.getProjectDir() + '/BaseScreenshots/'+graphlocation +'.png')

		extentTest.log(LogStatus.PASS, "Saved Screeenshot"+ extentTest.addScreenCapture(filePath))

		File image= new File(filePath);
		BufferedImage expectedimage= ImageIO.read(image);

		WebElement logo= driver.findElement(By.id(idname));
		//driver.findElement(By.ById)

		//Shutterbug.shootElement(driver,logo).withName("graph2").save("D:\\copydata\\screenshots")
		WebUI.click(findTestObject('Object Repository/Visualization_part/Refresh_button'))
		extentTest.log(LogStatus.PASS, 'Click on the Refresh button')
		WebUI.delay(3)
		extentTest.log(LogStatus.PASS, 'Take the screenshot of a particular webelement at the runtime and compare with the saved screenshot ')

		boolean status=Shutterbug.shootElement(driver,logo).withName("graph").equals(expectedimage,0.1);
		Shutterbug.shootElement(driver,logo).withName("graph").save((RunConfiguration.getProjectDir() )+ '/BaseScreenshots/')
		String s=(RunConfiguration.getProjectDir() )+ '/BaseScreenshots/'+ "graph.png"
		extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(s))




		println("The return value is :: "+ status)
		if (status==true) {
			println("The images are same")
			extentTest.log(LogStatus.PASS, 'The Images are same ')



		}else {
			println("The images are different")
			extentTest.log(LogStatus.FAIL, 'The Images are Different ')


		}
		return status;

	}

}
