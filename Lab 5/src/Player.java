
/**
 * Players of the die game
 * 
 * METHODS
 * rollDice()
 * track()
 * getPoints()
 * getName()
 * getRolls()
 * getTurns()
 * endTurn()
 * 
 * @author lns18qlr
 *
 */
public class Player {

	private int points;
	private int roll;
	private int turns;
	private boolean endTurn;
	private int penalty = 1;
	private String name; 
	
		
	/**
	 * Player constructor
	 * The player states how many turns they want to roll the die for 
	 * @param turns
	 */
		public Player(String name){
			this.name = name;
			points = 0;// initial points a player has
		}
		
	/**
	 * This method rolls the die
	 * @return integer roll
	 */ 
	public void rollDice() {
		
		Die dice = new Die();
		dice.throwDie();
		roll = dice.getFaceValue();
					
			if(roll != penalty) {
				endTurn = false;
				points += roll;
				
			}else {
				endTurn = true;
				points = 0;
			}	
			turns++;
	}
		
	/**
	 * tracks turns and points
	 * @return String msg
	 */
	public String track() {
		
		String msg;
		
		if(endTurn == true) {
			 msg = getName() + " [Die Face= " + getRolls() + " | Rolls= " + getTurns() +  " | Points= " + getPoints() + ". End of turn]";
			 turns = 0;
		}else {
			msg = getName() + " [Die Face= " + getRolls() + " | Rolls= " + getTurns() +  " | Points= " + getPoints() + "]";
		}
		return msg;
	}
	
	/**
	 * 
	 * @return points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * 	
	 * @return integer roll
	 */
	public int getRolls() {
		return roll;
	}
	
	/**
	 * 
	 * @return integer turns
	 */
	public int getTurns() {
		return turns;
	}
	
	/**
	 * 
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return String of turn endTurn
	 */
	public boolean endTurn(int end) {
		boolean endTurn = false;
		if(end != 5) {
			endTurn = false;
		}else {
			endTurn = true;
		}			
		return endTurn;
	}
}
