/**
 * @author Jirut Polohaul (5731017921) 
 * @version 3 Apr 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */
public class InputUtility {
	private static boolean aTriggered,dTriggered,jTriggered,kTriggered;
	



	public static boolean isaTriggered() {
		return aTriggered;
	}




	public static void setaTriggered(boolean aTriggered) {
		InputUtility.aTriggered = aTriggered;
	}




	public static boolean isdTriggered() {
		return dTriggered;
	}




	public static void setdTriggered(boolean dTriggered) {
		InputUtility.dTriggered = dTriggered;
	}




	public static boolean isjTriggered() {
		return jTriggered;
	}




	public static void setjTriggered(boolean jTriggered) {
		InputUtility.jTriggered = jTriggered;
	}




	public static boolean iskTriggered() {
		return kTriggered;
	}




	public static void setkTriggered(boolean kTriggered) {
		InputUtility.kTriggered = kTriggered;
	}




	public InputUtility() {
		InputUtility.aTriggered = false;
		InputUtility.dTriggered = false;
		InputUtility.jTriggered = false;
		InputUtility.kTriggered = false;
	}

}
