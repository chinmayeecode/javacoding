package com.corejava.demo;

class Car extends Vehicle {
	   int CC;
	   int gears;
	   int color;
	   void attributescar() {
	       // Error due to access violation
	      // System.out.println("Speed of Car : " + speed); 
	      // Error due to access violation
	      //System.out.println("Size of Car : " + size); 
	   }

	
	   public static void main(String args[]) {
	     Car b1 = new Car();
	     // the subclass can inherit 'color' member of the superclass
	     b1.color = 500; 
	     b1.setSpeed(200) ;
	     b1.setSize(22);
	     b1.CC = 1000;
	     b1.gears = 5;
	     // The subclass refers to the members of the superclass
	     System.out.println("Color of Car : " + b1.color);
	     System.out.println("Speed of Car : " + b1.getSpeed());
	     System.out.println("Size of Car : " + b1.getSize());
	     System.out.println("CC of Car : " + b1.CC);
	     System.out.println("No of gears of Car : " + b1.gears);
	  }
	}

