package ua.plotnikov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class APAStyleMenu extends StyleMenu
{
	public APAStyleMenu()
	{
		createMenu();
	}

	@Override
	protected void addComponents()
	{
		comboBox = new JComboBox<String>();
		comboBox.addItem("Книга(book)");
		comboBox.addItem("Журнал(magazine)");
		comboBox.addItem("Електронний ресурс(web resource)");
		nextButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = comboBox.getSelectedIndex();
				styleFrame.setVisible(false);
				new APATamplates(selectedIndex);
			}
		});
	}
}