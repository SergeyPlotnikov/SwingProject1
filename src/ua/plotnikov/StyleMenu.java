package ua.plotnikov;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class StyleMenu
{
	protected JButton nextButton;
	protected JButton backButton;
	protected JLabel textLabel;
	protected JComboBox<String> comboBox;
	public static JFrame styleFrame;
	protected JPanel mainPanel;
	protected static final int DEFAULT_SIZE = 14;

	protected void createMenu()
	{
		styleFrame = new JFrame();
		styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		styleFrame.setSize(300, 200);
		styleFrame.setLayout(new BorderLayout());
		styleFrame.setLocationRelativeTo(null);
		styleFrame.setResizable(false);

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		styleFrame.add(mainPanel, BorderLayout.CENTER);
		textLabel = new JLabel("Виберіть, будь-ласка, джерело: ");
		textLabel.setFont(new Font("TimesRoman", Font.BOLD, DEFAULT_SIZE));
		mainPanel.add(textLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(10, 30, 1, 30), 0, 0));

		nextButton = new JButton("Далі");
		nextButton.setPreferredSize(new Dimension(80, 25));
		mainPanel.add(nextButton, new GridBagConstraints(0, 2, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.NONE,
				new Insets(5, 200, 10, 30), 0, 0));
		addComponents();

		mainPanel.add(comboBox, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 30, 10, 30), 0, 0));


		backButton = new JButton("Назад");
		backButton.setPreferredSize(new Dimension(80, 25));
		mainPanel.add(backButton, new GridBagConstraints(0, 3, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.NONE,
				new Insets(-50, -135, 10, 30), 0, 0));
		styleFrame.add(mainPanel, BorderLayout.CENTER);
		backButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				styleFrame.setVisible(false);
				MainMenu.mainFrame.setVisible(true);
			}
		});
		styleFrame.pack();
		styleFrame.setVisible(true);
	}
	
	protected abstract void addComponents();
}