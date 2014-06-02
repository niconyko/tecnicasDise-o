package ar.com.grupo1.tecnicas.Logging;

import java.util.ArrayList;

public class ParserDefault extends ParserFile {

	@Override
	ArrayList<String> parser() {
		String defaultPattern = "%d{HH:mm:ss} %p %t %m %% %n %F %M";
		TranslateFormatIntoPattern(defaultPattern);
		return listConf;
	}

}
