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

public class NewColumn {

	@Keyword
	def Calculated_Column(extentTest,columnname) {
		//Step 4: create a new calculated column
		//Click on the calculated new column
		TestObject calcolobj=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Datatable_headings'), "text", "contains", "Calculated Columns", true)
		//click on the new column


		WebUI.click(calcolobj)
		WebUI.delay(2)
		TestObject newcolobj=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Datatable_headings'), "text", "contains", "New Column", true)
		WebUI.click(newcolobj)
		//select the calculated option from the new column
		WebUI.delay(2)
		TestObject calobj=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Fetch_Sheets'), "text", "contains",columnname, true)
		WebUI.click(calobj)

		WebUI.delay(5)
		extentTest.log(LogStatus.PASS, 'Select the'+ columnname+'  option from the Calculated column')
		//verify the new calculated column should appear in the Table

	}
}
