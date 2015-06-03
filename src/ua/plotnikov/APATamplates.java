package ua.plotnikov;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class APATamplates extends Tamplate
{

	protected APATamplates(int selectedTamplate)
	{
		super(selectedTamplate);

	}

	@Override
	protected void addElenents(int index, HashMap<String, JTextField> hashMap)
	{
		switch (index)
		{
		case 0:
		{
			addTextField(fieldPanel, "year", "Imprint date: ", hashMap);
			addTextField(fieldPanel, "title", "Book title: ", hashMap);
			addTextField(fieldPanel, "publishing", "Publishing:", hashMap);
			addTextField(fieldPanel, "city", "City edition: ", hashMap);
			break;
		}
		case 1:
		{
			addTextField(fieldPanel, "title", "Title of the article: ", hashMap);
			addTextField(fieldPanel, "titleMagazine", "Name of the journal: ",
					hashMap);
			addTextField(fieldPanel, "issue", "Issue number:", hashMap);
			addTextField(fieldPanel, "page", "Page number: ", hashMap);
			break;
		}
		case 2:
		{
			addTextField(fieldPanel, "name", "Name of web page: ", hashMap);
			addTextField(fieldPanel, "date", "Year, day and month of issue: ",
					hashMap);
			addTextField(fieldPanel, "nameSite", "Name of the site:", hashMap);
			addTextField(fieldPanel, "webPage",
					"Reference to web page of news: ", hashMap);
			break;
		}
		}
	}

	private void showTextArea(String[] replacement, String[] a, String[] b)
	{
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < replacement.length; i++)
		{
			if (replacement[i].equals(""))
			{
				str = str.append(replacement[i]);
			} else
			{
				str.append(b[i]).append(replacement[i]).append(a[i]);
			}
		}
		textArea.append(str.toString() + "\n");
	}

	@Override
	protected void resultShow(int index, HashMap<String, JTextField> map)
	{
		switch (index)
		{
		case 0:
		{
			String[] t = new String[table.bmt.getRowCount() * 2];
			int y = 0;
			for (String[] s : table.bmt.data)
			{
				for (int i = 0; i < s.length; i++)
				{
					t[y] = s[i];
					y++;
				}
			}
			String[] r = { map.get("year").getText(), map.get("title").getText(),
					map.get("city").getText(), map.get("publishing").getText()};
			
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar = {").", ",", ";", "\"." };
			String[] br = { "(", " ", " ", " \"" };
			String[] a = new String[60];
			Arrays.fill(a, "");
			String[] b = new String[60];
			Arrays.fill(b, "");
		
			System.arraycopy(aa, 0, a, 0, y);
			System.arraycopy(bb, 0, b, 0, y);
			System.arraycopy(ar, 0, a, y, ar.length);
			System.arraycopy(br, 0, b, y, br.length);
			showTextArea(replacement, a, b);
			break;
		}
		case 1:
		{

			String[] t = new String[table.bmt.getRowCount() * 2];
			int y = 0;
			for (String[] s : table.bmt.data)
			{
				for (int i = 0; i < s.length; i++)
				{
					t[y] = s[i];
					y++;
				}
			}
			String[] r = { map.get("title").getText(),
					map.get("titleMagazine").getText(),
					map.get("issue").getText(), map.get("page").getText()};
			
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar = { ",", "\";", ";", "." };
			String[] br = { " ", "\"", "№ ", " p. " };
			String[] a = new String[60];
			Arrays.fill(a, "");
			String[] b = new String[60];
			Arrays.fill(b, "");
		
			System.arraycopy(aa, 0, a, 0, y);
			System.arraycopy(bb, 0, b, 0, y);
			System.arraycopy(ar, 0, a, y, ar.length);
			System.arraycopy(br, 0, b, y, br.length);
			showTextArea(replacement, a, b);
			break;
		}
		case 2:
		{
			if (table.bmt.getRowCount() > 0)
			{
				JOptionPane.showMessageDialog(null,
						"Для данного раздела автор не предусмотрен",
						"Попередження!", JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { map.get("name").getText(),
					map.get("date").getText(), map.get("nameSite").getText(),
					map.get("webPage").getText() };
			String[] a = { " ", " ),", ". ", " " };
			String[] b = { " ", "( ", " ", "Доступ: " };
			showTextArea(replacement, a, b);
			break;
		}

		}
	}

}
