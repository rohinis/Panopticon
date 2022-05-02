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

import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.relevantcodes.extentreports.LogStatus as LogStatus

public class CreateTable_TimeBucket {

	@Keyword
	def createdatatable(extentTest) {


		def textvalue;
		//Create a New Data Table
		WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

		WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))
		extentTest.log(LogStatus.PASS, 'Click on the new Data table')

		//select the text
		TestObject textlink=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/File_Selection'), "text", "equals", "Text", true)
		WebUI.click(textlink)
		//Select the text option from the FileSource Dropdown
		extentTest.log(LogStatus.PASS, 'Select text from the File section')
		WebUI.click(findTestObject('Object Repository/Filesource_dropdown'))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/Filesource_dropdown'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Filesource_dropdown'), Keys.chord(Keys.ARROW_DOWN))
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/Filesource_dropdown'), Keys.chord(Keys.ENTER))
		extentTest.log(LogStatus.PASS, 'Select text from the Text File Source Dropdown')

		def str
		File file = new File("D:\\timebucket.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));


		while ((str = br.readLine()) != null) {

			// Print the string
			//System.out.println(st);
			WebUI.sendKeys(findTestObject('Object Repository/DataTable/textarea_filesource'),str)
			WebUI.sendKeys(findTestObject('Object Repository/DataTable/textarea_filesource'), Keys.chord(Keys.ENTER))


		}
		WebUI.delay(2)
		extentTest.log(LogStatus.PASS, 'Enter the text in the text Field')
		//click on the Generate Columns
		WebUI.click(findTestObject('Object Repository/DataTable/generate_columns'))

		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
		extentTest.log(LogStatus.PASS, 'Click on the Generate Columns and Refresh Preview button')

		//click on the save buttn
		/*	WebUI.delay(2)
		 WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
		 WebUI.delay(5)
		 WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))
		 /* //Step 3:Click on edit datatable icon
		 WebUI.click(findTestObject('Object Repository/Editable_datatable_Icon'))
		 WebUI.delay(3)
		 WebUI.click(findTestObject('Object Repository/DataTable/Fetch_Sheets'))
		 WebUI.delay(3)
		 WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))*/
	}
}
