package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ecxel {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wo;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;
	
	
	public Ecxel(String path) {
		this.path=path;
	}
	
	public int getrowcount(String sheetname) throws IOException {
		fi= new FileInputStream(path);
		wo= new XSSFWorkbook(fi);
		sheet=wo.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		wo.close();
		fi.close();
		return rowcount;
		
	}
	
	public int getcellcount(String sheetname,int rownum) throws IOException {
		fi= new FileInputStream(path);
		wo= new XSSFWorkbook(fi);
		sheet=wo.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wo.close();
		fi.close();
		return cellcount;
		
	}
	public String getCellData(String sheetname,int rownum,int colnum) throws IOException {
		fi= new FileInputStream(path);
		wo= new XSSFWorkbook(fi);
		sheet=wo.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter= new DataFormatter();
		String data;
		try {
		data=formatter.formatCellValue(cell);
	}
		catch(Exception e) {
			data="";
		}
		wo.close();
		fi.close();
		return data;
	
	
	
	
}
}

