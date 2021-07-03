package com.pbd.sertaoprotocolo.export;

import com.pbd.sertaoprotocolo.model.Protocolo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ProtocoloExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ProtocoloExport() {
        this.workbook = new XSSFWorkbook();
    }

    public void exelCabelcalho() {
        sheet = workbook.createSheet("Protocolos");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(11);
        style.setFont(font);

        createCell(row, 0, "n", style);
        createCell(row, 1, "assunto", style);
        createCell(row, 2, "descricao", style);
        createCell(row, 3, "inicio", style);
        createCell(row, 4, "fim", style);
        createCell(row, 5, "funcionario", style);
        createCell(row, 5, "categoria", style);
        createCell(row, 5, "situacao", style);
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

    public void popularLinhas(List<Protocolo> protocolos) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        style.setFont(font);

        for (Protocolo protocolo : protocolos) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, protocolo.getNProtocolo(), style);
            createCell(row, columnCount++, protocolo.getAssunto(), style);
            createCell(row, columnCount++, protocolo.getDescricao(), style);
            createCell(row, columnCount++, protocolo.getDataInicio() != null ? protocolo.getDataInicio().toString() : "-", style);
            createCell(row, columnCount++, protocolo.getDataFim() != null ? protocolo.getDataFim().toString() : "-", style);
            createCell(row, columnCount++, protocolo.getFuncionario() != null ? protocolo.getFuncionario().getNome() : "-", style);
            createCell(row, columnCount++, protocolo.getCategoria() != null ? protocolo.getCategoria().getNome() : "-", style);
            createCell(row, columnCount++, protocolo.getStatus() != null ? protocolo.getStatus().getDescricao() : "-", style);
            createCell(row, columnCount++, protocolo.getCreated_at() != null ? protocolo.getCreated_at().toString() : "-", style);
            createCell(row, columnCount++, protocolo.getUpdated_at() != null ? protocolo.getUpdated_at().toString() : "-", style);

        }
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }
}
