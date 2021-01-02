import java.util.Locale;

/**
  * SupprimerPlusPetit supprime les valeurs plus petites qu'un seuil.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusPetit extends Traitement {
  double value;

	public SupprimerPlusPetit(double val) {
    this.value = val;
  }

  @Override
	protected String toStringComplement() {
    return String.format(Locale.US, "< %.1f", value);
	}
}
