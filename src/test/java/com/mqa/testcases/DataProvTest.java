package com.mqa.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvTest {
	
	@DataProvider(name="DProvider")
	public Object[][] dataprov(){
	return new Object[][]{{"A","B"},{"C","D"}};
	}



	@Test(priority = 1,dataProvider ="DProvider")
	public void testing(String x,String y){
System.out.println("x:"+x +"y:"+y);
	}
	
	@Test(priority = -10)
	public void Test1() {
		System.out.println("Negative..!!");
		//Assert.assert
	}
}
