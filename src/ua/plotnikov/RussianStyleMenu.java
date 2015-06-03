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
		comboBox.addItem("�����(1 �����)");
		comboBox.addItem("�����(2 ������)");
		comboBox.addItem("�����(3 ������)");
		comboBox.addItem("�����(����� 3 �������)");
		comboBox.addItem("������� 1 ������");
		comboBox.addItem("�������� ������ �������");
		comboBox.addItem("��������� �����������");
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