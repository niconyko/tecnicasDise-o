package ar.com.grupo1.tecnicas.Parser;

import java.util.ArrayList;

public class ParserDefault extends ParserFile {

	@Override
	public	ArrayList<String> parser() {
		String defaultPattern = "%d{HH:mm:ss} %p %t %m %% %n %F %M";
		TranslateFormatIntoPattern(defaultPattern);
		return listConf;
	}

}
