package dados;

import negocio.Jogador;

public class ControleJogador {
	private RepositorioJogador jogadores = new RepositorioJogadorArray();

	public void inserir(Jogador jogador) {
		if (jogador == null) {
			throw new RuntimeException();
		} else {
			jogadores.inserir(jogador);
		}
	}

	public Jogador procurar(String nome) {
		return jogadores.procurar(nome);
	}
	
	
	/*
	 * criar exceção para nome do jogador
	 * ex: ter somente letras
	 */
}
