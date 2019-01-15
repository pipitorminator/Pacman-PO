package negocio;

import java.io.Serializable;

import dados.maps.Mapa;

public class Fantasmas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean vulneravel;
	private int posicaoX;
	private int posicaoY;
	private String cor;

	// construtor dos fantasmas;
	public Fantasmas(int posicaoX, int posicaoY, String cor) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.vulneravel = false;
		this.setCor(cor);
	}

	public Fantasmas(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.vulneravel = false;
	}
	// Get e Sets

	public boolean isVulneravel() {
		return vulneravel;
	}

	public void setVulneravel(boolean vulneravel) {
		this.vulneravel = vulneravel;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	// metódos
	public boolean EncontrouPac(Pacman pac) {
		if (this.posicaoX == pac.getPosiçãoX() && this.posicaoY == pac.getPosiçãoY()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean MatouPac(Pacman pac) {
		if (EncontrouPac(pac) && pac.isInvulneravel() == false) {
			// System.out.println(vulneravel);
			this.posicaoX = 12;
			this.posicaoY = 12;
			return true;

		} else {
			// System.out.println(vulneravel);
			return false;
		}
	}

	public void CorrerdoPac(Pacman pac, Mapa mapa) {
		if (pac.getPosiçãoX() > this.posicaoX) {
			if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'x'
					|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'e') {
				if (pac.getPosiçãoY() < this.posicaoY) {
					if (mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'e') {
						MoverParacima(mapa);
					} else {
						MoverParaBaixo(mapa);
					}
				} else {
					if (mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'e') {
						MoverParaBaixo(mapa);
					} else {
						MoverParacima(mapa);
					}
				}

			} else {
				MoverParaEsq(mapa);
			}
		} else if (pac.getPosiçãoX() < this.posicaoX) {

			if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'x'
					|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'e') {
				if (pac.getPosiçãoY() < this.posicaoY) {
					if (mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'e') {
						MoverParacima(mapa);
					} else {
						MoverParaBaixo(mapa);
					}
				} else {
					if (mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'e') {
						MoverParaBaixo(mapa);
					} else {
						MoverParacima(mapa);
					}
				}

			} else {
				MoverParaDir(mapa);
			}

		} else if (pac.getPosiçãoY() < this.posicaoY) {
			if (mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'x'
					|| mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'e') {
				if (pac.getPosiçãoX() < this.posicaoX) {
					if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'e') {
						MoverParaEsq(mapa);
					} else {
						MoverParaDir(mapa);
					}
				} else {
					if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'e') {
						MoverParaDir(mapa);
					} else {
						MoverParaEsq(mapa);
					}
				}

			} else {
				MoverParaBaixo(mapa);
			}

		} else if (pac.getPosiçãoY() > this.posicaoY) {
			if (mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'x'
					|| mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'e') {
				if (pac.getPosiçãoX() < this.posicaoX) {
					if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'x') {
						MoverParaEsq(mapa);
					} else {
						MoverParaDir(mapa);
					}
				} else {
					if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'x'
							|| mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'e') {
						MoverParaDir(mapa);
					} else {
						MoverParaEsq(mapa);
					}
				}

			} else {
				MoverParacima(mapa);
			}

		}
	}

	// movimento fantasma
	public void MoverParacima(Mapa mapa) {
		if (mapa.getPontos()[(int) this.posicaoY - 1][(int) (this.posicaoX)] == 'x') {
			// encontrou parede / n anda
		} else {
			setPosicaoY(posicaoY - 1);
		}
	}

	public void MoverParaBaixo(Mapa mapa) {
		if (mapa.getPontos()[(int) this.posicaoY + 1][(int) (this.posicaoX)] == 'x') {
			// encontrou parede / n anda
		} else {
			setPosicaoY(posicaoY + 1);
		}
	}

	public void MoverParaDir(Mapa mapa) {
		if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX + 1)] == 'x') {
			// encontrou parede / n anda
		} else {
			setPosicaoX(posicaoX + 1);
		}
	}

	public void MoverParaEsq(Mapa mapa) {
		if (mapa.getPontos()[(int) this.posicaoY][(int) (this.posicaoX - 1)] == 'x') {
			// encontrou parede / n anda
		} else {
			setPosicaoX(posicaoX - 1);
		}
	}

}