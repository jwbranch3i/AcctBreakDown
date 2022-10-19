package dataModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TransactionData
{
	private int _id;
	private SimpleObjectProperty<LocalDate> date;
	private SimpleStringProperty discription;
	private SimpleDoubleProperty gas;
	private SimpleDoubleProperty service;
	private SimpleDoubleProperty john;
	private SimpleDoubleProperty pastor;
	private SimpleDoubleProperty med;
	private SimpleDoubleProperty school;
	private SimpleDoubleProperty misc;

	private SimpleDoubleProperty tax;
	private SimpleDoubleProperty saving;
	private SimpleDoubleProperty transactionTotal;

	public TransactionData(Transaction transaction)
	{
		this._id = transaction.get_id();
		this.date.set(transaction.getDate());
		this.discription.set(transaction.getDiscription());
		this.gas.set(transaction.getGas());
		this.service.set(transaction.getService());
		this.john.set(transaction.getJohn());
		this.pastor.set(transaction.getPastor());
		this.med.set(transaction.getMed());
		this.school.set(transaction.getSchool());
		this.misc.set(transaction.getMisc());

		this.tax.set(transaction.getTax());
		this.saving.set(transaction.getSaving());
		this.transactionTotal.set(transaction.getTransactionTotal());
	}

	// ----------------------------------------
	public int get_id()
	{
		return _id;
	}

	// ----------------------------------------
	public void set_id(int _id)
	{
		this._id = _id;
	}

	// ----------------------------------------
	public LocalDate getTransactionDate()
	{
		return date.get();
		// DateTimeFormatter formatter =
		// DateTimeFormatter.ofPattern("MM/dd/YYYY");
		// return formatter.format(date.get());
	}

	public void setTransactionDate(LocalDate date)
	{
		this.date.set(date);
	}

	// ----------------------------------------
	public String getDiscription()
	{
		return discription.get();
	}

	public void setDiscription(String discription)
	{
		this.discription.set(discription);
	}

	// ----------------------------------------
	public double getGas()
	{
		return gas.get();

		// if (gas.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", gas.get());
		// }
	}

	public void setGas(double gas)
	{
		this.gas.set(gas);
	}

	// ----------------------------------------
	public double getService()
	{
		return service.get();
		// if (service.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", service.get());
		// }
	}

	public void setService(double service)
	{
		this.service.set(service);
	}

	// ----------------------------------------
	public double getJohn()
	{
		return john.get();
		// if (john.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", john.get());
		// }
	}

	public void setJohn(double john)
	{
		this.john.set(john);
	}

	// ----------------------------------------
	public double getPastor()
	{
		return pastor.get();
		// if (pastor.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", pastor.get());
		// }
	}

	public void setPastor(double pastor)
	{
		this.pastor.set(pastor);
	}

	// ----------------------------------------
	public String getMed()
	{
		return med.get();
		// if (med.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", med.get());
		// }
	}

	public void setMed(double med)
	{
		this.med.set(med);
	}

	// ----------------------------------------
	public double getSchool()
	{
		return school.get();
		// if (school.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", school.get());
		// }
	}

	public void setSchool(double school)
	{
		this.school.set(school);
	}

	// ----------------------------------------
	public double getMisc()
	{
		return misc.get();
		// if (misc.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", misc.get());
		// }
	}

	public void setMisc(double misc)
	{
		this.misc.set(misc);
	}

	// ----------------------------------------
	public double getTax()
	{
		return tax.get();
		// if (tax.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", tax.get());
		// }
	}

	public void setTax(double tax)
	{
		this.tax.set(tax);
	}

	// ----------------------------------------
	public double getSaving()
	{
		return saving.get();
		// if (saving.get() == 0.)
		// {
		// return "";
		// }
		// else
		// {
		// return String.format("%.2f", saving.get());
		// }
	}

	public void setSaving(double saving)
	{
		this.saving.set(saving);
	}

	// ----------------------------------------
	public double getTransactionTotal()
	{
		return transactionTotal.get();
//		if (transactionTotal.get() == 0.)
//		{
//			return "";
//		}
//		else
//		{
//			return String.format("%.2f", transactionTotal.get());
//		}
	}
