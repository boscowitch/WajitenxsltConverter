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
		if(!entry.japanese.isEmpty())
			println(entry.japanese + "\t" + entry.reading + "\t"
					+ entry.translation);
		else
			println(entry.reading  + "\t" + entry.reading + "\t"
					+ entry.translation);
	}

}
