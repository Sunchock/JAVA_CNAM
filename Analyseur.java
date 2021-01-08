import java.io.*;
import java.nio.file.Paths;
import java.util.*;
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

	private TypeFichier detecterTypeFichier(String source) {
		if (source.endsWith("-f2.txt") || source.equals("donnees-erreur.txt")) {
			return TypeFichier.TXT_2;
		} else if (source.endsWith(".txt")) {
			return TypeFichier.TXT_1;
		}
		return TypeFichier.NULL;
	}

	/* x y id(ignoré) valeur */
	private void chargerFichierType1(Scanner sc, Donnees donnees) {
		Position p = new Position(sc.nextInt(), sc.nextInt());
		double valeur;

		// skip id
		sc.next();
		valeur = sc.nextDouble();
		// Enregistrement
		donnees.ajouterDonnee(p, valeur);
	}

	/* id(ignoré) x y texte(ignoré) valeur texte[0](ignoré) */
	private void chargerFichierType2(Scanner sc, Donnees donnees) {
		// skip id
		sc.next();

		Position p = new Position(sc.nextInt(), sc.nextInt());
		double valeur;

		// skip text
		sc.next();
		valeur = sc.nextDouble();
		// Enregistrement
		donnees.ajouterDonnee(p, valeur);
	}

	public void chargerFichier(String source) throws FileNotFoundException {
		this.typeFichier = this.detecterTypeFichier(source);

		try {
			Scanner sc = new Scanner(new File(source)).useLocale(Locale.US);
			Donnees donnees = new Donnees(Paths.get(source).getFileName().toString());

			switch (this.typeFichier) {
				case TXT_1:
					this.chargerFichierType1(sc, donnees);
					break;
				case TXT_2:
					this.chargerFichierType2(sc, donnees);
					break;
				default:
					throw new Exception("Format du fichier non supporté");
			}
			sc.close();
			if (this.donnees == null) {
				this.donnees = donnees;
			} else {
				this.donnees.ajouterSuivants(donnees);
			}
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
