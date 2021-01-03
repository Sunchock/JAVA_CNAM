import java.util.*;

/**
 * Positions enregistre toutes les positions, quelque soit le lot.
 *
 * @author Xavier Crégut <Prenom.Nom@enseeiht.fr>
 */
public class Positions extends PositionsAbstrait {

  private List<Position> positions = new ArrayList<>();

	@Override
	public final int nombre() {
    return this.positions.size();
  }

	@Override
	public final Position position(int indice) {
    return this.positions.get(indice);
  }

  @Override
	public final int frequence(Position position) {
    return Collections.frequency(this.positions, position);
  }

  @Override
  public final void traiter(Position position, double valeur) {
    Collections.addAll(this.positions, position);
    super.traiter(position, valeur);
  }
}
