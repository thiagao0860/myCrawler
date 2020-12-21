package org.thiago;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        SpiderLegJsoup leg = new SpiderLegJsoup();
        for(int i=0;i<100;i++) {
            leg.getSearh("https://www.google.com", String.valueOf(i));
        }
        */
        (new SpiderSelenium()).thisIsARobot();
    }
}
