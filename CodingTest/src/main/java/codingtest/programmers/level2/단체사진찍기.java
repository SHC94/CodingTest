package codingtest.programmers.level2;

public class 단체사진찍기 {
	
	public static void main(String[] args) {
		
//		n	data				answer
//		2	["N~F=0", "R~T>2"]	3648
//		2	["M~C<2", "C~M>1"]	0

//		{A		, C	, F		, J		, M		, N		, R		, T} 
//		어피치	, 콘	, 프로도	, 제이지	, 무지	, 네오	, 라이언	, 튜브
		
		int n			= 2; 
		String[] data	= {"N~F=0", "R~T>2"};	
		int result 		= solution(n, data);
		
		System.out.println(result);
	}//end main()
	
	private static int answer = 0;
    private static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static int solution(int n, String[] data) {
        boolean[] visited = new boolean[friends.length];
        
        dfs("", visited, data);
        
        return answer;
    }//end solution()

    private static void dfs(String lineUp, boolean[] visited, String[] condition) {
        if (lineUp.length() == friends.length - 1) {
            if (check(lineUp, condition)) answer++;
            return;
        }//end if()
        
        for (int i = 0 ; i < friends.length ; i++) {
            if (!visited[i]) {
            	visited[i] = true;
                String line = lineUp + friends[i];
                dfs(line, visited, condition);
                visited[i] = false;
            }//end if()
        }//end for()
    }//end dfs()

    private static boolean check(String names, String[] condition) {
    	for (String data : condition) {
            int position1 	= names.indexOf(data.charAt(0));
            int position2 	= names.indexOf(data.charAt(2));
            int distance 	= Math.abs(position1 - position2);
            String cond 	= String.valueOf(data.charAt(3));
            int index 		= Character.getNumericValue(data.charAt(4));
            
            if (cond.equals("=") && !(distance == index + 1))		return false;
            else if (cond.equals(">") && !(distance > index + 1)) 	return false;
            else if (cond.equals("<") && !(distance < index + 1)) 	return false;
        }//end for()
        return true;
    }//end check()

}//end class()
