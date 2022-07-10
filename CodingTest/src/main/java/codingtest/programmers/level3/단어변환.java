package codingtest.programmers.level3;

import java.util.Arrays;

public class 단어변환 {
	
	public static void main(String[] args) {
		
//		begin	target	words										return
//		"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
//		"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]			0
				
		String begin 		= "hit";
		String target 		= "cog";
		String[] words		= {"hot", "dot", "dog", "lot", "log"};
		int result 			= solution(begin, target, words);
		
		System.out.println(result);
	}//end main()
	
	private static boolean[] visited;
	private static int answer = 51;
	
	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		
		if(Arrays.asList(words).contains(target)) {
			
			dfs(begin, target, words, 0);
			
		} else {
			
			answer = 0;
			
		}//end if()
        
        return answer;
	}//end solution()
	
	private static void dfs(String begin, String target, String[] words, int depth) {
        if(begin.equals(target)) {
        	answer = Math.min(answer, depth);
            return;
        }//end if()
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diffOne(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }//end if()
        }//end for()
    }//end dfs()

	private static boolean diffOne(String str1, String str2) {
		boolean result 	= false;
		int diff 		= 0;
		
		for(int a = 0 ; a < str1.length() ; a++) {
			if(str1.charAt(a) != str2.charAt(a)) {
				diff++;
			}//end if()
		}//end for()
		
		if(diff == 1) result = true;
		return result;
	}//end diffOne()
}//end class()