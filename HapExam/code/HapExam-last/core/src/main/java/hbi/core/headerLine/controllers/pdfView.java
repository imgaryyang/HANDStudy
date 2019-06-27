package hbi.core.headerLine.controllers;


import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;

import hbi.core.headerLine.dto.OmOrderHeaders;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Create By legend
 * @date 2019/4/25 11:17
 */
public class pdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {

        String fileName = "order.pdf";
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition",
                "attachment; filename=" + new String(fileName.getBytes(), "iso8859-1"));

        BaseFont bfChinese = BaseFont.createFont("C://Windows//Fonts//simfang.ttf", BaseFont.IDENTITY_H,
                BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);

        List<String> list = new ArrayList<>();

        list.add("<h1>PDF打印</h1>");
        list.add("<table>" +
                "<tr>#111111"+
                "</table>");

        for (int i = 0; i < list.size(); i++) {
            document.add(new Paragraph(list.get(i), FontChinese));
        }
    }
}
