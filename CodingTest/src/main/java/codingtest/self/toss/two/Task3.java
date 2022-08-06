package codingtest.self.toss.two;

public class Task3 {
	
	public static void main(String[] args) {

	  	solution();
		
	}//end main()
	
	public static void solution() {
//		카드, 계좌 사용이력을 하나의 화면에 보여주는 형철 가계부 서비스를 만들려고 합니다.
//
//		현재 형철은 Microservice Architecture(MSA)를 사용하고 있습니다.
//		즉, 소규모의 독립적인 서비스들로 구성되어 있으며, 각 서비스는 API를 통해 서로를 호출합니다.
//		이러한 맥락에서 카드 서비스와 계좌 서비스 또한 분리되어 있습니다.
//
//		가계부 서비스에서는 카드 서비스와 계좌 서비스에서 데이터를 가져와야 하고, 이때 캐쉬를 적용하려고 합니다.
//
//		A 방법 - 가계부 서비스에서 카드 서비스와 계좌 서비스에 대해 Rest API 로 통신하고, 카드 서비스와 계좌 서비스 쪽에선 캐쉬 레이어를 적용
//		B 방법 - 가계부 서비스에서 카드 서비스와 계좌 서비스에 대해 Rest API 로 통신하고, 가계부 서비스 측에서 캐쉬 레이어를 적용
//		C 방법 - 카드 서비스와 계좌 서비스가 각각 Kafka 로 데이터를 전송하고, 가계부 서비스는 이 데이터를 Consume 하여 자체적으로 NoSQL 에 저장 및 내부적으로 캐쉬 레이어를 적용
//		각 방법의 장점, 단점을 설명해 주세요.
    }//end solution()

}//end class()
