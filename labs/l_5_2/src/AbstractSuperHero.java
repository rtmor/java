import java.util.*;

public abstract class AbstractSuperHero implements Comparable<AbstractSuperHero> {

	private static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ToolNotFoundException {
		List<AbstractSuperHero> ashList = new ArrayList<AbstractSuperHero>();
		AbstractSuperHero hero = null;
		ashList.add(new Batman());
		ashList.add(new MarthaStewart());
		ashList.add(new VaccuumMan());

/* 		AbstractSuperHero martha = new MarthaStewart();
		AbstractSuperHero vaccuum = new VaccuumMan();
		AbstractSuperHero batguy = new Batman() */;

		for (AbstractSuperHero ash : ashList) {
			System.out.printf("Tool to add to %s's toolbelt: ", ash.getName());
			ash.addTool(input.nextLine());
		}

		for (AbstractSuperHero ash : ashList) {
			System.out.println();
			System.out.println(ash.getName() + "'s Toolbelt contains: " + ash.listToolbeltItems());
			System.out.printf("%s, which tool would you like to give away: ", ash.getName());
			String tool = input.nextLine();
			System.out.printf("\nWho would you like to give %s to: \n"+ 
					"Batguy (b)\n"+
					"Martha Stewart (m)\n"+
					"VaccuumMan (v)\n\n"+
					">>> ", tool);
			String heroName = input.nextLine();

			switch (heroName) {
			case "b": {
				hero = ashList.get(0);
				break;
			}
			case "v": {
				hero = ashList.get(2);
				break;
			}
			case "m": {
				hero = ashList.get(1);
				break;
			}
			default: {
				System.out.println("Superhero does not exist");
				break;
			}
			}

			// swap super hero tools and list contents following trade
			ash.swap(tool, hero);

		}
	}

	// I promise to implement these methods in a subclass.
	public abstract String getName();

	public abstract String getSuperPower();

	public abstract int getMeasureOfBadassness();

	public abstract ArrayList<String> listToolbeltItems();

	public abstract boolean rmTool(String tool);

	public abstract boolean hasToolBeltItem(String item);

	public abstract void addTool(String tool);

	public abstract String useTool(String tool) throws ToolNotFoundException;

	public abstract void swap(String tool, AbstractSuperHero hero);

	public int compareTo(AbstractSuperHero ash) {
		int them = ash.getMeasureOfBadassness();
		int me = this.getMeasureOfBadassness();

		if (them > me)
			return 1;
		if (them < me)
			return -1;
		return 0;
	}

	// Overrides from object
	public String toString() {
		return getName();
	}

}
