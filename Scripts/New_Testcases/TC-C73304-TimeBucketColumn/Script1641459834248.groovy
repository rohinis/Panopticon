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
import com.relevantcodes.extentreports.LogStatus as LogStatus

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.exception.StepErrorException as StepErrorException



def Browser = GlobalVariable.G_Browser

String ReportFile = GlobalVariable.G_ReportName + '.html'

def extent = CustomKeywords.'reports.Generatereport.create'(ReportFile, GlobalVariable.G_Browser, GlobalVariable.G_BrowserVersion)

def LogStatus = com.relevantcodes.extentreports.LogStatus

def extentTest = extent.startTest(TestCaseName)
try {
//Login to the Application

CustomKeywords.'toLogin.ForLogin.Login'(extentTest)

//Create a New Workbook
WebUI.delay(2)

CustomKeywords.'workbook.newworkbook.createworkbook'(workbookname,extentTest)

//Create a DataTable and and select the text
if(UserChoice == "KDB") {
	CustomKeywords.'datatable.CreateTable_KDB.createdataTable'(extentTest, datatablevalue)
	
}
else {
CustomKeywords.'datatable.CreateTable_TimeBucket.createdatatable'(extentTest)
}

//create TimeBucket column
//Create a New Ranking Column from the newcolumn option
CustomKeywords.'datatable.NewColumn.Calculated_Column'(extentTest,columnname)


extentTest.log(LogStatus.PASS, 'Select the Month Checkbox and Year Checkbox')
WebUI.click(findTestObject('Object Repository/Month_Checkbox'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Year_Checkbox'))
WebUI.delay(2)


WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))

//Verify the new updated column should appear in the Table
TestObject newyearcolumn=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Calculated_column'), "text", "contains", "Year", true)
TestObject newmonthcolumn=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Calculated_column'), "text", "contains", "Month", true)

boolean newyrcol=WebUI.verifyElementPresent(newyearcolumn,5, FailureHandling.CONTINUE_ON_FAILURE)
boolean newmonthcol=WebUI.verifyElementPresent(newmonthcolumn,5, FailureHandling.CONTINUE_ON_FAILURE)


if(newyrcol&&newmonthcol )
	extentTest.log(LogStatus.PASS, 'Verify the New column should appear in the table')
	else
		extentTest.log(LogStatus.FAIL, 'Failed to verify the column')
	
//click on the save buttn
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
//click on the back button
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button')
//Draw the Visualization graph
//double click on the dashboard

WebUI.delay(4)

WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
WebUI.delay(2)
//Select the BAR Graph
extentTest.log(LogStatus.PASS, 'Double-click on the Empty Dashboard')
WebUI.click(findTestObject('Object Repository/Graph_Object'))
//Drag the new updated column to the Y-axis of the Graph
extentTest.log(LogStatus.PASS, 'Select the Bar-Graph from the Timeseries visualization')

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'contains', 'Year', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Color', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

TestObject draggableobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'contains', 'Month', true)
TestObject dropobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Color', true)

WebUI.dragAndDropToObject(draggableobject1, dropobject1)


if(UserChoice == "KDB") {
	WebUI.delay(2)

TestObject draggableobject2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'sym', true)
TestObject dropobject2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Items', true)

WebUI.dragAndDropToObject(draggableobject2, dropobject2)}
else {
	WebUI.delay(2)
	TestObject draggableobject2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'a', true)
	TestObject dropobject2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Items', true)

WebUI.dragAndDropToObject(draggableobject2, dropobject2)}




extentTest.log(LogStatus.PASS, 'Drag and drop the Year amd Month Column to the Y axis and text Column to the Breakdown')
//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
extentTest.log(LogStatus.PASS, 'Click on the save button')

extentTest.log(LogStatus.PASS, 'Expand the sliders to view the full graph')
CustomKeywords.'expandgraph.inputgraph.resizegraph'()

boolean result
if(UserChoice != "KDB") 
result=CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid,extentTest,graphlocation,runtimegraph)
else
result=	CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid,extentTest,graphlocationkdb,runtimegraphkdb)


if (result) {
	extentTest.log(LogStatus.PASS, ('Verified :: ' + TestCaseName) + ' :: Sucessfully')
} else {
	extentTest.log(LogStatus.FAIL, TestCaseName + ' :: failed')
}
}

catch (StepErrorException e) {
	String screenShotPath = (('ExtentReports/' + TestCaseName) + GlobalVariable.G_Browser) + '.png'

	WebUI.takeScreenshot(screenShotPath)

	String p = (TestCaseName + GlobalVariable.G_Browser) + '.png'

	extentTest.log(LogStatus.FAIL, ex)

	extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(p))

	KeywordUtil.markFailed('ERROR: ' + e)
}
finally {
	extent.endTest(extentTest)

	extent.flush()
}



