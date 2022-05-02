import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.exception.StepErrorException as StepErrorException


//Login to the Application
def Browser = GlobalVariable.G_Browser

String ReportFile = GlobalVariable.G_ReportName + '.html'

def extent = CustomKeywords.'reports.Generatereport.create'(ReportFile, GlobalVariable.G_Browser, GlobalVariable.G_BrowserVersion)

def LogStatus = com.relevantcodes.extentreports.LogStatus

def extentTest = extent.startTest(TestCaseName)
try {
	
	

CustomKeywords.'toLogin.ForLogin.Login'(extentTest)

//Create a New Workbook 
WebUI.delay(2)

CustomKeywords.'workbook.newworkbook.createworkbook'(workbookname,extentTest)

//Create a DataTable and use 'Example StocksTimeSeries' as a data table[Timeseries example]


CustomKeywords.'datatable.CreateTable.createdatatable'(fileupload,extentTest)

//Select the column section
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Column_header'))
//Edit the Column name value
extentTest.log(LogStatus.PASS, 'Select the column section and Edit the Column name value ')
//Click on the refresh preview
WebUI.delay(3)
//WebUI.doubleClick(findTestObject('Object Repository/DataTable/column_object'))

WebUI.click(findTestObject('Object Repository/DataTable/column_object'))

WebUI.delay(2)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Column_text'), "12")
WebUI.delay(2)


WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
extentTest.log(LogStatus.PASS, 'Click on the Refresh Preview button ')

//Verify the new updated column should appear in the Table
TestObject newcolumn=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Calculated_column'), "text", "contains", "Ticker12", true)

boolean newcol=WebUI.verifyElementPresent(newcolumn,5, FailureHandling.CONTINUE_ON_FAILURE)

println("the new column is present"+newcol)
if(newcol)
	extentTest.log(LogStatus.PASS, 'Verify the new updated column should appear in the Table ')
	else
		extentTest.log(LogStatus.FAIL, 'Failed to verify the column')

//click on the save buttn
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
//click on the back button
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))

extentTest.log(LogStatus.PASS, 'Click on the Save button and Back button')
//Draw the Visualization graph 
//double click on the dashboard

WebUI.delay(4)
WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
extentTest.log(LogStatus.PASS, 'Double-Click on the Empty Dashboard')
WebUI.delay(2)
//Select the BAR Graph 
WebUI.click(findTestObject('Object Repository/Graph_Object'))
//Drag the new updated column to the Y-axis of the Graph
extentTest.log(LogStatus.PASS, 'Select the BAR Graph ')

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Ticker12', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Y', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

TestObject draggableobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Industry', true)
TestObject dropobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Items', true)

WebUI.dragAndDropToObject(draggableobject1, dropobject1)

extentTest.log(LogStatus.PASS, 'Drag and drop the new updated column to the Y-axis of the Graph and Industry to the Breakdown')
//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button')

CustomKeywords.'expandgraph.inputgraph.resizegraph'()
extentTest.log(LogStatus.PASS, 'Expand the sliders to view the full graph')

result=CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid,extentTest,graphlocation,runtimegraph)
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


