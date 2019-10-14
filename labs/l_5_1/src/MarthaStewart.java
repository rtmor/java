import java.util.ArrayList;
import java.util.Arrays;

/**
 * MarthaStewart
 */
public class MarthaStewart extends AbstractSuperHero implements ToolbeltHero {

    private static ArrayList<String> tools = new ArrayList<>(Arrays.asList("lawyers","nightquel pm"));

    @Override
    public ArrayList<String> listToolbeltItems() {
        return tools;
    }

    @Override
    public boolean hasToolBeltItem(String item) {

        for (String s : listToolbeltItems()) {
            if (s.equalsIgnoreCase(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getName() {
        return "Martha Stewart";
    }

    @Override
    public String getSuperPower() {
        return "Insider Trading";
    }

    @Override
    public int getMeasureOfBadassness() {
        return 2004;
    }

    @Override
    public void addTool(String tool) {
        if (!hasToolBeltItem(tool)) {
            tools.add(tool);
        }

    }

    @Override
    public String useTool(String tool) throws ToolNotFoundException {
        if (hasToolBeltItem(tool)) {
            return getName() + " uses " + tool;
        } else {
            throw new ToolNotFoundException("The tool " + tool + " could not be found!");
        }
    }

    @Override
    public boolean rmTool(String tool) {
        if (this.hasToolBeltItem(tool)) {
            if (tools.remove(tool)) {
                return true;
            }
        }
        return false;
    }

    @Override
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