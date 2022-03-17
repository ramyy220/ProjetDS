package projetDS;
import javax.xml.transform.Transformer;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Node;
import org.w3c.dom.DocumentType;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import javax.xml.transform.OutputKeys;
public class fiche2 {
	public static void fiche2xml(final String txtFile) throws Exception {
        final FileInputStream fiche = new FileInputStream(txtFile);
        final BufferedReader br = new BufferedReader(new InputStreamReader(fiche, "UTF8"));
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder parseur = factory.newDocumentBuilder();
        final DOMImplementation domimp = parseur.getDOMImplementation();
        final Document doc = domimp.createDocument(null, "FICHES", null);
        doc.setXmlStandalone(true);
        final Element rac = doc.getDocumentElement();

        Element ele1 = null;
        Element lang = null;
        Element lan = null;
        int counter = -1;
        String ligne;
        while ((ligne = br.readLine()) != null) {
            ++counter;
            final String chaine = ligne;
            if (counter == 0) {
                ele1 = doc.createElement("FICHE");
                rac.appendChild(ele1);
                ele1.setAttribute("id", "1");
            }
            if (counter >= 0 & counter <= 21) {
                int tailleDroite = chaine.length() - 2;
                String balise = chaine.substring(tailleDroite, chaine.length());
                String path = chaine.substring(0, tailleDroite);
                if (counter >= 0 & counter <= 4) {
                    final Element ele2 = doc.createElement(balise);
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    if (counter == 0) {
                        ele2.appendChild(doc.createTextNode(path));
                    }
                    else {
                        ele2.appendChild(doc.createTextNode(String.valueOf(balise) + " : " + path));
                    }
                }
                else if (counter == 5) {
                    lang = doc.createElement("Langue");
                    rac.appendChild(lang);
                    ele1.appendChild(lang);
                    lang.setAttribute("id", "AR");
                }
                else if (counter >= 6 & counter <= 9) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 10) {
                    tailleDroite = chaine.length() - 14;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | DF : VE : " + path));
                }
                else if (counter == 11) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | PH : " + path));
                }
                else if (counter == 12) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | NT : " + path));
                }
                else if (counter == 13) {
                    lan = doc.createElement("Langue");
                    rac.appendChild(lan);
                    ele1.appendChild(lan);
                    lan.setAttribute("id", "FR");
                }
                else if (counter >= 14 & counter <= 17) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 18) {
                    tailleDroite = chaine.length() - 14;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | VE : " + path));
                }
                else {
                    if (!(counter == 19 | counter == 20 | counter == 21)) {
                        continue;
                    }
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | " + balise + path));
                }
            }
            else if (counter >= 29 & counter <= 50) {
                int tailleDroite = chaine.length() - 2;
                String balise = chaine.substring(tailleDroite, chaine.length());
                String path = chaine.substring(0, tailleDroite);
                if (counter == 29) {
                    ele1 = doc.createElement("FICHE");
                    rac.appendChild(ele1);
                    ele1.setAttribute("id", "2");
                }
                if (counter >= 29 & counter <= 33) {
                    final Element ele2 = doc.createElement(balise);
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    if (counter == 29) {
                        ele2.appendChild(doc.createTextNode(path));
                    }
                    else {
                        ele2.appendChild(doc.createTextNode(String.valueOf(balise) + " : " + path));
                    }
                }
                else if (counter == 34) {
                    lang = doc.createElement("Langue");
                    rac.appendChild(lang);
                    ele1.appendChild(lang);
                    lang.setAttribute("id", "AR");
                }
                else if (counter >= 35 & counter <= 38) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 39) {
                    tailleDroite = chaine.length() - 14;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | DF : VE : " + path));
                }
                else if (counter == 40) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | PH : " + path));
                }
                else if (counter == 41) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | NT : " + path));
                }
                else if (counter == 42) {
                    lan = doc.createElement("Langue");
                    rac.appendChild(lan);
                    ele1.appendChild(lan);
                    lan.setAttribute("id", "FR");
                }
                else if (counter >= 43 & counter <= 46) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 47) {
                    tailleDroite = chaine.length() - 14;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | VE : " + path));
                }
                else {
                    if (!(counter == 48 | counter == 49 | counter == 50)) {
                        continue;
                    }
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | " + balise + path));
                }
            }
            else if (counter >= 54 & counter <= 73) {
                int tailleDroite = chaine.length() - 2;
                String balise = chaine.substring(tailleDroite, chaine.length());
                String path = chaine.substring(0, tailleDroite);
                if (counter == 54) {
                    ele1 = doc.createElement("FICHE");
                    rac.appendChild(ele1);
                    ele1.setAttribute("id", "3");
                }
                if (counter >= 54 & counter <= 58) {
                    final Element ele2 = doc.createElement(balise);
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    if (counter == 53) {
                        ele2.appendChild(doc.createTextNode(path));
                    }
                    else {
                        ele2.appendChild(doc.createTextNode(String.valueOf(balise) + " : " + path));
                    }
                }
                else if (counter == 59) {
                    lang = doc.createElement("Langue");
                    rac.appendChild(lang);
                    ele1.appendChild(lang);
                    lang.setAttribute("id", "AR");
                }
                else if (counter >= 60 & counter <= 63) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 64) {
                    tailleDroite = chaine.length() - 24;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | " + balise.substring(15, 19) + balise.substring(9, 15) + balise.substring(4, 10) + balise.substring(0, 4) + path));
                }
                else if (counter == 65) {
                    lan = doc.createElement("Langue");
                    rac.appendChild(lan);
                    ele1.appendChild(lan);
                    lan.setAttribute("id", "FR");
                }
                else if (counter >= 66 & counter <= 69) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 70) {
                    tailleDroite = chaine.length() - 10;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final String r = balise.substring(1, 3);
                    final Element ele3 = doc.createElement(r);
                    rac.appendChild(ele3);
                    ele1.appendChild(ele3);
                    lan.appendChild(ele3);
                    ele3.appendChild(doc.createTextNode("RF | " + r + " : " + path));
                }
                else {
                    if (!(counter >= 71 & counter <= 73)) {
                        continue;
                    }
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | " + balise + path));
                }
            }
            else {
                if (!(counter >= 79 & counter <= 98)) {
                    continue;
                }
                int tailleDroite = chaine.length() - 2;
                String balise = chaine.substring(tailleDroite, chaine.length());
                String path = chaine.substring(0, tailleDroite);
                if (counter == 79) {
                    ele1 = doc.createElement("FICHE");
                    rac.appendChild(ele1);
                    ele1.setAttribute("id", "4");
                }
                if (counter >= 79 & counter <= 83) {
                    final Element ele2 = doc.createElement(balise);
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    if (counter == 79) {
                        ele2.appendChild(doc.createTextNode(path));
                    }
                    else {
                        ele2.appendChild(doc.createTextNode(String.valueOf(balise) + " : " + path));
                    }
                }
                else if (counter == 84) {
                    lang = doc.createElement("Langue");
                    rac.appendChild(lang);
                    ele1.appendChild(lang);
                    lang.setAttribute("id", "AR");
                }
                else if (counter >= 85 & counter <= 88) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 89) {
                    tailleDroite = chaine.length() - 14;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | VE : " + path));
                }
                else if (counter == 90) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | PH : DF : VE : " + path));
                }
                else if (counter == 91) {
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lang.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | NT : " + path));
                }
                else if (counter == 92) {
                    lan = doc.createElement("Langue");
                    rac.appendChild(lan);
                    ele1.appendChild(lan);
                    lan.setAttribute("id", "FR");
                }
                else if (counter >= 93 & counter <= 96) {
                    tailleDroite = chaine.length() - 4;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement(balise.substring(0, 2));
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode(String.valueOf(balise) + path));
                }
                else if (counter == 97) {
                    tailleDroite = chaine.length() - 19;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF |\tPH : DF : VE : " + path));
                }
                else {
                    if (counter != 98) {
                        continue;
                    }
                    tailleDroite = chaine.length() - 5;
                    balise = chaine.substring(tailleDroite, chaine.length());
                    path = chaine.substring(0, tailleDroite);
                    final Element ele2 = doc.createElement("RF");
                    rac.appendChild(ele2);
                    ele1.appendChild(ele2);
                    lan.appendChild(ele2);
                    ele2.appendChild(doc.createTextNode("RF | " + balise + path));
                }
            }
        }
        final DOMSource ds = new DOMSource(doc);
        final StreamResult res = new StreamResult(new File("fiches2.xml"));
        final TransformerFactory transform = TransformerFactory.newInstance();
        final Transformer tr = transform.newTransformer();
        tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        tr.setOutputProperty("indent", "yes");
        tr.transform(ds, res);
        System.out.println("Le fichier fiches.txt est transforme avec succes \"fiches2.xml\"");
    }
}
