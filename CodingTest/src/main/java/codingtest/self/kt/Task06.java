package codingtest.self.kt;

public class Task06 {
	
	public static void main(String[] args) {
		solution();
	}//end main()
	
	public static void solution() {
		Card card1 = new Card(6);
		Card card2 = new Card(1);
		Card card3 = new Card(2);
		Card card4 = new Card(3);
		System.out.println(Card.cnt);
	}//end solution()
	
}//end class()

class Card {
	static int cnt;
	int data;
	
	Card(int data) {
		this.data = data;
		cnt++;
	}
	
}