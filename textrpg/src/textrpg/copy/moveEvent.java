package textrpg.copy;

import java.util.Scanner;


public class moveEvent {
	
	Scanner s = new Scanner(System.in);
	
	public int haegruid() {
		for (int i = 0; i < 99; i++) {
			try {
				System.out.println("◎ 해그리드의 상자를 발견했습니다. ");
				System.out.println(" [ 1 ] [ 2 ] [ 3 ] ");
				System.out.println("◎ 숫자를 입력해주세요. ");
				int yourDecision = s.nextInt();
				s.nextLine();
				
				if(yourDecision==1 || yourDecision==2 || yourDecision==3) {
					System.out.print("◎ 해그리드의 " + yourDecision + "번 상자에서 ");
					
					
					
					break;
				}
				else {
					System.out.println("정수만 입력해주세요.");
				}
			}
			
			catch (Exception e) {
				System.out.println("정수만 입력해주세요.");
				s.nextLine();	// nextInt()에 문자열이 들어와서 오류를 내고 바로 빠졌을 경우 여기서 System.in에 들어있는 문자열을 소거시킨다. 얘가 없으면 무한루프를 타게 된다.
//				this.skill();
			}
		}
		return 0;
	}
	
	public int nohaegruid() {
		for (int i = 0; i < 99; i++) {
			try {
				System.out.println("◎ 신비의 약초를 발견했습니다. ");
				System.out.println(" { 1 } { 2 } { 3 } ");
				System.out.println("◎ 숫자를 입력해주세요. ");
				int yourDecision = s.nextInt();
				s.nextLine();
				
				if(yourDecision==1 || yourDecision==2 || yourDecision==3) {
					System.out.print("◎ " + yourDecision + "번 신비의 약초에서 ");
					
					
					
					break;
				}
				else {
					System.out.println("정수만 입력해주세요.");
				}
			}
			
			catch (Exception e) {
				System.out.println("정수만 입력해주세요.");
				s.nextLine();	// nextInt()에 문자열이 들어와서 오류를 내고 바로 빠졌을 경우 여기서 System.in에 들어있는 문자열을 소거시킨다. 얘가 없으면 무한루프를 타게 된다.
//				this.skill();
			}
		}
		return 0;
	}
}
