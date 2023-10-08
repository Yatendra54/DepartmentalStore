package com;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		System.out.println("Welcome to XYZ Departmental Store");
		System.out.println("*********************************");

		Scanner sc = new Scanner(System.in);

		DepartmentalStore store = new DepartmentalStoreImpl();

		store.addProduct();

		int choice=1;

		while(choice==1)
		{
			store.displayProduct();
			store.buyProduct();
			System.out.println("Press 1 to continue or any other number to checkout");
			choice=sc.nextInt();
			System.out.println("---------------------------");
		}
		store.checkout();
	}

}
