package projetDS;
import javax.xml.transform.Transformer;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.NodeList;


import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Node;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.DocumentType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;

public class renault {
	 public static int cu;
	    public static int tel;
	    
	    static {
	        renault.cu = 0;
	        renault.tel = 0;
	    }
	    
	    public static void renaultxml(final String htmlFile) throws Exception {
	        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(false);
	        factory.setValidating(false);
	        factory.setFeature("http://xml.org/sax/features/namespaces", false);
	        factory.setFeature("http://xml.org/sax/features/validation", false);
	        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
	        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
	        final DocumentBuilder parseur = factory.newDocumentBuilder();
	        final Document document = parseur.parse(htmlFile);
	        final NodeList sections = document.getElementsByTagName("div");
	        final DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
	        final DocumentBuilder parseur2 = factory2.newDocumentBuilder();
	        final DOMImplementation domimp = parseur2.getDOMImplementation();
	        final Document doc = domimp.createDocument(null, "Concessionnaires", null);
	        doc.setXmlStandalone(true);
	        final Element rac = doc.getDocumentElement();
	        int y = 1;
	        for (int i = 1; i < sections.getLength(); ++i) {
	            final Element section = (Element)sections.item(i);
	            if (section.hasAttributes()) {
	                final NamedNodeMap attributes = section.getAttributes();
	                final Attr attribute = (Attr)attributes.item(0);
	                ++y;
	                if (attribute.getName() == "class" && y == 11) {
	                    Extraire(section, document, rac, doc);
	                }
	            }
	        }
	        final DOMSource ds = new DOMSource(doc);
	        final StreamResult res = new StreamResult(new File("renault.xml"));
	        final TransformerFactory transform = TransformerFactory.newInstance();
	        final Transformer tr = transform.newTransformer();
	        tr.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
	        tr.setOutputProperty(OutputKeys.INDENT, "yes");
	        tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        tr.setOutputProperty("indent", "yes");
	        tr.transform(ds, res);
	        System.out.println("Le fichier renault.html est transforme avec succes");
	    }
	    
	    public static void Extraire(final Node node, final Document document, final Element rac, final Document doc) {
	        if (!node.hasAttributes()) {
	            if (node.getFirstChild() != null & node.getNodeName() == "strong") {
	                final String chaine = node.getFirstChild().getNodeValue().trim();
	                if (chaine.length() != 0 && !chaine.equals("T\u00e9l") && !chaine.equals("Adresse")) {
	                    final Element texte = doc.createElement("Nom");
	                    rac.appendChild(texte);
	                    texte.appendChild(doc.createTextNode(node.getFirstChild().getNodeValue().replaceAll("\n", "")));
	                }
	            }
	            if (node.getNextSibling() != null) {
	                final String chaine = node.getNextSibling().getNodeValue();
	                if (chaine.length() != 0 & chaine.trim().length() != 0) {
	                    if (!chaine.trim().equals(":") & !chaine.trim().equals("Fax :") & (chaine.indexOf("021") == -1 | renault.cu == 0)) {
	                        if (chaine.indexOf("021") == -1) {
	                            final Element texte = doc.createElement("Adresse");
	                            rac.appendChild(texte);
	                            if (chaine.indexOf(": ") != -1) {
	                                texte.appendChild(doc.createTextNode(chaine.trim().replaceAll(": ", "")));
	                            }
	                            else {
	                                texte.appendChild(doc.createTextNode(chaine.trim().replaceAll("\n", " ")));
	                            }
	                        }
	                        if (chaine.indexOf("021") != -1) {
	                            final Element texte = doc.createElement("Num_t\u00e9l\u00e9phone");
	                            rac.appendChild(texte);
	                            texte.appendChild(doc.createTextNode(node.getNextSibling().getNodeValue().replaceAll("\n|: ", "")));
	                        }
	                    }
	                    else if (chaine.indexOf("021") != -1) {
	                        if (renault.cu != 0) {
	                            switch (renault.tel) {
	                                case 1: {
	                                    renault.tel = 0;
	                                    break;
	                                }
	                                case 0: {
	                                    renault.tel = 1;
	                                    final Element num = doc.createElement("Num_t\u00e9l\u00e9phone");
	                                    rac.appendChild(num);
	                                    num.appendChild(doc.createTextNode(node.getNextSibling().getNodeValue().trim().replaceAll("\n", " ")));
	                                    break;
	                                }
	                            }
	                        }
	                    }
	                    else if (renault.cu == 0) {
	                        renault.cu = 1;
	                    }
	                }
	            }
	        }
	        if (node.hasChildNodes()) {
	            final NodeList childNodes = node.getChildNodes();
	            for (int i = 0; i < childNodes.getLength(); ++i) {
	                final Node childNode = childNodes.item(i);
	                if (Filtrer(childNode)) {
	                    Extraire(childNode, document, rac, doc);
	                }
	            }
	        }
	    }
	    
	    public static boolean Filtrer(final Node noeud) {
	        return noeud.getNodeName() != "#text";
	    }

}
