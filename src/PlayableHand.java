
public interface PlayableHand { // makes the Hand playeble instead of an vector that only countins Card objects
	
	public int valueOfhand();
	public void getACard(Card card);
	public void printHand();
	public int handSize();
	public int latestCardToHandToInt();
	public int aceDecreaseHandvalue();

}
