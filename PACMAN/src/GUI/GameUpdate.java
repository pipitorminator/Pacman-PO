package GUI;

import java.applet.Applet;
import java.applet.AudioClip;

import negocio.Fachada;

public class GameUpdate extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (Fachada.getInstance().getPac().getVida() != 0) {
			if (Fachada.getInstance().getMapa().getPontos()[Fachada.getInstance().getPac().getPosiçãoY()][Fachada
					.getInstance().getPac().getPosiçãoX()] == 'o') {
				play("pacman_chomp");

			}
			if (Fachada.getInstance().getPac().isInvulneravel()) {

				play("pilula");

			}

			try {
				Thread.sleep(110);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void play(String nomeDoAudio) {
		java.net.URL url = Menu.class.getResource(nomeDoAudio + ".wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
}
