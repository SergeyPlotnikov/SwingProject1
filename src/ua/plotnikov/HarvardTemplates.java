package ua.plotnikov;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JTextField;

public class HarvardTemplates extends Tamplate
{

	protected HarvardTemplates(int selectedTamplate)
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
			addTextField(fieldPanel, "title", "Title: ", hashMap);
			addTextField(fieldPanel, "information",
					"Information about the re-release:", hashMap);
			addTextField(fieldPanel, "number", "Number of publications: ",
					hashMap);
			addTextField(fieldPanel, "chapter", "Chapter:", hashMap);
			addTextField(fieldPanel, "publishing", "Publishing:", hashMap);
			addTextField(fieldPanel, "city", "City edition: ", hashMap);
			addTextField(fieldPanel, "amount", "Number of pages: ", hashMap);
			break;

		}
		case 1:
		{
			addTextField(fieldPanel, "year", "Imprint date: ", hashMap);
			addTextField(fieldPanel, "articleTitle", "Article title: ", hashMap);
			addTextField(fieldPanel, "bookTitle", "Book title:", hashMap);
			addTextField(fieldPanel, "publishing", "Publishing:", hashMap);
			addTextField(fieldPanel, "city", "City edition: ", hashMap);
			addTextField(fieldPanel, "location",
					"Location of the article (page): ", hashMap);
			break;
		}
		case 2:
		{
			addTextField(fieldPanel, "year", "Imprint date: ", hashMap);
			addTextField(fieldPanel, "articleTitle", "Article title: ", hashMap);
			addTextField(fieldPanel, "magazineTitle", "Magazine title:",
					hashMap);
			addTextField(fieldPanel, "publishing", "Publishing:", hashMap);
			addTextField(fieldPanel, "issueNumber", "Issue number: ", hashMap);
			addTextField(fieldPanel, "location",
					"Location of the article (page): ", hashMap);
			break;
		}
		case 3:
		{
			addTextField(fieldPanel, "year", "Imprint date: ", hashMap);
			addTextField(fieldPanel, "title", "Title: ", hashMap);
			addTextField(fieldPanel, "URL", "URL:", hashMap);
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
			String[] r = { map.get("year").getText(),
					map.get("title").getText(),
					map.get("information").getText(),
					map.get("number").getText(), map.get("chapter").getText(),
					map.get("publishing").getText(), map.get("city").getText(),
					map.get("amount").getText() };
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", ",", ",", ",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " ," "," "," "," "," "};
			String[] ar = {  "),", ":", ".", "ed,", "", ", ", ", ",
					" p."};
			String[] br = { "(", " ", " ", " ", " ", ", ", " ", " "};
			
			String[] a = new String[60];
			Arrays.fill(a, "");
			String[] b = new String[60];
			Arrays.fill(b, "");

			System.arraycopy(aa, 0, a, 0, y);
			System.arraycopy(bb, 0, b, 0, y);
			System.arraycopy(ar, 0, a, y , ar.length);
			System.arraycopy(br, 0, b, y , br.length);
	
		
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
			String[] r = { map.get("year").getText(),
					map.get("articleTitle").getText(),
					map.get("bookTitle").getText(),
					map.get("publishing").getText(), map.get("city").getText(),
					map.get("location").getText() };
			
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar ={"),", "\",", ",", ",", ",", "." };
			String[] br = { "(", "\"", " ", " ", " ", " pp. "};
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
			String[] r = { map.get("year").getText(),
					map.get("articleTitle").getText(),
					map.get("magazineTitle").getText(),
					map.get("publishing").getText(),
					map.get("issueNumber").getText(),
					map.get("location").getText()  };
			
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar ={ "),", "\",", ",", ", ", " ", "." };
			String[] br = { "(", "\"", " ", " ", " No. ", ",pp. "};
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
		case 3:
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
					map.get("URL").getText()};
		
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, y);
			System.arraycopy(r, 0, replacement, y, r.length);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar = {  ",", "\"", " " };
			String[] br = {  " ", "\"", ", available at:" };
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

		}
	}

}
