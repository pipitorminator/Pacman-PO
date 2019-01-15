package negocio;

import dados.RepositorioJogadorArquivo;
import dados.RepositorioJogadorArray;
import dados.maps.GerarArquivosMapa;
import dados.maps.Mapa;
import dados.maps.RepositorioMapas;
import dados.maps.RepositorioMapasArquivo;

public class Fachada {
	private static Fachada instance;
	private RepositorioJogadorArray jogadores;
	private Jogador player;
	private RepositorioMapas mapasarquivo;
	private Mapa mapa;
	private Pacman pac;
	private Fantasmas[] fant;
	private ControlePacman controlpac;
	private Thread threadpacman;
	private Thread threadfantasmared;
	private Thread threadfantasmablue;
	private Thread threadfantasmapinky;
	private GameStart jogo;

	public Fachada() {
		RepositorioJogadorArquivo arquivo = new RepositorioJogadorArquivo();
		if (arquivo.procurar() == null) {
			jogadores = new RepositorioJogadorArray();
			arquivo.inserir(jogadores);
		} else {
			jogadores = arquivo.procurar();
		}
		mapasarquivo = new RepositorioMapasArquivo();
		GerarArquivosMapa gerar = new GerarArquivosMapa();
		gerar.GerarArquivos();

	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public Pacman getPac() {
		return pac;
	}

	public Fantasmas[] getFant() {
		return fant;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public Jogador getPlayer() {
		return player;
	}

	public void setPlayer(Jogador player) {
		this.player = player;
	}

	public RepositorioJogadorArray getJogadores() {
		return jogadores;
	}

	public GameStart getJogo() {
		return jogo;
	}

	public Mapa procurarmapa(int level) {
		mapa = mapasarquivo.procurar(level);
		pac = mapa.getPacman();
		fant = mapa.getFantasma();
		controlpac = mapa.getControlpac();
		threadfantasmared = new Thread(mapa);
		threadfantasmablue = new Thread(mapa);
		threadfantasmapinky = new Thread(mapa);
		jogo = new GameStart(threadfantasmared, threadfantasmablue, threadfantasmapinky);
		threadpacman = new Thread(controlpac);
		return mapa;

	}

	public void inserirarquivojogador() {
		RepositorioJogadorArquivo arquivo = new RepositorioJogadorArquivo();
		arquivo.inserir(jogadores);
	}

	public void inserir(Jogador jogador) {
		jogadores.inserir(jogador);
		inserirarquivojogador();

	}

	public Jogador procurarJogador(String nome) {
		player = jogadores.procurar(nome);
		return player;
	}

	public void novojogador(String nome) {
		player = new Jogador(nome);
	}

	public void MoverPac() {
		threadpacman.interrupt();
		threadpacman.start();
	}

}
