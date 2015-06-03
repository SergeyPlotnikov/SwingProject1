package ua.plotnikov;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class Table extends BookTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public   JPanel tablePanel;
	public static BookTableModel bmt;
	private JTable bookTable;
	public JButton addButton;
	
	public Table()
	{
	tablePanel = new JPanel();
	tablePanel.setPreferredSize(new Dimension(250, 120));
	tablePanel.setLayout(new BorderLayout());

	bmt = new BookTableModel();
	bookTable = new JTable(bmt);
	JScrollPane tableScrollPane = new JScrollPane(bookTable);
	addButton = new JButton("Додати");
	JButton removeButton = new JButton("Видалити");
	JButton clearButton = new JButton("Очистити таблицю");

	tablePanel.add(tableScrollPane, BorderLayout.CENTER);
	JPanel southButtonPanel = new JPanel();
	southButtonPanel.setLayout(new FlowLayout());
	southButtonPanel.setPreferredSize(new Dimension(250, 30));
	southButtonPanel.add(addButton);
	southButtonPanel.add(removeButton);
	southButtonPanel.add(clearButton);
	tablePanel.add(southButtonPanel, BorderLayout.SOUTH);

	addButton.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AddForm addForm = new AddForm();
			addForm.createGUI();
		}
	});
	removeButton.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				int i = bookTable.getSelectedRow();
				bmt.data.remove(i);
				bmt.fireTableDataChanged();
			} catch (ArrayIndexOutOfBoundsException ex)
			{
				System.out.println("Выберите рядок для удаления");
			}
		}
	});

	clearButton.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			while (bmt.getRowCount() > 0)
			{
				bmt.data.remove(0);
			}
			bmt.fireTableRowsDeleted(0, bmt.data.size());
		}
	});

	Border border = BorderFactory.createEtchedBorder();
	Border title = BorderFactory.createTitledBorder(border);
	tablePanel.setBorder(title);
	}
	
	public JComponent createGUI()
	{
		return tablePanel;
	}
	public Object getValue(int row,int column)
	{
		return getValueAt(row, column);
	}
}
