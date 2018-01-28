import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class queueTest {

	static class Joe {
		private int person = 0;
		private int repeat = 0;
		Queue<Object> queue;
		Joe(String order){
			StringTokenizer token = new StringTokenizer(order);
			
			person = Integer.parseInt(token.nextToken());
			repeat = Integer.parseInt(token.nextToken());
			queue = new LinkedList<Object>();
		}
		
		public String joesepus() {
			String result = "<";
			
			for(int i = 1; i <= person; i++)
				queue.add(i);
			
			while(!queue.isEmpty()) {
				Object item;
				for(int i = 1; i < repeat; i++) {
					item = queue.poll();
					queue.add(item);
				}
				
				result += queue.poll();
				
				if(!queue.isEmpty())
					result += ", ";
				else
					result += ">";
			}
			
			
			return result;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String order = scan.nextLine();
		
		Joe joe = new Joe(order);
		
		System.out.println(joe.joesepus());
		
		scan.close();
	}

}
