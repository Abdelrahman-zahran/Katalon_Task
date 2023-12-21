import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.comment('Story: Verify product added successfully in the cart')

Mobile.comment('Given that user has started an application')

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, false)

Mobile.comment('And user can select country')

Mobile.tap(findTestObject('CountryField'), 5)

Mobile.tap(findTestObject('AndoraCountry'), 5)

Mobile.comment('And user can enter name')

Mobile.setText(findTestObject('name'), 'Abdelrahman', 2)

Mobile.hideKeyboard()

Mobile.comment('And the user can select gender')

'Get displayed message on the dialog'
Mobile.checkElement(findTestObject('Gender'), 1)

Mobile.comment('When the user click on let\'s shop button')

Mobile.tap(findTestObject('LetsShopButton'), 2)

Mobile.comment('And select a product')

Mobile.scrollToText('Nike Blazer Mid \'77', FailureHandling.STOP_ON_FAILURE)

Mobile.comment('And add product to the cart')

Mobile.tap(findTestObject('Add_To_Cart'), 2)

Mobile.tap(findTestObject('Cart_Icon'), 2)

Mobile.comment('Then the user able to display product in the cart page')

Mobile.verifyElementText(findTestObject('product_name'), 'Nike Blazer Mid \'77')

Mobile.closeApplication()

