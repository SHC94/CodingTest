package codingtest.self.hanjin;

import java.util.Arrays;

public class Task {

	public static void main(String[] args) {
		
		System.out.println("1 ===================================");
	    int[][] matrix = {{1,2,1}, {2,3,1}, {3,2,1}};
	    int[][] result1 = Solution1(matrix);
	    
	    for(int a = 0 ; a < result1.length ; a++) {
	    	System.out.println(Arrays.toString(result1[a]));
	    }
		
	    
	    System.out.println("2 ===================================");
	    int[] goods 		= {1, 2};
	    int[] boxes 		= {2, 3, 1};
	    int result2 			= solution2(goods, boxes);
	    System.out.println(result2);
	    
	    
	    System.out.println("3 ===================================");
	    int money 			= 1200;
	    String expected 	= "TTHHH";
	    String actual 		= "HHTHT";
	    int result3 			= solution3(money, expected, actual);
	    System.out.println(result3);
	 
	    System.out.println("4 ===================================");
	    int n				= 6;
//	    int[] v				= {3,1,4,1,5,9,2,6,5,3};
//	    int[] v				= {1,2,3,4,5,6,7,8,9,10};
	    int[] v				= {4,1,7,6,5,2};
	    int result4 		= solution4(n, v);
	    System.out.println(result4);
	    
	}

	private static int[][] Solution1(int[][] matrix) {
		int n = matrix.length;
	    int[][] result = new int[n][n];

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            int rowSum = 0;
	            int colSum = 0;

	            // i행의 모든 숫자를 더함
	            for (int k = 0; k < n; k++) {
	                rowSum += matrix[i][k];
	            }

	            // j열의 모든 숫자를 더함
	            for (int k = 0; k < n; k++) {
	                colSum += matrix[k][j];
	            }

	            // i행과 j열의 교차 지점 값은 한번만 더함
	            result[i][j] = rowSum + colSum - matrix[i][j];
	        }
	    }

	    return result;
	}
	
	
	private static int solution2(int[] goods, int[] boxes) {
		
		Arrays.sort(goods);
        Arrays.sort(boxes);

        int maxCount = 0;
        int goodsIdx = 0;

        for (int boxesIdx = 0; boxesIdx < boxes.length && goodsIdx < goods.length; boxesIdx++) {
            if (goods[goodsIdx] <= boxes[boxesIdx]) {
                maxCount++;
                goodsIdx++;
            }
        }

        return maxCount;
  
    }
	
	private static int solution3(int money, String expected, String actual) {
		int bet 	= 100; 		// 배팅 금액 (첫판 100원)
		
        for(int a = 0 ; a < expected.length() ; a++) {
        	
//        	System.out.println((a + 1) + " 번 째 판 시작 ===============");
//        	System.out.println("배팅 금액 = " + bet);

        	// 탕진 잼
        	if(money <= 0) break; 
        	
        	// 배팅 금액이 모자른 경우
        	if(money < bet) bet = money;
        	
        	String e = String.valueOf(expected.charAt(a));
        	String b = String.valueOf(actual.charAt(a));
        	
        	// 같으면 걸었던 돈을 따고 배팅 금액 100원으로 초기화
        	// 다르면 걸었던 돈을 잃고 배팅 금액 2배
        	if(e.equals(b)) {
//        		System.out.println("이김");
        		money += bet;
        		bet = 100;
        	} else {
//        		System.out.println("짐");
        		money -= bet;
        		bet = bet * 2; 
        	}
        	
//        	System.out.println("남은 돈 = " + money);
        }

        int answer	= money;	// 남은 금액
        
        return answer;
	}
	
	private static int solution4(int n, int[] v) {
		
		int max = Integer.MIN_VALUE;
		// n일 이내에 송아지를 팔고 새로운 송아지를 한마리 사야한 함
		// n일 간 송아지 가격은 정확히 예측 됨
		// 판매 이익(판매 가격 - 구매가격이 최대가 되도록 구매일을 잡아야함.
		// 같은 날 송아지를 팔고 살수 없음.
		
		for(int a = 0 ; a < v.length ; a++) {
			System.out.println((a + 1) + " 일차 ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			// 오늘 가격 (팔았다고 가정)
			int sellAmt = v[a];
			System.out.println("오늘 판매 가격 = " + sellAmt);
			
			if(a == v.length) break;
			
			// 오늘 이후
			for(int b = a + 1 ; b < v.length ; b++) {
				int buyAmt = v[b];
				
				int compare = sellAmt - buyAmt;
				if(max < compare) max = compare;
			}
			
		}
		
		return max;
	}
}
