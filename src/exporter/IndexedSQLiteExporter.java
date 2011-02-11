package exporter;

import java.io.IOException;

import importer.*;

public class IndexedSQLiteExporter extends Exporter {
	
	public IndexedSQLiteExporter() {
		super();
	}
	
	public IndexedSQLiteExporter(String outfile) {
		super(outfile);
	}
	
	public void export(Importer in) throws IOException {
		Entry entry = in.getNext();
		//TODO REAL SQL
		while(entry != null)
			export(entry);
			entry = in.getNext();
			
	}
	
	public void export(Entry entry) throws IOException {
		print(entry.japanese + " || " + entry.reading + " || "
				+ entry.translation);
	}

}
