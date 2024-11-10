package com.inspection.penalty.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.inspection.penalty.model.penaltymodel.Inspection;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    public void exportToExcel(List<Inspection> inspections, HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inspections");

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
        for (Inspection inspection : inspections) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(inspection.getId());
            row.createCell(1).setCellValue(inspection.getInspectionID());
            row.createCell(2).setCellValue(inspection.getVehicle_no());
            row.createCell(3).setCellValue(inspection.getVehicleType());
            row.createCell(4).setCellValue(inspection.getInspectionDate().toString());
            row.createCell(5).setCellValue(inspection.getInspection_param_id());
            row.createCell(6).setCellValue(inspection.getInspectionParameter());
            row.createCell(7).setCellValue(inspection.getInspectionNote());
            row.createCell(8).setCellValue(inspection.getInspectionLocation());
            row.createCell(9).setCellValue(inspection.getDistrict());
            row.createCell(10).setCellValue(inspection.getInspectionOutcome());
            row.createCell(11).setCellValue(inspection.getIsCal());
            row.createCell(12).setCellValue(inspection.getPenCounter());
            row.createCell(13).setCellValue(inspection.getVehicleType());
            row.createCell(14).setCellValue(inspection.getPenAmount());
        }

        // Write to response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=inspections.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
