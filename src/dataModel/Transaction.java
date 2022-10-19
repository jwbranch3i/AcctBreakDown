package dataModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Transaction
{
	private Integer _id = 0;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ObjectProperty<LocalDate> transactionDate = new SimpleObjectProperty(LocalDate.now());
	private SimpleStringProperty discription = new SimpleStringProperty("");
	private SimpleDoubleProperty gas = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty service = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty john = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty pastor = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty med = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty school = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty misc = new SimpleDoubleProperty(0.0);

	private SimpleDoubleProperty tax = new SimpleDoubleProperty(0.0);
	private SimpleDoubleProperty saving = new SimpleDoubleProperty(0.0);

	private SimpleDoubleProperty transactionTotal = new SimpleDoubleProperty(0.0);

	public Transaction()
	{
	}

	// ----------------------------------------
	public Integer get_id()
	{
		return _id;
	}

	// ----------------------------------------
	public void set_id(Integer _id)
	{
		this._id = _id;
	}

	// ----------------------------------------
	public String getTransactionDate()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		return formatter.format(transactionDate.get());
	}

	public void setTransactionDate(LocalDate date)
	{
		this.transactionDate.set(date);
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
	public double getDoubleGas()
	{
		return gas.get();
	}

	public String getGas()
	{
		if (gas.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", gas.get());
		}
	}

	public void setGas(double gas)
	{
		this.gas.set(gas);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleService()
	{
		return service.get();
	}

	public String getService()
	{
		if (service.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", service.get());
		}
	}

	public void setService(double service)
	{
		this.service.set(service);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleJohn()
	{
		return john.get();
	}

	public String getJohn()
	{
		if (john.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", john.get());
		}
	}

	public void setJohn(double john)
	{
		this.john.set(john);
		addTotal();
	}

	// ----------------------------------------
	public double getDoublePastor()
	{
		return pastor.get();
	}

	public String getPastor()
	{
		if (pastor.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", pastor.get());
		}
	}

	public void setPastor(double pastor)
	{
		this.pastor.set(pastor);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleMed()
	{
		return med.get();
	}

	public String getMed()
	{
		if (med.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", med.get());
		}
	}

	public void setMed(double med)
	{
		this.med.set(med);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleSchool()
	{
		return school.get();
	}

	public String getSchool()
	{
		if (school.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", school.get());
		}
	}

	public void setSchool(double school)
	{
		this.school.set(school);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleMisc()
	{
		return misc.get();
	}

	public String getMisc()
	{
		if (misc.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", misc.get());
		}
	}

	public void setMisc(double misc)
	{
		this.misc.set(misc);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleTax()
	{
		return tax.get();
	}

	public String getTax()
	{
		if (tax.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", tax.get());
		}
	}

	public void setTax(double tax)
	{
		this.tax.set(tax);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleSavings()
	{
		return saving.get();
	}

	public String getSaving()
	{
		if (saving.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", saving.get());
		}
	}

	public void setSaving(double saving)
	{
		this.saving.set(saving);
		addTotal();
	}

	// ----------------------------------------
	public double getDoubleTransactionTotal()
	{
		return transactionTotal.get();
	}

	public String getTransactionTotal()
	{
		if (transactionTotal.get() == 0.)
		{
			return "";
		}
		else
		{
			return String.format("%.2f", transactionTotal.get());
		}
	}

	private void setTransactionTotal(double transactionTotal)
	{
		this.transactionTotal.set(transactionTotal);
	}

	private void addTotal()
	{
		transactionTotal.set(gas.get()
						+ service.get() + john.get() + pastor.get() + med.get()
						+ school.get() + misc.get() + tax.get() + saving.get());
	}

	@Override
	public String toString()
	{
		return "Transaction [_id="
						+ _id + ", \ntransactionDate=" + transactionDate
						+ ", \ndiscription=" + discription + ", \ngas=" + gas
						+ ", \nservice=" + service + ", \njohn=" + john + ", \npastor="
						+ pastor + ", \nmed=" + med + ", \nschool=" + school + ", \nmisc="
						+ misc + ", \ntax=" + tax + ", \nsaving=" + saving
						+ ", \ntransactionTotal=" + transactionTotal + "]";
	}

}
