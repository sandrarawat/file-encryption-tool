package ie.gmit.dip;
	//imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.awt.event.ActionEvent;

public class Runner {
	// Declare variables
	private final PolybiusSquareCypher cypher = new PolybiusSquareCypher();
	private JFrame frame_EncryptionDecryptionApplication;
	private JTextField textField_Output;
	private JTextField textField_Input;
	private JTextField textField_Keyword;
	private JLabel label;
	private JLabel lblKeyword;
	private JFileChooser fc = new JFileChooser();
	// Main method, frame runner
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Runner window = new Runner();
					window.frame_EncryptionDecryptionApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Runner() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame_EncryptionDecryptionApplication = new JFrame();
		frame_EncryptionDecryptionApplication.setTitle("File Encryption/Decryption Tool");
		frame_EncryptionDecryptionApplication.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame_EncryptionDecryptionApplication.setBounds(100, 100, 650, 300);
		frame_EncryptionDecryptionApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_EncryptionDecryptionApplication.getContentPane().setLayout(null);
		
		// Encrypt button
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.setToolTipText("Click this button to encrypt file");
		Image img1 = new ImageIcon(this.getClass().getResource("lock.png")).getImage();
		btnEncrypt.setIcon(new ImageIcon(img1));
		btnEncrypt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncrypt.setBounds(188, 185, 166, 66);
		frame_EncryptionDecryptionApplication.getContentPane().add(btnEncrypt);
		// ActionListener for Encrypt
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String encrypt = cypher.encrypt(Runner.readFile(textField_Input.getText()), textField_Keyword.getText());
					Runner.writeFile(textField_Output.getText(), encrypt);
					JOptionPane.showMessageDialog(frame_EncryptionDecryptionApplication, "Encryption was successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(frame_EncryptionDecryptionApplication, "Oops! Something went wrong. We could not encrypt that file", "Error Occured", JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
	
		
		
		// Decrypt button
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.setToolTipText("Click this button to decrypt file");
		Image img = new ImageIcon(this.getClass().getResource("unlock.png")).getImage();
		btnDecrypt.setIcon(new ImageIcon(img));
		btnDecrypt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDecrypt.setBounds(371, 185, 166, 66);
		frame_EncryptionDecryptionApplication.getContentPane().add(btnDecrypt);
		//ActionListerner for Decrypt
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String decrypt = cypher.decrypt(Runner.readFile(textField_Input.getText()), textField_Keyword.getText());
					Runner.writeFile(textField_Output.getText(), decrypt);
					JOptionPane.showMessageDialog(frame_EncryptionDecryptionApplication, "Decryption was successfull", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(frame_EncryptionDecryptionApplication, "Oops! Something went wrong. We could not decrypt that file", "Error Occured", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	
			
		// Textfield for Input path
		textField_Input = new JTextField();
		textField_Input.setBounds(371, 22, 220, 20);
		frame_EncryptionDecryptionApplication.getContentPane().add(textField_Input);
		textField_Input.setColumns(10);

		JButton btnInputPath = new JButton("Set Input File");
		btnInputPath.setToolTipText("Select and set input file location");
		btnInputPath.setBounds(204, 22, 150, 20);
		btnInputPath.addActionListener(new ActionListener() {
			
		// JFilechooser for input path
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = fc.showOpenDialog(frame_EncryptionDecryptionApplication);
				if (i == JFileChooser.APPROVE_OPTION) {
					textField_Input.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}	
		});
		frame_EncryptionDecryptionApplication.getContentPane().add(btnInputPath);
		
		
		// Textfield for output path
		textField_Output = new JTextField();
		textField_Output.setBounds(371, 53, 220, 20);
		frame_EncryptionDecryptionApplication.getContentPane().add(textField_Output);
		textField_Output.setColumns(10);
		
		JButton btnWriteOutput = new JButton("Set Output File");
		btnWriteOutput.setToolTipText("Create and set new output file location");
		btnWriteOutput.setBounds(204, 53, 150, 20);
		btnWriteOutput.addActionListener(new ActionListener() {
			
		// Filechooser for output path
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = fc.showSaveDialog(frame_EncryptionDecryptionApplication);
				if (i == JFileChooser.APPROVE_OPTION) {
					textField_Output.setText(fc.getSelectedFile().getAbsolutePath());
				}
			}
		});;	
		frame_EncryptionDecryptionApplication.getContentPane().add(btnWriteOutput);
		
	
		
		// Textfield for Keyword
		textField_Keyword = new JTextField();
		//textField_Keyword();
		textField_Keyword.setBounds(371, 84, 97, 20);
		frame_EncryptionDecryptionApplication.getContentPane().add(textField_Keyword);
		textField_Keyword.setColumns(10);
			
		lblKeyword = new JLabel("Enter keyword :");
		lblKeyword.setToolTipText("Matching keywords are needed for sucessful encryption/decryption");
		lblKeyword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKeyword.setBounds(267, 90, 104, 14);
		frame_EncryptionDecryptionApplication.getContentPane().add(lblKeyword);
		
		
		// Icon for Frame
		label = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("icon.png")).getImage();
		label.setIcon(new ImageIcon(img2));		
		label.setBounds(28, 22, 128, 143);
		frame_EncryptionDecryptionApplication.getContentPane().add(label);
		
	}

	
	
	
/*	private String textField_Keyword() {
		// TODO Auto-generated method stub
		return null;
	}*/

	  private static String readFile(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	  }

	  private static void writeFile(String path, String content) throws IOException {
	    Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE);
	  }
}
	

/* References :
https://docs.oracle.com/javase/7/docs/api/java/awt/EventQueue.html 
https://stackoverflow.com/questions/3018165/why-do-people-run-java-guis-on-the-event-queue
https://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.wb.swing.doc.user%2Fhtml%2Fwizards%2Fswing%2Fjframe.html
https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#FileChooserDemo2
http://www.java2s.com/Tutorial/Java/0240__Swing/UsingaJFileChooserinYourJFrame.htm
https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
http://www.java2s.com/Code/JavaAPI/javax.swing/JFramesetVisiblebooleanvisible.htm
https://www.codejava.net/java-core/the-java-language/implements-keyword
https://docs.oracle.com/javase/7/docs/api/javax/accessibility/Accessible.html
https://www.youtube.com/user/ProgrammingKnowledge/videos
https://www.youtube.com/watch?v=tFwp589MAFk&t=25s (Java Eclipse GUI Tutorial 7 # Add image, pictures and icons in JFrame)
https://www.mkyong.com/java/java-files-readallbytes-example/
https://docs.oracle.com/javase/tutorial/essential/io/file.html
https://docs.oracle.com/javase/7/docs/api/java/nio/file/StandardOpenOption.html
https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java/33808856
*/