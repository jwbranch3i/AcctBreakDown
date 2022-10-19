package dataModel;

import java.time.LocalDate;

public class Transaction
{
	private int _id;
	private LocalDate date;
	private String discription;
	private double gas;
	private double service;
	private double john;
	private double pastor;
	private double med;
	private double school;
	private double misc;

	private double tax;
	private double saving;
	private double saving_other;
	private double transactionTotal;

	public Transaction(int id, LocalDate date, String discription, double gas, double service, double john,
					double pastor, double med, double school, double misc, double tax=0d, double saving,
					double saving_other)
	{
		this._id = id;
		this.date = date;;
		this.discription = discription;
		this.gas = gas;
		this.service = service;
		this.john = john;
		this.pastor = pastor;
		this.med = med;
		this.school = school;
		this.misc = misc;

		this.tax = tax;
		this.saving = saving;
		this.saving_other = saving_other;
	}

	public Transaction(int id, LocalDate date, String discription, double gas, double service, double john, double pastor, double med, double school, double misc)
	{
		this._id = id;
		this.date = date;
		;
		this.discription = discription;
		this.gas = gas;
		this.service = service;
		this.john = john;
		this.pastor = pastor;
		this.med = med;
		this.school = school;
		this.misc = misc;

		this.tax = 0d;
		this.saving = 0d;
		this.saving_other = 0d;
	}

	public Transaction()
	{
		this._id = 0;
		this.date = LocalDate.now();
		this.discription = "";
		this.gas = 0d;
		this.service = 0d;
		this.john = 0d;
		this.pastor = 0d;
		this.med = 0d;
		this.school = 0d;
		this.misc = 0d;

		this.tax = 0d;
		this.saving = 0d;
		this.transactionTotal = 0d;
	}

	public int get_id()
	{
		return _id;
	}

	public void set_id(int _id)
	{
		this._id = _id;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public String getDiscription()
	{
		return discription;
	}

	public void setDiscription(String discription)
	{
		this.discription = discription;
	}

	public double getGas()
	{
		return gas;
	}

	public void setGas(double gas)
	{
		this.gas = gas;
		addTotal();
	}

	public double getService()
	{
		return service;
	}

	public void setService(double service)
	{
		this.service = service;
		addTotal();
	}

	public double getJohn()
	{
		return john;
	}

	public void setJohn(double john)
	{
		this.john = john;
		addTotal();
	}

	public double getPastor()
	{
		return pastor;
	}

	public void setPastor(double pastor)
	{
		this.pastor = pastor;
		addTotal();
	}

	public double getMed()
	{
		return med;
	}

	public void setMed(double med)
	{
		this.med = med;
		addTotal();
	}

	public double getSchool()
	{
		return school;
	}

	public void setSchool(double school)
	{
		this.school = school;
		addTotal();
	}

	public double getMisc()
	{
		return misc;
	}

	public void setMisc(double misc)
	{
		this.misc = misc;
		addTotal();
	}

	public double getTax()
	{
		return tax;
	}

	public void setTax(double tax)
	{
		this.tax = tax;
		addTotal();
	}

	public double getSaving()
	{
		return saving;
	}

	public void setSaving(double saving)
	{
		this.saving = saving;
		addTotal();
	}

	public double getTransactionTotal()
	{
		return transactionTotal;
	}

	private void addTotal()
	{
		transactionTotal = gas
						+ service + john + pastor + med + school + misc + tax + saving;
	}

}
