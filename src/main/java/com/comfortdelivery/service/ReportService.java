package com.comfortdelivery.service;

import com.comfortdelivery.entity.Order;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import oracle.sql.BFILE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.itextpdf.text.html.HtmlTags.FONT;


public class ReportService{

    public static void generateAgreement(Order order) {
        Document document = new Document();
        String path = "C:\\ComfortReports\\Agreements\\" + order.getOrderId()+".pdf";
        File file = new File(path);
        try {
            file.createNewFile();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            Paragraph header = new Paragraph();
            header.setAlignment(Element.ALIGN_CENTER);
            Image logo = Image.getInstance("C:\\Users\\Roman\\IdeaProjects\\Comfort\\src\\main\\webapp\\resources\\images\\comfort-icon.jpg");
            header.add(logo);
            //document.add(header);
            BaseFont bf = BaseFont.createFont("C:\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //подключаем файл шрифта, который поддерживает кириллицу

            Font font = new Font(bf);


            Chunk chunk = new Chunk(order.getCustomer().getFullName(), font);
            document.add(chunk);
            document.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (DocumentException e) {
            System.out.println("doc exception");
        } catch (IOException e) {
            System.out.println("cant create file");
        }


    }
}
