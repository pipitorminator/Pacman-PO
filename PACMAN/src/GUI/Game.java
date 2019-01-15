package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Fachada;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends JFrame implements Runnable {

	/**
	 * 	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon pac1 = new ImageIcon(Game.class.getResource("/GUI/Imagens/pac1.png"));
	ImageIcon pac2 = new ImageIcon(Game.class.getResource("/GUI/Imagens/pac2.png"));
	ImageIcon pac3 = new ImageIcon(Game.class.getResource("/GUI/Imagens/pac3.png"));
	ImageIcon pac4 = new ImageIcon(Game.class.getResource("/GUI/Imagens/pac4.png"));
	ImageIcon pac5 = new ImageIcon(Game.class.getResource("/GUI/Imagens/pac5.png"));
	ImageIcon ponto = new ImageIcon(Game.class.getResource("/GUI/Imagens/ponto.png"));
	ImageIcon pilula = new ImageIcon(Game.class.getResource("/GUI/Imagens/pilula.png"));
	ImageIcon fant1 = new ImageIcon(Game.class.getResource("/GUI/Imagens/red.png"));
	ImageIcon fant2 = new ImageIcon(Game.class.getResource("/GUI/Imagens/Blue.png"));
	ImageIcon fant3 = new ImageIcon(Game.class.getResource("/GUI/Imagens/Pinky.png"));
	ImageIcon fantmedo = new ImageIcon(Game.class.getResource("/GUI/Imagens/fantmedo.jpg"));

	JLabel pontos[][] = new JLabel[31][28];
	JLabel red = new JLabel(fant1);
	JLabel blue = new JLabel(fant2);
	JLabel pinky = new JLabel(fant3);
	JLabel pac = new JLabel(pac1);
	private final JLabel lblScore = new JLabel("SCORE");
	private JLabel score = new JLabel(Fachada.getInstance().getPlayer().toString());
	private final JLabel nome = new JLabel(Fachada.getInstance().getPlayer().getNome());

	private boolean mapavazio;

	public void play(Game jogo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					keyevent();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		playBegin("pacman_beginning");
		GameUpdate musica = new GameUpdate();
		musica.start();
		Fachada.getInstance().getJogo().start();

		Thread update = new Thread(jogo);
		update.start();
	}

	public void run() {
		while (Fachada.getInstance().getPac().getVida() != 0) {
			mapavazio = true;

			for (int i = 0; i < 28; i++) {
				for (int j = 0; j < 31; j++) {
					if (Fachada.getInstance().getPac().isInvulneravel()) {
						red.setIcon(fantmedo);
						blue.setIcon(fantmedo);
						pinky.setIcon(fantmedo);
					} else {
						red.setIcon(fant1);
						blue.setIcon(fant2);
						pinky.setIcon(fant3);
					}
					if (Fachada.getInstance().getFant()[0].getPosicaoX() == i
							&& Fachada.getInstance().getFant()[0].getPosicaoY() == j) {

						red.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					}
					if (Fachada.getInstance().getFant()[1].getPosicaoX() == i
							&& Fachada.getInstance().getFant()[1].getPosicaoY() == j) {
						blue.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					}
					if (Fachada.getInstance().getFant()[2].getPosicaoX() == i
							&& Fachada.getInstance().getFant()[2].getPosicaoY() == j) {
						pinky.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					}
					if (Fachada.getInstance().getPac().getPosiçãoX() == i
							&& Fachada.getInstance().getPac().getPosiçãoY() == j) {
						mudar();
						pac.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					}

					switch (Fachada.getInstance().getMapa().getPontos()[j][i]) {
					case 'o':

						pontos[j][i].setIcon(ponto);
						mapavazio = false;
						break;
					case '-':
						pontos[j][i].setIcon(pilula);
						break;
					case ' ':
						pontos[j][i].setBounds(0, 0, 0, 0);
						break;
					default:
						break;
					}
					Fachada.getInstance().getPlayer().pontos(Fachada.getInstance().getMapa());
					score.setText(Fachada.getInstance().getPlayer().toString());

				}
			}
			if (mapavazio) {
				Fachada.getInstance().getPac().setVida(0);
				Fachada.getInstance().getJogo().interrupt();

			}

		}
		Fachada.getInstance().inserir(Fachada.getInstance().getPlayer());
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.getInstance().getPac().setVida(0);
				Fachada.getInstance().getJogo().interrupt();

			}
		});
		Fachada.getInstance().procurarmapa(1);

		setTitle("Pacman");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		nome.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		nome.setForeground(Color.WHITE);
		nome.setBounds(478, 93, 104, 25);

		contentPane.add(nome);
		score.setForeground(Color.WHITE);
		score.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		score.setBounds(478, 129, 164, 29);

		contentPane.add(score);
		lblScore.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(470, 11, 174, 96);

		contentPane.add(lblScore);

		pinky.setBounds(241, 237, 46, 29);
		contentPane.add(pinky);

		red.setBounds(210, 215, 31, 43);
		contentPane.add(red);

		blue.setBounds(182, 230, 31, 43);
		contentPane.add(blue);

		for (int i = 0; i < 28; i++) {
			for (int j = 0; j < 31; j++) {
				if (Fachada.getInstance().getPac().getPosiçãoX() == i
						&& Fachada.getInstance().getPac().getPosiçãoY() == j) {
					pac.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					getContentPane().add(pac);
				}
				switch (Fachada.getInstance().getMapa().getPontos()[j][i]) {
				case 'o':
					pontos[j][i] = new JLabel(ponto);
					pontos[j][i].setBounds(i * 16 + 5, j * 16 + 13, 5, 5);
					getContentPane().add(pontos[j][i]);
					break;
				case '-':
					pontos[j][i] = new JLabel(pilula);
					pontos[j][i].setBounds(i * 16 + 5, j * 16 + 13, 7, 7);
					getContentPane().add(pontos[j][i]);
					break;
				case 'P':
					pac.setBounds(i * 16 - 2, j * 16 + 5, 25, 25);
					getContentPane().add(pac);
				case ' ':
					pontos[j][i] = new JLabel(pilula);
					pontos[j][i].setBounds(0, 0, 0, 0);
					getContentPane().add(pontos[j][i]);
					break;
				default:
					break;
				}

			}
		}

		JLabel map = new JLabel("");
		map.setIcon(new ImageIcon(Game.class.getResource("/GUI/Imagens/Mapa.png")));
		map.setBounds(0, 0, 460, 518);
		contentPane.add(map);

		JLabel Score = new JLabel("");
		Score.setIcon(new ImageIcon(Game.class.getResource("/GUI/Imagens/score.png")));
		Score.setBounds(451, 0, 222, 518);
		contentPane.add(Score);
	}

	public void playBegin(String nomeDoAudio) {
		java.net.URL url = Menu.class.getResource(nomeDoAudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();

	}

	public void mudar() {
		switch (Fachada.getInstance().getPac().getDirecao()) {
		case 1:
			pac.setIcon(pac1);
			break;
		case 2:
			pac.setIcon(pac2);
			break;
		case 3:
			pac.setIcon(pac3);
			break;
		case 4:
			pac.setIcon(pac4);
			break;

		}
	}

	public void musica() {
		if (Fachada.getInstance().getPac().getDirecao() == 1) {
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY()][Fachada
					.getInstance().getPac().getPosiçãoX() + 1] == 'o') {
				playBegin("pacman_chomp");
			}
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY()][Fachada
					.getInstance().getPac().getPosiçãoX() + 1] == '-') {
				playBegin("pilula");

			}
		}

		if (Fachada.getInstance().getPac().getDirecao() == 2) {
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY() + 1][Fachada
					.getInstance().getPac().getPosiçãoX()] == 'o')
				playBegin("pacman_chomp");
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY() + 1][Fachada
					.getInstance().getPac().getPosiçãoX()] == '-')
				playBegin("pilula");

		}

		if (Fachada.getInstance().getPac().getDirecao() == 3) {
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY()][Fachada
					.getInstance().getPac().getPosiçãoX() - 1] == 'o')
				playBegin("pacman_chomp");

			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY()][Fachada
					.getInstance().getPac().getPosiçãoX() - 1] == '-')
				playBegin("pilula");
		}

		if (Fachada.getInstance().getPac().getDirecao() == 4) {

			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY() - 1][Fachada
					.getInstance().getPac().getPosiçãoX()] == 'o')
				playBegin("pacman_chomp");

			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY() - 1][Fachada
					.getInstance().getPac().getPosiçãoX()] == '-')
				playBegin("pilula");
		}

	}

	public void keyevent() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 39) {
					Fachada.getInstance().getPac().setDirecao(1);
				}
				if (e.getKeyCode() == 40) {
					Fachada.getInstance().getPac().setDirecao(2);
				}
				if (e.getKeyCode() == 37) {
					Fachada.getInstance().getPac().setDirecao(3);
				}
				if (e.getKeyCode() == 38) {
					Fachada.getInstance().getPac().setDirecao(4);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

	}

}
