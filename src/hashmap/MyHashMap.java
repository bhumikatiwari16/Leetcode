package hashmap;

public class MyHashMap {
  
	Node head;
	
	
	public static void main(String[] args) {
		
		MyHashMap mh = new MyHashMap();
		mh.put(1, 1);
		mh.put(2, 2);
		
		mh.print();
		
		System.out.println(mh.get(1));
		System.out.println(mh.get(3));
		
		mh.put(2, 1);
		mh.print();
		
		System.out.println(mh.get(2));
		
		mh.remove(2);
		mh.print();
		
		System.out.println(mh.get(2));
		
	}
	
	 /** Initialize your data structure here. */
    public MyHashMap() {

    	head = new Node(-1,-1);
    	
    }
	
    /** value will always be non-negative. */
	public void put(int key, int value) {      
		// check if list is empty
		if(head.next==null) {
			Node temp = new Node(key, value);
			head.next = temp;
			return;
		}		
		// Traverse the List here and see if Node object of same key exist;
	
		Node temp=head.next;
		Node pre = head;
		while(temp!=null) {
			if(temp.key == key) {
				
				temp.value=value;
				return;
				
				
			}else {
				pre = temp;
				temp = temp.next;
			}
		}
		Node node = new Node(key,value);
		pre.next = node;
		
    }
	
	 /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
    	if(head.next == null) {
    		return -1;
    	}
    	
    	Node temp = head.next;
    	
    	while(temp != null) {
    		if (temp.key == key) {
    			return temp.value;
    		}
    		temp = temp.next;
    	}
    	
    	return -1;
    	
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
    	Node pre = head;
    	Node cur = head.next;
    	
    	while(cur != null) {
    		if (cur.key == key) {
    			pre.next = cur.next;
    			break;
    		} else {
    		pre = pre.next;
    		cur = cur.next;
    		}
    	}
    	
    }
    
    public void print() {
    	 
    	Node temp = head.next;
    	while(temp != null) {
    		System.out.println(temp.key + "   " + temp.value);
    		temp = temp.next;
    	}
    	
    }
	
	public static class Node {
		
		int key;
		int value;
		Node next;
		
		public Node(int key, int value) {
			
			this.key =  key;
			this.value = value;
			this.next = null;
			
		}
		
	}


}
