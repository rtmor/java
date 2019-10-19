import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * run
 */
public class run {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        List<ToolbeltHero> ashList = new ArrayList<ToolbeltHero>();
		ToolbeltHero hero = null;
		ashList.add(new Batman());
		ashList.add(new MarthaStewart());
        ashList.add(new VaccuumMan());

        for (ToolbeltHero ash : ashList) {
            System.out.printf("Tool to add to %s's toolbelt: ", ash.getName());
            ash.addTool(input.nextLine());
        }
    }
}