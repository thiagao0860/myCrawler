package org.thiago;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLegJsoup
{
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;

    public String getSearh(String url, String word){
        try
        {
            String str = url + "/search?q="+ word;
            Connection connection = Jsoup.connect(str).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            if(connection.response().statusCode() == 200) // 200 is the HTTP OK status code
            // indicating that everything is great.
            {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if(!connection.response().contentType().contains("text/html"))
            {
                System.out.println("**Failure** Retrieved something other than HTML");
                return null;
            }
            Element body = htmlDocument.body();
            Elements results = body.getElementsByClass("g");
            for (Element e: results) {
                Elements nome = e.getElementsByClass("LC20lb DKV0Md");
                System.out.println(nome.text());
            }
            return body.html();
        }
        catch(IOException ioe)
        {
            // We were not successful in our HTTP request
            ioe.printStackTrace();
            return null;
        }
    }
}
