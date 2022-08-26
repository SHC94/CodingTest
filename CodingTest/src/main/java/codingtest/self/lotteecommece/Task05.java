package codingtest.self.lotteecommece;

public class Task05 {
	
	public static void main(String[] args) {

		solution();
		
	}//end main()
	
	public static void solution() {
//	SELECT 
//	    T2.AREA
//	    , COUNT(*)
//	FROM (
//	  SELECT
//	    CASE    WHEN T.CNT = 0 THEN '0' 
//	            WHEN 0 < T.CNT AND T.CNT < 50 THEN '< 50'  
//	            WHEN 50 <= T.CNT AND T.CNT < 100 THEN '< 100' 
//	            WHEN T.CNT >= 100 THEN '>= 100' ELSE NULL END AS AREA
//	    FROM (
//	    SELECT 
//	            P.ID
//	            , COUNT(R.COMMENTS) AS CNT
//	        FROM PLACES P
//	        LEFT OUTER 
//	        JOIN PLACE_REVIEWS R
//	        ON P.ID = R.PLACE_ID
//	        GROUP BY P.ID
//	    ) T
//	) T2
//	GROUP BY T2.AREA
//	ORDER BY FIELD (T2.AREA, '0', '< 50', '< 100', '>= 100')

	}//end solution()

}//end class()

