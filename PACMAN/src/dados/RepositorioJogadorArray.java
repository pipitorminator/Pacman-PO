package dados;

import java.io.Serializable;

import negocio.Jogador;

public class RepositorioJogadorArray implements RepositorioJogador, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Jogador[] players;
	private int indice;
	final static int SIZE = 100;

	public RepositorioJogadorArray() {
		this.players = new Jogador[SIZE];
		this.indice = 0;
	}

	public Jogador[] getPlayers() {
		return players;
	}

	public int getIndice() {
		return indice;
	}

	@Override
	public void inserir(Jogador jogador) {
		this.players[indice] = jogador;
		this.indice++;

	}

	@Override
	public Jogador procurar(String nome) {
		Jogador player = null;
		int i;
		for (i = 0; i < SIZE; i++) {
			if (players[i].getNome() == nome) {
				player = players[i];
			}

		}
		return player;
	}

}
