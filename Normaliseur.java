
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
}