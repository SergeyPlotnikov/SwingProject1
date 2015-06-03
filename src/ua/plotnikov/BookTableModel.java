package ua.plotnikov;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int columnCount = 2;
	public List<String[]> data;

	public BookTableModel()
	{
		data = new ArrayList<String[]>();
	}

	@Override
	public int getColumnCount()
	{
		return columnCount;
	}

	@Override
	public int getRowCount()
	{
		return data.size();
	}

	//@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		
		String[] rows = data.get(rowIndex);
		return rows[columnIndex];
	
	}

	@Override
	public String getColumnName(int columnIndex)
	{
		switch (columnIndex)
		{
		case 0:
			return "Прізвище";
		case 1:
			return "Ініціали";
		}
		return "";
	}

	public void add(String[] row)
	{
		String[] rowTable = new String[getColumnCount()];
		rowTable = row;
		data.add(rowTable);
	}
}