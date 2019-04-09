package crypto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptotgraphy {

	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',  'y', 'z'};
		char[] alphaUP = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',  'Y', 'Z'};
		String result =  "";
		System.out.print("Please Enter Your File Name:   ");
			String name = scan.nextLine();
		String newname = "";
		Scanner inputFile = new Scanner(new File(name));
		for(int k = 0; k < name.length(); k++)
		{
			if(!isLower(name.charAt(k)) && !isUpper(name.charAt(k)))
			{
				newname = name.substring(0,k);
			}
		}
		PrintWriter outputfile = new  PrintWriter(newname + "_ENC.txt");
		while(inputFile.hasNext()) 
		{
			String line = inputFile.nextLine();
			String encrypt = line;
			for(int i = 0; i <encrypt.length(); i++)
			{
				if(!isLower(encrypt.charAt(i)) && !isUpper(encrypt.charAt(i)))
				{
					outputfile.append(encrypt.charAt(i));
					continue;
				}
				for(int j = 0; j <26; j++)
				{
					if(encrypt.charAt(i) == alpha[j])
					{
						int b = (alpha[j] -100) % 26;
						if (b<0)
						{
							outputfile.append(alpha[alpha.length +  b]);
						}
						else			
							outputfile.append(alpha[b]);
					}
					else if (encrypt.charAt(i) == alphaUP[j])
					{
						int  b = (alphaUP[j] - 68) % 26;
						if (b < 0)
						{
							outputfile.append(alphaUP[alphaUP.length + b]);
						}
						else
						{
							outputfile.append(alphaUP[b]);
						}
					}
					}
				}
			
			outputfile.println();
			}
		System.out.print("The code was written to " + newname  + "_ENC.txt");
}
public static boolean isLower(char c)
{
	return (c >= 'a' && c <= 'z');
}
public static boolean isUpper(char c)
{
	return (c >= 'A' && c <= 'Z');
}
}