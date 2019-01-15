package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import negocio.Jogador;

public class HighScore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HighScore() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// System.out.println(Fachada.getInstance().getJogadores().getPlayers()[1].getNome());
		// if(Fachada.getInstance().getJogadores().getPlayers().length )
		quickSort(Fachada.getInstance().getJogadores().getPlayers(), 0,
				Fachada.getInstance().getJogadores().getIndice() - 1);
		setBounds(100, 100, 379, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel lugar1 = new JLabel("");
		lugar1.setForeground(Color.YELLOW);
		lugar1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar1.setBounds(89, 97, 199, 35);

		contentPane.add(lugar1);

		JLabel lugar2 = new JLabel("");
		lugar2.setForeground(Color.LIGHT_GRAY);
		lugar2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar2.setBounds(89, 143, 199, 35);
		contentPane.add(lugar2);

		JLabel lugar3 = new JLabel("");
		lugar3.setForeground(new Color(139, 69, 19));
		lugar3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar3.setBounds(89, 189, 199, 35);
		contentPane.add(lugar3);

		JLabel lugar4 = new JLabel("");
		lugar4.setForeground(Color.WHITE);
		lugar4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar4.setBounds(89, 235, 199, 35);
		contentPane.add(lugar4);

		JLabel lugar5 = new JLabel("");
		lugar5.setForeground(Color.WHITE);
		lugar5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar5.setBounds(89, 281, 199, 35);
		contentPane.add(lugar5);

		JLabel lugar6 = new JLabel("");
		lugar6.setForeground(Color.WHITE);
		lugar6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar6.setBounds(89, 327, 199, 35);
		contentPane.add(lugar6);

		JLabel lugar7 = new JLabel("");
		lugar7.setForeground(Color.WHITE);
		lugar7.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar7.setBounds(89, 373, 199, 35);
		contentPane.add(lugar7);

		JLabel lugar8 = new JLabel("");
		lugar8.setForeground(Color.WHITE);
		lugar8.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar8.setBounds(89, 419, 199, 35);
		contentPane.add(lugar8);

		JLabel lugar9 = new JLabel("");
		lugar9.setForeground(Color.WHITE);
		lugar9.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar9.setBounds(89, 465, 199, 35);
		contentPane.add(lugar9);

		JLabel lugar10 = new JLabel("");
		lugar10.setForeground(Color.WHITE);
		lugar10.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lugar10.setBounds(84, 511, 199, 35);
		contentPane.add(lugar10);

		JLabel label = new JLabel("1\u00BA");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(51, 97, 46, 35);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("2\u00BA");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(51, 143, 46, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("3\u00BA");
		lblNewLabel_1.setForeground(new Color(139, 69, 19));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(51, 189, 46, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("4\u00BA");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(51, 235, 46, 35);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("5\u00BA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(51, 281, 46, 35);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("6\u00BA");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(51, 327, 46, 35);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("7\u00BA");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(51, 373, 46, 35);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("8\u00BA");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_6.setBounds(51, 419, 46, 35);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("9\u00BA");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_7.setBounds(51, 465, 46, 35);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("10\u00BA");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_8.setBounds(51, 511, 46, 35);
		contentPane.add(lblNewLabel_8);

		JLabel highscoretext = new JLabel("HighScore");
		highscoretext.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		highscoretext.setForeground(Color.RED);
		highscoretext.setBounds(89, 11, 194, 75);
		contentPane.add(highscoretext);

		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(HighScore.class.getResource("/GUI/Imagens/fundoHS.jpg")));
		fundo.setBounds(0, 0, 403, 595);
		contentPane.add(fundo);

		if (Fachada.getInstance().getJogadores().getIndice() > 0) {
			lugar1.setText(Fachada.getInstance().getJogadores().getPlayers()[0].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 1) {
			lugar2.setText(Fachada.getInstance().getJogadores().getPlayers()[1].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 2) {
			lugar3.setText(Fachada.getInstance().getJogadores().getPlayers()[2].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 3) {
			lugar4.setText(Fachada.getInstance().getJogadores().getPlayers()[3].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 4) {
			lugar5.setText(Fachada.getInstance().getJogadores().getPlayers()[4].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 5) {
			lugar6.setText(Fachada.getInstance().getJogadores().getPlayers()[5].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 6) {
			lugar7.setText(Fachada.getInstance().getJogadores().getPlayers()[6].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 7) {
			lugar8.setText(Fachada.getInstance().getJogadores().getPlayers()[7].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 8) {
			lugar9.setText(Fachada.getInstance().getJogadores().getPlayers()[8].toStringnome());
		}
		if (Fachada.getInstance().getJogadores().getIndice() > 9) {
			lugar10.setText(Fachada.getInstance().getJogadores().getPlayers()[9].toStringnome());
		}
	}

	// quicksort

	private void quickSort(Jogador[] jogadors, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(jogadors, inicio, fim);
			quickSort(jogadors, inicio, posicaoPivo - 1);
			quickSort(jogadors, posicaoPivo + 1, fim);
		}
	}

	private int separar(Jogador[] jogadors, int inicio, int fim) {
		Jogador pivo = jogadors[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (jogadors[i].getScore() >= pivo.getScore())
				i++;
			else if (pivo.getScore() > jogadors[f].getScore())
				f--;
			else {
				Jogador troca = jogadors[i];
				jogadors[i] = jogadors[f];
				jogadors[f] = troca;
				i++;
				f--;
			}
		}
		jogadors[inicio] = jogadors[f];
		jogadors[f] = pivo;
		return f;
	}

}
