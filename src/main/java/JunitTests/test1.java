package JunitTests;

import org.base.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class test1 extends BaseClass {
    @Test
	public void tc1() {
    	launchurl("https://www.facebook.com/");
	}
    @Test
    public void tc2() {
    	launchurl("https://inmakes.com/");
    }
    @Test
    public void tc3() {
    	launchurl("https://www.amazon.in/");
    }
    @Before
    public void StartingTime() {
    System.out.println("start time");
    }
    @After
    public void Endtime() {
    System.out.println("End Time");	 
    }
    @AfterClass
    public static void Starting() {
  
    
	}
    @BeforeClass
    public static void Ending() {
    launchBrowser();
    windowmaximize();
	}
}
