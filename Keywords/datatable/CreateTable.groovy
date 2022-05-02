package datatable

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

public class CreateTable {

	@Keyword
	def createdatatable(fileupload,extentTest) {

		//Create a New Data Table
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

		WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))
		extentTest.log(LogStatus.PASS, 'Click on the new Data table')

		//select   on the ms excel

		WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/File_Selection'), 5)
		WebUI.click(findTestObject('Object Repository/DataTable/File_Selection'))
		extentTest.log(LogStatus.PASS, 'Select MS excel from the File section')

		//Upload the Excel file StocksTimeSeries

		WebUI.delay(3)
		WebUI.uploadFile(findTestObject('Object Repository/DataTable/Browse_button'), fileupload)
		extentTest.log(LogStatus.PASS, 'Upload the File')

		//fetch sheets and refresh preview
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Fetch_Sheets'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
		//click on the save buttn
		extentTest.log(LogStatus.PASS, 'Click on the Fetch Sheets and Refresh preview button')

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
		extentTest.log(LogStatus.PASS, 'Click on the Save button')

		WebUI.delay(5)
		WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))

		//Step 3:Click on edit datatable icon
		WebUI.click(findTestObject('Object Repository/Editable_datatable_Icon'))
		extentTest.log(LogStatus.PASS, 'Click on edit datatable icon')

		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Fetch_Sheets'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
	}
}
