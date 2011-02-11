package exporter;

import importer.Entry;
import importer.Importer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Exporter {

	private FileWriter writer;
	
	public Exporter(String outfile) {
		File output = new File(outfile);
		try {
			writer = new FileWriter(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Exporter() {
		writer = null;
	}
	
	public void print(String out) throws IOException {
		if(writer != null) {
			writer.write(out);
		} else {
			System.out.print(out);
		}
	}
	
	public void println(String out) throws IOException {
		print(out + "\n");
	}
	
	public void export(Importer in) throws IOException {
		Entry entry = in.getNext();
		while(entry != null) {
			export(entry);
			entry = in.getNext();
		}
	}
	
	public abstract void export(Entry entry) throws IOException;

}
