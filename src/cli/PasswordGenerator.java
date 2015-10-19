import java.util.Random;

public class PasswordGenerator
{
	public static void main(String[] arg)
	{
		int n = 1;
		String array = "";
		try
		{
			n = Integer.parseInt(arg[0]);
			
			if(arg[1].contains("a"))
				array += "qwertyuiopasdfghjklzxcvbnm";
				
			if(arg[1].contains("A"))
				array += "QWERTYUIOPASDFGHJKLZXCVBNM";
				
			if(arg[1].contains("d"))
				array += "1234567890";
				
			if(arg[1].contains("x"))
				array += "`~!@#$%^&*()-_=+[]{}|;:,<.>/?";
				
			if(array.equals(""))
			{
				errorPrinter();
				System.exit(0);
			}
		}catch(java.lang.ArrayIndexOutOfBoundsException | java.lang.NumberFormatException e)
		{
			errorPrinter();
			System.exit(0);
		}
		
		array = shuffle(array);
		int size = array.length();
		
		System.out.print("You new password is:\n\t");
		for(int i=0;i<n;i++)
			System.out.print(array.charAt(new Random().nextInt(size)));
		System.out.println("\n");
	}
	
	static void errorPrinter()
	{
		System.out.println("Invalid argument(s)\nUsage:\n\tjava passwordgenerator <length> <rules>\n\nWhere <length> is the length of the password, and rules are as follows:\na -> include lowercase characters in password\nA -> include uppercase characters in password\nd -> include numbers in password\nx -> include special characters in password\n\nexample:\n\tjava passwordgenerator 15 aAd\n\nGenerates a 15 character long password that contains lowercase, uppercase characters and digits in it\n");
	}

	static String shuffle(String array)
	{
		int size = array.length();
		char[] a = array.toCharArray();
		Random rnd = new Random();
    	
    	for(int i=size; i>1; i--)
    		a=swap(a, i-1, rnd.nextInt(i));
    	
    	return new String(a);
	}
	
	static char[] swap(char[] x, int a, int b)
	{
    	char t = x[a];
    	x[a] = x[b];
    	x[b] = t;
    	return x;
	}
}
