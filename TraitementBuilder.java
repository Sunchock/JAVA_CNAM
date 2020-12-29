import java.lang.reflect.*;
import java.util.*;

/**
  * TraitementBuilder 
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */
public class TraitementBuilder {

	/** Retourne un objet de type Class correspondant au nom en paramètre.
	 * Exemples :
	 *   - int donne int.class
	 *   - Normaliseur donne Normaliseur.class
	 */
	Class<?> analyserType(String nomType) throws ClassNotFoundException {
		System.out.println("analyseType(" + nomType + ")");
		if (nomType.equals("double"))
			return double.class;
		return Class.forName(nomType);
	}

	/** Crée l'objet java qui correspond au type formel en exploitant le « mot » suivant du scanner.
	 * Exemple : si formel est int.class, le mot suivant doit être un entier et le résulat est l'entier correspondant.
	 * Ici, on peut se limiter aux types utlisés dans le projet : int, double et String.
	 */
	static Object decoderEffectif(Class<?> formel, Scanner in) {
		if (in.hasNextInt() && formel == int.class) {
			return in.nextInt();
		} else if (in.hasNextDouble() && formel == double.class) {
			return in.nextDouble();
		} else if (formel == String.class) {
			return in.next();
		}
		// Type non identifié -> erreur
		System.out.println(in.next());
		return null;
	}

	/** Définition de la signature, les paramètres formels, mais aussi les paramètres effectifs. */
	static class Signature {
		Class<?>[] formels;
		Object[] effectifs;

		public Signature(Class<?>[] formels, Object[] effectifs) {
			this.formels = formels;
			this.effectifs = effectifs;
		}
	}

	/** Analyser une signature pour retrouver les paramètres formels et les paramètres effectifs.
	 * Exemple « 3 double 0.0 java.lang.String xyz int -5 » donne
	 *   - [double.class, String.class, int.class] pour les paramètres formels et
	 *   - [0.0, "xyz", -5] pour les paramètres effectifs.
	 */
	Signature analyserSignature(Scanner in) throws ClassNotFoundException {
		int count = in.nextInt();
		Class<?> type = null;
		List<Class<?>> formels = new ArrayList<>();
		List<Object> effectifs = new ArrayList<>();

		while (count > 0) {
			System.out.println("analyserSignature " + count);
			type = analyserType(in.next());
			formels.add(type);
			effectifs.add(decoderEffectif(type, in));
			--count;
		}
		return new Signature(formels.toArray(new Class<?>[0]), effectifs.toArray());
	}


	/** Analyser la création d'un objet.
	 * Exemple : « Normaliseur 2 double 0.0 double 100.0 » consiste à charger
	 * la classe Normaliseur, trouver le constructeur qui prend 2 double, et
	 * l'appeler en lui fournissant 0.0 et 100.0 comme paramètres effectifs.
	 */
	Object analyserCreation(Scanner in) throws ClassNotFoundException, InvocationTargetException,
		IllegalAccessException,	NoSuchMethodException, InstantiationException
	{
		Class<?> formel = analyserType(in.next());
		Signature sign = analyserSignature(in);

		System.out.println("Construction " + formel);
		return formel.getConstructor(sign.formels).newInstance(sign.effectifs);
	}


	/** Analyser un traitement.
	 * Exemples :
	 *   - « Somme 0 0 »
	 *   - « SupprimerPlusGrand 1 double 99.99 0 »
	 *   - « Somme 0 1 Max 0 0 »
	 *   - « Somme 0 2 Max 0 0 SupprimerPlusGrand 1 double 20.0 0 »
	 *   - « Somme 0 2 Max 0 0 SupprimerPlusGrand 1 double 20.0 1 Positions 0 0 »
	 * @param in le scanner à utiliser
	 * @param env l'environnement où enregistrer les nouveaux traitements
	 */
	Traitement analyserTraitement(Scanner in, Map<String, Traitement> env) throws ClassNotFoundException,
		InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException
	{
		int nbNextTraits = 0;
		Traitement result = (Traitement) analyserCreation(in);

		nbNextTraits = in.nextInt();
		while (nbNextTraits-- > 0) {
			result.ajouterSuivants(analyserTraitement(in, env));
		}
		return (result);
	}


	/** Analyser un traitement.
	 * @param in le scanner à utiliser
	 * @param env l'environnement où enregistrer les nouveaux traitements
	 */
	public Traitement traitement(Scanner in, Map<String, Traitement> env)
	{
		try {
			return analyserTraitement(in, env);
		} catch (Exception e) {
			throw new RuntimeException("Erreur sur l'analyse du traitement, "
					+ "voir la cause ci-dessous", e);
		}
	}

}
