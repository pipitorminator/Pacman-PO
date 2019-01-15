package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;

public class IniciarJogador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public IniciarJogador() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNome.setForeground(Color.ORANGE);
		lblNome.setBounds(122, 13, 46, 14);
		contentPane.add(lblNome);

		textField = new JTextField();
		textField.setBounds(124, 38, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fachada.getInstance().novojogador(textField.getText());
				if (Fachada.getInstance().getPlayer().getNome() == "404") {
					textField.setText("Invalido1");
				} else {
					Game jogo = new Game();
					jogo.setVisible(true);
					jogo.play(jogo);
					setVisible(false);
				}

			}
		});
		btnOk.setBounds(37, 74, 89, 23);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(163, 74, 89, 23);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(IniciarJogador.class.getResource("/GUI/Imagens/fundojogador.jpg")));
		lblNewLabel.setBounds(-44, -33, 379, 163);
		contentPane.add(lblNewLabel);
	}
}
