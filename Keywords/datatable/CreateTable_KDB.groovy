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

public class CreateTable_KDB {

	@Keyword

	def createdataTable(extentTest, String DataValue_Table) {


		//Create a DataTable using KDB Connector
		//Create a New Data Table
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

		WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))
		extentTest.log(LogStatus.PASS, 'Click on the new Data table')

		//select  on the kbd
		WebUI.delay(2)
		TestObject kbdconnector=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/File_Selection'), "text", "contains", "Kdb+", true)
		WebUI.click(kbdconnector)
		extentTest.log(LogStatus.PASS, 'Select Kdb+ connector from the File/URL')

		extentTest.log(LogStatus.PASS, 'Load the NameSpace and Load the Table ')

		WebUI.click(findTestObject('Object Repository/DataTable/NameSpace_Load_Button'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataTable/Table_Load_Button'))

		extentTest.log(LogStatus.PASS, 'Click on the UnityDropdown button and Select the Table Value from the data Table ')
		WebUI.click(findTestObject('Object Repository/DataTable/unity_dropdown_Table'))

		WebUI.delay(2)
		//WebUI.click(findTestObject('Object Repository/DataTable/DataValue_Table'))

		TestObject datatablevalue=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/DataValue_Table'), "text", "contains",DataValue_Table, true)
		WebUI.click(datatablevalue)

		//Click on Generete Columns and Click on refresh Preview
		//click on the Generate Columns
		WebUI.click(findTestObject('Object Repository/DataTable/generate_columns'))

		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
		extentTest.log(LogStatus.PASS, 'Click on the Generate Columns and Refresh Preview button')

		//Click on the save button
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))

	}
}
