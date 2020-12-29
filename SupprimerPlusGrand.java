/**
  * SupprimerPlusGrand supprime les valeurs plus grandes qu'un seuil.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class SupprimerPlusGrand extends Traitement {
	Class<?>  type;
  Object    value;

	public SupprimerPlusGrand(double val) {
    this.type = double.class;
    this.value = val;
  }

}
