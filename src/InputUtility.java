/**
 * @author Jirut Polohaul (5731017921) 
 * @version 3 Apr 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */
public class InputUtility {
	private static boolean spaceTriggered;
	private static boolean spacePressed;

	public static boolean getSpaceTriggered() {
		return spaceTriggered;
	}

	public static void setSpaceTriggered(boolean spaceTriggered) {
		InputUtility.spaceTriggered = spaceTriggered;
	}

	public static boolean getSpacePressed() {
		return spacePressed;
	}

	public static void setSpacePressed(boolean spacePressed) {
		InputUtility.spacePressed = spacePressed;
	}

	public InputUtility() {
		InputUtility.spacePressed = false;
		InputUtility.spaceTriggered = false;
	}

}
