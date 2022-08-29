package codingtest.self.foodtree;

public class Task03 {
	
	public static void main(String[] args) {
		
		solution();
		
	}//end main()

	public static void solution() {
//		EMPLOYEE_RELATIONSHIPS 테이블은 회사 직원 간의 위계 관계를 나타내는 테이블입니다.
//		EMPLOYEE_RELATIONSHIPS 테이블 구조는 다음과 같으며, NAME은 직원의 이름, BOSS는 상관의 이름입니다.
//		1. 상관이 없는 직원(BOSS가 NULL)은 이 회사의 'CEO'입니다.
//		2. CEO가 아닌 직원 중, 본인이 누군가의 상관인 경우는 'MANAGER' 입니다.
//		3. 1이나 2에 해당하지 않은 직원은 'WORKER'입니다.
//		모든 사원의 이름과 이 사원의 유형을 조회하는 SQL문을 작성해주세요, 이때 사원 이름은 알파벳 순으로 나열되어야 합니다.
		
//		-- 코드를 입력하세요
//		SELECT 
//			A.NAME AS NAME
//			, CASE 	WHEN BOSS IS NULL THEN 'CEO'
//					WHEN (
//						SELECT COUNT(*)
//						  FROM EMPLOYEE_RELATIONSHIPS B
//						 WHERE B.BOSS = A.NAME 
//					) > 0 
//					THEN 'MANAGER'
//					ELSE 'WORKER' END AS BOSS
//		  FROM EMPLOYEE_RELATIONSHIPS A 
//		ORDER BY A.NAME
	}//end solution()

}//end class()