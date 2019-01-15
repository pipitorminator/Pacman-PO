package dados.maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RepositorioMapasArquivo implements RepositorioMapas {
	File file;

	@Override
	public boolean inserir(Mapa mapa) {
		try {
			file = new File("Level1.MAP");
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(mapa);
			output.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Mapa procurar(int level) {
		try {
			file = new File("Level" + level + ".MAP");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			Mapa map = (Mapa) input.readObject();
			input.close();
			return map;
		} catch (Exception e) {
			return null;
		}

	}

}
