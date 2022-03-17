package projetDS;
import java.io.BufferedWriter;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import org.w3c.dom.Element;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Node;
import org.w3c.dom.DocumentType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import org.xml.sax.InputSource;
//on utilise la meme classe pour les 2 fichier m457 et m674 car les fichiers ainsi que leurs sorties se ressemblent


public class M457 {
	public static void M457xml(String xmlFile) throws Exception {
	    xmlFile = CorrectionXml.corriger(xmlFile);
	 // le fichier du sortie (xmlFile) est le fichier corrigé, il est utilisé durant la lecture il est au meme niveau que le fichier original
	    final DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
	    final DocumentBuilder parseur2 = factory2.newDocumentBuilder();
	    final Document document = parseur2.parse(xmlFile);
	    final Node liste = document.getDocumentElement();
	    final DocumentBuilder one_parser = CreateDomParser.parseur();
	    final Document document_src = one_parser.parse(xmlFile);
	    final DOMImplementation domi_bis = CreateDomParser.cons();
	    final Document document_but = domi_bis.createDocument(null, "TEI_S", null);
	    final Element rac_but = document_but.getDocumentElement();
	    final Element m457 = document_but.createElement("M457.xml");
	    rac_but.appendChild(m457);
	    final Document document_but2 = transformer(liste, document, document_but, m457, rac_but);
	    final DOMSource ds = new DOMSource(document_but2);
	    final StreamResult res = new StreamResult(new StringWriter());
	    
	    //final StreamResult res = new StreamResult(new File("sortie2.xml"));
	    final TransformerFactory transform = TransformerFactory.newInstance();
	    final Transformer tr = transform.newTransformer();
	    tr.setOutputProperty(OutputKeys.INDENT, "yes");
	    // respecter l'indentation
	    tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	    document_but2.setXmlStandalone(true);
	    tr.setOutputProperty("encoding", "UTF-8");
	    tr.setOutputProperty("indent", "yes");
	    tr.setOutputProperty("doctype-system", "dom.dtd");
	    tr.transform(ds, res);
	    String xmlString = String.valueOf(res.getWriter());
	    
	   stringToDom( xmlString, "Sortie2.xml" );
	    System.out.println("Le fichier M457.xml est transforme avec succes");
	}

	public static Document transformer(final Node node, final Document doc, final Document doc_but, final Element m457, final Element rac_but) throws Exception {
	    if (node.hasAttributes() & node.getNodeName() == "pb") {
	        final String h =node.getNextSibling().getNodeValue();
	        if (h.trim().length() != 0) {
	            final String contenu = node.getNextSibling().getNodeValue();
	            final Element texte = doc_but.createElement("texte");
	            rac_but.appendChild(texte);
	            m457.appendChild(texte);
	            texte.appendChild(doc_but.createTextNode(contenu.trim()));
	        }
	    }
	    else {
	        if (node.cloneNode(true) != null && node.getNextSibling() != null) {
	            String h = node.getNextSibling().getNodeValue();
	            if (h.trim().length() != 0) {
	                if (h.indexOf("&") != -1) {
	                    h = node.getNextSibling().getNodeValue().trim();
	                    h = h.substring(9, h.length());
	                }
	                final String contenu = h;
	                final Element texte = doc_but.createElement("texte");
	                rac_but.appendChild(texte);
	                m457.appendChild(texte);
	                texte.appendChild(doc_but.createTextNode(contenu.trim()));
	            }
	        }
	        if (node.getFirstChild() != null & node.getNodeName() == "p") {
	            final String contenu2 = node.getFirstChild().getNodeValue();
	            final Element texte2 = doc_but.createElement("texte");
	            rac_but.appendChild(texte2);
	            m457.appendChild(texte2);
	            texte2.appendChild(doc_but.createTextNode(contenu2));
	        }
	    }
	    if (node.hasChildNodes()) {
	        final NodeList childNodes = node.getChildNodes();
	        for (int i = 0; i < childNodes.getLength(); ++i) {
	            final Node childNode = childNodes.item(i);
	            if (Filtrer(childNode)) {
	                transformer(childNode, doc, doc_but, m457, rac_but);
	            }
	        }
	    }
	    return doc_but;
	}

	public static boolean Filtrer(final Node noeud) {
	    return noeud.getNodeName() != "#text";
	}

	public static void stringToDom(String xmlSource, String Nom_fichier) 
	    throws IOException {
	Writer fstream = null;
	BufferedWriter out = null;
	fstream = new OutputStreamWriter(new FileOutputStream(Nom_fichier), StandardCharsets.UTF_8);
	 fstream.write(xmlSource);
	fstream.close();
	}



	// Pour le fichier M674
	public static void M674xml(String xmlFile) throws Exception {
	    final DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
	    final DocumentBuilder parseur2 = factory2.newDocumentBuilder();
	    final Document document = parseur2.parse(xmlFile);
	    final Node liste = document.getDocumentElement();
	    final DocumentBuilder one_parser = CreateDomParser.parseur();
	    final Document document_src = one_parser.parse(xmlFile);
	    final DOMImplementation domi_bis = CreateDomParser.cons();
	    final Document document_but = domi_bis.createDocument(null, "TEI_S", null);
	    final Element rac_but = document_but.getDocumentElement();
	    final Element m457 = document_but.createElement("M674.xml");
	    rac_but.appendChild(m457);
	    final Document document_but2 = transformer(liste, document, document_but, m457, rac_but);
	    final DOMSource ds = new DOMSource(document_but2);
	    final StreamResult res = new StreamResult(new StringWriter());
	    
	    //final StreamResult res = new StreamResult(new File("sortie2.xml"));
	    final TransformerFactory transform = TransformerFactory.newInstance();
	    final Transformer tr = transform.newTransformer();
	    tr.setOutputProperty(OutputKeys.INDENT, "yes");
	    tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	    document_but2.setXmlStandalone(true);
	    tr.setOutputProperty("encoding", "UTF-8");
	    tr.setOutputProperty("indent", "yes");
	    tr.setOutputProperty("doctype-system", "dom.dtd");
	    tr.transform(ds, res);
	    String xmlString = String.valueOf(res.getWriter());
	    
	   stringToDom( xmlString, "Sortie1.xml" );
	    System.out.println("Le fichier M674.xml est transforme avec succes");
	}
		


}
