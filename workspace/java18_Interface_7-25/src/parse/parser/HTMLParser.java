package parse.parser;

import parse.Parseable;

public class HTMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.println(fileName + " - HTML parsing completed !");
		
	}

}
