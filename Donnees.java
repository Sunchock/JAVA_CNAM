import java.util.*;

/**
  * Donnees enregistre toutes les données reçues, quelque soit le lot.
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class Donnees extends Traitement {
  private class Donnee {
    private int x;
    private int y;
    private double valeur;

    public Donnee(int x, int y, double valeur) {
      this.x = x;
      this.y = y;
      this.valeur = valeur;
    }
  }

  List<Donnee> list = new ArrayList<Donnee>();

  public Donnees() {

  }
}
