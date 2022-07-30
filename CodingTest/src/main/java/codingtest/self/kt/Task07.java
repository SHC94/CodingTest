package codingtest.self.kt;

public class Task07 {
	
	public static void main(String[] args) {

		solution();
		
	}//end main()
	
	public static void solution() {
		try {
			System.out.println(10/0);;
			System.out.print("a");
		} catch (Exception e) {
			System.out.print("b");
		} finally {
			System.out.print("c");
		}
		System.out.print("d");
	}//end solution()
	

}//end class()