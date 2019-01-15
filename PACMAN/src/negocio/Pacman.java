package negocio;

import java.io.Serializable;

import dados.maps.Mapa;

public class Pacman implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int vida;
	private int posi��oX;
	private int posi��oY;
	private boolean Invulneravel;
	private boolean comeu;
	private int direcao;
	// direcao = 1 direita
	// direcao = 2 baixo
	// direcao = 3 esquerda
	// direcao = 4 cima

	// Construtor
	public Pacman(int posi��oX, int posi��oY) {
		this.vida = 3;
		this.posi��oX = posi��oX;
		this.posi��oY = posi��oY;
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

	public int getPosi��oX() {
		return posi��oX;
	}

	public void setPosi��oX(int posi��oX) {
		this.posi��oX = posi��oX;
	}

	public int getPosi��oY() {
		return posi��oY;
	}

	public void setPosi��oY(int posi��oY) {
		this.posi��oY = posi��oY;
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
				if (this.posi��oY == 14 && this.posi��oX == 26) {
					this.posi��oY = 14;
					this.posi��oX = 1;

				}
				this.posi��oX = this.posi��oX + 1;
			}
		} else if (direcao == 2) {
			// indo para baixo
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				this.posi��oY = this.posi��oY + 1;
				
			}
		} else if (direcao == 3) {
			// indo para esquerda
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				if (this.posi��oY == 14 && this.posi��oX == 1) {
					this.posi��oY = 14;
					this.posi��oX = 26;

				}
				this.posi��oX = this.posi��oX - 1;
				
			}
		} else if (direcao == 4) {
			// indo para cima
			if (EncontrouParede(mapa.getPontos())) {
				// fazer nada / pacman encontrou uma parede
			} else {
				this.posi��oY = this.posi��oY - 1;

			}
		}

	}

	public boolean EncontrouParede(char[][] mapa) {
		if (direcao == 1) {
			if (mapa[(int) this.posi��oY][(int) (this.posi��oX + 1)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 2) {
			if (mapa[(int) this.posi��oY + 1][(int) (this.posi��oX)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 3) {
			if (mapa[(int) this.posi��oY][(int) (this.posi��oX - 1)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else if (direcao == 4) {
			if (mapa[(int) this.posi��oY - 1][(int) (this.posi��oX)] == 'x') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void ComeuPilula(Mapa mapa) {
		if (mapa.getPontos()[this.posi��oY][this.posi��oX] == '-') {
			this.Invulneravel = true;
		}
	}

	public boolean ComeuFant(Fantasmas fant) {
		if (Invulneravel == true && this.posi��oX == fant.getPosicaoX() && this.posi��oY == fant.getPosicaoY()) {
			return true;
		} else {
			return false;
		}
	}

}
