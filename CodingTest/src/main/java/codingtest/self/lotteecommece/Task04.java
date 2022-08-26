package codingtest.self.lotteecommece;

public class Task04 {
	
	public static void main(String[] args) {

		solution();
		
	}//end main()
	
	public static void solution() {
		
//	SELECT 
//	    T.ID AS USER_ID
//	    , SUM(T.CNT) AS PURCHASE_COUNT
//	    , SUM(T.PRICE) AS TOTAL_PRICE
//	  FROM (
//	      SELECT 
//	        G.ID AS ID
//	        , IFNULL(C.PRICE, 0) AS PRICE
//	        , CASE  WHEN P.ID IS NULL THEN 0
//	                ELSE 1
//	                END AS CNT
//	    FROM GAME_USERS G
//	    LEFT OUTER
//	    JOIN PURCHASES P
//	    ON G.ID = P.USER_ID
//	    LEFT OUTER
//	    JOIN CHARACTERS C
//	    ON C.NAME = P.ITEM
//	  ) T
//	  GROUP BY T.ID
//	  ORDER BY T.ID
	    
	}//end solution()

}//end class()