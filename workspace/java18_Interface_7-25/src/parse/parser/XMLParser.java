package parse.parser;

import parse.Parseable;

public class XMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.println(fileName + " - XML parsing completed !");
	}

}
