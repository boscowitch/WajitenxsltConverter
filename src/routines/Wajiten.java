package routines;

import java.io.IOException;

import exporter.TabfileExporter;
import importer.JMdictImporter;
import importer.WadokuImporter;

public class Wajiten {
	public static void main(String[] args) throws IOException {
		if(args.length < 1) {
			System.out.println("missing argument: missing file to import/convert");
			System.out.println("./wajiten inportfile [outfile]");
			return;
		}
		
		String outfile = null;
		if(args.length > 2) {
			outfile = args[1];
		}
		
		//WadokuImporter in = new WadokuImporter(args[0]);
		JMdictImporter in = new JMdictImporter("/home/bosco/Projekte/xml/JMdict");
		
		TabfileExporter ex = new TabfileExporter();
		
		ex.export(in);
		/*
		Entry entry = in.getNext();
		
		while(entry != null) {
			
			entry = in.getNext();
		}*/
		
		
	}
}
