import java.io.*;
import java.util.*;
import java.util.IllegalFormatException;
import static java.util.AbstractMap.SimpleImmutableEntry;

/** Réaliser un traitement sur les données d'une source. */
public class Analyseur {
	private enum TypeFichier {
		NULL, TXT_1, TXT_2
	}
	private Donnees donnees;
	private Traitement traitement;
	private TypeFichier typeFichier;
 
	public Analyseur(Traitement traitement) {
		Objects.requireNonNull(traitement);

		this.donnees = new Donnees();
		this.traitement = traitement;
		this.typeFichier = TypeFichier.NULL;
	}

	private TypeFichier detecterTypeFichier(String source) throws IllegalFormatException {
		if (source.endsWith("-f2.txt") || source.equals("donnees-erreur.txt")) {
			return TypeFichier.TXT_2;
		} else if (source.endsWith(".txt")) {
			return TypeFichier.TXT_1;
		}
		return TypeFichier.NULL;
	}

	public void chargerFichier(String source) throws FileNotFoundException {
		this.typeFichier = this.detecterTypeFichier(source);

		try {
			Scanner sc = new Scanner(new File(source));

			if (this.typeFichier == TypeFichier.NULL) {
				throw new Exception("Format du fichier non supporté");
			}
			int i = 0;
			while (sc.hasNext()) {
				if (++i >= 4 && this.typeFichier == TypeFichier.TXT_1) {
					i = 0;
					System.out.println("->" + sc.next());
				} else if (i >= 6 && this.typeFichier == TypeFichier.TXT_2) {
					i = 0;
					System.out.println("->" + sc.next());
				} else {
					System.out.print("->" + sc.next());
				}
			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/** Charger l'analyseur avec les données de la source. */
	public void traiter(Iterable<SimpleImmutableEntry<Position, Double>> source, String nom) {
		this.traitement.gererDebutLot(nom);
		for (SimpleImmutableEntry<Position, Double> info : source) {
			Double valeur = info.getValue();
			Position p = info.getKey();
			this.donnees.ajouterDonnee(p, valeur);
			this.traitement.traiter(p, valeur);
		}
		this.traitement.gererFinLot(nom);
	}
}
