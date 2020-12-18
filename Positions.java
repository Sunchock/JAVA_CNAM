import java.util.*;

/**
 * Positions enregistre toutes les positions, quelque soit le lot.
 *
 * @author Xavier Crégut <Prenom.Nom@enseeiht.fr>
 */
public class Positions extends PositionsAbstrait {

  private List<Position> positions = new ArrayList<>();

	@Override
	public int nombre() {
    return this.positions.size();
  }

	@Override
	public Position position(int indice) {
    return this.positions.get(indice);
  }

  @Override
	public int frequence(Position position) {
    int nbMatch = 0;

    for (Position p : this.positions) {
      if (p.x == position.x && p.y == position.y) {
        ++nbMatch;
      }
    }
    return nbMatch;
  }

  @Override
  public void traiter(Position position, double valeur) {
    Collections.addAll(this.positions, position);
    super.traiter(position, valeur);
  }
}
