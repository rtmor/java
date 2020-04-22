import java.util.ArrayList;

public interface ToolbeltHero {
	ArrayList<String> listToolbeltItems();
	boolean hasToolBeltItem(String item);
	void addTool(String tool);
	String useTool(String tool) throws ToolNotFoundException;
	boolean rmTool(String tool);
	void swap(String tool, AbstractSuperHero hero);
}
