package projetDS;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
//on corrige le fichier M457 car il contient 2 erreurs
//on utilise String.valueOf pour eviter d'utiliser toString
public class CorrectionXml {
	public static String corriger(final String File) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        final BufferedWriter out2 = new BufferedWriter(new FileWriter(String.valueOf(File.substring(0, File.length() - "M457.xml".length())) + "TEIFrantext.dtd"));
        out2.write("");
        out2.close();
        int counter = -1;
        try {
            in = new BufferedReader(new FileReader(File));
            out = new BufferedWriter(new FileWriter(String.valueOf(File.substring(0, File.length() - "M457.xml".length())) + "M457Corrige.xml"));
            String c;
            while ((c = in.readLine()) != null) {

               if (counter == 18) {
                    out.write(String.valueOf(c) + "</p>" + "\n");
                }
                else if (counter == 416) {
                    c = c.replaceAll("&", "&#38;");
                    out.write(String.valueOf(c) + "\n");
                }
                else {
                    out.write(String.valueOf(c) + "\n");
                }
            counter++;
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
        return String.valueOf(File.substring(0, File.length() - "M457.xml".length())) + "M457Corrige.xml";
    }
}
