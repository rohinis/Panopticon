package expandgraph

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
import com.relevantcodes.extentreports.LogStatus as LogStatus

import internal.GlobalVariable

public class pdf_download {


	@Keyword
	def download(extentTest) {
		//Go to the View option and click on the refresh button

		extentTest.log(LogStatus.PASS, 'Go to the View option and click on the refresh button')

		WebUI.click(findTestObject('Object Repository/Visualization_part/View_Button'))

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Visualization_part/Refresh_Button'))


		extentTest.log(LogStatus.PASS, 'Click on the pdf file to download the pdf')

		WebUI.click(findTestObject('Object Repository/Visualization_part/PDF_Icon'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Visualization_part/PDF_Ok_Button'), 4)

		WebUI.click(findTestObject('Object Repository/Visualization_part/PDF_Ok_Button'))
		WebUI.delay(3)

		extentTest.log(LogStatus.PASS,"Verify the pdf file is downloaded")
		WebUI.delay(5)
	}
}
