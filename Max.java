/**
  * Max calcule le max des valeurs vues, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */

public class Max extends Traitement {
  double max_value = 0;

	@Override
	public void gererFinLotLocal(String nomLot) {
		super.gererFinLotLocal(nomLot);
		System.out.println(nomLot + ": max = " + this.max());
	}

	@Override
	public void traiter(Position position, double valeur) {
    if (valeur > this.max_value) {
      this.max_value = valeur;
    }
		super.traiter(position, valeur);
	}

  public double max() {
    return this.max_value;
  }
}
