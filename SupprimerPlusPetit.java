/**
  * SupprimerPlusPetit supprime les valeurs plus petites qu'un seuil.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusPetit extends Traitement {
  Class<?>  type;
  Object    value;

	public SupprimerPlusPetit(double val) {
    this.type = double.class;
    this.value = val;
  }

}
