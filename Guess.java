import java.util.*;
import java.io.*; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
class Guess3 
{
	static boolean storeWord(String s2) throws Exception
	{
		int n=12;
		String s = getString(n); 
		char a[] = s.toCharArray();
		ArrayList<String> str = new ArrayList();
		//providing file path as parameter
		File file = new File("radbound.txt"); 
		
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st; 
		while ((st = br.readLine()) != null) 
		{
			//for checking print "st";
			//System.out.println(st);
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(st);
			while (m.find()) {
			  m.group(1);
			  str.add(m.group(1));
			}
		}
		str.replaceAll(String::toUpperCase);
		
		char c[] = s2.toCharArray();
		
		/*for string s1*/
		int arr1[] = new int[26];
		
		/*for string s*/
		int arr2[] = new int[26];
		
		/*Storing how many times a character repeated in s2*/
		for (int i=0;i<s2.length();i++) {
			arr1[c[i]-65]++;
		}
		
		/*Storing how many times a character repeated in input string s*/
		for (int i=0;i<s.length();i++) {
			arr2[a[i]-65]++;
		}
		
		int flag=1;
		
		for(int i=0;i<26;i++) {
			if(arr1[i]!=0 && arr2[i]!=0) {
				if(arr2[i]<arr1[i]) {
					flag=0;
				}
			}
			
		}
		if(flag ==1) {
			if(str.contains(s2)) {
				
				System.out.println("*****HURRAY YOU WIN******");
				return true;
			}
			else {
				System.out.println("BETTER LUCK NEXT TIME");
				return false;
			}
			
		}
		else {
			System.out.println("Wrong Input");
			return false;
		}
	}
	//Generate Character
	static String getString(int n) 
    { 
  
        String Alpha1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
  
        // create StringBuffer size of Alpha1
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) 
		{ 
  
            int ind= (int)(Alpha1.length()* Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(Alpha1.charAt(ind)); 
        } 
  
        return sb.toString(); 
    } 
  
    public static void main(String[] args)throws Exception
	{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Rules: MAINTAIN THE WORD LENGTH \n---------------------------------");
		// Get the size n 
        int n = 15; 
		int i=1;
				
		do
		{ 
			String s = getString(n); 
			/**input string**/
			char a[] = s.toCharArray();
			for(char c:a) 
				System.out.print(c+" ");
			System.out.println();
			System.out.println("Let's Guess a "+(i+1)+" length word");
			/*Input*/
			String s1 = sc.next();
			
			if(s1.length()!=i+1)
			{
				System.out.println("You Break The Game Rules");
				System.out.println("Do you want to play again?");
				System.out.println("Enter Y for continue and N for quit");
				String ans=sc.next();
				String ans1=ans.toUpperCase();
				if(ans1.equals("Y")) 
				{
					continue;
				}
				else 
					break;
			}
			String abc=s1.toUpperCase(); 
			boolean val=storeWord(abc);
			if(val==true)
			{
				i++;
			}
			if(i>3)
			{
				System.out.println("......All Levels Completed......");
				break;
			}
			System.out.println("Do you want to play again?");
			System.out.println("Enter Y for continue and N for quit");
			String ans=sc.next();
			String ans1=ans.toUpperCase(); 
			if(ans1.equals("Y")) 
			{
				continue;
			}
			else 
				break;
			
		}while(i<=3);
	}
}