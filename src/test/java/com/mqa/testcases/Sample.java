package com.mqa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mqa.btr.base.BaseTest;

public class Sample extends BaseTest {

	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Invoked before method ");
		
	}
	
	@Test (priority=1)
	public void test1() {
		System.out.println("Invoked test1...");
		
	}
	

	@Test (priority=2)
	public void test2() {
		System.out.println("Invoked test2...");
	}

	@Test (priority=3)
	public void test3() {
		System.out.println("Invoked test3...");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Invoked after method ");
	}
}
