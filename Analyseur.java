import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;

/** Réaliser un traitement sur les données d'une source. */
public class Analyseur {
	private Donnees donnees;
	private Traitement traitement; 
 
	public Analyseur(Traitement traitement) {
		Objects.requireNonNull(traitement);

		this.donnees = new Donnees();
		this.traitement = traitement;
	}

	public void chargerFichier(String source) {

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
