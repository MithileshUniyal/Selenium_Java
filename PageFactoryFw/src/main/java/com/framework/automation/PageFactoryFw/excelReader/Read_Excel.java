/**
 * 
 */
package com.framework.automation.PageFactoryFw.excelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author ANKIT
 *
 */
public class Read_Excel {
	
	
	public String path;
	public FileInputStream fileInputStream;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public Read_Excel(String path) {
		this.path = path;
		
		try{
			fileInputStream=new FileInputStream(path);
			wb=new XSSFWorkbook(fileInputStream);
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	
	
	
	public String[][] getDataFromSheet(String excelName,String sheetName){
		
		String excelData[][]=null;
		
		try{
			//get sheet from excel workbook
			XSSFSheet sheet=wb.getSheet(sheetName);
			
			//get count of active rows in the sheet
			//+1 is added to work prope
			
			int totalRows=sheet.getLastRowNum()+1;
			
			//get active columns in the row
			
			int totalColumns=sheet.getRow(0).getLastCellNum();
			
			//create 2D array of rows and columns with which we will actually interact using loops.
			//in object of 2D array we will set the row to totalRow-1 as from above code it will read one extra row from sheet
			
			excelData=new String[totalRows-1][totalColumns];
		
			//for loop will store data in 2D array..
			//loop1-rows
			
			for(int i=1;i<totalRows;i++){
				XSSFRow row=sheet.getRow(i);
				
				//now we have row with us, we will get columns of this row, using loop2
				
				for(int j=0;j<totalColumns;j++){
					//now we have total columns of perticular row, now we have to get the perticular cell value of the column ..
					
					XSSFCell cell=row.getCell(j);
					
					//now we have the cell with us, now we have to work with the cell value
					//work with the cell value type accordingly
					
					//this will work if the cell value is string
					
					if(cell.getCellType()==Cell.CELL_TYPE_STRING){
						
						//now as we are reeding from excel sheet , we need to store the value in 2D array as well
						//so we will start reeding the 2D array from excelData[0][0], as first data should be stored in this position and so on..
						
						//[i-1] because first loop i=1, so 1-1=0, and j at first run is j=0, so excelData[0][0]=cell.getStringCellValue();
						
						excelData[i-1][j]=cell.getStringCellValue();	
						
					}
					
					// if value is numeric
					
					else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
						//first get the numeric value from cell and save it to some string variable
						
						String cellText=String.valueOf(cell.getNumericCellValue());
						excelData[i-1][j]=cellText;
					}
					
					//this will work for boolean cell type...
					
					else{
						
					 excelData[i-1][j]=String.valueOf(cell.getBooleanCellValue());
					}
					
				}
				
				
			}
			
			return excelData;
		}catch(Exception e){
			System.out.println("Exception occured in excel file"+e.getMessage());
			e.printStackTrace();
		}
		
		return excelData;
		
	}

	
	
	
	//code logic for runmode:
	
	
	public String getCellData(String sheetName, String colName,int rowNum){
		try{
			int col_num=0;
			int index=wb.getSheetIndex(sheetName);
			sheet=wb.getSheetAt(index);
			XSSFRow row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().equals(colName)){
					col_num=i;
					break;
				}
				
			}
			
			row=sheet.getRow(rowNum-1);
			
			XSSFCell cell=row.getCell(col_num);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			return cell.getStringCellValue();	
			}
			else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
				return "";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
