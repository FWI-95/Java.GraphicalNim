import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomeFrame extends JFrame implements ActionListener{
	static GridLayout gl;
	static JPanel MainPanel;
	
	static JTextField PlayerTextField;
	static JButton StartButton;
	
	static JLabel lblWelcome;
	static IntroLabel lblIntro1;
	static IntroLabel lblIntro2;
	static IntroLabel lblIntro3;
	static IntroLabel lblIntro4;
	static IntroLabel lblIntro5;
	static IntroLabel lblIntro6;
	
	static Font fntWelcome;
	static Font fntIntro;
	
	public WelcomeFrame() {
		this.setSize(700,500);
		this.setTitle("Dr. Nim");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		MainPanel = new JPanel();
		
		fntWelcome = new Font("Arial", Font.BOLD, 24);
		fntIntro = new Font("Arial", Font.PLAIN, 16);
		
		lblWelcome = new JLabel("Willkommen");
		lblWelcome.setFont(fntWelcome);
		lblWelcome.setBounds(15, 10, 680, 50);
		lblWelcome.setHorizontalAlignment(JLabel.CENTER);
		
		lblIntro1 = new IntroLabel("Dies ist das Nim Spiel", 70);
		lblIntro2 = new IntroLabel("Regeln:", 150);
		lblIntro3 = new IntroLabel("Abwechselnd zeht der Spieler und der Computer 1, 2 oder 3 Hölzer", 190);
		lblIntro4 = new IntroLabel("Gestartet wird mit 21 Hölzern", 230);
		lblIntro5 = new IntroLabel("Wer das letzte ziehen muss, hat verloren", 270);
		lblIntro6 = new IntroLabel("Wie lautet dein Name?", 350);
		
		PlayerTextField = new JTextField("");
		PlayerTextField.setBounds(15, 400, 500, 50);
		
		StartButton = new JButton("Start");
		StartButton.addActionListener(this);
		StartButton.setBounds(510, 400, 150, 50);
		
		MainPanel.setLayout(null);
		
		MainPanel.add(lblWelcome);
		MainPanel.add(lblIntro1);
		MainPanel.add(lblIntro2);
		MainPanel.add(lblIntro3);
		MainPanel.add(lblIntro4);
		MainPanel.add(lblIntro5);
		MainPanel.add(lblIntro6);
		
		MainPanel.add(PlayerTextField);
		MainPanel.add(StartButton);
		
		this.getContentPane().add(MainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== StartButton) {
			if(PlayerTextField.getText().equals("")) {
				Main.StartGame("Spieler");
			}else {
				Main.StartGame(PlayerTextField.getText());
			}
		}
		
	}
	
}
