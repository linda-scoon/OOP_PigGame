/**
 * This program prompts the user to roll a dice and simulates the game of pig
 * 
 * METHODS
 * begin()
 * play()
 * gameOver()
 * 
 * @author lns18qlr
 *
 */

import java.util.Scanner;
public class Pig {
	
	/**
	 *  Due to the dependence of scanner through out the programme, I have made it static
	 *  removing this will break everything
	 */
	static Scanner in = new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		boolean gameOver = false;
				
//			Game instructions	
			System.out.println("\nHOW TO PLAY");
			System.out.print("On each turn, a player rolls the die repeatedly until either:\r\n" + 
					"• A one is rolled\r\n" + 
					"• The player chooses to endTurn (stop rolling)\r\n" + 
					"If a one is rolled, that player's turn ends and no points are earned.\r\n" + 
					"If the player chooses to endTurn, all of the points rolled during that turn are added to his or her score.\n" +
					"******************************************************************************************************\n");
			
//			Creating and assigning Names to players
			System.out.print("\nName the first player: ");
					String name1 = in.next();
					Player firstPlayer = new Player(name1);	
			
			
			System.out.print("Name the second player: ");
					String name2 = in.next();
					Player secondPlayer = new Player(name2);	
			
			while(gameOver == false) {	
				
				boolean go = false;
				
//				running game for first player
				if(go == false && gameOver == false) {
					
					System.out.print("\n" + name1 + " It is your turn\nplease press \"R\" to Roll the Dice\n");
					begin(firstPlayer);
					gameOver = gameOver(firstPlayer);
					go = true;
				}
				
//				running game for second player
				if(go == true && gameOver == false) {
						System.out.print("\n" + name2 + " It is your turn\nplease press \"R\" to Roll the Dice\n");
						begin(secondPlayer);
						gameOver = gameOver(secondPlayer);
						go = false;
				}
			}
//			closing scanner
			in.close();
	}
	
	/**
	 * This method prompts user to begin game and calls the play method
	 * @param current
	 */
	public static void begin(Player current) {
		
		String run;
		
//		Checking that player presses R to begin the game
		if(in.hasNext("R")){
			run = in.next("R");
			System.out.print(run + "olling Dice...");
			play(current);	
		}else {
			
			String err = in.next();
			System.out.println("You pressed " + err + ". Since you can't follow instuctions, you miss your turn");
		}
	}
		
	/**
	 * This method simulates the game
	 * @param Player current
	 */
	public static void play(Player current) {
		
		int endTurn = 0;
		boolean gameOver = false;
		
//		Checking that player is not on endTurn
		while (current.endTurn(endTurn) != true) {

//			rolling the dice and displaying the result
			current.rollDice();
			System.out.println(current.track()); 

//			ending game if the roll exceeds 100 points
			if(current.getPoints() >= 100) {
				System.out.print("Welldone " + current.getName() + ". You've won");
				gameOver = true;
				endTurn = 5;
			}
			
//			Checking that players have less than 100 points and that they haven't rolled a 1. If they have endTurn			
			if(current.getRolls() != 1 && gameOver == false) {
				
				System.out.println("Press 5 to HOLD or enter \"R\" to roll again");
				
//				Checking that player presses R to begin the game
					if(in.hasNextInt()) {
						endTurn = in.nextInt();
						if(endTurn == 5) {
							System.out.println(current.getName() + " you are on HOLD. You currently have " + current.getPoints() + " points\n");
						}else {						
							System.out.println("You pressed " + endTurn + ". You can't follow instuctions, you have to go on endTurn");
							endTurn = 5;
						}					
						
					}else if(in.hasNext("R")){
						String run = in.next("R");
						System.out.println(run + "olling Dice.....");
							
					}else {
						String err = in.next();
						System.out.println("You pressed " + err + ". You can't follow instuctions, go on and think about what you've done");
						endTurn = 5;
					}
			}else {
				endTurn = 5;
			}
		}	
	}
	
	/**
	 * This method checks if the players points are => 100
	 * If they are it ends the game
	 * @param current
	 * @return boolean gameOver
	 */
	public static boolean gameOver(Player current) {
		
		boolean gameOver = false;
		if(current.getPoints() >= 100) {
			gameOver = true;
		}
		return gameOver;
	}
}
