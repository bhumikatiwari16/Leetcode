package basic.problems;

public class inheritanceExample {

	public static void main(String[] args) {
	
		inheritanceExample ie = new inheritanceExample();
		
		//when object created, left side of equal to decides which variables are accessible by object
		//when object created, right side of equal to decides which methods are accessible
		
		
		
		A a = ie.new A();
		
		System.out.println(a.a);
		
		//parent class object cannot access child class variables and methods
		//System.out.println(a.chUniq);
		
		a.test();
		
		//parent class object cannot access child class variables and methods
		//a.testChk();
		
		
		A ab = ie.new Achild();
		
		System.out.println(ab.a);
		
		//parent class object cannot access child class variables and methods
		// System.out.println(ab.chUniq);
		
		ab.test();
		
		//parent class object cannot access child class variables and methods
		//ab.testChk();
		
		
		Achild ac = ie.new Achild();
		
		System.out.println(ac.a);
		System.out.println(ac.b);
		
		//child class object can access parent class variables and methods
		System.out.println(ac.auniq);
		
		ac.test();
		
		//child class object can access parent class variables and methods
		ac.testChng();
		
	    ac.testChk();
		
		//child reference cannot hold parent object
		//Achild ad = (Achild)ie.new A();
	
	}
	
	
	class A {
		
		int a = 5;
		int b = 10;
		int auniq = 0;
		
		public void test() {
			
			System.out.println("a = " + a);
		}
		
		public void testChng() {
			
			System.out.println("a = " + a);
		}
		
	}

	class Achild extends A {
		
		int a = 6;
		int chUniq = 20;
		
		public void test() {
			
			System.out.println("a = " + a);
		}
		
		public void testChk() {
			
			System.out.println("uniq = " + auniq);
		}
		
		
	}

}
