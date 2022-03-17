package projetDS;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;
import javax.xml.transform.Transformer;
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
import javax.xml.transform.OutputKeys;

public class fxml {
	 public static void fxmll(final String fxmlFile) throws Exception {
	        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        final DocumentBuilder parseur = factory.newDocumentBuilder();
	        final DOMImplementation domimp = parseur.getDOMImplementation();
	        final Document doc = domimp.createDocument(null, "Racine", null);
	        doc.setXmlStandalone(true);
	        final Element rac = doc.getDocumentElement();
	        rac.setAttribute("xmlns:fx", "http://javafx.com/fxml");
	        final DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
	        final DocumentBuilder parseur2 = factory2.newDocumentBuilder();
	        final Document document = parseur2.parse(fxmlFile);
	        final Node liste = document.getDocumentElement();
	        EcrireXml(liste, doc, rac);
	        final DOMSource ds = new DOMSource(doc);
	        final StreamResult res = new StreamResult(new File("javafx.xml"));
	        final TransformerFactory transform = TransformerFactory.newInstance();
	        final Transformer tr = transform.newTransformer();
	         tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
	        tr.setOutputProperty(OutputKeys.INDENT, "yes");
	        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        tr.setOutputProperty("indent", "yes");
	        tr.transform(ds, res);
	        System.out.println("Le fichier boitedialog.fxml est transforme avec succes");
	    }
	    
	    public static void EcrireXml(final Node node, final Document doc, final Node rac) {
	        if (node.hasAttributes()) {
	            final NamedNodeMap attributes = node.getAttributes();
	            for (int j = 0; j < attributes.getLength(); ++j) {
	                final Attr attribute = (Attr)attributes.item(j);
	                final Element texte = doc.createElement("texte");
	                rac.appendChild(texte);
	                texte.setAttribute(attribute.getName(), "x");
	                texte.appendChild(doc.createTextNode(attribute.getValue()));
	            }
	        }
	        if (node.hasChildNodes()) {
	            final NodeList childNodes = node.getChildNodes();
	            for (int i = 0; i < childNodes.getLength(); ++i) {
	                final Node childNode = childNodes.item(i);
	                EcrireXml(childNode, doc, rac);
	            }
	        }
	    }
	    
	    public static boolean Filtrer(final Node noeud) {
	        return noeud.getNodeName() != "#text";
	    }

}
