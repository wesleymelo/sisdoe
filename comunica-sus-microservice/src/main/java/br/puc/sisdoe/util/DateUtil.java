package br.puc.sisdoe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String FORMATO_PADRAO_BR = "dd/MM/yyyy";

    public static Date formataDataPadraoBR(String dataStr) {
	try {
	    return new SimpleDateFormat(FORMATO_PADRAO_BR).parse(dataStr);
	} catch (ParseException e) {
	    e.printStackTrace();
	    return new Date();
	}

    }

    public static String formataDataStrPadraoBR(Date date) {
	return new SimpleDateFormat(FORMATO_PADRAO_BR).format(date);
    }
}
