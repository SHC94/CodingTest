package codingtest.baekjoon.deepening;

import java.util.Scanner;

public class 너의평점은 {

	public static void main(String[] args) {

		Scanner sc 		= new Scanner(System.in);
		double summary 	= 0;				// 학점 * 과목평점
		double total 	= 0;				// 총학점

		for (int i = 0; i < 20; i++) {

			String subject 	= sc.next();				// 과목명
			double point 	= sc.nextDouble();			// 학점
			String grade	= sc.next();				// 등급

			if ("A+".equals(grade)) {
				summary 		+= point * 4.5;
				total 			+= point;
			} else if ("A0".equals(grade)) {
				summary 		+= point * 4.0;
				total 			+= point;
			} else if ("B+".equals(grade)) {
				summary 		+= point * 3.5;
				total 			+= point;
			} else if ("B0".equals(grade)) {
				summary 		+= point * 3.0;
				total 			+= point;
			} else if ("C+".equals(grade)) {
				summary 		+= point * 2.5;
				total 			+= point;
			} else if ("C0".equals(grade)) {
				summary 		+= point * 2.0;
				total 			+= point;
			} else if ("D+".equals(grade)) {
				summary 		+= point * 1.5;
				total 			+= point;
			} else if ("D0".equals(grade)) {
				summary 		+= point * 1.0;
				total 			+= point;
			} else if ("F".equals(grade)) {
				summary 		+= point * 0.0;
				total 			+= point;
			}
		}

		System.out.printf("%.6f", summary / total);
	}
}
