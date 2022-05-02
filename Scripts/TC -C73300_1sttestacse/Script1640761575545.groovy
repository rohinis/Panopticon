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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.relevantcodes.extentreports.LogStatus as LogStatus
import com.assertthat.selenium_shutterbug.core.Shutterbug as Shutterbug
import java.awt.image.BufferedImage as BufferedImage
import java.io.File as File
import java.io.IOException as IOException
import javax.imageio.ImageIO as ImageIO
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.remote.RemoteWebDriver as RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import org.openqa.selenium.interactions.Actions as Actions

//Login to the application
WebDriver driver = DriverFactory.getWebDriver()

CustomKeywords.'toLogin.ForLogin.Login'()

//Create a new workbook
/*
WebUI.delay(2)
//Step 1: CreatCreate new workbook 

WebUI.waitForElementVisible(findTestObject('Object Repository/New_Workbook'), 10)

WebUI.click(findTestObject('Object Repository/New_Workbook'))
WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Input_Field'), "workbook88")

WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Create_Button'))

WebUI.delay(2)
//Step 1: use 'Example StocksTimeSeries' as a data table.

//Create a New Data Table 
WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/New_Datatable'), 10)

WebUI.click(findTestObject('Object Repository/DataTable/New_Datatable'))

//select   on the ms excel 

WebUI.waitForElementVisible(findTestObject('Object Repository/DataTable/File_Selection'), 5)
WebUI.click(findTestObject('Object Repository/DataTable/File_Selection'))

//Upload the Excel file StocksTimeSeries

WebUI.delay(3)
WebUI.uploadFile(findTestObject('Object Repository/DataTable/Browse_button'), "D:\\StocksTimeSeries_2020.xls")

//fetch sheets and refresh preview
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Fetch_Sheets'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))


//Click on the Back button
//Double click on the empty dashboard
//WebUI.delay(5)
//WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))

//Step 2:Select Line graph from time  series visualization section

//Step 3:Click on edit datatable icon 
WebUI.click(findTestObject('Object Repository/Editable_datatable_Icon'))

WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Fetch_Sheets'))
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))

//Seklect and Enable Time Series from the datasource section 


WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Dropdown_object'))

WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Dropdown_object'), Keys.chord(Keys.ARROW_DOWN))

WebUI.delay(3)
WebUI.sendKeys(findTestObject('Object Repository/DataTable/Dropdown_object'), Keys.chord(Keys.ENTER))
//WebUI.click(findTestObject('Object Repository/DataTable/Label_sheets'))
//WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Label_sheets'), "label", "contains", "TimeSeries", false)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Datatable_headings'))

WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/DataTable/slider_round'))

//click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))
WebUI.delay(5)

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
TestObject calobj=WebUI.modifyObjectProperty(findTestObject('Object Repository/DataTable/Fetch_Sheets'), "text", "contains", "Calculated", true)
WebUI.click(calobj)

WebUI.delay(5)
//verify the new calculated column should appear in the Table

WebUI.setText(findTestObject('Object Repository/textarea_xpath'), 'SUM_TIMEWIN("Adj Close", [TimeWindowStart],[TimeWindowEnd])')
//Click on the validate button
WebUI.delay(3)
TestObject validatebtn=WebUI.modifyObjectProperty(findTestObject('Object Repository/Create_Button'), "text", "contains", "Validate", true)
WebUI.click(validatebtn)

//Click on the Refresh Preview
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/DataTable/Refresh_Preview'))


//Verify the new calculated column should appear in the Table
boolean newcol=WebUI.verifyElementPresent(findTestObject('Object Repository/DataTable/Calculated_column'),5, FailureHandling.CONTINUE_ON_FAILURE)

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
WebUI.doubleClick(findTestObject('Object Repository/New_Dashboard'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Visualization_part/linegraph_timeseries'))
//Drag the calculated column to the Y-axis of the Graph

TestObject draggableobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Calculated', true)
TestObject dropobject = WebUI.modifyObjectProperty(findTestObject('Object Repository/General_Button'), 'text', 'equals', 'Y', true)

WebUI.dragAndDropToObject(draggableobject, dropobject)

//Click on the save button
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/DataTable/Save_Button'))

*/
//File image= new File("D:\\copydata\\screenshots");
//BufferedImage expectedimage= ImageIO.read(image);
//WebElement logo= findTestObject('Object Repository/sessions/sessionlist')
//WebElement logo= katalonWebDriver.findElementById("guacDisplay")
// WebElement logo= driver.findElement(By.id("scrollElement-visualization.LineGraph1"));
//driver.findElement(By.ById)
//extentTest.log(LogStatus.PASS, 'Take the screenshot of a particular webelement at the runtime and compare with the saved screenshot ')
// Shutterbug.shootElement(driver,logo).withName("graph1").save("D:\\copydata\\screenshots")
//Refresh Take the screenshot at the runtime
// WebUI.click(findTestObject('Object Repository/Visualization_part/Refresh_button'))
WebUI.delay(3)

//boolean status=Shutterbug.shootElement(driver,logo).withName("graph2").equals(expectedimage,0.1);
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Rough_work/workbook'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Rough_work/workbook_object'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/DataTable/Bar_Graph_id'))

Actions move = new Actions(driver)

WebElement slider = driver.findElement(By.xpath('//div[contains(@class,"move-adorner secondary-50-fill")]'))

move.dragAndDropBy(slider, -100, -100).build().perform()

WebUI.delay(4)

WebElement slider1 = driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[5]'))

move.dragAndDropBy(slider1, 200, 0).build().perform()

WebUI.delay(4)

WebElement slider2 = driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[9]'))

move.dragAndDropBy(slider2, -100, 0).build().perform()

WebUI.delay(4)

WebElement slider3 = driver.findElement(By.xpath('//div[contains(@class,"bounds-adorner secondary-50-border")]/div[2]'))

move.dragAndDropBy(slider3, 0, -200).build().perform()

/*boolean status=Shutterbug.shootElement(driver,logo).withName("sessionpage2").equals(expectedimage,0.1);*/
WebUI.click(findTestObject('Object Repository/Rough_work/scrollable_content'))

WebElement logo1 = driver.findElement(By.id('scrollElement-visualization.VerticalBarGraph1'))

Shutterbug.shootElement(driver, logo1).withName('graph1').save('D:\\copydata\\screenshots')

WebUI.delay(5)

File image = new File('D:\\copydata\\screenshots\\graph1.png')

BufferedImage expectedimage = ImageIO.read(image)

WebElement logo = driver.findElement(By.id('scrollElement-visualization.VerticalBarGraph1'))

//driver.findElement(By.ById)
//extentTest.log(LogStatus.PASS, 'Take the screenshot of a particular webelement at the runtime and compare with the saved screenshot ')
Shutterbug.shootElement(driver, logo).withName('graph2').save('D:\\copydata\\screenshots')

WebUI.click(findTestObject('Object Repository/Visualization_part/Refresh_button'))

WebUI.delay(3)

boolean status = Shutterbug.shootElement(driver, logo).withName('graph3').equals(expectedimage, 0.1)

println('The return value is :: ' + status)

if (status == true) {
    println('The images are same')
} else {
    println('The images are different')
}