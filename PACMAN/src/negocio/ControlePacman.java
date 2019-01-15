package negocio;

import java.io.Serializable;

import dados.maps.Mapa;

public class ControlePacman implements Serializable, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mapa mapa;

	public ControlePacman(Mapa mapa) {
		this.mapa = mapa;

	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public void run() {
		int timer = 0;
		while (mapa.getPacman().getVida() != 0) {
			mapa.getPacman().Mover(mapa);
			if (mapa.getPacman().isInvulneravel() && timer < 33) {
				timer++;
			} else {
				mapa.getPacman().setInvulneravel(false);
				timer = 0;
			}
			try {
				Thread.sleep(100);
				// }
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}

		}

	}

}