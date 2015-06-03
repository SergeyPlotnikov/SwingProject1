package ua.plotnikov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class RussianStyleMenu extends StyleMenu
{
	public RussianStyleMenu()
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
		comboBox.addItem(" нига(более 3 авторов)");
		comboBox.addItem("—борник 1 автора");
		comboBox.addItem("—борники разных авторов");
		comboBox.addItem("ћатериалы конференций");
		nextButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				int selectedIndex = comboBox.getSelectedIndex();
				styleFrame.setVisible(false);
				new RussianTamplates(selectedIndex);
			}
		});
	}
}