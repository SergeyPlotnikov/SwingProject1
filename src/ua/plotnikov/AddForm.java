package ua.plotnikov;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddForm
{
	private JTextField surnameTextField;
	private JTextField initialsTextField;
	private JLabel surnameLabel;
	private JLabel initialsLabel;
	private JButton addButton;
	private JButton exitButton;

	public void createGUI()
	{
		final JFrame addForm = new JFrame();
		addForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		addForm.setSize(new Dimension(300, 100));
		addForm.setLocationRelativeTo(addForm);
		addForm.setLayout(new GridBagLayout());

		surnameTextField = new JTextField(10);
		initialsTextField = new JTextField(10);
		surnameLabel = new JLabel("Прізвище:");
		initialsLabel = new JLabel("Ініціали:");
		addButton = new JButton("Додати");
		exitButton = new JButton("Закрити");
		addForm.add(surnameLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		addForm.add(initialsLabel, new GridBagConstraints(1, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		addForm.add(surnameTextField, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		addForm.add(initialsTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		addForm.add(addButton, new GridBagConstraints(1, 2, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));

		addForm.add(exitButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
		addButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] row = new String[2];
				String surname = surnameTextField.getText();
				String initials = initialsTextField.getText();
				row[0] = surname;
				row[1] = initials;
				Table.bmt.add(row);
				Table.bmt.fireTableDataChanged();
				surnameTextField.setText("");
				initialsTextField.setText("");
			}
		});

		exitButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				addForm.dispose();
			}
		});
		addForm.setVisible(true);
	}
}