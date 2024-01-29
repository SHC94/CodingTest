package codingtest.programmers.level1;

import java.util.HashMap;
import java.util.StringTokenizer;

public class 가장많이받은선물 {

	// 내가 준거
	private static HashMap<String, HashMap<String, Integer>> send = new HashMap<>();
	
	// 내가 받은거
	private static HashMap<String, HashMap<String, Integer>> receive = new HashMap<>();
	
	// 최종 받을 선물
	private static HashMap<String, Integer> gift = new HashMap<>();
			
	public static void main(String[] args) {
		// https://school.programmers.co.kr/learn/courses/30/lessons/134240
		
//		입출력 예
//		friends	gifts	result
//		["muzi", "ryan", "frodo", "neo"]	
//		["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]	
//		2
		
//		["joy", "brad", "alessandro", "conan", "david"]	
//		["alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"]	
//		4
		
//		["a", "b", "c"]	
//		["a b", "b a", "c a", "a c", "a c", "c a"]	
//		0

		
		String[] friends	= {"muzi", "ryan", "frodo", "neo"};
		String[] gifts		= {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		int result 	= process(friends, gifts);
		
        System.out.println(result);
	}

	private static int process(String[] friends, String[] gifts) {
		
		for(String friend : friends) gift.put(friend, 0);
		
		// 주고 받기
		sendReceive(gifts);
		
		// 선물 정산하기 (따질건 따지자)
		giftSettlement(friends);
		
		// 결과 출
		int result = Integer.MIN_VALUE;
		
		for(String key : gift.keySet()) 
			if(result < gift.get(key)) result = gift.get(key);
		
		return result;
	}

	private static void giftSettlement(String[] friends) {
 
		for(int a = 0 ; a < friends.length ; a++) {
			for(int b = a + 1 ; b < friends.length ; b++) {
				String p1 = friends[a];
				String p2 = friends[b];

				int p1Send 		= send.get(p1) == null ? 0 : send.get(p1).get(p2) == null ? 0 : send.get(p1).get(p2);
				int p1Receive 	= receive.get(p1) == null ? 0 : receive.get(p1).get(p2) == null ? 0 : receive.get(p1).get(p2);
				
				int p2Send 		= send.get(p2) == null ? 0 : send.get(p2).get(p1) == null ? 0 : send.get(p2).get(p1);
				int p2Receive 	= receive.get(p2) == null ? 0 : receive.get(p2).get(p1) == null ? 0 : receive.get(p2).get(p1);

				if(0 < p1Send || 0 < p1Receive || 0 < p2Send || 0 < p2Receive) {
					if(p1Send < p2Send) {
						gift.put(p2, gift.get(p2) + 1);
					} else if(p2Send < p1Send) {
						gift.put(p1, gift.get(p1) + 1);
					} else {
						int giftPoint1 = giftPointCalculate(p1);
						int giftPoint2 = giftPointCalculate(p2);

						if(giftPoint1 != giftPoint2) {
							if(giftPoint1 < giftPoint2) gift.put(p2, gift.get(p2) + 1);
							if(giftPoint2 < giftPoint1) gift.put(p1, gift.get(p1) + 1);
						}
					}
				} else {
					int giftPoint1 = giftPointCalculate(p1);
					int giftPoint2 = giftPointCalculate(p2);

					if(giftPoint1 != giftPoint2) {
						if(giftPoint1 < giftPoint2) gift.put(p2, gift.get(p2) + 1);
						if(giftPoint2 < giftPoint1) gift.put(p1, gift.get(p1) + 1);
					}
				}
				
			}
		}
		
	}

	private static int giftPointCalculate(String p) {
		int sendCnt = 0;
		int receiveCnt = 0;
		
		if(send.get(p) != null)
			for(String key : send.get(p).keySet()) sendCnt += send.get(p).get(key);
			
		
		if(receive.get(p) != null)
			for(String key : receive.get(p).keySet()) receiveCnt += receive.get(p).get(key);
		
		return sendCnt - receiveCnt;
	}

	private static void sendReceive(String[] gifts) {
		for(int a = 0 ; a < gifts.length ; a++ ) {
			String detail = gifts[a];
			StringTokenizer st = new StringTokenizer(detail);
			String sp = st.nextToken();
			String rp = st.nextToken();
			
			if(send.get(sp) == null) {
				HashMap<String, Integer> map = new HashMap<>();
				map.put(rp, 1);
				send.put(sp, map);
			} else {
				HashMap<String, Integer> map = new HashMap<>();
				map = send.get(sp);
				
				if(map.get(rp) == null) map.put(rp, 1);
				else map.put(rp, map.get(rp) + 1);
				
				send.put(sp, map);
			}
			
			if(receive.get(rp) == null) {
				HashMap<String, Integer> map = new HashMap<>();
				map.put(sp, 1);
				receive.put(rp, map);
			} else {
				HashMap<String, Integer> map = new HashMap<>();
				map = receive.get(rp);
				if(map.get(sp) == null) map.put(sp, 1);
				else map.put(sp, map.get(sp) + 1);
				
				receive.put(rp, map);
			}
			
		}
		
	}

}
