package com.aravinda.app.baseScript;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLReader {
    private XSSFWorkbook workbook;

    private static final Logger logger = Logger.getLogger(XLReader.class);

    public String[] getData(int columnNumber) {
        System.out.println();
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new SystemConfiguration());
        try {
            config.addConfiguration(new PropertiesConfiguration("config.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        List<String> date = new ArrayList<>();
        File src = new File(config.getProperty("XL_FILE_ABSOLUTE_PATH").toString());
        try {
            FileInputStream fis = new FileInputStream(src);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        try {
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                XSSFCell cell = sheet.getRow(i).getCell(columnNumber);
                cell.setCellType(CellType.STRING);
                date.add(cell.getStringCellValue());
            }
        } catch (Exception e) {
            logger.info("Enf ot Excel sheet.");
        }

        String[] dataArray = new String[date.size()];
        dataArray = date.toArray(dataArray);
        return dataArray;
    }

    private static XLReader XLReader = null;

    private XLReader() {
    }

    public static synchronized XLReader getInstance() {
        if (XLReader == null) {
            XLReader = new XLReader();
        }
        return XLReader;
    }

}
