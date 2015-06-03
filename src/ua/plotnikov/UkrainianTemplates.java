package ua.plotnikov;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UkrainianTemplates extends Tamplate
{

	protected UkrainianTemplates(int selectedTamplate)
	{
		super(selectedTamplate);

	}

	@Override
	protected void addElenents(int index, HashMap<String, JTextField> hashMap)
	{
		switch (index)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		{
			addTextField(fieldPanel, "titleBook", "Назва посібника: ", hashMap);
			addTextField(fieldPanel, "translator", "Перекладач: ", hashMap);
			addTextField(fieldPanel, "language",
					"Мова оригіналу (у род. відмінку ж.р.):", hashMap);
			addTextField(fieldPanel, "note", "Примітка до посібника: ", hashMap);
			addTextField(fieldPanel, "type", "Тип(монографія і т.д.):", hashMap);
			addTextField(fieldPanel, "city", "Місто: ", hashMap);
			addTextField(fieldPanel, "publishing", "Видавництво:", hashMap);
			addTextField(fieldPanel, "year", "Рік:", hashMap);
			addTextField(fieldPanel, "amount", "Кількість сторінок: ", hashMap);
			addTextField(fieldPanel, "ISBN", "ISBN: ", hashMap);
			break;
		}
		case 4:
		{
			addTextField(fieldPanel, "titleBook", "Назва посібника: ", hashMap);
			addTextField(fieldPanel, "translator", "Перекладач: ", hashMap);
			addTextField(fieldPanel, "language",
					"Мова оригіналу (у род. відмінку ж.р.):", hashMap);
			addTextField(fieldPanel, "type", "Тип(монографія і т.д.):", hashMap);
			addTextField(fieldPanel, "city", "Місто: ", hashMap);
			addTextField(fieldPanel, "publishing", "Видавництво:", hashMap);
			addTextField(fieldPanel, "year", "Рік:", hashMap);
			addTextField(fieldPanel, "amount", "Кількість сторінок: ", hashMap);
			addTextField(fieldPanel, "contents", "Зміст: ", hashMap);
			addTextField(fieldPanel, "ISBN", "ISBN: ", hashMap);
			break;
		}
		case 5:
		{
			addTextField(fieldPanel, "titleBook", "Назва посібника: ", hashMap);
			addTextField(fieldPanel, "translator", "Перекладач: ", hashMap);
			addTextField(fieldPanel, "language",
					"Мова оригіналу (у род. відмінку ж.р.):", hashMap);
			addTextField(fieldPanel, "type", "Тип(монографія і т.д.):", hashMap);
			addTextField(fieldPanel, "city", "Місто: ", hashMap);
			addTextField(fieldPanel, "publishing", "Видавництво:", hashMap);
			addTextField(fieldPanel, "year", "Рік:", hashMap);
			addTextField(fieldPanel, "amount", "Кількість сторінок: ", hashMap);
			addTextField(fieldPanel, "ISBN", "ISBN: ", hashMap);
			break;
		}
		case 6:
		{
			addTextField(fieldPanel, "titleBook", "Назва: ", hashMap);
			addTextField(fieldPanel, "description", "Опис конференції: ",
					hashMap);
			addTextField(fieldPanel, "cityEvent", "Місто проведення: ", hashMap);
			addTextField(fieldPanel, "dateEvent", "Дата проведення:", hashMap);
			addTextField(fieldPanel, "cityPrint", "Місто, де друкувалось: ",
					hashMap);
			addTextField(fieldPanel, "publishing", "Видавництво:", hashMap);
			addTextField(fieldPanel, "year", "Рік:", hashMap);
			addTextField(fieldPanel, "amount", "Кількість сторінок: ", hashMap);
			addTextField(fieldPanel, "ISBN", "ISBN: ", hashMap);
			break;
		}
		default:
		{
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
			if (table.bmt.getRowCount() != 1)
			{
				JOptionPane.showMessageDialog(null,
						"Введена невірна кількість авторів", "Попередження!",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(0, 1).toString(),
					map.get("titleBook").getText(),
					table.bmt.getValueAt(0, 1).toString(),
					table.bmt.getValueAt(0, 0).toString(),
					map.get("translator").getText(),
					map.get("language").getText(), map.get("note").getText(),
					map.get("type").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] a = { ",", " ", " / ", " ", ";", " ", "]", ";", " ", "-",
					",", ".-", "c. ", "." };
			String[] b = { " ", " ", " ", " ", "", "[пер. с ", " ", "- ", "- ",
					".-", ":", " ", " ", "-ISBN" };
			showTextArea(replacement, a, b);
			break;
		}
		case 1:
		{
			if (table.bmt.getRowCount() != 2)
			{
				JOptionPane.showMessageDialog(null,
						"Введена невірна кількість авторів", "Попередження!",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(0, 1).toString(),
					map.get("titleBook").getText(),
					table.bmt.getValueAt(0, 1).toString(),
					table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(1, 1).toString(),
					table.bmt.getValueAt(1, 0).toString(),
					map.get("translator").getText(),
					map.get("language").getText(), map.get("note").getText(),
					map.get("type").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] a = { ",", " ", " / ", " ", ", ", " ", ";", " ", "];",
					";", " ", "-", ",", ".-", "c. ", "." };
			String[] b = { " ", " ", " ", " ", " ", " ", "", "[пер. с ", " ",
					"- ", "- ", ".-", ":", " ", " ", ".-ISBN" };
			showTextArea(replacement, a, b);
			break;
		}
		case 2:
		{
			if (table.bmt.getRowCount() != 3)
			{
				JOptionPane.showMessageDialog(null,
						"Введена невірна кількість авторів", "Попередження!",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(0, 1).toString(),
					map.get("titleBook").getText(),
					table.bmt.getValueAt(0, 1).toString(),
					table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(1, 1).toString(),
					table.bmt.getValueAt(1, 0).toString(),
					table.bmt.getValueAt(2, 1).toString(),
					table.bmt.getValueAt(2, 0).toString(),
					map.get("translator").getText(),
					map.get("language").getText(), map.get("note").getText(),
					map.get("type").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] a = { ",", " ", " / ", " ", ", ", " ", ", ", " ", ";",
					" ", "];", ";", " ", "-", ",", ".-", "c. ", "." };
			String[] b = { " ", " ", " ", " ", " ", " ", " ", " ", "",
					"[пер. с ", " ", "- ", "- ", ".-", ":", " ", " ", ".-ISBN" };
			showTextArea(replacement, a, b);
			break;
		}
		case 3:
		{
			if (table.bmt.getRowCount() < 4)
			{
				JOptionPane.showMessageDialog(null,
						"Введена невірна кількість авторів", "Попередження!",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
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
			String[] r = { map.get("titleBook").getText(),
					map.get("language").getText(),
					map.get("translator").getText(), map.get("note").getText(),
					map.get("type").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, 2);
			System.arraycopy(r, 0, replacement, 2, 1);

			for (int i = 1; i < t.length; i = i + 2)
			{
				replacement[i + 2] = t[i];
				replacement[i + 3] = t[i - 1];
			}
			System.arraycopy(r, 1, replacement, y + 3, r.length - 1);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar = { ",", " ", "/", ".", "].", ".", ".", " ", " ", ". ",
					" .", " ." };
			String[] br = { " ", " ", " ", " [перевод с ", "- ", "- ", "- ",
					"- ", ": ", ", ", "- ", "- ISBN " };

			String[] a = new String[60];
			Arrays.fill(a, "");
			String[] b = new String[60];
			Arrays.fill(b, "");

			System.arraycopy(ar, 0, a, 0, 3);
			System.arraycopy(br, 0, b, 0, 3);
			System.arraycopy(aa, 0, a, 3, y);
			System.arraycopy(bb, 0, b, 3, y);
			System.arraycopy(ar, 3, a, y + 3, ar.length - 3);
			System.arraycopy(br, 3, b, y + 3, br.length - 3);

			showTextArea(replacement, a, b);
			break;
		}

		case 4:
		{
			if (table.bmt.getRowCount() > 1)
			{
				JOptionPane.showMessageDialog(null,
						"Введена невірна кількість авторів", "Попередження!",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { table.bmt.getValueAt(0, 0).toString(),
					table.bmt.getValueAt(0, 1).toString(),
					map.get("titleBook").getText(), map.get("type").getText(),
					table.bmt.getValueAt(0, 1).toString(),
					table.bmt.getValueAt(0, 0).toString(),
					map.get("translator").getText(),
					map.get("language").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("contents").getText(),
					map.get("ISBN").getText() };
			String[] a = { ",", " ", ": ", "/ ", " ", "-", ".-", ":", ",",
					".-", ".-", ":", " ", "" };
			String[] b = { " ", " ", "-", "-", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", ".-ISBN" };
			showTextArea(replacement, a, b);
			break;
		}
		case 5:
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
			String[] r = { map.get("titleBook").getText(),
					map.get("type").getText(), map.get("language").getText(),
					map.get("translator").getText(), map.get("city").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] replacement = new String[30];
			Arrays.fill(replacement, "");
			System.arraycopy(t, 0, replacement, 0, 2);
			System.arraycopy(r, 0, replacement, 2, 1);

			for (int i = 1; i < t.length; i = i + 2)
			{
				replacement[i + 2] = t[i];
				replacement[i + 3] = t[i - 1];
			}
			System.arraycopy(r, 1, replacement, y + 3, r.length - 1);
			String[] aa = { ",", ",", ",", ",", ",", ",", ",", ",", ",", ",",
					",", ",", "," };
			String[] bb = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
					" ", " ", " ", " " };
			String[] ar = { ",", " ", ": ", ".", ".", " ]", " ", " ", " ",
					" стр." };
			String[] br = { " ", " ", " ", "-", "-[перевод с ", "-", ":", ",",
					".-", " ", " -ISBN " };

			String[] a = new String[60];
			Arrays.fill(a, "");
			String[] b = new String[60];
			Arrays.fill(b, "");

			System.arraycopy(ar, 0, a, 0, 3);
			System.arraycopy(br, 0, b, 0, 3);
			System.arraycopy(aa, 0, a, 3, y);
			System.arraycopy(bb, 0, b, 3, y);
			System.arraycopy(ar, 3, a, y + 3, ar.length - 3);
			System.arraycopy(br, 3, b, y + 3, br.length - 3);
			showTextArea(replacement, a, b);
			break;
		}
		case 6:
		{
			if (table.bmt.getRowCount() > 0)
			{
				JOptionPane.showMessageDialog(null,
						"Для данного раздела автор не предусмотрен",
						"Попередження!", JOptionPane.WARNING_MESSAGE);
				break;
			}
			String[] replacement = { map.get("titleBook").getText(),
					map.get("description").getText(),
					map.get("cityEvent").getText(),
					map.get("dateEvent").getText(),
					map.get("cityPrint").getText(),
					map.get("publishing").getText(), map.get("year").getText(),
					map.get("amount").getText(), map.get("ISBN").getText() };
			String[] a = { ":", ":", ",", ";", ":", ",", ".-", ".", "." };
			String[] b = { " ", " ", "-", " ", "-", "-", "-", " ", "-ISBN " };
			showTextArea(replacement, a, b);
			break;
		}

		}
	}
	
}