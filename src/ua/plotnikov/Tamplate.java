package ua.plotnikov;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class Tamplate
{
	protected int selectedTamplate;
	protected JFrame bookFrame;
	protected JPanel westPanel;
	protected JPanel eastPanel;
	protected JPanel fieldPanel;
	protected JPanel buttonPanel;
	protected JButton resultButton;
	protected JTextArea textArea;
	protected JLabel resultLabel;
	protected JButton saveButton;
	protected JButton backButton;
	protected Table table;
	protected JButton clearTextAreaButton;
	protected static final int TEXTAREA_ROWS = 10;
	protected static final int TEXTAREA_COLUMNS = 35;

	protected abstract void addElenents(int index,
			HashMap<String, JTextField> hashMap);

	protected abstract void resultShow(int index,
			HashMap<String, JTextField> map);

	protected Tamplate(int selectedTamplate)
	{
		this.selectedTamplate = selectedTamplate;
		createInterface();
	}

	
	protected void createInterface()
	{
		bookFrame = new JFrame();
		bookFrame.setSize(800, 700);
		bookFrame.setLocationRelativeTo(null);
		bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bookFrame.setLayout(new GridLayout(1, 2));
		bookFrame.setResizable(false);

		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(400, 700));
		bookFrame.add(westPanel);

		table = new Table();
		westPanel.setLayout(new BorderLayout());
		westPanel.add(table.createGUI(), BorderLayout.NORTH);

		fieldPanel = new JPanel();
		fieldPanel.setPreferredSize(new Dimension(400, 400));
		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
		fieldPanel.add(Box.createRigidArea(new Dimension(30, 10)));

		final HashMap<String, JTextField> map = new HashMap<String, JTextField>();
		addElenents(selectedTamplate, map);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(10, 110));
		buttonPanel.setLayout(new GridBagLayout());

		resultButton = new JButton("Результат");
		buttonPanel.add(resultButton, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(
						25, 165, 1, 1), 0, 0));

		backButton = new JButton("Назад");
		buttonPanel.add(backButton, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(
						-10, 190, 1, 1), 0, 0));

		westPanel.add(buttonPanel, BorderLayout.SOUTH);
		westPanel.add(fieldPanel, BorderLayout.CENTER);

		eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(400, 730));
		eastPanel.setLayout(new GridBagLayout());

		resultLabel = new JLabel("Результат: ");
		Font font = new Font("Verdana", Font.BOLD, 15);
		resultLabel.setFont(font);
		eastPanel.add(resultLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(10, 150, 1, 1), 0, 0));

		textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		eastPanel.add(scrollPane, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(
						-150, 1, 1, 1), 0, 0));
		saveButton = new JButton("Зберегти данні");
		eastPanel.add(saveButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						-400, 265, 1, 1), 0, 0));
		clearTextAreaButton = new JButton("Очистити поле");
		eastPanel.add(clearTextAreaButton, new GridBagConstraints(0, 3, 1, 1,
				1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(-712, 1, 1, 1), 0, 0));

		bookFrame.add(eastPanel);
		backButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				bookFrame.setVisible(false);
				StyleMenu.styleFrame.setVisible(true);

			}
		});

		
		resultButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				resultShow(selectedTamplate, map);
				for (JTextField value : map.values())
				{
					value.setText("");
				}
			}

		});
		bookFrame.setVisible(true);

		saveButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					FileWriter fw = new FileWriter("Save.txt", true);
					fw.write(textArea.getText() + "\n");
					fw.close();
				} catch (IOException ex)
				{
					System.out.println(ex.getMessage());
				}

			}
		});
		clearTextAreaButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				textArea.setText("");
				
			}
		});
	}

	protected static void addTextField(Container container, String key,
			String textLabel, HashMap<String, JTextField> collection)
	{
		container.add(Box.createVerticalStrut(5));
		addLabel(textLabel, container);
		container.add(Box.createVerticalStrut(2));
		JTextField textField = new JTextField();
		textField.setMaximumSize(new Dimension(300, 20));
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.add(textField);
		collection.put(key, textField);
	}

	protected static void addLabel(String text, Container container)
	{
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		container.add(label);
	}
}