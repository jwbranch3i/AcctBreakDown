package dataModel;

import java.util.Date;

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
		// SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
		// String sDate = formatter.format(transDate.get());
		// return sDate;
	}

	public void setTransDate(
					Date transDate)
	{
		this.transDate.set(transDate);
	}

	// ----------------------------------------
	public String getDiscription()
	{
		return discription.get();
	}

	public void setDiscription(
					String discription)
	{
		this.discription.set(discription);
	}

	// ----------------------------------------
	public double getDoubleGas()
	{
		return gas.get();
	}

	public double getGas()
	{
		return gas.get();
	}

	// public String getGas()
	// {
	// if (gas.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", gas.get());
	// }
	// }

	public void setGas(double gas)
	{
		this.gas.set(gas);
	}

	// ----------------------------------------
	public double getDoubleService()
	{
		return service.get();
	}

	public double getService()
	{
		return service.get();
	}
	// public String getService()
	// {
	// if (service.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", service.get());
	// }
	// }

	public void setService(double service)
	{
		this.service.set(service);
	}

	// ----------------------------------------
	public double getDoubleJohn()
	{
		return john.get();
	}

	public double getJohn()
	{
		return john.get();
	}
	// public String getJohn()
	// {
	// if (john.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", john.get());
	// }
	// }

	public void setJohn(double john)
	{
		this.john.set(john);
	}

	// ----------------------------------------
	public double getDoublePastor()
	{
		return pastor.get();
	}

	public double getPastor()
	{
		return pastor.get();
	}
	// public String getPastor()
	// {
	// if (pastor.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", pastor.get());
	// }
	// }

	public void setPastor(double pastor)
	{
		this.pastor.set(pastor);
	}

	// ----------------------------------------
	public double getDoubleMed()
	{
		return med.get();
	}

	public double getMed()
	{
		return med.get();
	}
	// public String getMed()
	// {
	// if (med.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", med.get());
	// }
	// }

	public void setMed(double med)
	{
		this.med.set(med);
	}

	// ----------------------------------------
	public double getDoubleSchool()
	{
		return school.get();
	}

	public double getSchool()
	{
		return school.get();
	}
	// public String getSchool()
	// {
	// if (school.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", school.get());
	// }
	// }

	public void setSchool(double school)
	{
		this.school.set(school);
	}

	// ----------------------------------------
	public double getDoubleMisc()
	{
		return misc.get();
	}

	public double getMisc()
	{
		return misc.get();
	}
	// public String getMisc()
	// {
	// if (misc.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", misc.get());
	// }
	// }

	public void setMisc(double misc)
	{
		this.misc.set(misc);
	}

	// ----------------------------------------
	public double getDoubleTax()
	{
		return tax.get();
	}

	public double getTax()
	{
		return tax.get();
	}
	// public String getTax()
	// {
	// if (tax.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", tax.get());
	// }
	// }

	public void setTax(double tax)
	{
		this.tax.set(tax);
	}

	// ----------------------------------------
	public double getDoubleSaving()
	{
		return saving.get();
	}

	public double getSaving()
	{
		return saving.get();
	}
	// public String getSaving()
	// {
	// if (saving.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", saving.get());
	// }
	// }

	public void setSaving(double saving)
	{
		this.saving.set(saving);
	}

	// ----------------------------------------
	public double getDoubleTransactionTotal()
	{
		return transactionTotal.get();
	}

	public double getTransactionTotal()
	{
		return transactionTotal.get();
	}
	// public String getTransactionTotal()
	// {
	// if (transactionTotal.get() == 0.)
	// {
	// return "";
	// }
	// else
	// {
	// return String.format("%.2f", transactionTotal.get());
	// }
	// }

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
