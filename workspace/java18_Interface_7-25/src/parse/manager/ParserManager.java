package parse.manager;

import parse.Parseable;
import parse.parser.HTMLParser;
import parse.parser.XMLParser;

public class ParserManager {
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
		}
	}
}
