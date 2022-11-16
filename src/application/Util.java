package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util
{
	public static double round(double value, int places)
	{
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/******************************************/
	public static String makeDoubleString(
					Double doubleNumber)
	{
		return String.format("%.2f", doubleNumber);
	}

	public static Double makeStringDouble(String stringNumber)
	{
		return Double.parseDouble(stringNumber);
	}

	public static boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}

	public static String dateToString(Date inDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String outDate = formatter.format(inDate);
		return outDate;
	}
}
