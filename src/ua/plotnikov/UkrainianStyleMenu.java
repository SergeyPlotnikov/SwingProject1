package ua.plotnikov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class UkrainianStyleMenu extends StyleMenu
{
	public UkrainianStyleMenu()
	{
		createMenu();
	}

	@Override
	protected void addComponents()
	{
		comboBox = new JComboBox<String>();
		comboBox.addItem(" нига(1 автор)");
		comboBox.addItem(" нига(2 автора)");
		comboBox.addItem(" нига(3 автора)");
		comboBox.addItem(" нига(б≥льше 3 автор≥в)");
		comboBox.addItem("«б≥рник 1 автора");
		comboBox.addItem("«б≥рник р≥зних автор≥в");
		comboBox.addItem("ћатер≥али конференц≥й");
		nextButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = comboBox.getSelectedIndex();
				styleFrame.setVisible(false);
				new UkrainianTemplates(selectedIndex);
			}
		});
	}
}