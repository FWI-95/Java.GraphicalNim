import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{

	
	static int Woods;
	static String KI;
	static String Player;
	static int AmZug;
	static int Taken;
	
	static JButton one;
	static JButton two;
	static JButton three;
	
	static JLabel lblWoods;
	static JLabel lblKITakes;
	
	static Font fWoods;
	static Font fKITakes;
	
	static boolean GameOver;
	
	static JPanel MainPanel;
	
	public Frame(String Playername) {
		this.setSize(700,500);
		this.setTitle("Dr. Nim");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Player = Playername;
		KI = "Computer";
				
		GameOver = false;
		
		Woods = 21;
		
		fWoods = new Font("Arial", Font.BOLD, 32);
		fKITakes = new Font("Arial", Font.PLAIN, 18);
		
		lblWoods = new JLabel("" + Woods);
		lblWoods.setHorizontalAlignment(JLabel.CENTER);
		lblWoods.setVerticalAlignment(JLabel.CENTER);
		lblWoods.setFont(fWoods);
		lblWoods.setBounds(10,10,this.getWidth()-20, 150);
		
		lblKITakes = new JLabel("");
		lblKITakes.setHorizontalAlignment(JLabel.CENTER);
		lblKITakes.setVerticalAlignment(JLabel.CENTER);
		lblKITakes.setFont(fKITakes);
		lblKITakes.setBounds(10, lblWoods.getBounds().y + lblWoods.getBounds().height+10, this.getWidth()-20, 50);
		
		one = new JButton("1");
		one.setBounds(10, this.getHeight()-100, (this.getWidth()-50)/3, 50);
		one.addActionListener(this);
		
		two = new JButton("2");
		two.setBounds(one.getBounds().x + one.getBounds().width + 10, one.getBounds().y, (this.getWidth()-50)/3, 50);
		two.addActionListener(this);
		
		
		three = new JButton("3");
		three.setBounds(two.getBounds().x + two.getBounds().width + 10, one.getBounds().y, (this.getWidth()-50)/3, 50);
		three.addActionListener(this);
		
		MainPanel = new JPanel();
		MainPanel.setLayout(null);
		
		MainPanel.add(lblWoods);
		MainPanel.add(lblKITakes);
		MainPanel.add(one);
		MainPanel.add(two);
		MainPanel.add(three);
		
		this.getContentPane().add(MainPanel);
		
		if(Player.equalsIgnoreCase("Chuck Norris")) {
			End(0);
		}
	}
	
	private void Take(int totake) {
		System.out.println(totake + " totake");
		
		Woods -= totake;
		
		if(Woods == 1) {
			End(0);
		}else if (Woods < 1) {
			End(1);
		}
		
		System.out.println(Woods + " nach Playerabzug");
		
		int tmpTake = GetToTake(Woods);
		
		System.out.println(tmpTake + " tmptake");
		
		Woods -= tmpTake;
		
		lblKITakes.setText(KI + " nimmt " + tmpTake);
		
		System.out.println(Woods + " nach KI abzug");
		
		if(Woods == 1) {
			End(1);
		}else if (Woods < 1) {
			End(0);
		}
		
		lblWoods.setText("" + Woods);
		
	}
	
	private static int GetToTake(int Left) {
		int Differenz;
		int Counter = Left-1;
		
		while((Counter % 4)!= 0) {
			Counter -= 1;
		}
		
		Differenz = (Left - Counter) - 1;
		
		if((Differenz < 4) && (Differenz > 0)) {
			return Differenz;
		}else if( Differenz > 0){
			return 1;
		}else if(Differenz < 4) {
			return 3;
		}
		return 1;
	}
	
	private void End(int WhoLost) {
		if(WhoLost == 1){
			lblKITakes.setText(KI + " hat " + Player + " besiegt!");
		}else {
			lblKITakes.setText(Player + " hat " + KI + " besiegt!");
		}
		
		one.setEnabled(false);
		two.setEnabled(false);
		three.setText("Beenden");
		GameOver = true;
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== one)Take(1);
		if(ae.getSource()== two)Take(2);
		if(ae.getSource()== three) {
			if(GameOver) {
				System.exit(0);
			}else {
				Take(3);
			}
		}
		this.repaint();
	}
}




//2