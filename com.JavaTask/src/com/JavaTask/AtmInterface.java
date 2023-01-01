package com.JavaTask;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 public class AtmInterface {
	double bal=10000.0;
	double depamt;
	double wdamt;
	static double amount=0;

	public AtmInterface()
	{	
		//default constructor
	}
	public double getwdamt()
	{
		
		return wdamt;
	}
	public void setwdamt(double wdamt)
	{
		this.wdamt =  wdamt;
	}	
	public double getbal()
	{
		return bal;
	}
	public void setbal(double bal)
	{
		this.bal = bal;
	}
	public double getdepamt()
	{
		return depamt;
	}
	public void setdepamt(double depamt)
	{
		this.depamt = depamt;
	}

	ATM atmobj=new ATM();
	HashMap<Double,String> atmstmt=new HashMap<>();
	public void viewbal(){
		System.out.println("Current balance is : "+atmobj.getbal());
	}
	public void wdamt(double wdamt)
	{
		if(wdamt<=Double.parseDouble(atmobj.getbal()))
		{
			atmstmt.put(wdamt," has been withdrawn");
			System.out.println(wdamt+" has been withdrawn Successfully !!!");
			atmobj.setbal(Double.parseDouble(atmobj.getbal())-wdamt);
			viewbal();
		}
		else
		{
			System.out.println("Sorry!!!, Insufficient balance.");
		}
	
	}
	public void depamt(double depamt)
	{
		atmstmt.put(depamt," has been deposited");
		System.out.println(depamt+" has been deposited Successfully !!!");
		atmobj.setbal(atmobj.getbal()+depamt); 
		viewbal();
	}
	public void showstmt()
	{
		for(Map.Entry<Double,String> m:atmstmt.entrySet())
		{
			System.out.println(m.getKey()+""+m.getValue());
		}
	}
	
	public static void transfer (AtmInterface from, AtmInterface to, double amount)
	{
   		 from.wdamt(amount);
   		 to.depamt(amount);
    	System.out.println(amount+" has been transfered successfulluy");
	}
   


	public static void main(String[] args) {
		AtmInterface op=new AtmInterface();

		int cardnum=1234567890;
		int atmpin=3211;
		Scanner sc=new Scanner(System.in);
		System.out.print("Please enter your card number:");
		int cardno=sc.nextInt();
		System.out.print("Please enter pin number:");
		int pin=sc.nextInt();
		
		AtmInterface from=new AtmInterface();
		AtmInterface to=new AtmInterface();

		if((cardnum == cardno)&&(atmpin == pin))
		{
			while(true)
			{
				System.out.print("\n1.View current balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Show History\n5.Transfer\n6.Exit");
				System.out.println("\nPlease enter your choice :");
				int ch=sc.nextInt();
				if(ch==1)
				{
					op.viewbal();
				}
				else if(ch==2)
				{
					System.out.println("\nEnter the amount you want to withdraw :");
					double wdamt=sc.nextDouble();
					op.wdamt(wdamt); 
				}
				else if(ch==3)
				{
					System.out.println("Enter the amount you want to Deposit :");
					double depamt=sc.nextDouble();
					op.depamt(depamt);
				}
				else if(ch==4)
				{
					op.showstmt();
				}
				else if(ch==5)
				{
					System.out.println("\nEnter the account numbet you want to transfer money to.");
					int accno=sc.nextInt();
					System.out.println("\nEnter the amount you want to transfer :");
					int amount=sc.nextInt();
					transfer(from,to,amount);
					
				}
				else if(ch==6)
				{
					System.out.println("Thank You!!!.Have a nice day.");
					break;
				}
				else
				{
					System.out.println("Invalid choice,Please enter valid choice");
				}

			}
		}
		else
		{
			System.out.print("Incorrect Card number or pin number please try again.");
		}
	}
}
interface ATMOperations
{
	public void viewbal();
	public void wdamt(double wdamt);
	public void depamt(double depamt);
	public void showstmt();
	public void transfer(AtmInterface from,AtmInterface to,double amount);



}
