package com.corejava.demo;

import java.util.Scanner;


public class Prime {
	
	public void checkPrime(int num){
		
		boolean isPrime = true;
		
		for(int i=2; i<num; i++){
			if(num%i==0){
				isPrime = false;
			}
		}
		if(isPrime)
			System.out.println("prime number");
		else
			System.out.println("Not a prime number");
	}
	
	public void checkFibonacci(int num){
		int temp=num;
		int a=1;
		int b=1;
		int k=0;
		
		System.out.print("1, 1, ");
		
	while(k<=num){		
	k= a+b;
	a=b;
	b=k;
	System.out.print(k + " ");
		}
	}

	public static void main(String[] args) {
		new Prime().checkPrime(20);
		new Prime().checkFibonacci(8);
			
	}

}
