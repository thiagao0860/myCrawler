package org.thiago;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

public class SpiderHTMLUnit {
    public void homePage_Firefox()  {
        final BrowserVersion myChrome = new BrowserVersion.BrowserVersionBuilder(BrowserVersion.EDGE)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36 Edg/87.0.664.60")
                .build();
        try (final WebClient webClient = new WebClient(myChrome)){
            HtmlPage page = webClient.getPage("https://www.google.com.br/");

            final HtmlForm form = page.getFormByName("f");
            final HtmlTextInput input = form.getInputByName("q");
            final HtmlSubmitInput search = form.getInputByName("btnK");
            input.setText("i'm a robot");
            //final HtmlPage result = search.click();
            System.out.println(webClient.getCurrentWindow().getEnclosedPage().getUrl());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
