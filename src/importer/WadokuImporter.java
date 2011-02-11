package importer;


public class WadokuImporter extends XmlImporter  {
	
	
	
	@Override
	public Entry getNext() {
		String tags = readNextTag("entry");

		if(tags=="")
			return null;
		
		Entry entry = new Entry();
		entry.japanese = transform("src/wadoku_entry_japanese.xsl", tags).trim();
		entry.reading = transform("src/wadoku_entry_reading.xsl", tags).trim();
		entry.translation = transform("src/wadoku_entry_german.xsl", tags).trim();
		return entry;
	}
	
	public WadokuImporter(String filename) {
		super(filename);
	}

}