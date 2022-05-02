import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable
import com.relevantcodes.extentreports.LogStatus as LogStatus
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

//Create a DataTable and use 'Example StocksTimeSeries' as a data table[Timeseries example]


CustomKeywords.'datatable.CreateTable.createdatatable'(fileupload,extentTest)

//Seklect and Enable Time Series from the datasource section


WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Dropdown_object'))

WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Dropdown_object'), Keys.chord(Keys.ARROW_DOWN))

WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Dropdown_object'), Keys.chord(Keys.ENTER))
extentTest.log(LogStatus.PASS, 'Select the TimeSeries  value from the Sheet')
//WebUI.click(findTestObject('Object Repository/DataTable/Label_sheets'))
//WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Label_sheets'), "label", "contains", "TimeSeries", false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Datatable_headings'))
extentTest.log(LogStatus.PASS, 'Enable  the TimeSeries  option  from the Transform settings option')
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/DataTable/slider_round'))

//click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
WebUI.delay(5)
//Ceate a New Calculated Column from the newcolumn option
CustomKeywords.'datatable.NewColumn.Calculated_Column'(extentTest,columnname)

WebUI.setText(findTestObject('Object Repository/textarea_xpath'), 'SUM_TIMEWIN("Adj Close", [TimeWindowStart],[TimeWindowEnd])')
//Click on the validate button
WebUI.delay(3)
TestObject validatebtn=WebUI.modifyObjectProperty(findTestObject('Object Repository/Create_Button'), "text", "contains", "Validate", true)
WebUI.click(validatebtn)
extentTest.log(LogStatus.PASS, 'Evaluate the Expression and click on the Validate button ')
//Click on the Refresh Preview
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))


//Verify the new calculated column should appear in the Table
boolean newcol=WebUI.verifyElementPresent(findTestObject('Object Repository/DataTable/Calculated_column'),5, FailureHandling.CONTINUE_ON_FAILURE)
if(newcol)
	extentTest.log(LogStatus.PASS, 'Verify the new calculated column should appear in the Table ')
println("the new column is present"+newcol)

//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))

//Go Back to Visualization part and create a Line Graph
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))

//Select the line graph from the TimeSeries Visualization section

//double click on the dashboard
WebUI.delay(4)
extentTest.log(LogStatus.PASS, 'Double-click on the Empty Dashboard')
WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Visualization_part/linegraph_timeseries'))
//Drag the calculated column to the Y-axis of the Graph
extentTest.log(LogStatus.PASS, 'Select the LIne-Graph from the Timeseries visualization')

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Calculated', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Y', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)
extentTest.log(LogStatus.PASS, 'Drag and drop the  (calculated  Column) to the  Y axis co-ordinates')

//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))

CustomKeywords.'expandgraph.inputgraph.resizegraph'()
extentTest.log(LogStatus.PASS, 'Expand the sliders to view the full graph')

boolean result;
result= CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid,extentTest,graphlocation)

if(result) {
	extentTest.log(LogStatus.PASS, ('Verified :: ' + TestCaseName) + ' :: Sucessfully')
} else {
extentTest.log(LogStatus.FAIL, ( TestCaseName) + ' :: failed')
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

