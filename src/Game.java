import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 
 */
public class Game {
	private Deck deck = new Deck();
	private Hand hand = new Hand();
	private Hand dealerHand = new Hand();
	
	public void startGame(){
		int choice, c;
		System.out.println("Hi and welcom to the game of BlackJack");
		while(true){
			System.out.println();
			System.out.println("Please make a choice in the panel write 1 , 2 or 3");
			System.out.println("***********************************************************");
			System.out.println("1. Rules of the game");
			System.out.println("2. Play the game");
			System.out.println("3. To exit");
			System.out.println("************************************************************");
			while(true){	// input for the user. catches if wrong input
				try{	
					Scanner scan = new Scanner(System.in);
					choice = scan.nextInt();
					if(choice <= 3 || choice >= 1 ){
						break;
					}
					
				}catch (InputMismatchException e){
					System.out.println("Wrong input write 1 , 2 or 3");
				}
			}
			switch(choice){
			case 1:
				System.out.println("The rules of Blackjack is verry simple.");
				System.out.println("Try to get 21 if you get 21 when dealer deals you get blackjack.");
				System.out.println("Aces can be worth 11 or 1 its all you choice.");
				System.out.println("Knights, Queens and Kings are worth 10");
				System.out.println("If you get over 21 your fat and automaticly looses.");
				System.out.println("**************************************************************");
				System.out.println();
				break;
			case 2:
					deck.makeDeck(); // makes 3 decks
					deck.shuffleDeck(); // shuffles the decks
					Deal();
					System.out.println();
					System.out.print("Your Hand "); hand.printHand();
					if(ifHandBlackJack(hand)==true || ifHandBlackJack(dealerHand)==true){ // checks if anyone has blackjack
						break;
					}
					System.out.println("*********************************************************");
					System.out.println("Its your turn write *1* to take a card or *2* to pass");
					while(true){
						while(true){	// input for the user. catches if wrong input
							try{
								Scanner scan2 = new Scanner(System.in);
								c = scan2.nextInt();
								if(c <= 2 || c >= 1 ){
									break;
								}
								
							}catch (InputMismatchException e){
								System.out.println("Wrong input write *1* to take a card or *2* to pass");
							}
						}
						switch(c){
						case 1:
							dealOneCard(hand); ifPlayerCardAce(hand);
							break;
						case 2: 
							System.out.println("You Have passed");
							break;
						}
						if(c ==2){// breaks whileloop
							break;
						}
						if( ifHandFat(hand) == true){ // if playerhand is fat.
							System.out.println("You went fat and lost Hahaha dumb Fuck");
							break;
						
						}
					}
					if(ifHandFat(hand)== false){	// if player hand is fat = false. dealer will get his turn
						System.out.println("**************************************");
						System.out.println("Dealers turn");
						while(true){
							if(dealerHand.valueOfhand() < 16){
								System.out.println("Dealer picks up a card");
								dealOneCard(dealerHand);
							}else if(ifHandFat(dealerHand)== true){
								System.out.println("Dealer went fat and you won!");
								break;
							}
							else{
								System.out.println("Dealer stays");
								break;
							}
						}
					}
					if(ifHandFat(hand)== false && ifHandFat(dealerHand) == false){ // if noone is fat. decide who won
						whoWon(dealerHand ,hand);
					}
					hand.clearCollection(); dealerHand.clearCollection(); deck.clearCollection(); // clears all CollectionsOfCards before nex round
					break;
			case 3:
				System.out.println("Good bye, have a nice day!");
				System.exit(0);
			}
		}
}
	public void whoWon(Hand dealer, Hand player){	// decides who won
		if(dealer.valueOfhand() >= player.valueOfhand()){
			System.out.println("Dealer Won with the hands total of " + dealer.valueOfHandToString());
			dealerHand.printHand();
		}
		else{
			System.out.println("Congratulations you won!!!!");
			System.out.print("With the hand of ");
			hand.printHand();
		}
	}
	
	public boolean ifHandBlackJack(Hand temp) {	// checks if hand is blackjack 
		if(temp.valueOfhand() == 21){
			System.out.println("BlackJack!!!");
			return true;
		}
		return false;
	}
	public boolean ifHandFat(Hand temp){	// checks if hand is fat
		if(temp.valueOfhand() > 21){
			return true;
		}
		return false;
	}

	public void dealOneCard(Hand temp){ // deals one card to a Hand of choice
		dealCard(temp);
		temp.valueOfhand();
		System.out.println("Draws a " + temp.GetCard(temp.handSize()).toString() +  " . Hands total: " + temp.valueOfHandToString());
		temp.printHand();
	}
	public void Deal(){	// deals the opening round.
		System.out.println("Dealer is dealing cards ");
		dealCard(hand); ifPlayerCardAce(hand);
		System.out.println("Your first card is " + hand.GetCard(0).toString());
		dealCard(dealerHand);
		System.out.println("Dealers first card is hidden");
		dealCard(hand); ifPlayerCardAce(hand);
		System.out.println("Your Secound card is " + hand.GetCard(1).toString());
		dealCard(dealerHand);
		System.out.println();
		System.out.println("Dealers secound card is " + dealerHand.GetCard(1).toString());
		System.out.println("--------------------------------------------");
		System.out.println("Total of your hand is now " + hand.valueOfHandToString());
	}
	
	public void dealCard(Hand temp) { // deals card to hand of choice and removes it from Deck
		temp.getACard(deck.GetCard(0));
		temp.increaseValueOfHand();
		deck.removeFirstCard();
	}
	public void ifPlayerCardAce(Hand temp){	// if the player gets a ace the player will get a choice off ace = 1 or 11
		int ace;
		if(temp.latestCardToHandToInt() == 11){
			System.out.println("You draw a ace. Write *1* to change ace to value of 1. Or write *2* and it will remain 11");
			while(true){	// input for the user. catches if wrong input
				try{
					Scanner scan = new Scanner(System.in);
					ace = scan.nextInt();
					if(ace <= 2 || ace >= 1 ){
						break;
					}
				}catch (InputMismatchException e){
					System.out.println("Write *1* to change ace to value of 1. Or write *2* and it will remain 11");
				}
			}
			if(ace==1){
				temp.aceDecreaseHandvalue();
			}
		}
	}
	

}
