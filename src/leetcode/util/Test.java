package leetcode.util;

public class Test {

	public static void main(String[] args) {
		String s1 = new String("Manish");
		String s2 = new String("Manish");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(s2.compareTo(s1));
		Test t = new Test();
		Player player1 = new  Test().new Player(59, "John", 20);
	    Player player2 = new Test().new Player(67, "Roger", 22);
	    
		
		System.out.println(player1.compareTo(player2));
		
	}
	
	 class Player implements Comparable<Player> {
	    private int ranking;
	    private String name;
	    private int age;
	     public Player(int ranking1 , String name1,int age1) {
			ranking = ranking1;
			name=name1;
			age=age1;
		}
		@Override
		public int compareTo(Player o) {
			// TODO Auto-generated method stub
			return this.ranking-o.ranking;
		}
	     
	} 

}
