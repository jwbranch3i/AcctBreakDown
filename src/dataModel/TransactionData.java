package dataModel;

import java.util.Date;

import application.Util;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TransactionData
{
	private int _id = 0;
	private SimpleObjectProperty<Date> transDate = new SimpleObjectProperty<Date>(new Date());
	private SimpleStringProperty discription = new SimpleStringProperty("");
	private SimpleDoubleProperty gas = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty service = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty john = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty pastor = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty med = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty school = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty misc = new SimpleDoubleProperty(0);

	private SimpleDoubleProperty tax = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty saving = new SimpleDoubleProperty(0);
	private SimpleDoubleProperty transactionTotal = new SimpleDoubleProperty(0);

	public TransactionData(Transaction transaction)
	{
		this._id = transaction.get_id();

		Date temp = transaction.getTransDate();
		System.out.println(temp);
		transDate.set(temp);

		this.transDate.set(transaction.getTransDate());
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
	public Date getTransDate()
	{
		return transDate.get();
	}

	public void setTransDate(Date transDate)
	{
		this.transDate.set(transDate);
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
	}

	public void setGas(double gas)
	{
		this.gas.set(gas);
		addTotal();
	}

	// ----------------------------------------
	public double getService()
	{
		return service.get();
	}

	public void setService(double service)
	{
		this.service.set(service);
		addTotal();
	}

	// ----------------------------------------
	public double getJohn()
	{
		return john.get();
	}

	public void setJohn(double john)
	{
		this.john.set(john);
		addTotal();
	}

	// ----------------------------------------
	public double getPastor()
	{
		return pastor.get();
	}

	public void setPastor(double pastor)
	{
		this.pastor.set(pastor);
		addTotal();
	}

	// ----------------------------------------
	public double getMed()
	{
		return med.get();
	}

	public void setMed(double med)
	{
		this.med.set(med);
		addTotal();
	}

	// ----------------------------------------
	public double getSchool()
	{
		return school.get();
	}

	public void setSchool(double school)
	{
		this.school.set(school);
		addTotal();
	}

	// ----------------------------------------
	public double getMisc()
	{
		return misc.get();
	}

	public void setMisc(double misc)
	{
		this.misc.set(misc);
		addTotal();
	}

	// ----------------------------------------
	public double getTax()
	{
		return tax.get();
	}

	public void setTax(double tax)
	{
		this.tax.set(tax);
		addTotal();
	}

	// ----------------------------------------
	public double getSaving()
	{
		return saving.get();
	}

	public void setSaving(double saving)
	{
		this.saving.set(saving);
		addTotal();
	}

	// ----------------------------------------
	public double getTransactionTotal()
	{
		return transactionTotal.get();
	}

	private void addTotal()
	{
		double temp;
		temp = gas.get() + service.get() + john.get() +
						pastor.get() + med.get() + school.get() + misc.get() +
						tax.get() + saving.get();
		transactionTotal.set(Util.round(temp, 2));
	}

	@Override
	public String toString()
	{
		return "TransactionData [_id=" +
						_id +
						", transDate=" +
						transDate +
						", discription=" +
						discription + "]";
	}

}
