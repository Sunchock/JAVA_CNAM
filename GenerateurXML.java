import java.io.File;

import org.jdom2.output.XMLOutputter;

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
		XMLOutputter xmlOutput = new XMLOutputter();
		File file = new File(nomLot);

		/* Ecrire les données */
		//Element e = new Element();
		//DocumentType.
	}

	@Override
	protected String toStringComplement() {
		return String.format("\"%s\"", this.filename);
	}
}
