import java.util.Scanner;

//Forgotten password
public class password {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int numOfCases=input.nextInt();
		int passwordLength=0;
		int counter=0;
		int[] array=new int[numOfCases];
		for(int i=0;i<numOfCases;i++) {
			passwordLength = input.nextInt();
			counter=0;
			for(int j=passwordLength;j>=1; j--) {
				counter+=countPasswords(j);
			}
			array[i]=counter;
			//System.out.println("total accounts:"+counter);
		}
		for(int i=0;i<numOfCases;i++) {
			System.out.println(array[i]);
		}
	}
	

	private static String generateBeginNumber(int length) {
		if(length==1)
			return "0";
		String beginStr="1";
		for(int i=0;i<length-1;i++) {
			
			beginStr+="0";
		}
		return beginStr;
	}
	
	private static String generateEndNumber(int length) {
		String endStr="";
		for(int i=0;i<length;i++) {
			endStr+="9";
			
		}
		
		return endStr;
	}

	private static String generateNextNumber(String number) {
		String nextNumber="";
		String digit="";

		int next=Integer.parseInt(number)+1;
		nextNumber= String.valueOf(next);
		return nextNumber;
	}

	private static int countPasswords(int passwordLength) {
		// list out all substrings
		String beginNumber=generateBeginNumber(passwordLength);
		String endNumber=generateEndNumber(passwordLength);
		String nextNumber =beginNumber;
		String sub="";
		boolean isPassword=true;
		int counter=0;
		//System.out.println("beginNumber="+beginNumber+" "+" endNumber="+ endNumber+" length="+passwordLength);
		while(nextNumber.compareTo(endNumber)<=0) {
			isPassword=true;
			for(int i=0;i<nextNumber.length();i++) {
				for(int j=0;j<nextNumber.length()-i;j++) {
					sub=nextNumber.substring(j, j+i+1);
					//System.out.println("nextnumber sub string:"+nextNumber.substring(j, j+i+1));
					
					while(!sub.equals("0")&&sub.startsWith("0")) {
						sub=sub.substring(1);
					}
					if(Integer.parseInt(sub)%3!=0) {
						isPassword=false;
						//System.out.println("isPassword="+isPassword);
						break;
					}
					
				}
				if(!isPassword)
					break;
			}
			if(isPassword) {
				counter++;
			}
			//System.out.println("compare:"+(nextNumber.compareTo(endNumber))+" counter="+counter);
			if(nextNumber.contentEquals(endNumber))
				break;
			else
			nextNumber =generateNextNumber(nextNumber);
			//System.out.println("next number:"+nextNumber);
		}
		return counter;
	}
}
