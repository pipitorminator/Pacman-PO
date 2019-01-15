package negocio;

import java.util.ArrayList;

import dados.maps.Mapa;

public class Pathfinder {

	private static ArrayList<Fantasmas> pathtopac = new ArrayList<Fantasmas>();

	public ArrayList<Fantasmas> getPathtopac() {
		return pathtopac;
	}

	public void Finder(Mapa mapa, Fantasmas fant, Pacman pacman) {
		ArrayList<Fantasmas> path = new ArrayList<Fantasmas>();
		Fantasmas fantasma = null;
		Fantasmas fantasmaguia = null;
		Pacman pac = new Pacman(pacman.getPosiçãoX(), pacman.getPosiçãoY());
		int caminho = 0;
		int linhas = mapa.getPontos().length;
		int colunas = mapa.getPontos()[0].length;
		int[][] MapaPeso = new int[linhas][colunas];
		boolean[][] visitado = new boolean[linhas][colunas];
		int[] antecessor = new int[colunas * linhas];

		MapaPeso[fant.getPosicaoY()][fant.getPosicaoX()] = 0;
		visitado[fant.getPosicaoY()][fant.getPosicaoX()] = true;
		path.add(0, fant);
		antecessor[0] = 0;

		/*
		 * gera uma lista de todos os passos possiveis do fantasma e para ao encontrar o
		 * pacman
		 */
		if (fant.getPosicaoX() == pac.getPosiçãoX() && fant.getPosicaoY() == pac.getPosiçãoY()) {

		} else {
			caminho++;
			for (int i = 0;; i++) {
				fantasmaguia = path.get(i);
				fantasma = new Fantasmas(fantasmaguia.getPosicaoX(), fantasmaguia.getPosicaoY());

				if ((mapa.getPontos()[fantasmaguia.getPosicaoY() + 1][fantasmaguia.getPosicaoX()] != 'x'
						&& mapa.getPontos()[fantasmaguia.getPosicaoY() + 1][fantasmaguia.getPosicaoX()] != 'e')
						&& (visitado[fantasmaguia.getPosicaoY() + 1][fantasmaguia.getPosicaoX()] == false)) {

					fantasma.MoverParaBaixo(mapa);
					MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = 1
							+ MapaPeso[fantasma.getPosicaoY() - 1][fantasma.getPosicaoX()];
					visitado[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = true;
					path.add(caminho, fantasma);
					antecessor[caminho] = i;

					if (fantasma.EncontrouPac(pac)) {
						break;
					} else {
						caminho++;
						fantasma = new Fantasmas(fantasmaguia.getPosicaoX(), fantasmaguia.getPosicaoY());
					}

				}
				if ((mapa.getPontos()[fantasmaguia.getPosicaoY() - 1][fantasmaguia.getPosicaoX()] != 'x'
						&& mapa.getPontos()[fantasmaguia.getPosicaoY() - 1][fantasmaguia.getPosicaoX()] != 'e')
						&& (visitado[fantasmaguia.getPosicaoY() - 1][fantasmaguia.getPosicaoX()] == false)) {

					fantasma.MoverParacima(mapa);
					MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = 1
							+ MapaPeso[fantasma.getPosicaoY() + 1][fantasma.getPosicaoX()];
					visitado[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = true;
					path.add(caminho, fantasma);
					antecessor[caminho] = i;

					if (fantasma.EncontrouPac(pac)) {
						break;
					} else {
						caminho++;
						fantasma = new Fantasmas(fantasmaguia.getPosicaoX(), fantasmaguia.getPosicaoY());
					}
				}
				if ((mapa.getPontos()[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() + 1] != 'x'
						&& mapa.getPontos()[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() + 1] != 'e')
						&& (visitado[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() + 1] == false)) {

					fantasma.MoverParaDir(mapa);
					MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = 1
							+ MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX() - 1];
					visitado[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = true;
					path.add(caminho, fantasma);
					antecessor[caminho] = i;

					if (fantasma.EncontrouPac(pac)) {
						break;
					} else {
						caminho++;
						fantasma = new Fantasmas(fantasmaguia.getPosicaoX(), fantasmaguia.getPosicaoY());
					}
				}
				if ((mapa.getPontos()[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() - 1] != 'x'
						&& mapa.getPontos()[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() - 1] != 'e')
						&& (visitado[fantasmaguia.getPosicaoY()][fantasmaguia.getPosicaoX() - 1] == false)) {

					fantasma.MoverParaEsq(mapa);
					MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = 1
							+ MapaPeso[fantasma.getPosicaoY()][fantasma.getPosicaoX() + 1];
					visitado[fantasma.getPosicaoY()][fantasma.getPosicaoX()] = true;
					path.add(caminho, fantasma);
					antecessor[caminho] = i;

					if (fantasma.EncontrouPac(pac)) {
						break;
					} else {
						caminho++;
						fantasma = new Fantasmas(fantasmaguia.getPosicaoX(), fantasmaguia.getPosicaoY());
					}
				}
			}
		}

		gerarcaminho(path, caminho, antecessor);

	}

	private static void gerarcaminho(ArrayList<Fantasmas> path, int caminho, int[] antecessor) {
		ArrayList<Fantasmas> inverter = new ArrayList<Fantasmas>();
		Fantasmas fant = null;
		int i = 0;
		/*
		 * gera uma lista com o menor caminho do fantasma ao pacman, porem com o proximo
		 * passo do fantasma na ultima possição dessa lista
		 */
		for (; caminho != 0; i++) {

			fant = path.get(caminho);
			inverter.add(i, fant);
			caminho = antecessor[caminho];
		}
		i--;
		/*
		 * inverte a lista para por o proximo passo do fantasma na primeira posição da
		 * lista
		 */

		for (int j = 0; i >= 0; i--) {

			fant = inverter.get(i);
			pathtopac.add(j, fant);
			j++;

		}

	}

}
