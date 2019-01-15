package negocio;

import java.io.Serializable;

import dados.maps.Mapa;

public class Pacman implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int vida;
	private int posiçãoX;
	private int posiçãoY;
	private boolean Invulneravel;
	private boolean comeu;
	private int direcao;
	// direcao = 1 direita
	// direcao = 2 baixo
	// direcao = 3 esquerda
	// direcao = 4 cima

	// Construtor
	public Pacman(int posiçãoX, int posiçãoY) {
		this.vida = 3;
		this.posiçãoX = posiçãoX;
		this.posiçãoY = posiçãoY;
		this.direcao = 1;
		setComeu(false);

	}

	// get & set
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPosiçãoX() {
		return posiçãoX;
	}

	public void setPosiçãoX(int posiçãoX) {
		this.posiçãoX = posiçãoX;
	}

	public int getPosiçãoY() {
		return posiçãoY;
	}

	public void setPosiçãoY(int posiçãoY) {
		this.posiçãoY = posiçãoY;
	}

	public boolean isInvulneravel() {
		return Invulneravel;
	}

	public void setInvulneravel(boolean invulneravel) {
		Invulneravel = invulneravel;
	}

	public boolean getComeu() {
		return comeu;
	}

	public void setComeu(boolean comeu) {
		this.comeu = comeu;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	// Metodos do Pacman

	public void Mover(Mapa mapa) {

		if (direcao == 1) {
			// indo para direita
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				if (this.posiçãoY == 14 && this.posiçãoX == 26) {
					this.posiçãoY = 14;
					this.posiçãoX = 1;

				}
				this.posiçãoX = this.posiçãoX + 1;
			}
		} else if (direcao == 2) {
			// indo para baixo
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				this.posiçãoY = this.posiçãoY + 1;
				
			}
		} else if (direcao == 3) {
			// indo para esquerda
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				if (this.posiçãoY == 14 && this.posiçãoX == 1) {
					this.posiçãoY = 14;
					this.posiçãoX = 26;

				}
				this.posiçãoX = this.posiçãoX - 1;
				
			}
		} else if (direcao == 4) {
			// indo para cima
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				this.posiçãoY = this.posiçãoY - 1;

			}
		}

	}

	public boolean EncontrouParede(char[][] mapa) {
		if (direcao == 1) {
			if (mapa[(int) this.posiçãoY][(int) (this.posiçãoX + 1)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 2) {
			if (mapa[(int) this.posiçãoY + 1][(int) (this.posiçãoX)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 3) {
			if (mapa[(int) this.posiçãoY][(int) (this.posiçãoX - 1)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 4) {
			if (mapa[(int) this.posiçãoY - 1][(int) (this.posiçãoX)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void ComeuPilula(Mapa mapa) {
		if (mapa.getPontos()[this.posiçãoY][this.posiçãoX] == '-') {
			this.Invulneravel = true;
		}
	}

	public boolean ComeuFant(Fantasmas fant) {
		if (Invulneravel == true && this.posiçãoX == fant.getPosicaoX() && this.posiçãoY == fant.getPosicaoY()) {
			return true;
		} else {
			return false;
		}
	}

}
