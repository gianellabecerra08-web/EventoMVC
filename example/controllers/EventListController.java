package controllers;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;
import views.EventListView;


/**
 * Responsible for EventListView behavior.
 */
public class EventListController extends Controller
{
	//-----------------------------------------------------------------------
	//    Attributes
	//-----------------------------------------------------------------------
	private EventListView eventListView;
	private JTable table;


	//-----------------------------------------------------------------------
	//    Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		table = new JTable(getDataColumns(), getNameColumns());
		eventListView = new EventListView(this, table);
	}

	/**
	 * Adds a new row in the JTable.
	 */
	public void addNewRow(Object[] values)
	{
		((DefaultTableModel) table.getModel()).addRow(values);
	}

	/**
	 * Removes a row from the JTable by index (0-based).
	 * NUEVO: necesario para RemoveEventView
	 */
	public void removeRow(int rowIndex)
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (rowIndex < 0 || rowIndex >= model.getRowCount()) {
			throw new IllegalArgumentException("Fila inválida: " + (rowIndex + 1));
		}
		model.removeRow(rowIndex);
	}


	//-----------------------------------------------------------------------
	//    Getters
	//-----------------------------------------------------------------------
	public EventListView getView()
	{
		return eventListView;
	}

	public Vector<String> getNameColumns()
	{
		Vector<String> nameColumns = new Vector<String>();
		nameColumns.add("Date");
		nameColumns.add("Description");
		nameColumns.add("Frequency");
		nameColumns.add("E-mail");
		nameColumns.add("Alarm");
		return nameColumns;
	}

	public Vector<Vector<Object>> getDataColumns()
	{
		Vector<Vector<Object>> dataColumns = null;
		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			schedulerIO.attach(eventListView);
			dataColumns = schedulerIO.getEvents();
		} catch (Exception ex) { }
		return dataColumns;
	}
}