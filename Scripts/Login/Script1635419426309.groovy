import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.waitForElementVisible(findTestObject('Object Repository/Username_Field'), 10)

WebUI.setText(findTestObject('Object Repository/Username_Field'),"all" )

WebUI.setText(findTestObject('Object Repository/Password_Field'),"tomcat" )

WebUI.click(findTestObject('Object Repository/Login_Button'))
//Create a new workbook

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Object Repository/New_Workbook'), 10)

WebUI.click(findTestObject('Object Repository/New_Workbook'))
WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Input_Field'), "workbook88")

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Create_Button'))

WebUI.delay(2)

//Create a New Data Table 
WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))

//click on the ms excel 

WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/File_Selection'), 5)
WebUI.click(findTestObject('Object Repository/DataTable/File_Selection'))

//Upload the Excel file
WebUI.delay(5)
WebUI.uploadFile(findTestObject('Object Repository/DataTable/Browse_button'), "D:\\StocksStatic.csv")


//Double click on the empty dashboard

//WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))

