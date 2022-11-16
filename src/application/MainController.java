package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dataModel.AcctData;
import dataModel.TransactionData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import tableEditFiles.EditCell;
import tableEditFiles.MyDateStringConverter;
import tableEditFiles.MyDoubleStringConverter;

public class MainController
{
	@FXML
	private TableView<TransactionData> table;

	@FXML
	private TableColumn<TransactionData, Date> colDate;

	@FXML
	private TableColumn<TransactionData, String> colDiscription;

	@FXML
	private TableColumn<TransactionData, Double> colGas;

	@FXML
	private TableColumn<TransactionData, Double> colService;

	@FXML
	private TableColumn<TransactionData, Double> colJohn;

	@FXML
	private TableColumn<TransactionData, Double> colPastor;

	@FXML
	private TableColumn<TransactionData, Double> colMed;

	@FXML
	private TableColumn<TransactionData, Double> colSchool;

	@FXML
	private TableColumn<TransactionData, Double> colMisc;

	@FXML
	private TableColumn<TransactionData, Double> colTransactionTotal;

	@FXML
	private Label totalGas;

	@FXML
	private Label totalService;

	@FXML
	private Label totalJohn;

	@FXML
	private Label totalPastor;

	@FXML
	private Label totalMed;

	@FXML
	private Label totalSchool;

	@FXML
	private Label totalMisc;

	@FXML
	private Label totalAcct;

