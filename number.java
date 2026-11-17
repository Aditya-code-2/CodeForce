
import java.awt.Desktop;
import java.net.URI;

public class number{
    public static void main(String[] args) throws Exception {

        String prefix = "87997604";

        for (int i = 0; i < 100; i++) {

            String number = prefix + String.format("%02d", i);

            String url = "https://www.truecaller.com/search/in/" + number;

            System.out.println(number + " -> " + url);

            // Browser mein search open karega
            Desktop.getDesktop().browse(new URI(url));

            Thread.sleep(2000);
        }
    }
}


