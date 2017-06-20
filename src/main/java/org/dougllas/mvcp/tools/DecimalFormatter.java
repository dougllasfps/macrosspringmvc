package org.dougllas.mvcp.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class DecimalFormatter {

    private static java.text.DecimalFormat decimalFormat;
	
	static{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		decimalFormat = (java.text.DecimalFormat) nf;
		DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
		decimalFormatSymbols.setCurrencySymbol("");
		decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
	}
	
	public static java.text.DecimalFormat getDecimalFormat(){
		return decimalFormat;
	}
	
	public static String format(BigDecimal number){
		return getDecimalFormat().format(number);
	}
	
	public static BigDecimal roundUp(BigDecimal value){
		value.setScale(2, RoundingMode.HALF_UP);
		return new BigDecimal(value.doubleValue());
	}
}