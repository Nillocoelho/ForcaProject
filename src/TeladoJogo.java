import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;

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
	private JogoDaForca jogo;
	private int contador;
	private int contagem;
	private JLabel label_9;
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
		ArrayList<String> letras = new ArrayList<>();
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
				contador++;
				try {
					jogo = new JogoDaForca();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				jogo.iniciar();
				label_2.setText("<html>"+jogo.getDica()+"<html>");
				label_5.setText(jogo.getPalavraAdivinhada());
				label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/6.png")));
				label_8.setText("0");
				contagem = 0;
				button_1.setEnabled(true);
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
				if (contador > 0) {
						String texto = textField.getText();
						if (texto.length() == 1) {
							letras.add(texto);
								try {
									ArrayList<Integer> ocorrencias = jogo.getOcorrencias(texto);
									if (!ocorrencias.isEmpty()) {
										label_9.setText("voce acertou a letra =" + " " + texto);
										label_5.setText(jogo.getPalavraAdivinhada());
									}
									else {
										contagem++;
										label_9.setText("voce errou a letra = " +  " " + texto);
										label_8.setText("" + contagem);
										switch (contagem) {
										case 1:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/5.png")));
											break;
										case 2:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/4.png")));
											break;
										case 3:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/3.png")));
											break;
										case 4:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/2.png")));
											break;
										case 5:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/1.png")));
											break;
										case 6:
											label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/0.png")));
											JOptionPane.showMessageDialog(null, "Fim de jogo", "Alerta", JOptionPane.WARNING_MESSAGE);
											label_5.setText(jogo.getPalavra());
											button_1.setEnabled(false);
											break;
										}
									}
								} catch (Exception ex) {
									JOptionPane.showMessageDialog(null, "Você já adicionou essa letra antes", "Alerta", JOptionPane.WARNING_MESSAGE);
								}
						}
					else {
						JOptionPane.showMessageDialog(null, "Você adicionou mais de uma letra", "Alerta", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Você não iniciou um jogo!", "Alerta", JOptionPane.WARNING_MESSAGE);
				}
		}
		});

		button_1.setBounds(176, 88, 89, 23);
		frame.getContentPane().add(button_1);

		label_2 = new JLabel();
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_2.setBounds(78, 23, 195, 66);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("Forca:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_3.setBounds(294, 45, 89, 17);
		frame.getContentPane().add(label_3);

		label_4 = new JLabel("Palavra:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_4.setBounds(29, 134, 66, 14);
		frame.getContentPane().add(label_4);

		label_5 = new JLabel("");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_5.setBounds(105, 122, 160, 35);
		frame.getContentPane().add(label_5);

		label_6 = new JLabel("Boneco");
		label_6.setIcon(new ImageIcon(TeladoJogo.class.getResource("/imagens/0.png")));
		label_6.setBounds(352, 57, 152, 158);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("No de tentativas:");
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_7.setBounds(294, 11, 132, 23);
		frame.getContentPane().add(label_7);

		label_8 = new JLabel("Null");
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_8.setForeground(new Color(255, 0, 0));
		label_8.setBounds(438, 12, 66, 20);
		frame.getContentPane().add(label_8);

		label_9 = new JLabel("");
		label_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_9.setBounds(29, 159, 208, 29);
		frame.getContentPane().add(label_9);

}
}
