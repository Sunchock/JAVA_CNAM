import java.util.Locale;

/**
  * Normaliseur normalise les données d'un lot en utilisant une transformation affine.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Normaliseur extends Traitement {
  double x;
  double y;

  public Normaliseur(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  @Override
	protected String toStringComplement() {
    return String.format(Locale.US, "début=%.1f, fin=%.1f", this.x, this.y);
	}
}