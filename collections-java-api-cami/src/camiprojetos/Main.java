package camiprojetos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);		
		//int nums[] = {1,2,3,4,5,6}; 
		for(int num : nums) {
		System.out.println("Elemento da lista: "+num);
		}
		
		System.out.println("Iterando através do for");
		
		for(int i = 1; i <= 6; i++) {
			System.out.println("Elemento do for: "+i);
		}

	}

}
