
public class DieTester {

	public static void main (String[] args) {

		Die dieRoll = new Die();  
		
		System.out.println("Die test run");
		System.out.println("Test 1: Test constructor using toString");
		System.out.println(dieRoll.toString());
		
		System.out.println("\nTest 2: Test getFaceValue");
		System.out.println("Inspecting Die face");
		System.out.println(dieRoll.getFaceValue());
		
		System.out.println("\nTest 3: Test throwDie");
		System.out.println("Value is being thrown");
		for(int i = 0; i < 10; i++) {
			dieRoll.throwDie();
			System.out.print(dieRoll.getFaceValue() + " ");
		}
		System.out.println("\nTest finished");
		
	}
	
}
