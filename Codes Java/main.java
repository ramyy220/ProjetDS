package projetDS;
import java.io.File;
import java.io.IOException;



public class main {

	public static void main(String[] argv) throws IOException, Exception{
		 if (argv.length != 0) {
	            try {
	                final String dir = argv[0];
	                scanDir(dir);
	            }
	            catch (Exception e) {
	                System.out.println("ERROR : Le repertoire n'existe pas verifiez le path");
	            }
	        }
	        else {
	            System.out.println("Attention vous avez oublie de specifier le nom du repertoire a traiter ! ");
	        }
	    }
	    // parcours du répértoire 
	    public static void scanDir(final String d) throws Exception {
	        final File currDir = new File(d);
	        final String[] List = currDir.list();
	        for (int i = 0; i < List.length; ++i) {
	            final String rep = String.valueOf(d) + File.separator + List[i];
	            final File repe = new File(rep);
	            if (repe.isDirectory()) {
	                scanDir(rep);
	            }
	            // ouverture des fichiers
	            else if ("M674.xml".equals(List[i])) {
	                deplacerDTD.DTD(String.valueOf(repe).substring(0, String.valueOf(repe).length() - List[i].length()));
	                M457.M674xml(String.valueOf(repe));
	                final File fichier = new File(String.valueOf(String.valueOf(repe).substring(0, String.valueOf(repe).length() - List[i].length())) + "TEIFrantext.dtd");
	                fichier.delete();
	            }
	            else if ("M457.xml".equals(List[i])) {
	                M457.M457xml(String.valueOf(repe));
	                final File fichier = new File(String.valueOf(String.valueOf(repe).substring(0, String.valueOf(repe).length() - List[i].length())) + "TEIFrantext.dtd");
	                fichier.delete();
	            }
	            else if ("fiches.txt".equals(List[i])) {
	                fiche1.fiche1xml(String.valueOf(repe));
	                fiche2.fiche2xml(String.valueOf(repe));
	            }
	            else if ("boitedialog.fxml".equals(List[i])) {
	                fxml.fxmll(String.valueOf(repe));
	            }
	            else if ("renault.html".equals(List[i])) {
	                renault.renaultxml(String.valueOf(repe));
	            }
	            else if ("poeme.txt".equals(List[i])) {
	                Neruda.poemexml(String.valueOf(repe));
	            }
	        }
	    }

	}


