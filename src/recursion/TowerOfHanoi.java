package recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		
		int n = 3 ; // Number of disks 
        printTower(n, 'A', 'C', 'B');  // A, B and C are names of rods 
        

	}

	private static void printTower(int n, char src, char target, char inter) {
		
		// Order of parameters in function call: src, target, inter
		// Values for each of them keep changing as mentioned in comments below
		
		// Base condition when single disk to be moved from source to target rod
		if (n == 1) {
			System.out.println("Move disk 1 from " + src + " to " + target);
			return;
		}
		
		// All disks except the largest disk to be moved from source to intermediate rod 
		printTower(n-1, src, inter, target);
		// Move the largest disk from source rod to target rod
		System.out.println("Move Disk: " +  n + " from " + src + " to " + target + " using "
				+ inter);
		// All (n-1) disks to be moved from intermediate to target rod 
		printTower(n-1, inter, target, src);
	}

}
