package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStore 
{


	Scanner sc=new Scanner(System.in);
	//Product Id is a Key -> <Integer>
	//Product Object is the Value -> <Product>
	Map<Integer, Product> db=new LinkedHashMap<>();

	int totalBill=0;

	@Override
	public void addProduct() {
		db.put(1, new Product("Chocolates", 20, 5));
		db.put(2, new Product("Biscuits", 30, 10));
		db.put(3, new Product("IceCream", 50, 20));
	}

	@Override
	public void displayProduct() {
		Set<Integer> keys=db.keySet();

		for(int key:keys)
		{
			Product p=db.get(key);//getting product based on key
			System.out.println("Enter "+key+" to Order "+p.getName());
			System.out.println("Available Quantity: "+p.getQuantity());
			System.out.println("Cost: Rs."+p.getCost());
		}
	}

	@Override
	public void buyProduct() {
		System.out.println("Enter Choice: ");//choice->key
		int choice=sc.nextInt();

		//getting Product based on choice(key)
		//if choice/key is not present,it returns null
		Product p=db.get(choice);
		if(p!=null)
		{
			System.out.println("Enter Quantity:");
			int quantity = sc.nextInt();
			//checking if the quantity is available or not
			if(quantity <= p.getQuantity())
			{
				//Calculating current product cost
				int productCost = quantity*p.getCost();

				//setting the new updated quantity
				p.setQuantity(p.getQuantity()-quantity);

				//adding current product cost to total bill
				totalBill = totalBill + productCost;

				System.out.println("Order "+quantity+" "+p.getName());
				System.out.println("Current Product Cost is Rs. "+productCost);
				System.out.println("Your Total Bill as of now is Rs. "+totalBill);
			}
		}
		else {
			try {
				String message="Invalid Choice,Kindly Enter Valid Choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void checkout() {
		System.out.println("Your Total Bill is Rs."+totalBill);
		System.out.println("Thankyou for Shopping at XYZ Departmental Store");
	}

}
