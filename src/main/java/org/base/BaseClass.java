package org.base;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    
    public static void launchBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	}
    
    public static void windowmaximize() {
    driver.manage().window().maximize();
    }
    
    public static void launchurl(String url) {
    driver.get(url);
    }
    
    public static void pageTitle() {
    String title = driver.getTitle();
    System.out.println(title);
    }
    
    public static void pageurl() {
    String currentUrl = driver.getCurrentUrl();
    System.out.println(currentUrl);
    }
    
    public static void passText (String text,WebElement ele){
    ele.sendKeys(text);
    }
    
    public static void closeEntireBrowser() {
    driver.quit();
    }
    
    public static void clickBtn(WebElement ele) {
    ele.click();
    }
    
    public static void screenShot(String imgName)throws IOException{
    TakesScreenshot ts = (TakesScreenshot)driver;
    File image = ts.getScreenshotAs(OutputType.FILE);
    File f = new File("location+ imgName.png");
    FileUtils.copyFile(image,f);
    }
    
    public static Actions a;
    
    public static void moveThecurer(WebElement targetWebElement) {
    a = new Actions(driver);
    a.moveToElement(targetWebElement).perform();
    }
    
    public static void dragDrop(WebElement drogWebElement,WebElement dropElement) {
    a = new Actions(driver);
    a.dragAndDrop(drogWebElement ,dropElement ).perform();
    }
    public static JavascriptExecutor js ;
    
    public static void scrollthepages(WebElement tarwebEle) {
    js =(JavascriptExecutor)driver; 
    js.executeScript("arguments[].ScrollIntoView(true)", tarwebEle);
    }
    
    public static void scroll(WebElement element) {
    js = (JavascriptExecutor)driver;
    js.executeScript("aruguments[].ScrollIntoView(Fulse)", element);
    }
    public static void excelRead(String SheetName,int rowNam,int cellNum)throws IOException {
    File f = new File("excellocation.xlsx");
    FileInputStream fis = new FileInputStream(f);
    Workbook wb = new XSSFWorkbook(fis);
    Sheet mysheet = wb.getSheet("Data");
    Row r = mysheet.getRow(rowNam);
    Cell c = r.getCell(cellNum);
    int cellType = c.getCellType();
    
    String value = "";
    if (cellType==1) {
		String Value2 = c.getStringCellValue();			
	}
    else if (DateUtil.isCellDateFormatted(c)) {
    Date dd = (Date) c.getDateCellValue();
    SimpleDateFormat s = new SimpleDateFormat(value);		
    String Value1 = s.format(dd);
    }
    else {
    double d = c.getNumericCellValue();
    long l = (long)d;
    String ValueOf = String.valueOf(l);
    }
    }
    
    public static void creatNewExcellFile (int rowNum ,int cellNum,String writeData) throws IOException{
    File f = new File("C:\\\\Users\\\\elcot\\\\eclipse-workspace\\\\MavenProject\\\\Excel\\\\Newbook.xlsx");	
    Workbook w = new XSSFWorkbook();	
    Sheet newSheet = w.createSheet("Datas");	
    Row newrow = newSheet.createRow(rowNum);	
    Cell newcell = newrow.createCell(cellNum);
    newcell.setCellValue(writeData);
    FileOutputStream fos = new FileOutputStream(f);
    w.write(fos); 	
    }
    public static void createcell(int getRow, int creCell,String newData)throws IOException{
    File f = new File("C:\\Users\\elcot\\eclipse-workspace\\MavenProject\\Excel\\Newbook.xlsx");
    FileInputStream fis = new FileInputStream(f);
    Workbook wb = new XSSFWorkbook(fis);
    Sheet s = wb.getSheet("Datas");
    Row r = s.getRow(getRow);    
    Cell c = r.createCell(creCell);
    c.setCellValue(newData);
    FileOutputStream fos = new FileOutputStream(f);
    wb.write(fos);
    }
    public static void creatrow(int creRow, int creCell, String newData)throws IOException{
    File f = new File("C:\\\\Users\\\\elcot\\\\eclipse-workspace\\\\MavenProject\\\\Excel\\\\Newbook.xlsx");
    FileInputStream fis = new FileInputStream(f);
    Workbook wb = new XSSFWorkbook(fis);
    Sheet s = wb.getSheet("Datas");
    Row r = s.createRow(creRow);   
    Cell c = r.createCell(creCell);
    c.setCellValue(newData);
    FileOutputStream fos = new FileOutputStream(f);
    wb.write(fos);
    }
    public static void main(String[] args) {
    	launchBrowser();
    	launchurl("https://www.facebook.com/");
    	windowmaximize();
    	FbLoginpojo f = new FbLoginpojo();
    	WebElement email = driver.findElement(By.name("email"));
        passText("gokul", email);
        
        WebElement pass = driver.findElement(By.id("pass"));
        passText("krishna", pass);
        
        WebElement login = driver.findElement(By.name("login"));
        clickBtn(login);
    }
}


    