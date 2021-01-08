import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;

/**
  * Donnees enregistre toutes les données reçues, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Donnees extends Traitement {
  public List<SimpleImmutableEntry<Position, Double>> list = new ArrayList<>();

  public Donnees() {
  }

  public void ajouter(Position position, double valeur) {
    this.list.add(new SimpleImmutableEntry<>(position, valeur));
  }
}
