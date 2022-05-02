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
WebUI.click(findTestObject('Object Repository/DataTable/DataValue_Table'))

//Click on Generete Columns and Click on refresh Preview
//click on the Generate Columns
WebUI.click(findTestObject('Object Repository/DataTable/generate_columns'))

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))
extentTest.log(LogStatus.PASS, 'Click on the Generate Columns and Refresh Preview button')

//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))

//Create a New Calculated Column from the newcolumn option
CustomKeywords.'datatable.NewColumn.Calculated_Column'(extentTest,columnname)

WebUI.setText(findTestObject('Object Repository/textarea_xpath'), '[Mcap_local]+[Mcap_USD]')
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

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button and Back button ')


//double click on the dashboard
WebUI.delay(4)
WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
extentTest.log(LogStatus.PASS, 'Double-click on the Empty Dashboard and Select the BAR Graph')
WebUI.delay(2)

//Select the BAR Graph
WebUI.click(findTestObject('Object Repository/Graph_Object'))

//drag calculated column to Height variable and  text column to the Breakdown Widget and click on save


TestObject draggableobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Captain', true)
TestObject dropobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Items', true)

//Click on the save button
WebUI.delay(2)

WebUI.dragAndDropToObject(draggableobject1, dropobject1)


TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Calculated', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Y', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

extentTest.log(LogStatus.PASS, 'Drag and drop the  (Calculated Column) to the Height variable  and text column  to the Breakdown Widget')

//Go to the Height Variable settings and choose the Aggregation method as Calculation

extentTest.log(LogStatus.PASS, 'Go to the Height Variable settings and Verify the Aggregation method as Calculation')

WebUI.verifyElementPresent(findTestObject('Object Repository/Visualization_part/Aggregation_Method'), 8)




CustomKeywords.'expandgraph.inputgraph.resizegraph'()
extentTest.log(LogStatus.PASS, 'Expand the sliders to view the full graph')

WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button')

result= CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid, extentTest, graphlocation,runtimegraph)


WebUI.delay(2)

CustomKeywords.'expandgraph.pdf_download.download'(extentTest)

//CustomKeywords.'workbook.Download.verify_download'(extentTest,workbookname)
//Include the image comparision and verify download file
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



