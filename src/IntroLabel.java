import java.awt.Font;

import javax.swing.JLabel;

public class IntroLabel extends JLabel{
	public IntroLabel(String Text, int posy) {
		Font f = new Font("Arial", Font.PLAIN, 16);
		this.setFont(f);
		this.setText(Text);
		this.setBounds(15, posy, 680, 30);
		this.setHorizontalAlignment(CENTER);
	}
}
