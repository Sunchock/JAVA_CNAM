import java.util.Locale;

/**
  * Normaliseur normalise les données d'un lot en utilisant une transformation affine.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Normaliseur extends Traitement {
  private double debut;
  private double fin;

  public Normaliseur(double x, double y) {
    this.debut = x;
    this.fin = y;
  }
  
  @Override
	protected final String toStringComplement() {
    return String.format(Locale.US, "début=%.1f, fin=%.1f", this.debut, this.fin);
  }
  
  @Override
	public final void traiter(Position position, double valeur) {
    double a, b;

    a = (Math.max(this.debut, this.fin) - Math.min(this.debut, this.fin)) / (this.fin - this.debut);
    b = this.debut - a * Math.min(this.debut, this.fin);
    super.traiter(position, a * valeur + b);
  }
}