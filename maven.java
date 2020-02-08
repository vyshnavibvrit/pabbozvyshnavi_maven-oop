package com.epam.new_year_gift;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

abstract class Gift
{
	String name;
	Integer quantity;
	Integer weight_in_grams;
	abstract int total_weight();
}

class Chocolate extends Gift
{
	Chocolate(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

class Sweets extends Gift
{
	Sweets(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

class Candy extends Gift
{
	Candy(String name,int quantity,int weight_in_grams)
	{
		this.name=name;
		this.quantity =quantity;
		this.weight_in_grams = weight_in_grams;
	}
	int total_weight()
	{
		return this.quantity*this.weight_in_grams;
	}
}

 
public class App 
{
	static void name_sort(Vector<Gift> child1,Vector<Gift> child2)
	{
		Vector<Chocolate> v=new Vector<Chocolate>();
		for(Gift g : child1)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Comparator<Chocolate> byname=(Chocolate c1,Chocolate c2) -> c1.name.compareTo(c2.name);
		Collections.sort(v,byname);
		System.out.println("\tFirst gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name);
		v.clear();
		for(Gift g : child2)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Collections.sort(v,byname);
		System.out.println("\n\tSecond gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name);
	}
	
	static void quantity_sort(Vector<Gift> child1,Vector<Gift> child2)
	{
		Vector<Chocolate> v=new Vector<Chocolate>();
		for(Gift g : child1)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Comparator<Chocolate> byquant=(Chocolate c1,Chocolate c2) ->  c1.quantity.compareTo(c2.quantity);
		Collections.sort(v,byquant);
		System.out.println("\tFirst gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name+":"+c.quantity);
		v.clear();
		for(Gift g : child2)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Collections.sort(v,byquant);
		System.out.println("\n\tSecond gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name+":"+c.quantity);
	}
	static void weight_sort(Vector<Gift> child1,Vector<Gift> child2)
	{
		Vector<Chocolate> v=new Vector<Chocolate>();
		for(Gift g : child1)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Comparator<Chocolate> byweight=(Chocolate c1,Chocolate c2) -> c1.weight_in_grams.compareTo(c2.weight_in_grams);
		Collections.sort(v,byweight);
		System.out.println("\nFirst gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name+" : "+c.weight_in_grams+" gms");
		v.clear();
		for(Gift g : child2)
		{
			if(g instanceof Chocolate)
			{
				Chocolate c=(Chocolate) g;
				v.add(c);
			}
		}
		Collections.sort(v,byweight);
		System.out.println("\n\tSecond gift box : ");
		for(Chocolate c:v)
			System.out.println("->"+c.name+" : "+c.weight_in_grams+" gms");
	}
	
	static void search(String cn,Vector<Gift> child1,Vector<Gift> child2)
	{
		boolean c1=false,c2=false;
		for(Gift g : child1)
		{
			if(g instanceof Candy)
			{
				Candy c=(Candy) g;
				if(c.name.equals(cn))
				{
					c1=true;
					break;
				}
			}
		}
		for(Gift g : child2)
		{
			if(g instanceof Candy)
			{
				Candy c=(Candy) g;
				if(c.name.equals(cn))
				{
					c2=true;
					break;
				}
			}
		}
		if(c1==false && c2==false)
			System.out.println(cn+" not found in either of boxes ");
		else
		{
			if(c1)
				System.out.println(cn+" found in gift box 1");
			if(c2)
				System.out.println(cn+" found in gift box 2");
		}
	}
	
    public static void main( String[] args ) throws IOException
    {
    	Vector<Gift> child1=new Vector<Gift>();
    	Vector<Gift> child2=new Vector<Gift>();
    	child1.add(new Chocolate("Dairy milk",2,15));
    	child1.add(new Chocolate("Eclairs",10,2));
    	child1.add(new Chocolate("Five star",5,20));
    	child1.add(new Chocolate("Munch",1,10));
    	child1.add(new Sweets("gulab jamun",1,250));
    	child1.add(new Sweets("ladoo",1,150));
    	child1.add(new Sweets("jalebi",1,200));
    	child1.add(new Candy("Friut candy",20,2));
    	child1.add(new Candy("Mangobite",10,2));
    	child1.add(new Candy("Kopiko",5,2));
    	
    	child2.add(new Chocolate("Five star",10,20));
    	child2.add(new Chocolate("Dairy milk silk",1,100));
    	child2.add(new Chocolate("Dark chocolate",1,200));
    	child2.add(new Sweets("Kaju barfi",2,500));
    	child2.add(new Sweets("Motichoor ladoo",1,50));
    	child2.add(new Candy("Alpenlibe",20,2));
    	child2.add(new Candy("Lollipop",10,2));
    	child2.add(new Candy("Skittles",1,20));
    	child2.add(new Candy("Gems",1,20));
    	child2.add(new Candy("Kopiko",5,2));
    	
    	System.out.println("The contents of gift boxes of two children are :- ");
    	System.out.println("1st gift box");
    	for(Gift g:child1)
    	{
    		System.out.println("\t"+g.name);
    	}
    	
    	System.out.println("2nd gift box");
    	for(Gift g:child2)
    	{
    		System.out.println("\t"+g.name);
    	}
    	
    	System.out.print("\nTotal weight of the Gift Boxes (in grams) : ");
    	int total_weight=0;
    	for(Gift g:child1)
    		total_weight += g.total_weight();
    	for(Gift g:child2)
    		total_weight += g.total_weight();
    	System.out.println(total_weight+"\n");
    	
    	
    	int decision=0;
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	while(decision!=4)
    	{
	    	System.out.println("\nOptions for sorting the chocolates of children :-");
	    	System.out.println("1) by name");
	    	System.out.println("2) by quantity");
	    	System.out.println("3) by weight");
	    	System.out.println("4) quit menu");
	    	decision=Integer.parseInt(br.readLine());
	    	switch(decision)
	    	{
	    	case 1: System.out.println("Sorted according to names : ");
	    			name_sort(child1,child2);
	    			break;
	    	case 2: System.out.println("Sorted according to quantity : ");
	    			quantity_sort(child1,child2);
	    			break;
	    	case 3: System.out.println("Sorted according to weight : ");
	    			weight_sort(child1,child2);
	    			break;
	    	case 4:break;
	    	default:System.out.println("Invalid option !");
	    	}
    	}
    	String s="yes";
    	while(!s.toLowerCase().equals("no"))
    	{
	    	System.out.println("Enter the candy's name you want to search in gift Boxes : ");
	    	String cn=br.readLine();
	    	search(cn,child1,child2);
	    	System.out.println("Do you want to continue to search candies( type yes/no)");
	    	s=br.readLine();
    	}
    }
}
