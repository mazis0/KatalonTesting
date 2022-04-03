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

def jsonSlurper = new groovy.json.JsonSlurper()

def result = jsonSlurper.parseText(response.getResponseBodyContent())

def value = result.data.email

println('email : ' + value)

GlobalVariable.email = value

println('Global variable email : ' + GlobalVariable.email)

response1 = WS.sendRequest(findTestObject('User/RegisterSuccessfull', [('base_url') : GlobalVariable.base_url, ('email') : GlobalVariable.email]))

println(response1.getResponseBodyContent())

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response1, 'email', 'janet.weaver@reqres.in')

WS.verifyElementPropertyValue(response1, 'password', 'test')

