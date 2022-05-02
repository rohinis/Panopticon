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

//Click on the Existing Table that has cloumns



WebUI.click(findTestObject('Object Repository/Workbook_Page/workbook'))
//Create a new workbook

WebUI.delay(2)
//click on the edit button
WebUI.click(findTestObject('Object Repository/General_Button'))
//double click


//click on the Bar graph


WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Graph_Object'))
WebUI.delay(2)
//Drag and Drop the  Objects
//move the offset to Left

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Country', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Breakdown', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

//Drag the objects to Y.Axis

TestObject draggableobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Forex', true)
TestObject dropobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Y', true)

WebUI.dragAndDropToObject(draggableobject1, dropobject1)