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


//Create a New Workbook 
WebUI.delay(2)


//Create a DataTable using KDB Connector
//Create a New Data Table
WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))
extentTest.log(LogStatus.PASS, 'Click on the new Data table')

//select  on the kbd 
WebUI.delay(2)
TestObject mqttconnector=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/File_Selection'), "text", "contains", "MQTT", true)
WebUI.click(mqttconnector)
extentTest.log(LogStatus.PASS, 'Select MQTT connector from the File/URL')

//Enter the topic name as- panotest and Message type-json

WebUI.setText(findTestObject('Object Repository/DataTable/Topic_Input'),"panotest")

//Click on the generate column and Start Preview
WebUI.click(findTestObject( 'Object Repository/DataTable/generate_columns'))
WebUI.delay(5)

WebUI.click(findTestObject( 'Object Repository/DataTable/Start_Stop_Preview'))

WebUI.delay(3)
//click on the Stop Preview
TestObject stoppreview=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Start_Stop_Preview'), "text", "contains", "Stop Preview", true)
WebUI.click(stoppreview)



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

