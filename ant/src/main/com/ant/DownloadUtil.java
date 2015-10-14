package main.com.ant;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Valentyn on 10/10/2015.
 */
public class DownloadUtil {
    public static final String filePath = System.getenv("TEMP") + "/NewTxt.txt";

    public static void main(String[] args) throws Exception{
        URL website = new URL("https://dl.dropboxusercontent.com/u/98396761/NewTxt.txt");
        try(ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        Desktop.getDesktop().open(new File(filePath));
    }
}
