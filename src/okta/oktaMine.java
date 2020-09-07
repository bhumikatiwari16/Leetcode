package okta;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class oktaMine {

	public static void main(String[] args) {
		
    	
        solution(
                new String[]{"1,5,10", "2,5,10", "3,5,10", "4,5,10"},
                2,
                10);
        

	}
	
	static void solution(String[] customers, int numWindows, int queueSize) {
      
		  PriorityQueue<Window> windows = new PriorityQueue<Window>((x, y) -> {
	            if (x.getAvaTime() != y.getAvaTime()) {
	                return x.getAvaTime() - y.getAvaTime();
	            } else {
	                return x.getWindowIndex() - y.getWindowIndex();
	            }
	        });

	        for (int i = 0; i < numWindows; i++) {
	            windows.add(new Window(i));
	        }
	        
	        List<Customer> customersList = new LinkedList<>();
	        for (String c : customers) {
	            String[] line = c.split(",");
	            customersList.add(new Customer(
	                    Integer.parseInt(line[0]),
	                    Integer.parseInt(line[1]),
	                    Integer.parseInt(line[2])
	            ));
	        }
	        
	        List<Customer> queue = new LinkedList<>();
	        

	        int leastTime = -1;
	        for (Customer customer : customersList) {
	            //simulate(windows, leastTime, queue, customer.getArrivalTimestamp());
	            leastTime = customer.getArrivalTimestamp();
	            if (queue.size() < queueSize) {
	                queue.add(customer);
	                System.out.println("push custumer " + customer);
	                System.out.println(queue);
	            } else {
	                System.out.println("queue full, remove custumer " + customer);
	            }
	        }

    }
	
	
}

class Customer {
	
	private int arrivalTimestamp;
    private int serviceTime;
    private int toleranceTime;
    
    public int getArrivalTimestamp() {
        return arrivalTimestamp;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getToleranceTime() {
        return toleranceTime;
    }

    public Customer(int aT, int sT, int tT) {
        this.arrivalTimestamp = aT;
        this.serviceTime = sT;
        this.toleranceTime = tT;
    }
    
}

class Window {
	
	 private int avaTime;
	 private int windowIndex;
	 private int servedPeople;
	    
    public int getAvaTime() {
        return avaTime;
    }

    public int getWindowIndex() {
        return windowIndex;
    }

    public int getServedPeople() {
        return servedPeople;
    }
    
    public Window(int index) {
        this.windowIndex = index;
        this.avaTime = -1;
        this.servedPeople = 0;
    }
    
    public void serve(Customer customer, int time) {
        this.avaTime = time + customer.getServiceTime();
        servedPeople++;
    }
 
}
