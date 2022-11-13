package dataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcctData
{

	public static final String DB_NAME = "accounts.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:G:/JavaWork/AcctBreakDown/" +
					DB_NAME;

	/* table - transactions */
	public static final String TABLE_TRANSACTIONS = "transactions";
	public static final String COL_TRANSACTIONS_ID = "_ID";
	public static final String COL_TRANSACTIONS_DATE = "date";
	public static final String COL_TRANSACTIONS_DISCRIPTION = "discription";
	public static final String COL_TRANSACTIONS_GAS = "gas";
	public static final String COL_TRANSACTIONS_SERVICE = "service";
	public static final String COL_TRANSACTIONS_JOHN = "john";
	public static final String COL_TRANSACTIONS_PASTOR = "pastor";
	public static final String COL_TRANSACTIONS_MED = "med";
	public static final String COL_TRANSACTIONS_SCHOOL = "school";
	public static final String COL_TRANSACTIONS_MISC = "misc";
	public static final String COL_TRANSACTIONS_TAX = "tax";
	public static final String COL_TRANSACTIONS_SAVINGS = "savings";
	public static final String COL_TRANSACTIONS_SAVINGS_OTHER = "savings_other";

	public static final int INDEX_TRANSACTIONS_ID = 1;
	public static final int INDEX_TRANSACTIONS_DATE = 2;
	public static final int INDEX_TRANSACTIONS_DISCRIPTION = 3;
	public static final int INDEX_TRANSACTIONS_GAS = 4;
	public static final int INDEX_TRANSACTIONS_SERVICE = 5;
	public static final int INDEX_TRANSACTIONS_JOHN = 6;
	public static final int INDEX_TRANSACTIONS_PASTOR = 7;
	public static final int INDEX_TRANSACTIONS_MED = 8;
	public static final int INDEX_TRANSACTIONS_SCHOOL = 9;
	public static final int INDEX_TRANSACTIONS_MISC = 10;
	public static final int INDEX_TRANSACTIONS_TAX = 11;
	public static final int INDEX_TRANSACTIONS_SAVINGS = 12;
	public static final int INDEX_TRANSACTIONS_SAVINGS_OTHER = 13;

	public static final int ORDER_BY_NONE = 1;
	public static final int ORDER_BY_ASC = 2;
	public static final int ORDER_BY_DESC = 3;

	// UPDATE transactions SET gas = -10 WHERE _ID = 7
	public static final String UPDATE_TRANSACTION = "UPDATE " +
					TABLE_TRANSACTIONS +
					" SET gas = ? WHERE _ID = ?";

	private PreparedStatement updateInTransaction;

	private static double totalGas = 0.0;
	private static double totalService = 0.0;
	private static double totalJohn = 0.0;
	private static double totalPastor = 0.0;
	private static double totalMed = 0.0;
	private static double totalSchool = 0.0;
	private static double totalMisc = 0.0;
	private static double totalAcct = 0.0;

	private Connection conn;

	private static AcctData instance = new AcctData();

	private AcctData()
	{
	}

	public static AcctData getInstance()
	{
		return instance;
	}

	/****************************************/
	public boolean open()
	{
		try
		{
			conn = DriverManager.getConnection(CONNECTION_STRING);
			System.out.println(UPDATE_TRANSACTION);
			updateInTransaction = conn.prepareStatement(UPDATE_TRANSACTION);
			return true;
		}
		catch (SQLException e)
		{
			System.out.println("Couldn't connect to database: " +
							e.getMessage());
			return false;
		}
	}

	/****************************************/
	public void close()
	{
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println("Couldn't close connection" +
							e.getMessage());
		}
	}

	public double getTotalGas()
	{
		return totalGas;
	}

	public double getTotalService()
	{
		return totalService;
	}

	public double getTotalJohn()
	{
		return totalJohn;
	}

	public double getTotalPastor()
	{
		return totalPastor;
	}

	public double getTotalMed()
	{
		return totalMed;
	}

	public double getTotalSchool()
	{
		return totalSchool;
	}

	public double getTotalMisc()
	{
		return totalMisc;
	}

	public double getTotalAcct()
	{
		return totalAcct;
	}

	public List<TransactionData>
					queryTransactions(
									int sortOrder)
	{
		StringBuilder sb = new StringBuilder("SELECT ");
		sb.append(COL_TRANSACTIONS_ID +
						", ");
		sb.append(COL_TRANSACTIONS_DATE +
						", ");
		sb.append(COL_TRANSACTIONS_DISCRIPTION +
						", ");
		sb.append(COL_TRANSACTIONS_GAS +
						", ");
		sb.append(COL_TRANSACTIONS_SERVICE +
						", ");
		sb.append(COL_TRANSACTIONS_JOHN +
						", ");
		sb.append(COL_TRANSACTIONS_PASTOR +
						", ");
		sb.append(COL_TRANSACTIONS_MED +
						", ");
		sb.append(COL_TRANSACTIONS_SCHOOL +
						", ");
		sb.append(COL_TRANSACTIONS_MISC +
						", ");
		sb.append(COL_TRANSACTIONS_TAX +
						", ");
		sb.append(COL_TRANSACTIONS_SAVINGS +
						", ");
		sb.append(COL_TRANSACTIONS_SAVINGS_OTHER +
						" FROM ");
		sb.append(TABLE_TRANSACTIONS);
		if (sortOrder != ORDER_BY_NONE)
			;
		{
			sb.append(" ORDER BY ");
			sb.append(COL_TRANSACTIONS_DATE);
			if (sortOrder == ORDER_BY_DESC)
			{
				sb.append(" DESC");
			}
			else
			{
				sb.append(" ASC");
			}
		}
		// System.out.println("[AccData.java - 206]" + sb);

		try (Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery(sb.toString()))
		{
			List<TransactionData> list = new ArrayList<TransactionData>();
			while (results.next())
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Transaction currentTrans = new Transaction();
				currentTrans.set_id(results.getInt(INDEX_TRANSACTIONS_ID));

				try
				{
					String inDate = results.getString(INDEX_TRANSACTIONS_DATE);
					Date dInDate = sdf.parse(inDate);
					// System.out.println("[AccData.java - 223]" +
					// dInDate);

					currentTrans.setTransDate(dInDate);

					// currentTrans.setTransDate(sdf.parse(results.getString(INDEX_TRANSACTIONS_DATE)));
				}
				catch (ParseException e)
				{
					currentTrans.setTransDate(new Date(2000, 1, 1));
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}

				currentTrans.setDiscription(results.getString(INDEX_TRANSACTIONS_DISCRIPTION));
				currentTrans.setGas(results.getDouble(INDEX_TRANSACTIONS_GAS));
				currentTrans.setService(results.getDouble(INDEX_TRANSACTIONS_SERVICE));
				currentTrans.setJohn(results.getDouble(INDEX_TRANSACTIONS_JOHN));
				currentTrans.setPastor(results.getDouble(INDEX_TRANSACTIONS_PASTOR));
				currentTrans.setMed(results.getDouble(INDEX_TRANSACTIONS_MED));
				currentTrans.setSchool(results.getDouble(INDEX_TRANSACTIONS_SCHOOL));
				currentTrans.setMisc(results.getDouble(INDEX_TRANSACTIONS_MISC));
				currentTrans.setTax(results.getDouble(INDEX_TRANSACTIONS_TAX));
				currentTrans.setSaving(results.getDouble(INDEX_TRANSACTIONS_SAVINGS));
				currentTrans.setSavingOther(results.getDouble(INDEX_TRANSACTIONS_SAVINGS_OTHER));

				// System.out.println("***AccData.java - 248]" +
				// currentTrans);
				TransactionData transactionData = new TransactionData(currentTrans);
				// System.out.println("[AccData.java - 251]" +
				// transactionData);
				list.add(transactionData);
			}
			return list;
		}
		catch (SQLException e)
		{
			System.out.println("[AccData.java - 256]" +
							"Query failed: " +
							e.getMessage());
			return null;
		}
	}

	/******************************************/
	public ArrayList<Double> queryTotals()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SUM(gas) as tgas, SUM(service) as tservice, ");
		sb.append("SUM(john) as tjohn, SUM(pastor) as tpastor, ");
		sb.append("SUM(med) as tmed, SUM(school) tschool, ");
		sb.append("SUM(misc) as tmisc ");
		sb.append("from " +
						TABLE_TRANSACTIONS);

		System.out.println(sb);

		try (Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery(sb.toString()))
		{
			ArrayList<Double> list = new ArrayList<Double>();

			for (int i = 1; i <= 7; i++)
			{
				list.add(results.getDouble(i));
			}
			return list;
		}
		catch (SQLException e)
		{
			System.out.println("246 - Query failed: " +
							e.getMessage());
			return null;
		}
	}

	public void updateTransaction(
					String changedColumn,
					TransactionData transactionData)
	{
		String update_transaction;

		String part1 = "UPDATE " +
						TABLE_TRANSACTIONS +
						" SET ";
		String part2 = " = ? WHERE _ID = ?";
		try
		{
			switch (changedColumn)
			{
			case COL_TRANSACTIONS_DISCRIPTION:
				update_transaction = part1 +
								COL_TRANSACTIONS_DISCRIPTION +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setString(1, transactionData.getDiscription());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 316] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_GAS:
				update_transaction = part1 +
								COL_TRANSACTIONS_GAS +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getGas());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 328] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_SERVICE:
				update_transaction = part1 +
								COL_TRANSACTIONS_SERVICE +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getService());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 340] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_JOHN:
				update_transaction = part1 +
								COL_TRANSACTIONS_JOHN +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getJohn());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 352] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_PASTOR:
				update_transaction = part1 +
								COL_TRANSACTIONS_PASTOR +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getPastor());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 3364] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_MED:
				update_transaction = part1 +
								COL_TRANSACTIONS_MED +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getMed());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 376] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_SCHOOL:
				update_transaction = part1 +
								COL_TRANSACTIONS_SCHOOL +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getSchool());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 388] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;

			case COL_TRANSACTIONS_MISC:
				update_transaction = part1 +
								COL_TRANSACTIONS_MISC +
								part2;
				updateInTransaction = conn.prepareStatement(update_transaction);
				updateInTransaction.setDouble(1, transactionData.getMisc());
				updateInTransaction.setInt(2, transactionData.get_id());

				System.out.println("[AcctData 400] -  " +
								updateInTransaction.toString());
				updateInTransaction.executeUpdate();
				break;
			}
		}
		catch (Exception e)
		{
			System.out.println("[AcctData 415] -  " +
							"update transaction exception ");
		}
	}

}
