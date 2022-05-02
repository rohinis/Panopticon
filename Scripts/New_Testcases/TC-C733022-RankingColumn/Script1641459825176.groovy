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
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import com.relevantcodes.extentreports.LogStatus as LogStatus
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;


import org.openqa.selenium.WebElement;
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.exception.StepErrorException as StepErrorException

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver


//Login to the application
def Browser = GlobalVariable.G_Browser

String ReportFile = GlobalVariable.G_ReportName + '.html'

def extent = CustomKeywords.'reports.Generatereport.create'(ReportFile, GlobalVariable.G_Browser, GlobalVariable.G_BrowserVersion)

def LogStatus = com.relevantcodes.extentreports.LogStatus

def extentTest = extent.startTest(TestCaseName)
try {

WebDriver driver = DriverFactory.getWebDriver()


//Create a new workbook
CustomKeywords.'toLogin.ForLogin.Login'(extentTest)

WebUI.delay(2)
//Step 1: Create  a new workbook 
CustomKeywords.'workbook.newworkbook.createworkbook'(workbookname,extentTest)

//Step 1: use 'Example StocksTimeSeries' as a data table.


CustomKeywords.'datatable.CreateTable.createdatatable'(fileupload,extentTest)


//Step 3: create a new Ranking column
//Create a New Ranking Column from the newcolumn option
CustomKeywords.'datatable.NewColumn.Calculated_Column'(extentTest,columnname)

//select the column name to be sorted
WebUI.click(findTestObject('Object Repository/DataTable/Ranking_Column'))
//verify the new calculated column should appear in the Table
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Ranking_Column'), Keys.chord(Keys.ARROW_DOWN))
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Ranking_Column'), Keys.chord(Keys.ARROW_DOWN))
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Ranking_Column'), Keys.chord(Keys.ARROW_DOWN))
WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Ranking_Column'), Keys.chord(Keys.ENTER))

//Click on the sort  order
extentTest.log(LogStatus.PASS, 'Select the Column Name to be sorted')

WebUI.click(findTestObject('Object Repository/DataTable/sort_order'))
//Click on the Refresh Preview
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))




//Verify the new calculated column should appear in the Table
TestObject rankingcolumn=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Calculated_column'), "text", "contains", "Ranking", true)

boolean newcol=WebUI.verifyElementPresent(rankingcolumn,5, FailureHandling.CONTINUE_ON_FAILURE)
if(newcol)
	extentTest.log(LogStatus.PASS, 'Verify the new calculated column should appear in the Table::'+newcol)
	else
		extentTest.log(LogStatus.FAIL, 'Failed to verify the column')

println("the new column is present"+newcol)

//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button')

//Go Back to Visualization part and create a Line Graph
extentTest.log(LogStatus.PASS, 'Go Back to Visualization part and create a BAR Graph')
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Back_Button'))

//Select the line graph from the TimeSeries Visualization section

//double click on the dashboard
WebUI.delay(4)
WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
extentTest.log(LogStatus.PASS, 'Double-click on the Empty Dashboard')
WebUI.delay(2)
//Select the BAR Graph 
WebUI.click(findTestObject('Object Repository/Graph_Object'))

//drag industry to breakdownand Ranking  column to the Y-Axis (or color) and click on save

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Industry', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Breakdown', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

TestObject draggableobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Ranking', true)
TestObject dropobject1 = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Color', true)

//Click on the save button
WebUI.delay(2)

WebUI.dragAndDropToObject(draggableobject1, dropobject1)

extentTest.log(LogStatus.PASS, 'Drag and drop the  (Ranking Column) to the Color variable  and Industry to the Breakdown Variable')
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
extentTest.log(LogStatus.PASS, 'Click on the Save button')




CustomKeywords.'expandgraph.inputgraph.resizegraph'()
extentTest.log(LogStatus.PASS, 'Expand the sliders to view the full graph')
CustomKeywords.'image_Comparision.Compare_Screenshots.compare_graphs'(graphid,extentTest,graphlocation)
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









