package com.pbd.sertaoprotocolo.export;

import com.pbd.sertaoprotocolo.model.Funcionario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class FuncionarioExport {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public FuncionarioExport() {
        this.workbook = new XSSFWorkbook();
    }


    public void exelCabelcalho() {
        sheet = workbook.createSheet("Funcionarios");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(11);
        style.setFont(font);

        createCell(row, 0, "id", style);
        createCell(row, 1, "nome", style);
        createCell(row, 2, "matricula", style);
        createCell(row, 3, "telefone", style);
        createCell(row, 4, "cargo", style);
        createCell(row, 5, "lotacao", style);
        createCell(row, 6, "creado_em", style);
        createCell(row, 7, "atualizado_em", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
        sheet.autoSizeColumn(columnCount);
        cell.setCellStyle(style);

    }

    public void popularLinhas(List<Funcionario> funcionarios) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        style.setFont(font);

        for (Funcionario funcionario : funcionarios) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, funcionario.getId(), style);
            createCell(row, columnCount++, funcionario.getNome(), style);
            createCell(row, columnCount++, funcionario.getMatricula(), style);
            createCell(row, columnCount++, funcionario.getTelefone(), style);
            createCell(row, columnCount++, funcionario.getCargo() != null ? funcionario.getCargo().getNome() : "-", style);
            createCell(row, columnCount++, funcionario.getLotacao() != null ? funcionario.getLotacao().getNome() : "-", style);
            createCell(row, columnCount++, funcionario.getCreated_at() != null ? funcionario.getCreated_at().toString() : "-", style);
            createCell(row, columnCount++, funcionario.getUpdated_at() != null ? funcionario.getUpdated_at().toString() : "-", style);

        }
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }
}


