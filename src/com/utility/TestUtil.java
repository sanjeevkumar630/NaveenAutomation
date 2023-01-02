package com.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		try {
			reader=new Xls_Reader("D:\\Selenium Naveen\\NaveenAutomation\\src\\com\\testdata\\Data.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("Register");rowNum++)
		{
			String businessname=reader.getCellData("Register", "businessname", rowNum);
			
			
			String businessemail=reader.getCellData("Register", "businessemail", rowNum);
			
			
			String reenteremail=reader.getCellData("Register", "reenteremail", rowNum);
			
			
			String password=reader.getCellData("Register", "password", rowNum);
			
			
			String phone=reader.getCellData("Register", "phone", rowNum);
			 
			Object ob[]= {businessname,businessemail,reenteremail,password,phone};
			myData.add(ob);
			
		}
		return myData;
	}

}
