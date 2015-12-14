

public class InputUtility {
	private static boolean aTriggered,dTriggered,jTriggered,lTriggered;
	



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




	public static boolean islTriggered() {
		return lTriggered;
	}




	public static void setlTriggered(boolean lTriggered) {
		InputUtility.lTriggered = lTriggered;
	}




	public InputUtility() {
		InputUtility.aTriggered = false;
		InputUtility.dTriggered = false;
		InputUtility.jTriggered = false;
		InputUtility.lTriggered = false;
	}

}
