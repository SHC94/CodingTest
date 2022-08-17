package codingtest.self.st11;

public class Task3 {

	public static void main(String[] args) {
//		SELECT 
//	    t.name as name
//	    , t.all_test_cases as all_test_cases
//	    , t.passed_test_cases as passed_test_cases
//	    , t.passed_test_cases * t.test_value as total_value
//	  FROM (
//	    SELECT  
//	        g.name as name
//	        , (
//	            SELECT COUNT(*)
//	            FROM test_cases c
//	            WHERE 1=1
//	            AND c.group_name = g.name
//	        ) as all_test_cases
//	        , (
//	            SELECT COUNT(*)
//	            FROM test_cases c
//	            WHERE 1=1
//	            AND c.group_name = g.name
//	            AND c.status = 'OK'
//	        ) as passed_test_cases 
//	        , g.test_value
//	    FROM test_groups g
//	  ) T
//	ORDER BY total_value DESC, name
	}//end main()
	
}//end class()
