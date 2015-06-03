package ua.plotnikov;

import javax.swing.SwingUtilities;

public class MainProgram
{

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				new MainMenu();
			}
		});
	
		}

}
