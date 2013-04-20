package com.example.aggienav;

import java.io.File;
import java.io.IOException;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BusStopDatabase extends BusStop{
	Route[]routes = new Route[100];
	public Route collectStops(int sheetNum){
		Route r = new Route();
		try {
			BusStop[]bs = new BusStop[100];
			Cell cell;
			String s;
			OPCPackage pkg = OPCPackage.open(new File("/AggieNav/BusStop_GPS_locations.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			
			Sheet sheet1 = wb.getSheetAt(sheetNum);
			
		       
			//grabs names of routes
			Row row = sheet1.getRow(0);
			for(int c = 1; c<row.getLastCellNum(); c++){
				cell = row.getCell(c);
				s = cell.getStringCellValue();
				bs[c-1].name = s;
			}
			//uploads latitudes
			double lat;
			row = sheet1.getRow(1);
			for(int c = 1; c<row.getLastCellNum(); c++){
				cell = row.getCell(c);
				lat = cell.getNumericCellValue();
				bs[c-1].lat = lat;
			}
			//uploads longitudes
			double lon;
			row = sheet1.getRow(2);
			for(int c = 1; c<row.getLastCellNum(); c++){
				cell = row.getCell(c);
				lon = cell.getNumericCellValue();
				bs[c-1].lon = lon;
			}
			for(int c = 0; c<row.getLastCellNum()-1; c++ ){
				r.add(bs[c]);
			}
			
			pkg.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
		
	}


	
}


