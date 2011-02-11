package exporter;

import java.io.IOException;

import importer.*;

public class TabfileExporter extends Exporter {
	
	public TabfileExporter() {
		super();
	}
	
	public TabfileExporter(String outfile) {
		super(outfile);
	}
	
	public void export(Importer in) throws IOException {
		Entry entry = in.getNext();
		while(entry != null) {
			export(entry);
			entry = in.getNext();
		}
	}
	
	public void export(Entry entry) throws IOException {
		println(entry.japanese + "\t" + entry.reading + "\\n"
				+ entry.translation);
		println(entry.reading+ "\t" + entry.japanese  + "\\n"
				+ entry.translation);
	}

}
