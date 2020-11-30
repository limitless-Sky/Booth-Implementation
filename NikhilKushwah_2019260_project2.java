import java.io.*;
import java.util.Scanner;

public class NikhilKushwah_2019260_project2{

	public static void main(String[] args) throws IOException {
		Scanner x = new Scanner(System.in);
		File output_file=new File("answer_file.txt");
		FileWriter fw= new FileWriter(output_file);
		PrintWriter pw=new PrintWriter(fw);
		int num1=x.nextInt();
		int num2=x.nextInt();
		pw.println("number_1 : "+num1);
		pw.println("number_2 : "+num2);
		String bin1="";
		String bin2="";
		if(num1<0){
			bin1=Integer.toBinaryString(0-num1);
			if(bin1.length()<12)
				bin1=change_to_bits(bin1,12);
			else
				bin1=change_to_bits(bin1,24);
		}
		else{
			bin1=Integer.toBinaryString(num1);
			if(bin1.length()<12)
				bin1=change_to_bits(bin1,12);
			else
				bin1=change_to_bits(bin1,24);
			}
		if(num2<0){
			bin2=Integer.toBinaryString(0-num2);
			if(bin2.length()<12)
				bin2=change_to_bits(bin2,12);
			else
				bin2=change_to_bits(bin2,24);
		}
		else{
			bin2=Integer.toBinaryString(num2);
			if(bin2.length()<12)
				bin2=change_to_bits(bin2,12);
			else
				bin2=change_to_bits(bin2,24);
		}
		int max=Math.max(bin1.length(), bin2.length());
		if(max==12)
		{
			bin1=change_to_bits(bin1,12);
			bin2=change_to_bits(bin2,12);
		}
		else
		{
			bin1=change_to_bits(bin1,24);
			bin2=change_to_bits(bin2,24);
		}
		if(num1<0)
			bin1=t(bin1);
		if(num2<0)
			bin2=t(bin2);
		System.out.println(bin1);
		System.out.println(bin2);
		String mult_result=multiply(bin1,bin2,pw);
		System.out.println("multiplication = "+mult_result);
		pw.println("multiplication = "+mult_result);
		Long magnitude=magnitude(mult_result);
		System.out.println("magnitude = "+magnitude);
		pw.println("magnitude = "+magnitude);
		x.close();
		pw.close();
			}

	private static String multiply(String bin1, String bin2,PrintWriter pw) {
		int count=1;
		String M=bin1;
		String Q=bin2;
		String neg_m=t(M);
		System.out.println(neg_m);
		String Q0=Q.substring(Q.length()-1);
		String Q_1="0";
		String acc="";
		if(bin1.length()==12)
			acc="000000000000";
		else
			acc="000000000000000000000000";
		String result=acc+Q+Q_1;
		pw.println();
		int counter=acc.length();
		if(counter==12)
			pw.println("Count		acc						Q												Operation");
		else
		pw.println("Count		acc									Q															Operation");
		while(count!=counter+1)
		{
			pw.print(count+"			");
			pw.print(acc+"			");
			pw.print(Q+"			");
			pw.print("Q0 = "+Q0+"	"+"Q-1 = "+Q_1+"			");
			String real_result="";
			if(Q0.matches("1") && Q_1.matches("0")){
				pw.println("acc=acc-M");
				acc=add_binary(acc, neg_m);
			}
			else if(Q0.matches("0") && Q_1.matches("1")){
				pw.println("acc=acc+M");
				acc=add_binary(acc,M);
			}
			else
				pw.println();
			pw.print("			"+acc+"			");
			pw.print(Q+"			");
			real_result+=acc.substring(0, 1);
			real_result=real_result+acc;
			real_result=real_result+Q;
			result=real_result;
			if(acc.length()==12)
			{
			acc=result.substring(0, 12);
			Q=result.substring(12, 24);
			Q0=result.substring(result.length()-2,result.length()-1);
			Q_1=result.substring(result.length()-1);
			}
			else
			{
				acc=result.substring(0, 24);
				Q=result.substring(24, 48);
				Q0=result.substring(result.length()-2,result.length()-1);
				Q_1=result.substring(result.length()-1);
			}
			count+=1;
			
			
			pw.println("						Arithmetic Shift Right");
			pw.println();
			
		}
		if(acc.length()<=12)
			result=result.substring(0, 24);
		else
			result=result.substring(0, 48);
		return result;
	}
	
	private static long magnitude(String mult_result) {
		long decimal=0;
		if(mult_result.substring(0, 1).matches("0")){
			decimal=Long.parseLong(mult_result,2);
		}
		else{
			String b=t(mult_result);
			decimal=Long.parseLong(b,2);
			decimal=-decimal;
		}
		return decimal;
	}

	private static String change_to_bits(String bin,int number) {
		while(bin.length()!=number)
			return change_to_bits("0"+bin,number);
		return bin;

	}
	private static String t(String bin)
	{
		String result="";
		int index=0;
		for(int i=bin.length()-1;i>=0;i--)
		{
			if(bin.substring(i).equals("1"))
			{
				result="1"+result;
				index=i;
				break;
			}
			else
				result="0"+result;
			bin=bin.substring(0, bin.length()-1);
		}
		for(int j=index-1;j>=0;j--){
			if(bin.substring(j,j+1).matches("0")){
				result="1"+result;
			}
			else
				result="0"+result;
		}
		return result;
	}
	private static String add_binary(String bin1, String bin2) {
		
		String bin="";
		int flag=0;
		for(int i=bin1.length()-1;i>=0;i--){
			if(bin1.substring(i,i+1).matches("0") && (bin2.substring(i,i+1).matches("0")||bin2.substring(i,i+1).matches(""))){
				if(flag==0){
					bin="0"+bin;
				}
				else{
					bin="1"+bin;
				}
				flag=0;
			}
			if(bin1.substring(i,i+1).matches("0") && bin2.substring(i,i+1).matches("1")){
				if(flag==0){
					bin="1"+bin;
					flag=0;
				}
				else{
					bin="0"+bin;
					flag=1;
				}
			}
			if(bin1.substring(i,i+1).matches("1") && bin2.substring(i,i+1).matches("0")){
				if(flag==0){
					bin="1"+bin;
					flag=0;
				}
				else{
					bin="0"+bin;
					flag=1;
				}
			}
			if(bin1.substring(i,i+1).matches("1") && bin2.substring(i,i+1).matches("1")){
				if(flag==0){
					bin="0"+bin;
				}
				else{
					bin="1"+bin;
				}
				flag=1;
			}
		}
		return bin;
	}

}
