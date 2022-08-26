package codingtest.self.lotteecommece;

public class Task06 {
	
	public static void main(String[] args) {

		solution();
		
	}//end main()
	
	public static void solution() {
        try {
        	System.out.println(10/0);
        	System.out.println("a");
        } catch (Exception e) {
        	System.out.println("b");
		} finally {
			System.out.println("c");
		}
        System.out.println("d");
	}//end solution()

}//end class()
