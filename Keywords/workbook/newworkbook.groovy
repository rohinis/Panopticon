package workbook

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

public class newworkbook {
	@Keyword
	def createworkbook( workbookname,extentTest) {

		extentTest.log(LogStatus.PASS, 'Click on the New Workbook button')

		WebUI.waitForElementVisible(findTestObject('Object Repository/New_Workbook'), 10)

		WebUI.click(findTestObject('Object Repository/New_Workbook'))
		WebUI.delay(2)

		WebUI.setText(findTestObject('Object Repository/Input_Field'), workbookname)

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Create_Button'))
		extentTest.log(LogStatus.PASS, 'Workbbok created wih the name '+ workbookname)

		WebUI.delay(2)
	}
}