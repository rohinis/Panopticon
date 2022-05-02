package toLogin

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
import com.relevantcodes.extentreports.LogStatus as LogStatus

import internal.GlobalVariable

public class ForLogin {

	@Keyword
	def Login(extentTest){

		extentTest.log(LogStatus.PASS, 'Navigated to the Instance - '+GlobalVariable.G_BaseUrl)

		WebUI.waitForElementVisible(findTestObject('Object Repository/Username_Field'), 10)

		WebUI.setText(findTestObject('Object Repository/Username_Field'),GlobalVariable.G_userName )

		WebUI.setText(findTestObject('Object Repository/Password_Field'),GlobalVariable.G_Password )

		extentTest.log(LogStatus.PASS, 'Entered Username and Password  - '+GlobalVariable.G_userName +"    " + GlobalVariable.G_Password)


		WebUI.click(findTestObject('Object Repository/Login_Button'))

		extentTest.log(LogStatus.PASS, 'Clicked on the Login button')
	}
}

