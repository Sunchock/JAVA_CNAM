import java.util.*;

/**
  * Donnees enregistre toutes les données reçues, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Donnees extends Traitement {
  /* classe Donnée pour stocker les informations */
  private class Donnee {
    private Position position;
    private double valeur;

    public Donnee(Position position, double valeur) {
      this.position = position;
      this.valeur = valeur;
    }

    @Override public String toString() {
      return super.toString() + "(" + this.position.x + "," + this.position.y + ") " + this.valeur;
    }
  }

  List<Donnee> list = new ArrayList<>();

  public Donnees() {
  }

  public void ajouterDonnee(Position position, double valeur) {
    this.list.add(new Donnee(position, valeur));
  }
}
