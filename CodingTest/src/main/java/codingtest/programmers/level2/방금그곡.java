package codingtest.programmers.level2;

import java.math.BigInteger;
import java.util.HashMap;

public class 방금그곡 {
	
	public static void main(String[] args) {
		
//		m						musicinfos	answer
//		"ABCDEFG"				["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"HELLO"
//		"CC#BCC#BCC#BCC#B"		["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	"FOO"
//		"ABC"					["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]	"WORLD"

		String m			= "CC#BCC#BCC#BCC#B";
		String[] musicinfos	= {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String result 		= solution(m, musicinfos);
		
		System.out.println(result);
	}//end main()
	
	static BigInteger max = new BigInteger("0");
	
	public static String solution(String m, String[] musicinfos) {
		int longTime	= -1;
        HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        
        for(int a = 0 ; a < musicinfos.length ; a++) {
        	String musicInfo 	= musicinfos[a];
        	String[] musicArr 	= musicInfo.split(",");

        	/**재생시간*/
        	int startHour 		= Integer.parseInt(musicArr[0].split(":")[0]);
        	int endHour 		= Integer.parseInt(musicArr[1].split(":")[0]);        	
        	int startMin 		= Integer.parseInt(musicArr[0].split(":")[1]);
        	int endMin 			= Integer.parseInt(musicArr[1].split(":")[1]);
        	int playTime		= ((endHour - startHour) * 60) + (endMin - startMin);
        	
        	/**악보*/
        	String scoreStd		= sharpReplace(musicArr[3]);
        	int scoreLength		= scoreStd.length();
        	StringBuilder score	= new StringBuilder();
        	int repeat 			= playTime / scoreLength;
        	int part			= playTime % scoreLength;
        	for(int b = 0 ; b < repeat ; b++) score.append(scoreStd);
        	if(part != 0) score.append(scoreStd.substring(0, part));
        	
        	/**일치 여부 확인*/
        	if(score.toString().contains(sharpReplace(m))) {
        		
        		if(longTime < playTime) longTime = playTime;
        		if(!resultMap.containsKey(playTime)) resultMap.put(playTime, a);
        		
        	}//end if()
        		
        }//end for()
        
        String answer = "(None)";
        if(resultMap.containsKey(longTime)) answer = musicinfos[resultMap.get(longTime)].split(",")[2];
        
        return answer;
    }
    
    private static String sharpReplace(String oldMelody) {
		
		oldMelody	= oldMelody.replaceAll("A#", "H")
								.replaceAll("C#", "I")
								.replaceAll("D#", "J")
								.replaceAll("F#", "K")
								.replaceAll("G#", "L");
								
		return oldMelody;
	}//end sharpReplace()
}//end class()
