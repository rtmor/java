import java.util.ArrayList;

public abstract class ToolbeltHero extends AbstractSuperHero{
	private ArrayList<String> tools = new ArrayList<String>();

	public abstract String getName();

	public abstract String getSuperPower();

	public abstract int getMeasureOfBadassness();
	
	public ArrayList<String> listToolbeltItems() {
		return tools;
	}
	
	public boolean hasToolBeltItem(String item) {
		for (String s : listToolbeltItems()) {
			if (s.equalsIgnoreCase(item)) {
				return true;
			}
		}
		return false;
	}
	
	public void addTool(String tool) {

		if (!hasToolBeltItem(tool)) {
			tools.add(tool);
		}
	}
	
	public String useTool(String tool) throws ToolNotFoundException {
		if (hasToolBeltItem(tool)) {
			return getName() + " uses " + tool;
		} else {
			throw new ToolNotFoundException("The tool, " + tool + ", could not be found!");
		}
	}
	
	public boolean rmTool(String tool) {
		if (hasToolBeltItem(tool)) {
			if (tools.remove(tool)) {
				return true;
			}
		}
		return false;
	}
	
	public void swap(String tool, AbstractSuperHero hero) {
		if (this.hasToolBeltItem(tool)) {
			if (tools.remove(tool)) {
				hero.addTool(tool);
			}
		} else {
			System.out.printf("Hero, %s, does not have the tool %s to give!", getName(), tool);
		}
	}
}
