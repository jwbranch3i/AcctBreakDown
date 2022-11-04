package dataModel;

import java.util.Date;

public class Transaction
{
	private Integer _id;
	private Date transDate;
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

	public Transaction(int id, Date transDate, String discription, double gas, double service, double john, double pastor, double med, double school, double misc, double tax, double saving, double saving_other)
	{
		this._id = id;
		this.transDate = transDate;
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

	public Transaction(int id, Date transDate, String discription, double gas, double service, double john, double pastor, double med, double school, double misc)
	{
		this._id = id;
		this.transDate = transDate;
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
		this.transDate = new Date();
		this.discription = "";
		this.gas = -1d;
		this.service = -1d;
		this.john = -1d;
		this.pastor = -1d;
		this.med = -1d;
		this.school = -1d;
		this.misc = -1d;

		this.tax = -1d;
		this.saving = -1d;

		this.transactionTotal = -1d;
	}

	public int get_id()
	{
		return _id;
	}

	public void set_id(int _id)
	{
		this._id = _id;
	}

	public Date getTransDate()
	{
		return transDate;
	}

	public void setTransDate(Date transDate)
	{
		this.transDate = transDate;
	}

	public String getDiscription()
	{
		return discription;
	}

	public void setDiscription(
					String discription)
	{
		this.discription = discription;
	}

	public double getGas()
	{
		return gas;
	}

	public void setGas(Double gas)
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

	public double getSavingOther()
	{
		return saving_other;
	}

	public void setSavingOther(double saving)
	{
		this.saving_other = saving;
		addTotal();
	}

	public double getTransactionTotal()
	{
		return transactionTotal;
	}

	private void addTotal()
	{
		transactionTotal = gas + service +
						john + pastor + med +
						school + misc + tax +
						saving;
	}

	@Override
	public String toString()
	{
		return "Transaction [_id=" + _id +
						", transDate=" +
						transDate +
						", discription=" +
						discription +
						", gas=" + gas +
						", service=" +
						service + ", john=" +
						john + ", pastor=" +
						pastor + ", med=" +
						med + ", school=" +
						school + ", misc=" +
						misc + ", tax=" +
						tax + ", saving=" +
						saving +
						", saving_other=" +
						saving_other +
						", transactionTotal=" +
						transactionTotal +
						"]";
	}

}
