package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RepositorioJogadorArquivo {
	File filejogador;

	public boolean inserir(RepositorioJogadorArray jogador) {
		try {
			filejogador = new File("jogador.jog");
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filejogador));
			output.writeObject(jogador);
			output.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public RepositorioJogadorArray procurar() {
		try {
			filejogador = new File("jogador.jog");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(filejogador));
			RepositorioJogadorArray array = (RepositorioJogadorArray) input.readObject();
			input.close();
			return array;
		} catch (Exception e) {
			System.out.println("kakasa");
			return null;
		}

	}

}
