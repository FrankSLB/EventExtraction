package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static extras.FileNames.*;

public class ParseSchema 
{
	public static void main(String[] args)
	{
		try
		{
			new ParseSchema().parse(M_S_O, M_S_R);
			System.out.println("<<Done parsing schema>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void parse(String input, String output)throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		
		Pattern pattern = Pattern.compile("A\\s*?\\d+\\s*?:\\s*?\\[.*\\]");
		Matcher matcher = null;
		HashSet<String> schemas_set = new HashSet<String>();
		String line = "";
		while((line = br.readLine()) != null)
		{
			matcher = pattern.matcher(line);
			if(matcher.find())
			{
				schemas_set.add(matcher.group());
			}
		}
		
		for(String s: schemas_set)
		{
			bw.write(s + "\n");
		}
		
		br.close();
		bw.close();
	}
}
