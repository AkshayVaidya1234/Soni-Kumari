package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.Testbase;
import Utility.commonmethos;

public class Register extends Testbase {
	
	
	@Test
	public void Registeruser() throws IOException {
		commonmethos.Verfiytitle("Swag Labs");
		commonmethos.enterinput("usename", "standard_user", "user enter the username");
		commonmethos.enterinput("pwd", "secret_sauce");
		commonmethos.clicknobtn("btn");
		commonmethos.verfiytext("text", "Product");
	
	}
      
}
