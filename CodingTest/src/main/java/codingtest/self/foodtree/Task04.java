package codingtest.self.foodtree;

public class Task04 {
	
public static void main(String[] args) {
		
		solution();
		
	}//end main()
	
	public static void solution() {
		
//		MERCHANTS 테이블은 XX카드 가맹점 정보를 담은 테이블입니다.
//		MERCHANTS 테이블의 구조는 다음과 같으며, ID, NAME, BYSUNESS_ID, TAX_TYPE, CATEGORY_ID는 각각
//		아이디, 상호명, 사업자 등록번호ㅡ 과세유형, 업종 분류아이디를 나타냅니다. ID는 기본키입니다.
		
//		-- 코드를 입력하세요
//		SELECT 
//			T.ID
//			, T.NAME
//			, SUM(T.PAY)
//		  FROM (
//			SELECT 
//				A.ID
//				, A.NAME
//				, CASE  WHEN B.CATEGORY = 0 THEN 1
//						ELSE 0
//						END AS PAY
//			FROM MERCHANTS A
//			LEFT OUTER JOIN CARD_USAGES B
//				ON A.ID = B.MERCHANT_ID
//			WHERE 1=1
//			AND (
//				A.NAME LIKE '%강남%'
//				OR A.NAME LIKE '%논현%'
//			)	  
//		  ) T
//		GROUP BY 
//			T.ID
//			, T.NAME
//		ORDER BY T.ID
		
	}//end solution()
	
}//end class()