import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class TeladoJogo {

	private JFrame frame;
	private JButton button;
	private JTextField textField;
	private JLabel label;
	private JLabel label_1;
	private JButton button_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeladoJogo window = new TeladoJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeladoJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Forca - by Danillo e Jessye");
		frame.setBounds(100, 100, 530, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		button = new JButton("Iniciar");
		button.setBackground(SystemColor.control);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(223, 199, 89, 23);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(89, 88, 68, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("Letra:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(29, 92, 66, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Dica:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(29, 57, 76, 24);
		frame.getContentPane().add(label_1);
		
		button_1 = new JButton("Enviar");
		button_1.setBackground(SystemColor.activeCaption);
		button_1.setEnabled(false);
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(176, 88, 89, 23);
		frame.getContentPane().add(button_1);
		
		label_2 = new JLabel("New label");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_2.setBounds(89, 63, 95, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Forca:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_3.setBounds(294, 45, 89, 17);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Palavra:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_4.setBounds(29, 134, 66, 14);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("New label");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_5.setBounds(105, 134, 95, 14);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("New label");
		label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/6.png")));
		label_6.setBounds(352, 57, 152, 158);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("No de tentativas:");
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_7.setBounds(294, 11, 132, 23);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("0");
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_8.setForeground(new Color(255, 0, 0));
		label_8.setBounds(438, 12, 66, 20);
		frame.getContentPane().add(label_8);
		
	}
}
