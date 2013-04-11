package com.example.aggienav;
import jxl.*;
import java.io.*;

public class BusStopDatabase extends BusStop{
	BusStop[]BSDB = new BusStop[100];
	private void readExcelSheet(String destFile){ 
	      File excelSheet = null;
	      Workbook workbook = null;    
	           
	        try {
	             Workbook wb = Workbook.getWorkbook(new File(destFile));
	             System.out.println(wb.getNumberOfSheets());
	             for(int sheetNo=0; sheetNo<wb.getNumberOfSheets();sheetNo++)
	                {                
	                  Sheet sheet = wb.getSheet(sheetNo);
	                  int columns = sheet.getColumns();
	                  int rows = sheet.getRows();
	                  String data;
	                  System.out.println("Sheet Name\t"+wb.getSheet(sheetNo).getName());
	                          for(int row = 0;row < rows;row++) {
	                              for(int col = 0;col < columns;col++) {
	                               data = sheet.getCell(col, row).getContents();
	                              System.out.print(data+ " ");
	                            
	                          }                          
	                          System.out.println("\n");
	                      }
	                      }
	                  } catch(Exception ioe) {
	                       ioe.printStackTrace();
	                  }
	             
	          }
	      public static void main(String arg[]){
	            //ReadExcel excel = new ReadExcel();
	            //excel.readExcelSheet("C://Employee.xls");
	      }
	      
	}



