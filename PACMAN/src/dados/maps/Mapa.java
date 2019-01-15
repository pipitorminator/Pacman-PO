package dados.maps;

import java.io.Serializable;

import negocio.ControlePacman;
import negocio.Fantasmas;
import negocio.Pacman;
import negocio.Pathfinder;

public class Mapa implements Serializable, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char pontos[][];
	private String ProximoFantasma;
	private Fantasmas[] fantasma;
	private Pacman pacman;
	private ControlePacman controlpac;

	// Construtor Mapa
	public Mapa(char pontos[][], Fantasmas[] fantasma, Pacman pacman) {
		this.pontos = pontos;
		this.fantasma = fantasma;
		this.pacman = pacman;
		this.pontos[pacman.getPosiçãoY()][pacman.getPosiçãoX()] = 'P';
		ProximoFantasma = "Red";
		controlpac = new ControlePacman(this);

	}

	// Get & Set

	public Fantasmas[] getFantasma() {
		return fantasma;
	}

	public void setFantasma(Fantasmas[] fantasma) {
		this.fantasma = fantasma;
	}

	public Pacman getPacman() {
		return pacman;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public char[][] getPontos() {
		return pontos;
	}

	public void setPontos(char[][] pontos) {
		this.pontos = pontos;
	}

	public void setPontos(char pontos, int linha, int coluna) {
		this.pontos[linha][coluna] = pontos;
	}

	public String getProximoFantasma() {
		return ProximoFantasma;
	}

	public void setProximoFantasma(String proximoFantasma) {
		ProximoFantasma = proximoFantasma;
	}

	public ControlePacman getControlpac() {
		return controlpac;
	}

	public void setControlpac(ControlePacman controlpac) {
		this.controlpac = controlpac;
	}

	// metodos

	@Override
	public void run() {
		Pathfinder moverfant = new Pathfinder();
		int index = 0;

		if (ProximoFantasma == "blue") {
			index = 1;
		} else if (ProximoFantasma == "pinky") {
			index = 2;
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// e1.printStackTrace();
		}
		while ((!fantasma[0].MatouPac(pacman) || !fantasma[1].MatouPac(pacman) || !fantasma[2].MatouPac(pacman))
				&& pacman.getVida() != 0) {

			if (pacman.isInvulneravel()) {

				fantasma[index].CorrerdoPac(pacman, this);

				if (pacman.ComeuFant(fantasma[index])) {
					this.pontos[fantasma[index].getPosicaoY()][fantasma[index].getPosicaoX()] = ' ';
					fantasma[index].setPosicaoX(12);
					fantasma[index].setPosicaoY(12);
					pacman.setComeu(true);

					try {
						Thread.sleep(2500);
						this.pontos[fantasma[index].getPosicaoY()][fantasma[index].getPosicaoX()] = 'x';
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}

				}
				
				try {
					Thread.sleep(400);
				} catch (InterruptedException e1) {
					// e1.printStackTrace();
				}

			} else {
				moverfant.Finder(this, fantasma[index], pacman);
				fantasma[index] = moverfant.getPathtopac().get(0);
				try {
					if (fantasma[index].MatouPac(pacman)) {
						pacman.setVida(pacman.getVida() - 1);
						setPontos(' ', getPacman().getPosiçãoY(), getPacman().getPosiçãoX());
						getPacman().setPosiçãoX(14);
						getPacman().setPosiçãoY(23);
						getPacman().setDirecao(1);
						setPontos('P', getPacman().getPosiçãoY(), getPacman().getPosiçãoX());

						fantasma[0].setPosicaoX(12);
						fantasma[0].setPosicaoY(12);
						fantasma[1].setPosicaoX(12);
						fantasma[1].setPosicaoY(12);
						fantasma[2].setPosicaoX(12);
						fantasma[2].setPosicaoY(12);

						Thread.sleep(2500);
					}
					if (index == 0) {
						Thread.sleep(115);
					} else if (index == 1) {
						Thread.sleep(160);
					} else if (index == 2) {
						Thread.sleep(210);
					}

				} catch (InterruptedException e) {

				}

			}
		}
	}

}