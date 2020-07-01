
public class PlayerTester {

	public static void main(String[] args) {
		Player player1 = new Player("Ron");
		
		//Testing all methods
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n","Testing rollDice, getRolls, getPoints, getName, getTurns and track methods","Expected:",
				" getName - Name of player",
				" getPoints - Points scored| 0 when a 1 is rolled",
				" getRolls - 10 random numbers between 1 & 6 (face value of dice)",
				" getTurns - Number of times rolled|reset when a 1 is rolled",
				" track - break down of all information");
		
		System.out.printf("%s%n%s%15s%15s%15s%15s%n","RESULT:","getName()","getPoints()","getRolls()","getTurns()","track()" );
		for(int i = 0; i < 10; i++) {
			
			player1.rollDice();// rolling dice
			
			System.out.printf( "%3s%13s",player1.getName()," ");
			System.out.printf("%-5d%10s",player1.getPoints(), " ");
			System.out.printf("%-5d%10s",player1.getRolls(), " ");
			System.out.printf("%-5d%5s",player1.getTurns(), " ");
			System.out.printf("%-10s%n",player1.track());
		}
		
		
		//Testing hold
		System.out.printf("%n%s%n","Testing endTurn method Expecting: True when value entered is 5");
		System.out.println("RESULT: " + player1.endTurn(4));
		
	}

}
