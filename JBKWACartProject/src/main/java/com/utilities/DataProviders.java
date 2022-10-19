package com.utilities;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	private static Excel_Reader excel_reader;
	private static String sheetName=null;
	private static String path=null;
	

	public DataProviders() {
		path=System.getProperty("user.dir")+"/src/main/java/com/testData/TestData.xlsx";
	}

	
	ExcelUtil obj = new ExcelUtil();
	//Class --> LoginPageTest
		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			int rows = obj.getRowCount("Credentials");
			int column = obj.getColumnCount("Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credentials", j, i + 2);
				}
			}
			return data;
		}
		
		
		@DataProvider(name="newcustomer")
		public Object[][] getNewCustomerData(){
			sheetName="NewCustomer";
			excel_reader=new Excel_Reader(path);
			Object[][] data=excel_reader.getTestData(sheetName);
			return data;
		}
		
		@DataProvider(name="searchProductDP")
		public Object[][] getSearchProductData(){
			sheetName="SearchProduct";
			excel_reader=new Excel_Reader(path);
			Object[][] data=excel_reader.getTestData(sheetName);
			return data;
		}

		@DataProvider(name="BillingAddressDP")
		public Object[][] getBillingAddressData(){
			sheetName="BillingAddress";
			excel_reader=new Excel_Reader(path);
			Object[][] data=excel_reader.getTestData(sheetName);
			return data;
		}
		
		
}
