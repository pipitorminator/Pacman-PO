package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean tocar;
	private static Thread play;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					play = new Thread(frame);
					play.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		tocar = true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IniciarJogador player = new IniciarJogador();
				player.setVisible(true);
				tocar = false;

			}
		});
		btnPlay.setBackground(Color.YELLOW);
		btnPlay.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnPlay.setBounds(175, 72, 107, 23);

		contentPane.add(btnPlay);

		JButton btnBestPlayers = new JButton("Best Players");
		btnBestPlayers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HighScore HS = new HighScore();
				HS.setVisible(true);

			}
		});
		btnBestPlayers.setBackground(Color.YELLOW);
		btnBestPlayers.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnBestPlayers.setBounds(175, 137, 107, 23);
		contentPane.add(btnBestPlayers);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/GUI/Imagens/fundoMenu.jpeg")));
		label.setBounds(0, 0, 444, 293);
		contentPane.add(label);

	}

	public void play(String nomeDoAudio) {
		java.net.URL url = Menu.class.getResource(nomeDoAudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.loop();

	}

	@Override
	public void run() {

		while (tocar == true) {
			java.net.URL url = Menu.class.getResource("pacman_beginning.wav");
			AudioClip audio = Applet.newAudioClip(url);
			audio.play();
			try {
				Thread.sleep(4100);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}

		}

	}
}
