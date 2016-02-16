package dataacquisition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RunLineReadThread implements Runnable {

	public Thread t;
	private String threadName;
	boolean suspended = false;

	public RunLineReadThread(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	static String csvFile = "C:/Users/NiklasBae/workspace/dss/lib/person.csv";
	static BufferedReader br = null;
	static String line = "";
	static String cvsSplitBy = ";";

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			while (true) {
				try {
					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {
						
						suspend();

						String[] data = line.split(cvsSplitBy);

						int id;

						id = Integer.parseInt(data[0]);
						gui.Controller.hoyde = Double.parseDouble(data[1]);
						gui.Controller.vekt = Double.parseDouble(data[2]);
						gui.Controller.alder = Integer.parseInt(data[3]);
						gui.Controller.iq = Integer.parseInt(data[4]);

						System.out.println(gui.Controller.hoyde + " " + gui.Controller.vekt + " " + gui.Controller.alder
								+ " " + gui.Controller.iq);

						Thread.sleep(300);
						synchronized (this) {
							while (suspended) {
								wait();
							}
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted");
		}
		System.out.println("Thread " + threadName + " exiting");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public void suspend() {
		suspended = true;
	}

	public synchronized void resume() {
		suspended = false;
		notify();
	}

}
