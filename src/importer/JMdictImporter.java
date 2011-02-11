package importer;


public class JMdictImporter extends XmlImporter  {
	
	public JMdictImporter(String filename) {
		super(filename);
		header = xml.substring(0, xml.indexOf("<JMdict>"));
	}
	
	String header;
	

	@Override
	public Entry getNext() {
		String tags = readNextTag("entry");

		if(tags=="")
			return null;
		tags = header +"\n" + tags;
		Entry entry = new Entry();
		entry.japanese = transform("src/jmdict_entry_japanese.xsl", tags);
		System.out.println(entry.japanese);
		//entry.reading = transform("src/jmdict_entry_reading.xsl", tags);
		//entry.translation = transform("src/jmdict_entry_translation.xsl", tags);
		return entry;
	}
	
	public static void main(String[] args) {
		JMdictImporter in = new JMdictImporter(args[0]);
		System.out.println(args[0]);
		System.out.println(in.readNextTag("entry"));
		System.out.println(in.readNextTag("entry"));
	}

}
