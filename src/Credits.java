import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;

public class Credits extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton button[] = new JButton[6];
	JLabel label[] = new JLabel[2];
	String labels[] = {"Credits", "<html>&copy;2023 SOUL_AYU </html>"}, buttonlabel[] = {"github.com/prasad5793/gmailphishing", "github.com/AvishkaRJ/Phishing-Attack-smaple", "github.com/opandao-oo/oPANDAoPhishing", " github.com/evildevill/EmptyPhish", "github.com/princekrvert/Ravana", "GitHub"};
	
	Credits(){
		for(int i=0; i<6; i++) {
				button[i] = new JButton(buttonlabel[i]);
				button[i].setForeground(Color.BLUE);
				button[i].setBackground(new Color(238, 238, 238));
				button[i].setBorder(null);
				button[i].setFont(new Font("MV Boli", Font.PLAIN, 13));
				button[i].setFocusable(false);
				button[i].setVisible(true);
				button[i].addActionListener(this);
				this.add(button[i]);
			
				if(i<2) {
					label[i] = new JLabel(labels[i]);
					label[i].setFont(new Font("Ink Free", Font.BOLD, 25));
					this.add(label[i]);
				}
		}
		
		label[0].setBounds(140, 10, 150, 25);
		label[0].setForeground(Color.red);
		button[0].setBounds(10, 60, 250, 25);
		button[1].setBounds(10, 80, 300, 25);
		button[2].setBounds(10, 100, 275, 25);
		button[3].setBounds(10, 120, 210, 25);
		button[4].setBounds(10, 140, 210, 25);
		label[1].setFont(new Font("Ink Free", Font.BOLD, 15));
		label[1].setForeground(Color.red);
		label[1].setBounds(110, 170, 150, 30);
		button[5].setBounds(110, 195, 150, 20);
		
		this.setTitle("Credits");
		this.setIconImage(new ImageIcon(getClass().getResource("/icons/icon.jpg")).getImage());
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(new Dimension(380,  270));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		           Fisherman.credit = null;
		    }
		};
		this.addWindowListener(exitListener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[0]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/prasad5793/gmailphishing"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[1]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/AvishkaRJ/Phishing-Attack-smaple"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[2]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/opandao-oo/oPANDAoPhishing"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[3]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/evildevill/EmptyPhish"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[4]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/princekrvert/Ravana"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button[5]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/DeadSOUL-Studios/"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}