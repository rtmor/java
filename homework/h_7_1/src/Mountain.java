
public class Mountain {

	private String name;
	private String smallImage;
	private String largeImage;
	
	public Mountain(String name, String smallImage, String largeImage) {
		// should be using a setter
		this.name = name;
		this.smallImage = smallImage;
		this.largeImage = largeImage;
	}

	public String getLargeImage() {
		return largeImage;
	}
	
	public String toString() {
		return name;
	}

	public String getThumbImage() {
		// TODO Auto-generated method stub
		return smallImage;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
