package parse.test;

import parse.Parseable;
import parse.manager.ParserManager;

public class ParseTest {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
		
	}

}
