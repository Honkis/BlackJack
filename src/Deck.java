
import java.util.Collections;
import java.util.Vector;

/*
 * The deck class that contains 3 decks.
 */
public class Deck extends CollectionOfCards {
	private Vector<Card> Deck = new Vector<Card>();
	
	public void makeDeck(){
		String[] colourx = {"Hearth","Spade","Clubs", "Diamond"};
		String[] valuex = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Knight","Queen","King"};
		for(int i = 0; i <=2; ++i){
			for(int c = 0; c <= 3 ; ++c){	// creates 3 52 cards deck
				for(int v = 0; v <= 12 ; ++v){	// makes 12 card of each colour
					if(v+1 == 11 || v+1== 12 || v+1 == 13){	// makes the King knight and queen gets value of 10
						Deck.add(new Card(valuex[v],colourx[c], 10));
					}else if (v+1 == 1){	// makes aces value to 11
						Deck.add(new Card(valuex[v] , colourx[c], 11));
					}else{
						Deck.add(new Card(valuex[v] , colourx[c], v+1));
					}
				}
			}
		}
	}
	
	protected void shuffleDeck(){ 
		Collections.shuffle(Deck);
	}
	public void pickACard(int p){	// isnt used for this programm
		System.out.println(Deck.get(p));
	}
	public Card GetCard(int temp){
		return Deck.get(temp);
	}
	public void removeFirstCard(){ 
		Deck.remove(0);
	}

	@Override	
	public void clearCollection() {
		Deck.clear();
		
	}
	
}
