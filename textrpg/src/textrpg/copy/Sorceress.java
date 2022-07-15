package textrpg.copy;

import java.util.Random;
import java.util.Scanner;

public class Sorceress extends Player {
	Random r = new Random();
	Scanner s = new Scanner(System.in);
	
	public Sorceress() {
		this.playerName = "당신";
		this.hp = 6500;
		this.recovery = 50;
		this.saveskill = 0;
		this.level = 1;
		this.exp = 0;
		this.isAlive = 0;
		
	}
	
	public String toString() {
		System.out.print(this.playerName);
		return super.toString();
	}
	
	@Override
	public int attack() {
		this.damage = 100 + r.nextInt(200);
		return this.damage;
	}
	
	@Override
	public void checkHP() {
		if (this.hp < 1) {
			System.out.println(this.playerName + "이(가) 죽었습니다.");
			this.isLive = false;
			this.hp = 0;	// 사망시 HP 마이너스 된 값 0으로 보정.
		}
	}
	
	@Override
	public void recoveryHP() {
		if (this.hp < 6500) {
			this.hp = this.hp + this.recovery;
		}
		if (this.hp > 6500) {	// 회복은 하지만 자신의 최대 HP를 넘어갈 수 없도록 보정.
			this.hp = 6500;
		}
	}
	
	@Override
	public int skill() {
		for (int i = 0; i < 99; i++) {
			try {
				System.out.println(this.playerName + "의 마력을 해방하려면 '1', 축적하려면 '2'를 입력하세요. [마력 게이지 " + (this.saveskill+1)*100 + "%]");
				int yourDecision = s.nextInt();
				s.nextLine();	// nextInt() return 소거용. 이거는 nextInt()에 정수가 들어왔을 경우에만 소거가 작동하지 nextInt()에 문자가 들어올 경우에는 아예 윗 라인에서 에러가 나고 바로 catch로 빠지기 때문에 입력이 들어오지 않는다.
				if (yourDecision == 1) {
					System.out.println(this.playerName + "이(가) 메테오를 사용합니다.");
					this.damage = ((1000 + r.nextInt(4000)) * (this.saveskill + 1));
					this.saveskill = 0;
					break;	// 정상 입력이 들어왔을 경우 for문을 나가기 위한 제어.
				} else if (yourDecision == 2) {
					System.out.println("마력을 축적합니다.");
					this.saveskill = this.saveskill + 1;
					this.damage = 0; // 최초 턴 이후 스킬을 모았을 때 이전에 턴에 저장된 일반 공격력 값에 의해 플레이어의 공격이 실행되지 않도록 초기화.
					break;	// 정상 입력이 들어왔을 경우 for문을 나가기 위한 제어.
				} else {
					System.out.println("정수 '1' 또는 '2'만 입력해주세요.");
//					this.skill();	// for문을 돌기 때문에 얘가 있으면 안 된다. 얘가 있으면 for문 반복에 재귀 호출이 되어 버려서 오류 3번 입력시 정상 입력을 3번 해서 break를 3번 제어 받아야 루프를 완전히 나갈 수 있다.
			}
			System.out.println("");
			} catch (Exception e) {
				System.out.println("정수 '1' 또는 '2'만 입력해주세요.");
				s.nextLine();	// nextInt()에 문자열이 들어와서 오류를 내고 바로 빠졌을 경우 여기서 System.in에 들어있는 문자열을 소거시킨다. 얘가 없으면 무한루프를 타게 된다.
//				this.skill();	// for문을 돌기 때문에 얘가 있으면 안 된다. 얘가 있으면 for문 반복에 재귀 호출이 되어 버려서 오류 3번 입력시 정상 입력을 3번 해서 break를 3번 제어 받아야 루프를 완전히 나갈 수 있다.
			}
		}
			
		return this.damage;
		
	}
}
