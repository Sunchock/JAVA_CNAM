/**
 * Multiplicateur transmet la valeur multipliée par un facteur.
 *
 * @author Théodore Marestin <theodore.marestin@ipst.fr>
 */
public class Multiplicateur extends Traitement {
  double facteur;

  public Multiplicateur(double valeur) {
    this.facteur = valeur;
  }

  @Override
	public void traiter(Position position, double valeur) {
		super.traiter(position, this.facteur * valeur);
	}
}
