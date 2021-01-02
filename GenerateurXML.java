

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
	protected String toStringComplement() {
		return String.format("\"%s\"", this.filename);
	}
}
