package vTiger.Product;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtiliy;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInformation;
import vTiger.ObjectRepository.ProductInformationPage;
import vTiger.ObjectRepository.ProductPage;
import vTiger.ObjectRepository.ToProductLookupImageClick;

public class ToCreatProductPage extends BaseClass{
	
	@Test
	public void tocreateProductPage() throws EncryptedDocumentException, IOException {
	//WebDriver driver =null;
	HomePage hp=new HomePage(driver);
	ExcelFileUtiliy eutil=new ExcelFileUtiliy();
    WebDriverUtility wutil=new WebDriverUtility();
    ProductPage pp=new ProductPage(driver);
    ProductInformationPage pip=new ProductInformationPage(driver);
    pp.getToclickprodbutton().click();
    
    ToProductLookupImageClick tpl=new ToProductLookupImageClick(driver);
    tpl.getToclickLookupImage().click();
    
    
    ProductInformation pi=new ProductInformation(driver);
  //  pi.getProductname().sendKeys("iphone");euti
    String productnamee = eutil.toReadDataFromExcel("Sheet1", 3, 0);
    pi.getProductname().sendKeys(productnamee);
   
    
    wutil.ToHandleDropdown(pi.getProductCat(), 1);
   
    pi.getToclicksavebutton().click();
    Reporter.log("product page created sucsessfully",true);
    
    String pagename = pip.getPageinfopage().getText();
    Reporter.log(pagename,true);
   AssertJUnit.assertTrue(pagename.contains(productnamee));
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
	}
	
}
