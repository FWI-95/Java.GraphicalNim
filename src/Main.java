import java.util.Scanner;

public class Main {
	static Frame frame;
	static WelcomeFrame welcomeframe;
	
	static int Woods;
	static String KI;
	static String Player;
	static int AmZug;
	static int Taken;
	
	public static void main(String[] args) {
		
		welcomeframe = new WelcomeFrame();
		
		welcomeframe.setVisible(true);

	}

	
	public static void StartGame(String Playername) {
		if(Playername.equals("")) {
			Playername = "Player";
		}
		Player = Playername;
		frame = new Frame(Playername);
		frame.setVisible(true);
		welcomeframe.setVisible(false);
	}
}
 