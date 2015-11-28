package us.com.formalMethods.main;




public class Food {
	
	String name;
	int calories;
	float price;
	
	public Food(String n, int c, float p){
		
		this.name = n;
		this.calories = c;
		this.price = p;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
