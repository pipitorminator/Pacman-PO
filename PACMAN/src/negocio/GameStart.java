package negocio;

public class GameStart extends Thread {

	private Thread threadfantasmared;
	private Thread threadfantasmablue;
	private Thread threadfantasmapinky;

	public GameStart(Thread threadfantasmared, Thread threadfantasmablue, Thread threadfantasmapinky) {
		this.threadfantasmared = threadfantasmared;
		this.threadfantasmablue = threadfantasmablue;
		this.threadfantasmapinky = threadfantasmapinky;
	}

	public void run() {
		//threadfantasmared.interrupt();
		//threadfantasmablue.interrupt();
		//threadfantasmapinky.interrupt();

		try {
			
			Thread.sleep(4000);
			Fachada.getInstance().MoverPac();
			threadfantasmared.start();
			Thread.sleep(5000);
			Fachada.getInstance().getMapa().setProximoFantasma("blue");
			threadfantasmablue.start();
			Thread.sleep(5000);
			Fachada.getInstance().getMapa().setProximoFantasma("pinky");
			threadfantasmapinky.start();
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}

	}

}
