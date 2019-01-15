package negocio;

import java.io.Serializable;

import dados.NumberException;
import dados.maps.Mapa;

public class Jogador extends NumberException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int Score;

	// construtor Jogador
	public Jogador(String nome) {
		super();
		try {
			setNome(nome);
		} catch (NumberException e) {
			this.nome = "404";
		}
		this.Score = 0;
	}

	// Get & Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NumberException {

		if (EhNumero(nome)) {
			throw new NumberException();
		} else {
			this.nome = nome;
		}
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public void pontos(Mapa mapa) {

		if (mapa.getPontos()[mapa.getPacman().getPosiçãoY()][mapa.getPacman().getPosiçãoX()] == 'o') {

			mapa.getPontos()[mapa.getPacman().getPosiçãoY()][mapa.getPacman().getPosiçãoX()] = ' ';
			setScore(this.Score + 100);
		}

		if (mapa.getPontos()[mapa.getPacman().getPosiçãoY()][mapa.getPacman().getPosiçãoX()] == '-') {

			mapa.getPontos()[mapa.getPacman().getPosiçãoY()][mapa.getPacman().getPosiçãoX()] = ' ';
			setScore(this.Score + 500);
		}

		if (mapa.getPacman().getComeu()) {
			setScore(this.Score + 1000);
			mapa.getPacman().setComeu(false);
		}

	}

	@Override
	public String toString() {
		return "" + Score + "";
	}

	public String toStringnome() {
		return "" + nome + "  " + Score + "";
	}

}
