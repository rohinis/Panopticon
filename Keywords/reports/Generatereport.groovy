package reports
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import java.text.SimpleDateFormat
import com.relevantcodes.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter




import internal.GlobalVariable



public class Generatereport {

	@Keyword
	def create(String ReportName , String BrowserName , String BrowserVersion){
		def filePath = (RunConfiguration.getProjectDir() + '/ExtentReports/')
		def date = new Date()
		def path = filePath+ReportName
		println("file name from keyword " +path)
		def extent = new ExtentReports(path,false)
		extent.addSystemInfo("BrowserName", BrowserName.capitalize())
		extent.addSystemInfo("BrowserVersion", BrowserVersion)
		//	htmlReporter = new ExtentHtmlReporter(path);
		//extent.attach(htmlReporter)
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.setAppendExisting(true);


		return extent
	}


	@Keyword
	def getDateWala() {
		def date = new Date()
		def sdf = new SimpleDateFormat("dd_MM_yyyy_HHmmss")
		def start_time = sdf.format(date)
		println start_time
	}
}
