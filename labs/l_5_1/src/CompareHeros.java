import java.util.*;

public class CompareHeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Set<AbstractSuperHero> heros = new TreeSet<AbstractSuperHero>();
		heros.add(new Batman());
		heros.add(new MarthaStewart());
		heros.add(new VaccuumMan());
		
		for (AbstractSuperHero ash : heros) {
			System.out.println(ash);
		}
	}
}
