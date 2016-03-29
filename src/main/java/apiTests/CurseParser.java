package apiTests;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DimaM on 12/7/2015.
 */
public class CurseParser {


   @Test
    public void getCurseFromFidoBank () throws IOException {

        HttpResponse resp = Request.Get("https://fidobank.ua/").execute().returnResponse();
        String respBody = EntityUtils.toString(resp.getEntity());
        int indexOF = respBody.indexOf("<div class=\"currency_ind\">");
        String html = respBody.substring(indexOF);
        String html1 = html.substring(0,html.indexOf("<div class=\"currency_imf hidden\">"));
         int p1= html1.indexOf("'value'>")+"'value'>".length();
        String rez1 = html1.substring(p1);
        int p2 = html1.indexOf("</span></div><div class='currency'><span class='name'>EUR");
        String rez2 = html1.substring(p2);
        String usdFidobank = html1.substring(p1,p2);
        String buyF = usdFidobank.substring(0,usdFidobank.indexOf("/"));
        System.out.println("!!!Fidobank BUY USD = "+buyF);
        String payF = usdFidobank.substring(usdFidobank.indexOf("/") + "/".length());
        System.out.println("!!!Fidobank PAY USD = "+payF);


        double f1 = Double.parseDouble(buyF);
        double f2 = Double.parseDouble(payF);



//PRIVATBANK

        HttpResponse resp2 = Request.Get("https://privatbank.ua//").execute().returnResponse();
        String respPrivat = EntityUtils.toString(resp2.getEntity());

        int indexOfTable = respPrivat.indexOf("course-table-pb");
        String table = respPrivat.substring(indexOfTable);
       // System.out.println(table);
        int indexOfUsd = table.indexOf("<td width=\"26%\">USD/UAH</td>\n" +
                "                  <td width=\"9%\" style=\"text-align:right;\">");
        String table1 = table.substring(indexOfUsd);
        String itrH = " </tr>\n" +"            <tr>";
         int itr = table1.indexOf(itrH)+ itrH.length();
        int itr2 = table1.indexOf("USD/UAH</td>")+"USD/UAH</td>".length();
        String table3 = table1.substring(itr2, itr);
        int b = table3.indexOf("right;\">")+"right;\">".length();
        int b1 = table3.indexOf("</");
        String buyUSD = table3.substring(b,b1);     // PRIVAT BUY USD
        int pa1 = table3.indexOf("<td width=\"25%\" style=\"text-align:right;\">")+"<td width=\"25%\" style=\"text-align:right;\">".length();
        String paH = "</td>\n" +"            </tr>\n" +"            <tr>";
        int pa2 = table3.indexOf(paH);
        String payUSD = table3.substring(pa1, pa2); // PRIVAT PAY USD
        System.out.println("!!!!!BUY USD PRIVAT = "+buyUSD);
        System.out.println("!!! PAY USD PRIVAT = "+payUSD);

        double pr1 = Double.parseDouble(buyUSD);
        double pr2 = Double.parseDouble(payUSD);


        if(f1>pr1){
            System.out.println("The best bank for buying USD is PrivatBank");
        } else {
            System.out.println("The best bank for buying USD is fidobank");
        }

        if(f2>pr2){
            System.out.println("The best bank for sell USD is Fidobank");
        } else {
            System.out.println("The best bank for sell USD is Privat Bank");
        }
    }



    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Test
    public void currentDay () throws IOException, ParseException {
        HttpResponse resp3 = Request.Get("http://www.pdffiller.com/").execute().returnResponse();
        String respPDFfiller = EntityUtils.toString(resp3.getEntity());

        int blD=respPDFfiller.indexOf("date\">Today:")+"date\">Today:".length();
        String bl1 = respPDFfiller.substring(blD);
        int blD1 = bl1.indexOf("</div");
        String dateString = bl1.substring(1, blD1);
         String monthP = dateString.substring(0,4);
        String ddP = dateString.substring(4,6);
        String yyyyP = dateString.substring(10,14);

        String parseDateP = monthP+ddP+" "+yyyyP;

        if(parseDateP.equals(getDateTime())) {
            System.out.println("Date of PDFFiller = "+ parseDateP+"   Date on Current PC = "+getDateTime());
        } else
        {
            System.out.println("watafuckinggoing on in");
        }



    }
}
