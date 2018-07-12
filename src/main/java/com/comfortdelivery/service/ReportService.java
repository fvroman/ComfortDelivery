package com.comfortdelivery.service;

import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.OrderedProduct;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;


public class ReportService{

    public static void generateAgreement(Order order, String url) {
        String path = "C:\\ComfortReports\\Agreements\\" + order.getOrderId()+".html";
        File file = new File(path);
        try {
            file.createNewFile();
            Writer writer = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
            generateHTML(writer, order, url);
            writer.close();
        } catch (IOException e) {
            System.out.println("exc");
        }

    }


    private static void generateHTML(Writer writer, Order order, String url) throws IOException{

        writer.write("<head>\n");
        writer.write(" <meta charset=\"utf-8\">\n");
        writer.write("</head>\n");

       // writer.write();//todo style


        writer.write("<body>\n");

        writer.write("<div class=\"agreement-container\">");

        writer.write("<img src=\"/resources/images/comfort-icon.jpg\" alt= \"Уют\" width=\"200px\" height=\"100px\">\n");

        writer.write("<h3>"+"Заказ №"+order.getOrderId());
        writer.write("<html>\n");

        writer.write("<td><td>");
        writer.write("<table class=\"goods-table\">");
        writer.write("<tr><th>Наименование</th>\n" +
                "    <th>Количество</th> \n" +
                "    <th>Цена</th>\n" +
                "  </tr>");

        for (OrderedProduct orderedProduct : order.getOrderedProducts()) {
            writer.write("<tr>\n");
            writer.write("<td>" + orderedProduct.getProduct().getProductName() + "</td>");
            writer.write("<td>" + orderedProduct.getQuantity() + "</td>");
            writer.write("<td>" + orderedProduct.getProduct().getPrice() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>\n");
        writer.write("<br>");
        writer.write("<span >Сумма заказа - " + order.getOrderSum() + " рублей </span>");

        writer.write("</div>");
        writer.write("</body>");
        writer.write("</html>");
    }

}
