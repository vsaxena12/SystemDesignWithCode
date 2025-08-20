package networks;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.HerbSchildt.com/WhatsNew");

        System.out.println("Protocol: "+ url.getProtocol());
        System.out.println("Port: "+ url.getPort());
        System.out.println("Protocol: "+ url.getHost());
        System.out.println("Protocol: "+ url.getFile());
        System.out.println("Ext: : "+ url.toExternalForm());
    }
}
