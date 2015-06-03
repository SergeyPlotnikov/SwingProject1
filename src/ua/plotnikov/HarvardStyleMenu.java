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
		comboBox.addItem("�����(book)");
		comboBox.addItem("������ ������ �����(article of book)");
		comboBox.addItem("������ �������(article of magazine)");
		comboBox.addItem("����������� ������(web resource)");
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