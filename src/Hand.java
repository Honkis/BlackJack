
import java.util.Vector;
/*
 *  Hand Class and its a PlayebleHand. 
 */

public class Hand extends CollectionOfCards implements PlayableHand{
	private Vector<Card> Hand = new Vector<Card>();
	private int ValueOfHand;


	@Override
	public void getACard(Card card) {
		Hand.add(card);
	}

	@Override
	public void printHand() {
		for(int i = 0; i < Hand.size() ; i++){
			System.out.print("| " + Hand.get(i).toString());
		}
		System.out.println();
	}

	@Override
	public Card GetCard(int temp) {
		return Hand.get(temp);
	}

	@Override
	public int handSize() { // not rly true handsize. but - 1. 
		return Hand.size()-1;
	}
	public String valueOfHandToString(){
		return String.valueOf(ValueOfHand);
	}
	public void increaseValueOfHand() { // adds incresec the handvalue. (should make a method to calc whole hands value)
		ValueOfHand += Hand.get(Hand.size()-1).toInt();
	}

	@Override
	public int valueOfhand() {
		return ValueOfHand;
		
	}

	@Override
	public void clearCollection() {
		Hand.clear();
		ValueOfHand= 0 ;
	}
	@Override
	public int latestCardToHandToInt() {
		return Hand.get(Hand.size()-1).toInt();
	}

	@Override
	public int aceDecreaseHandvalue() {
		return ValueOfHand-= 10;
	}
	
}
