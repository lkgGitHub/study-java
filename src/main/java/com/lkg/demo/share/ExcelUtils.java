package com.lkg.demo.share;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtils {

    public static int numOfSheets(String path) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(path));
        System.out.println( workbook.getNumberOfNames());
        return workbook.getNumberOfSheets();
    }

    public static List<String> getSheetNames(String path) throws IOException {
        List<String> sheetNames = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File(path));
        for(int i=0; i<workbook.getNumberOfSheets(); i++){
            sheetNames.add(workbook.getSheetName(i));
        }
        return sheetNames;
    }

    public static List<List<Object>> readExcel(String path, int startSheet, int startRow, int startColumn) throws IOException {
        List<List<Object>> rootList = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(new File(path));
//        throw new RuntimeException("文件类型错误：预期类型：xls/xlsx，传入类型：" + suffix);

        Sheet sheet = workbook.getSheetAt(startSheet);

        if (sheet != null){
            for (int r=startRow; r<= sheet.getLastRowNum(); r++){
                Row row = sheet.getRow(r);
                List<Object> list = new LinkedList<>();
                if (row != null){
                    for (int c=startColumn; c<row.getLastCellNum(); c++){
                        Cell cell = row.getCell(c);
//                        System.out.print(getCellValue(cell) + "\t");
                        list.add(getCellValue(cell));
                    }
                }else {
                    //todo 空行处理
                }
//                System.out.println();
                rootList.add(list);
            }
        }else {
            //todo 空sheet处理
        }
        return rootList;
    }

    private static Object getCellValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellType() == CellType.FORMULA) {
            System.err.println("cell 数据为 FORMULA");
            return "";
        } else if (cell.getCellType() == CellType.ERROR) {
            return cell.getErrorCellValue();
        } else if (cell.getCellType() == CellType.BLANK){
            return "";
        }else {
            return "";
        }
    }
}
