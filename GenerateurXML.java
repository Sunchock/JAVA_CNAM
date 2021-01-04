import java.io.File;
import java.io.FileOutputStream;

import org.jdom2.*;
import org.jdom2.output.*;

/**
 * GenerateurXML écrit dans un fichier, à charque fin de lot, toutes
 * les données lues en indiquant le lot dans le fichier XML.
 *
 * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
 */
public class GenerateurXML extends Traitement {
	String filename;

	public GenerateurXML(String arg) {
		this.filename = arg;
	}

	@Override
	public final void gererFinLotLocal(String nomLot) {
		try {
			Element root = new Element("root");
			Document doc = new Document(root);
			XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

			xmlOutput.output(doc, new FileOutputStream(new File(this.filename)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected String toStringComplement() {
		return String.format("\"%s\"", this.filename);
	}
}
