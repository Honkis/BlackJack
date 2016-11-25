/*
 * Card class with 2 methods of returnin to string for output and to int.
 */
public class Card {
	private String colour;
	private String rank;
	private int value;
	
	
	public Card(String rank ,String colour, int value) {
		this.rank = rank;
		this.colour = colour;
		this.value= value;
		
	}
	public String toString(){
		return rank + " of " + colour;
	}
	public int toInt(){
		return value;
	}
	
}
