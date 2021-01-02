import java.util.Locale;

/**
  * SupprimerPlusGrand supprime les valeurs plus grandes qu'un seuil.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusGrand extends Traitement {
	double value;

	public SupprimerPlusGrand(double val) {
    this.value = val;
  }

  @Override
	protected String toStringComplement() {
    return String.format(Locale.US, "> %.1f", value);
	}
}
