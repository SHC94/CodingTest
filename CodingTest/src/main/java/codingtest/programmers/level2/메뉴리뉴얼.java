package codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 메뉴리뉴얼 {
	
	public static void main(String[] args) {
//		
//		orders												course	result
//		["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]		[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
//		["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
//		["XYZ", "XWY", "WXA"]								[2,3,4]	["WX", "XY"]
		
		String[] orders 		= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course			= {2,3,4};
		String[] result 		= solution(orders, course);
		
		System.out.println(Arrays.toString(result));
	}//end main()j
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static String[] solution(String[] orders, int[] course) {
        String[] answer         = {};
        List<String> resultList = new ArrayList<String>();
        int[] courseLength      = new int[course.length];

        //주문마다의 조합 구하기
        for(int a = 0 ; a < orders.length ; a++) {
            String order        = orders[a];
            String[] orderArr   = new String[order.length()];
            boolean[] visited   = new boolean[order.length()];

            for(int olength = 0 ; olength < order.length() ; olength++) {
                orderArr[olength] = String.valueOf(order.charAt(olength));
            }//end for()

            Arrays.sort(orderArr);

            for(int b = 0 ; b < course.length ; b++) {
                int r = course[b];
                combination(orderArr, visited, 0, orderArr.length, r);
            }//end for()
        }//end for()

        //코스 길이마다의 최대 주문 횟수 구하기
        for(int c = 0 ; c < course.length ; c++) {
            int max     = 0;
            int cLength = course[c];
            //최대 길이 먼저 뽑고.
            for(String key : map.keySet()) {

                //조합의 길이가 코스와 같다면
                if(key.length() == cLength) {
                    int value = map.get(key);
                    if(max < value) max = value;
                }//end if()

            }//end for()

            courseLength[c] = max;
        }//end for()

        //정답 뽑기
        for(int z = 0 ; z < course.length ; z++) {
            int courseCnt = course[z];
            int courseMax = courseLength[z];
            if(1 < courseMax) {
                for(String key : map.keySet()) {
                    if(key.length() == courseCnt && map.get(key) == courseMax) {
                        resultList.add(key);
                    }
                }//end for()
            }//end if()
        }//end for()

        Collections.sort(resultList);

        answer = resultList.toArray(new String[resultList.size()]);

        return answer;
    }

	static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }//end if()

        for(int i = start ; i < n ; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }//end for()
    }//end combination()

    static void print(String[] arr, boolean[] visited, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (visited[i]) sb.append(arr[i]);
        }//end for()

        String orderCase = sb.toString();

        //신규 주문
        if(map.get(orderCase) == null) {
            map.put(orderCase, 1);

        //기존 주문
        } else { 
            int cnt = map.get(orderCase);
            cnt++;
            map.put(orderCase, cnt);
        }//end if()

    }//end print()

}//end class()