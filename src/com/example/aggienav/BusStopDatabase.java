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
	BusStop[]BSDB = new BusStop[100];
	public void collectStops(){
		try {
			Cell cell;
			String s;
			OPCPackage pkg = OPCPackage.open(new File("/AggieNav/BusStop_GPS_locations.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			Sheet sheet1 = wb.getSheetAt(0);
			//grabs names of routes
			Row row = sheet1.getRow(0);
			for(int c = 1; c<10; c++){
				cell = row.getCell(c);
				s = cell.getStringCellValue();
				BSDB[c-1].name = s;
			}
			//uploads latitudes
			double lat;
			row = sheet1.getRow(1);
			for(int c = 1; c<10; c++){
				cell = row.getCell(c);
				lat = cell.getNumericCellValue();
				BSDB[c-1].lat = lat;
			}
			//uploads longitudes
			double lon;
			row = sheet1.getRow(2);
			for(int c = 1; c<10; c++){
				cell = row.getCell(c);
				lon = cell.getNumericCellValue();
				BSDB[c-1].lon = lon;
			}
			for(int i = 0; i<9; i++){
				if(BSDB[i+1]==null)BSDB[i].nextBusStop = BSDB[0];
				else BSDB[i].nextBusStop = BSDB[i+1];
			}
			
			pkg.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



