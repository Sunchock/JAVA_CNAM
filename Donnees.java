import java.util.*;
import static java.util.AbstractMap.SimpleImmutableEntry;

/**
  * Donnees enregistre toutes les données reçues, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Donnees extends Traitement {
  String nomLot;
  List<SimpleImmutableEntry<Position, Double>> list = new ArrayList<>();

  public Donnees() {
    this.nomLot = "manuelles";
  }

  public Donnees(String nomLot) {
    this.nomLot = nomLot;
  }

  public void ajouterDonnee(Position position, double valeur) {
    this.list.add(new SimpleImmutableEntry<>(position, valeur));
  }
}
