package tableEditFiles;

import javafx.util.converter.DoubleStringConverter;

public class MyDoubleStringConverter extends DoubleStringConverter
{

	@Override
	public Double fromString(final String value)
	{
		return value.isEmpty() ||
						!isNumber(value) ? null : super.fromString(value);
	}

	public static boolean isNumber(String value)
	{
		if (value == null)
		{
			return false;
		}
		try
		{
			double d = Double.parseDouble(value);
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}

	// public boolean isNumber(String value)
	// {
	// int size = value.length();
	// for (int i = 0; i < size; i++)
	// {
	// if (!Character.isDigit(value.charAt(i)))
	// {
	// return false;
	// }
	// }
	// return size > 0;
	// }
}