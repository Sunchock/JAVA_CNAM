/**
  * Somme calcule la sommee des valeurs, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */

public class Somme extends SommeAbstrait {
	double result = 0;

	@Override
	public final void gererFinLotLocal(String nomLot) {
		super.gererFinLotLocal(nomLot);
		System.out.println(nomLot + ": somme = " + this.somme());
	}

	@Override
	public final void traiter(Position position, double valeur) {
		this.result += valeur;
		super.traiter(position, valeur);
	}

	@Override
	public final double somme() {
		return (double) Math.round(this.result * 10d) / 10d;
	}
}
