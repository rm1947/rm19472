package textrpg.copy;

import java.util.Random;


public class BossMob extends Monster {
Random r = new Random();
	
	String bossName;
	String bossNameArray[] = {"키메라","코카트리스","드래곤","혼드 서펀트","레시폴드","만티코어","눈두","퀸타페드","웜퍼스 캣","웨어울프","애크로맨툴라","바실리스크"};
	
	public BossMob (int player_level) {
		
		double hardness = player_level*0.1+1;
		
		this.bossName = bossNameArray[r.nextInt(11)];
		this.hp = (int) Math.round((20000+r.nextInt(10000))*hardness);
		this.recovery = 100;
		this.hp_backup = this.hp;
		this.toString();
	}
	
	public String toString() {
		System.out.print(this.bossName);
		return super.toString();
	}
	
	@Override
	public int attack(int player_level) {
		double hardness = player_level*0.1+1;
		if (r.nextInt(10) == 0) {	// 10% 확률로 실행.
			System.out.println("△ " + this.bossName + "이(가) 치명타로 공격합니다!");
			this.damage = (int)Math.round((800 + r.nextInt(800))*hardness);
			return this.damage;
		} else {					// 90% 확률로 실행.
			this.damage = (int)Math.round((200 + r.nextInt(400))*hardness);
			return this.damage;
		}
	}
	
	@Override
	public void checkHP() {
		if (this.hp < 1) {
			System.out.println("△ " + this.bossName + "이(가) 죽었습니다.");
			this.isLive = false;
			this.hp = 0;	// 사망시 HP 마이너스 된 값 0으로 보정.
		}
	}
	
	@Override
	public void recoveryHP() {
		if (this.hp < this.hp_backup) {
			this.hp = this.hp + this.recovery;
		}
		if (this.hp > this.hp_backup) {	// 회복은 하지만 자신의 최대 HP를 넘어갈 수 없도록 보정.
			this.hp = this.hp_backup;
		}
	}
	
	
	public int skill() {
		this.damage = 500 + r.nextInt(1000);
		return this.damage;
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}
}
