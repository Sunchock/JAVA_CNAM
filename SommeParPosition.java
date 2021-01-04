import java.util.*;

/**
  * SommeParPosition 
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */

public class SommeParPosition extends Traitement {
  private class TotalParPosition {
    public Position position;
    public double valeur;

    public TotalParPosition(Position position, double valeur) {
      this.position = position;
      this.valeur = valeur;
    }
  }

  private List<TotalParPosition> positions = new ArrayList<TotalParPosition>();

  @Override
  public final void gererFinLotLocal(String nomLot) {
    System.out.println("SommeParPosition " + nomLot);
    for (TotalParPosition s : this.positions) {
      System.out.println(" - " + s.position + "\t-> " + s.valeur);
    }
    System.out.println("Fin SommeParPosition.");
	}

  @Override
  public final void traiter(Position position, double valeur) {
    boolean find = false;

    for (TotalParPosition s : this.positions) {
      if (s.position.equals(position)) {
        find = true;
        s.valeur += valeur;
        break;
      }
    }
    if (!find) {
      Collections.addAll(this.positions, new TotalParPosition(position, valeur));
    }
    super.traiter(position, valeur);
  }
}