	private static final String DATE_PATTERN = "MM/dd/yyy";
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_PATTERN);

	public void initialize()
	{
		DATE_FORMATTER.setLenient(false);

		colDate.setCellValueFactory(new PropertyValueFactory<TransactionData, Date>("transDate"));
		colDate.setCellFactory(EditCell.<TransactionData, Date>forTableColumn(new MyDateStringConverter(DATE_PATTERN)));
		colDate.setOnEditCommit(e -> colDate_OnEditCommit((Event) e));

		colDiscription.setCellValueFactory(new PropertyValueFactory<TransactionData, String>("discription"));
		colDiscription.setCellFactory(TextFieldTableCell.forTableColumn());
		colDiscription.setOnEditCommit(e -> colDiscription_OnEditCommit((Event) e));

		colGas.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("gas"));
		colGas.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colGas.setOnEditCommit(e -> colGas_OnEditCommit((Event) e));

		colService.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("service"));
		colService.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colService.setOnEditCommit(e -> colService_OnEditCommit((Event) e));

		colJohn.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("john"));
		colJohn.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colJohn.setOnEditCommit(e -> colJohn_OnEditCommit((Event) e));

		colPastor.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("pastor"));
		colPastor.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colPastor.setOnEditCommit(e -> colPastor_OnEditCommit((Event) e));

		colMed.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("med"));
		colMed.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colMed.setOnEditCommit(e -> colMed_OnEditCommit((Event) e));

		colSchool.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("school"));
		colSchool.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colSchool.setOnEditCommit(e -> colSchool_OnEditCommit((Event) e));

		colMisc.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("misc"));
		colMisc.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colMisc.setOnEditCommit(e -> colMisc_OnEditCommit((Event) e));

		colTransactionTotal.setCellValueFactory(new PropertyValueFactory<TransactionData, Double>("transactionTotal"));
		colTransactionTotal.setCellFactory(EditCell.<TransactionData, Double>forTableColumn(new MyDoubleStringConverter()));
		colTransactionTotal.setStyle("-fx-alignment: CENTER-RIGHT");

		setTableEditable();

	}

	private void setTableEditable()
	{
		table.setEditable(true);
		// allows the individual cells to be selected
		table.getSelectionModel().cellSelectionEnabledProperty().set(true);
		// when character or numbers pressed it will start edit in editable
		// fields
		table.setOnKeyPressed(event ->
		{
			if (event.getCode().isLetterKey() ||
							event.getCode().isDigitKey() ||
							event.getCode().equals(KeyCode.DECIMAL) ||
							event.getCode().equals(KeyCode.MINUS) ||
							event.getCode().equals(KeyCode.SUBTRACT))
			{
				editFocusedCell();
			}
			else if (event.getCode()
							== KeyCode.RIGHT ||
							event.getCode() == KeyCode.TAB)
			{
				table.getSelectionModel().selectNext();
				event.consume();
			}
			else if (event.getCode()
							== KeyCode.LEFT)
			{
				// work around due to
				// TableView.getSelectionModel().selectPrevious() due to a bug
				// stopping it from working on
				// the first column in the last row of the table
				selectPrevious();
				event.consume();
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void editFocusedCell()
	{
		final TablePosition<TransactionData, ?> focusedCell = table.focusModelProperty().get().focusedCellProperty().get();
		table.edit(focusedCell.getRow(), focusedCell.getTableColumn());
	}

	@SuppressWarnings("unchecked")
	private void selectPrevious()
	{
		if (table.getSelectionModel().isCellSelectionEnabled())
		{
			// in cell selection mode, we have to wrap around, going from
			// right-to-left, and then wrapping to the end of the previous line
			TablePosition<TransactionData, ?> pos = table.getFocusModel().getFocusedCell();
			if (pos.getColumn() - 1 >= 0)
			{
				// go to previous row
				table.getSelectionModel().select(pos.getRow(), getTableColumn(pos.getTableColumn(), -1));
			}
			else if (pos.getRow()
							< table.getItems().size())
			{
				// wrap to end of previous row
				table.getSelectionModel().select(pos.getRow() -
								1, table.getVisibleLeafColumn(table.getVisibleLeafColumns().size() -
												1));
			}
		}
		else
		{
			int focusIndex = table.getFocusModel().getFocusedIndex();
			if (focusIndex == -1)
			{
				table.getSelectionModel().select(table.getItems().size() -
								1);
			}
			else if (focusIndex > 0)
			{
				table.getSelectionModel().select(focusIndex -
								1);
			}
		}
	}

	private TableColumn<TransactionData, ?>
					getTableColumn(final TableColumn<TransactionData, ?> column,
									int offset)
	{
		int columnIndex = table.getVisibleLeafIndex(column);
		int newColumnIndex = columnIndex +
						offset;
		return table.getVisibleLeafColumn(newColumnIndex);
	}

	/******************************************/
	public void listTotals()
	{

		@SuppressWarnings("unchecked")
		Task<ArrayList<Double>> task = new GetTotals();
		task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>()
		{
			@Override
			public void handle(WorkerStateEvent t)
			{
				ArrayList<Double> list = task.getValue();

				// fill total labels
				totalGas.setText(Util.makeDoubleString(list.get(0)));
				totalService.setText(Util.makeDoubleString(list.get(1)));
				totalJohn.setText(Util.makeDoubleString(list.get(2)));
				totalPastor.setText(Util.makeDoubleString(list.get(3)));
				totalMed.setText(Util.makeDoubleString(list.get(4)));
				totalSchool.setText(Util.makeDoubleString(list.get(5)));
				totalMisc.setText(Util.makeDoubleString(list.get(6)));

				Double sum = 0d;
				for (int i = 0; i < list.size(); i++)
				{
					sum += list.get(i);
				}

				totalAcct.setText(Util.makeDoubleString(sum));
			}
		});

		new Thread(task).start();

	}

	/******************************************/
	public void listTransactions()
	{
		@SuppressWarnings("unchecked")
		Task<ObservableList<TransactionData>> task = new GetAllTransactions();
		table.itemsProperty().bind(task.valueProperty());

		new Thread(task).start();
	}

	@SuppressWarnings("unchecked")
	public void colDate_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Date> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Date>) e;
		TransactionData working = ce.getRowValue();

		working.setTransDate(ce.getNewValue());

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_DATE, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colDiscription_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, String> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, String>) e;
		TransactionData working = ce.getRowValue();

		working.setDiscription(ce.getNewValue());

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_DISCRIPTION, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colGas_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();

			// update column total
			totalGas.setText(Util.makeDoubleString(Double.parseDouble(totalGas.getText()) -
							working.getGas() +
							temp));

			// update grand total
			double current = Double.parseDouble(totalAcct.getText());
			double old = working.getGas();
			double newVal = temp;

			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getGas() +
							temp));

			working.setGas(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_GAS, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colService_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalService.setText(Util.makeDoubleString(Double.parseDouble(totalService.getText()) -
							working.getService() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getService() +
							temp));

			working.setService(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_SERVICE, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colJohn_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalJohn.setText(Util.makeDoubleString(Double.parseDouble(totalJohn.getText()) -
							working.getJohn() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getJohn() +
							temp));

			working.setJohn(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_JOHN, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colPastor_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalPastor.setText(Util.makeDoubleString(Double.parseDouble(totalPastor.getText()) -
							working.getPastor() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getPastor() +
							temp));

			working.setPastor(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_PASTOR, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colMed_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalMed.setText(Util.makeDoubleString(Double.parseDouble(totalMed.getText()) -
							working.getMed() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getMed() +
							temp));

			working.setMed(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_MED, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colSchool_OnEditCommit(
					Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalSchool.setText(Util.makeDoubleString(Double.parseDouble(totalSchool.getText()) -
							working.getSchool() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getSchool() +
							temp));

			working.setSchool(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_SCHOOL, working);
		table.refresh();
	}

	@SuppressWarnings("unchecked")
	public void colMisc_OnEditCommit(Event e)
	{
		TableColumn.CellEditEvent<TransactionData, Double> ce;
		ce = (TableColumn.CellEditEvent<TransactionData, Double>) e;
		TransactionData working = ce.getRowValue();
		try
		{
			// Double temp = Double.parseDouble(ce.getNewValue());
			Double temp = ce.getNewValue();
			totalMisc.setText(Util.makeDoubleString(Double.parseDouble(totalMisc.getText()) -
							working.getMisc() +
							temp));

			// update grand total
			totalAcct.setText(Util.makeDoubleString(Double.parseDouble(totalAcct.getText()) -
							working.getMisc() +
							temp));

			working.setMisc(temp);
		}
		catch (NumberFormatException ex)
		{
			table.refresh();
			return;
		}

		AcctData.getInstance().updateTransaction(AcctData.COL_TRANSACTIONS_MISC, working);
		table.refresh();
	}
}

/******************************************/
class GetTotals extends Task
{
	public ArrayList<Double> call()
	{
		ArrayList<Double> list;

		list = AcctData.getInstance().queryTotals();

		return list;
	}
}

/******************************************/
class GetAllTransactions extends Task
{
	public ObservableList<TransactionData>
					call()
	{
		return FXCollections.observableArrayList(AcctData.getInstance().queryTransactions(AcctData.ORDER_BY_ASC));

	}
}
