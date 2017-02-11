package seva.project;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Date;

/**
 * Created by v.herasymenko on 30/01/2017.
 */
public class XLSWriter {
    private Workbook book;
    private File file;
    private Row row;

    public XLSWriter(String filePath) {
        this.file = new File(filePath);
        if (file.exists())
            book = getWorkbook(file);
        else {
            book = new HSSFWorkbook();
            book.createSheet();
        }
    }

    private Workbook getWorkbook(File file) {
        Workbook book = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            book = new HSSFWorkbook(bis);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                book.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return book;
    }

    public void appendRow() {
        Sheet sheet = book.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        row = sheet.createRow(rowCount);
    }

    public void appendCell(String value){
        int i = row.getLastCellNum();
        if (i < 0)
            i = 0;
        Cell cell = row.createCell(i);
        cell.setCellValue(value);
        row.getSheet().autoSizeColumn(i);
    }

    public void appendDateCell(){
        int i = row.getLastCellNum();
        Cell cell = row.createCell(i);
        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy hh:mm:ss"));
        cell.setCellStyle(dateStyle);
        cell.setCellValue(new Date(System.currentTimeMillis()));
        row.getSheet().autoSizeColumn(i);
    }

    public void write(){
        try {
            book.write(new FileOutputStream(file));
            book.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
