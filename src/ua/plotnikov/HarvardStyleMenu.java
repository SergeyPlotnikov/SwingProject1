package ua.plotnikov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class HarvardStyleMenu extends StyleMenu
{

	public HarvardStyleMenu()
	{
		createMenu();
	}

	@Override
	protected void addComponents()
	{
		comboBox = new JComboBox<String>();
		comboBox.addItem("Книга(book)");
		comboBox.addItem("Окрема стаття книги(article of book)");
		comboBox.addItem("Стаття журнала(article of magazine)");
		comboBox.addItem("Електронний ресурс(web resource)");
		nextButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = comboBox.getSelectedIndex();
				styleFrame.setVisible(false);
				new HarvardTemplates(selectedIndex);
			}
		});
	}
}