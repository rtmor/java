import java.util.*;

public abstract class AbstractSuperHero implements Comparable<AbstractSuperHero> {

	private static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ToolNotFoundException {
		List<AbstractSuperHero> ashList = new ArrayList<AbstractSuperHero>();
		ashList.add(new Batman());
		ashList.add(new MarthaStewart());
		ashList.add(new VaccuumMan());

		for (AbstractSuperHero ash : ashList) {
			ash.defeatVillain();
		}

		for (AbstractSuperHero ash : ashList) {
			System.out.printf("Tool to add to %s's toolbelt: ", ash.getName());
			ash.addTool(input.nextLine());
		}

		for (AbstractSuperHero ash : ashList) {
			System.out.printf("\nWhich tool to use from %s's belt: ", ash.getName());
			System.out.println(ash.useTool(input.nextLine()));
		}

		for (AbstractSuperHero ash : ashList) {

			AbstractSuperHero hero = null;
			System.out.printf("%s, which tool would you like to give away: ", ash.getName());
			String tool = input.nextLine();
			System.out.printf("Who would you like to give %s to: ", tool);
			String heroName = input.nextLine();

			switch (heroName) {
			case "batman": {
				hero = new Batman();
				break;
			}
			case "vaccuumman": {
				hero = new VaccuumMan();
				break;
			}
			case "marthastewart": {
				hero = new MarthaStewart();
				break;
			}
			default: {
				System.out.println("Superhero does not exist");
				break;
			}
			}

			// swap super hero tools and list contents following trade
			ash.swap(tool, hero);
			System.out.println(ash.listToolbeltItems());
			System.out.println(hero.listToolbeltItems());

		}
		// create own instance of Scanner
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter something: ");
		System.out.println(input.nextLine());
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

	public void defeatVillain() {
		// Seriously! I promised a subclass would implement them! Please let me use
		// them!
		System.out.println(getName() + " defeated the villain using " + getSuperPower());
	}

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
