package dados.maps;

import dados.Global;
import negocio.Fantasmas;
import negocio.Pacman;

public class GerarArquivosMapa {

	private RepositorioMapas arquivo = new RepositorioMapasArquivo();
	
	public void GerarArquivos() {
		Fantasmas[] fant = new Fantasmas[3];
		fant[0] = new Fantasmas(12, 12, "red");
		fant[1] = new Fantasmas(12, 12, "blue");
		fant[2] = new Fantasmas(12, 12, "pinky");
		Mapa mapa1 = new Mapa(Global.MAPA1, fant, new Pacman(14, 23));
		arquivo.inserir(mapa1);

	}

}
