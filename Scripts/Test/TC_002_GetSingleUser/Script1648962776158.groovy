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

response = WS.sendRequest(findTestObject('User/GetSingleUser', [('base_url') : GlobalVariable.base_url]))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'data.id', 2)

WS.verifyElementPropertyValue(response, 'data.email', 'janet.weaver@reqres.in')

WS.verifyElementPropertyValue(response, 'data.first_name', 'Janet')

WS.verifyElementPropertyValue(response, 'data.last_name', 'Weaver')

WS.verifyElementPropertyValue(response, 'data.avatar', 'https://reqres.in/img/faces/2-image.jpg')

WS.verifyElementPropertyValue(response, 'support.url', 'https://reqres.in/#support-heading')

WS.verifyElementPropertyValue(response, 'support.text', 'To keep ReqRes free, contributions towards server costs are appreciated!')

