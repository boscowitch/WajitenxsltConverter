package importer;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public abstract class XmlImporter extends Importer {
	
	/**
     * Die Hashmap, die die Templates speichert.
     */
    private static final Map<String, Templates> hm = new HashMap<String, Templates>();
	
    public static String transform(final String xslt, final String xml) {
        final StringWriter res = new StringWriter();
        try {
            final StringReader stringReader = new StringReader(xml);
            getTransformerInstance(xslt).transform(
                    new StreamSource(stringReader),
                    new StreamResult(res));
            stringReader.close();
        } catch (TransformerException e) {
            
        }
        final String s = res.toString();
        try {
            res.close();
        } catch (IOException e) {
           
        }
        return s;
    }
	
	private static Transformer getTransformerInstance(String xslt) throws TransformerConfigurationException {
		if (hm.containsKey(xslt)) {
            try {
                return hm.get(xslt).newTransformer();
            } catch (TransformerConfigurationException e) {
                //logger.error("getTransformerInstance: {}: {}", xslt, e.toString());
            }
        }
        else {
            try {
                final TransformerFactory tf = TransformerFactory.newInstance();
                final Source stylesheet = new StreamSource(new File(xslt));
                final Templates templates = tf.newTemplates(stylesheet);
                hm.put(xslt, templates);
                return templates.newTransformer();
            } catch (TransformerConfigurationException e) {
                //logger.error("getTransformerInstance: {}: {}", xslt, e.toString());
            }
        }
        return null;
	}

	public static String file2String(String filename) throws IOException  {
		FileReader in = new FileReader(filename);
		String str = file2String(in);
		in.close();
		return str;
	}
	
	private static String file2String(FileReader in) throws IOException {
		StringBuilder str = new StringBuilder();
		int CountBytes = 0;
		char[] bytesRead = new char[512];
		while( (CountBytes = in.read(bytesRead)) > 0 ) {
			str.append(bytesRead,0,CountBytes);
		}
		return str.toString();
	}
	
	protected String xml;
	protected int current_position;
	
	public XmlImporter(String filename) {
		current_position = 0;
		try {
			xml = file2String(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readNextTag(String tagname) {
		int prev_pos = current_position = xml.indexOf("<"+ tagname, current_position);
		current_position = xml.indexOf("</"+ tagname + ">", current_position);
		current_position += tagname.length()+3;
		if(prev_pos != -1 && current_position != -1)
		return xml.substring(prev_pos, current_position);
		return "";
	}
	
	public abstract Entry getNext();

}










