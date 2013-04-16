package com.example.aggienav;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.*;

public class BuildingDatabase extends Building {
	Building[]BDB = new Building[233];
	private String inputFile;

	  public void setInputFile(String inputFile) {
	    this.inputFile = inputFile;
	  }

	  public void read() throws IOException  {
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first sheet
	      Sheet sheet = w.getSheet(0);
	      // Loop over first 10 column and lines
	      Cell a, b, c, d, e, f, g;
	      String stringa, stringb, stringe;
	      double latc, lond, latf, lon_g;
	      NumberCell cnum, dnum, fnum, gnum;
	           
	      
	        for (int i = 2; i < 230; i++) {
	          a = sheet.getCell(0, i);
	          stringa = a.getContents();
	          BDB[i-2].name = stringa;
	          
	          b = sheet.getCell(1, i);
	          stringb = b.getContents();
	          BDB[i-2].abbr = stringb;
	          
	          c = sheet.getCell(2, i);
	          cnum = (NumberCell)c;
	          latc = cnum.getValue();
	          
	          d = sheet.getCell(2, i);
	          dnum = (NumberCell)d;
	          lond = dnum.getValue();
	          	               
	        }
	      
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
	  }

	  /*public static void main(String[] args) throws IOException {
	    BuildingDatabase test = new BuildingDatabase();
	    test.setInputFile("Building_GPS_locations.xlsx");
	    test.read();
	  }*/
}
