import java.util.*;

public class SuperHero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<SuperHero> shList = new ArrayList<SuperHero>();
		shList.add(new SuperHero("GenericMan"));
		
		for(SuperHero sh : shList) {
			sh.defeatVillain();
		}
	}
	
	private String m_name;
	
	public SuperHero(String name) {
		m_name = name;
	}
	
	public String getName() {
		return m_name;
	}
	
	public void defeatVillain() {
		System.out.println(m_name + " defeated the villain using my awesome power of being generic!");
	}
}
