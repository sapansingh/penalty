package com.inspection.penalty.service.export;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.analytics.assignment;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Service
public class Assignmentexport {

    public void exportToExcel(List<assignment> assignments, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("assignments");

        // Create header row
        String[] columns = {
            "ID", "Inspection ID", "Vehicle No", "Vehicle Type ID", "Inspection Date",
            "Inspection Param ID", "Inspection Parameter", "Inspection Note",
            "Inspection Location", "District", "Inspection Outcome", "Is Cal",
            "Pen Counter", "Vehicle Type", "Pen Amount"
        };

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Create data rows
        int rowNum = 1;
        for (assignment asisng : assignments) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(asisng.getCall_type_name());
            row.createCell(1).setCellValue(asisng.getCallid());
            row.createCell(2).setCellValue(asisng.getCall_end_time());
            row.createCell(3).setCellValue(asisng.getPhone_number());
            row.createCell(4).setCellValue(asisng.getPhone_number());
            row.createCell(5).setCellValue(asisng.getPhone_number());
            row.createCell(6).setCellValue(asisng.getPhone_number());
            row.createCell(7).setCellValue(asisng.getPhone_number());
            row.createCell(8).setCellValue(asisng.getPhone_number());
            row.createCell(9).setCellValue(asisng.getPhone_number());
            row.createCell(10).setCellValue(asisng.getPhone_number());
            row.createCell(11).setCellValue(asisng.getPhone_number());
            row.createCell(12).setCellValue(asisng.getPhone_number());
            row.createCell(13).setCellValue(asisng.getPhone_number());
            row.createCell(14).setCellValue(asisng.getPhone_number());
        }

        // Write to response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Assignment.csv");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
