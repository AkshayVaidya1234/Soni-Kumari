package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders {

	
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException {
		String path=".\\TestData\\Test.xlsx";
		
		Ecxel util= new Ecxel(path);
		
		int totalrows=util.getrowcount("Sheet1");
		int totalcol=util.getcellcount("Sheet1",1);
		
		String logindata[][]= new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcol;j++) {
				
				logindata[i-1][j]=util.getCellData("Sheet1", i, j);
				
			}
		}
		return logindata;
				
	}
	
	
}
