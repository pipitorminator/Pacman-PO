package dados;

import negocio.Jogador;

public interface RepositorioJogador {
	public void inserir(Jogador jogador);

	public Jogador procurar(String nome);
}
