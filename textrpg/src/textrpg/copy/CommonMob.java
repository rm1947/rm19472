package textrpg.copy;

import java.util.Random;

public class CommonMob extends Monster {
Random r = new Random();	
	
	// 방법 1.
//	String mob[]; 
//	
//	public CommonMob(int number) {
//		this.mob = new String[number];
//		for (int i = 0; i < number; i++) {
//			this.mob[i] = mobName[r.nextInt(10)];
//			this.hp = 300 + r.nextInt(200);
//			this.toString(i);
//		}
//		
//	}
//	
//	public String toString(int i) {
//		System.out.print(this.mob[i]);
//		return super.toString();
//	}
	
	// 방법 2.
	String commonMob;
	
	public CommonMob (int player_level) {
		this.commonMob = mobName[r.nextInt(mobName.length)];
		
		double hardness = player_level*0.1+1;
		
		this.hp = (int)Math.round((2000 + r.nextInt(2000))*hardness);
		this.toString();
	}
	

	public String toString() {
		System.out.print(this.commonMob);
		return super.toString();
	}
	
	@Override
	public int attack(int player_level) {
		double hardness = player_level*0.1+1;
		int mobNum = 5 + r.nextInt(6);
		
		this.damage = (int)Math.round((25 + r.nextInt(10))*mobNum*hardness);
		return this.damage;
	}
	
	@Override
	public void checkHP() {
		if (this.hp < 1) {
			System.out.println(this.commonMob + "이(가) 죽었습니다.");
			this.isLive = false;
			this.hp = 0;	// 사망시 HP 마이너스 된 값 0으로 보정.
		}
	}
	
	// Monster 클래스의 skill() 메소드와 비교해보자. recoveryHP() 메소드는 abstract로 만들었기 때문에 사용하지 않더라도 반드시 구현해줘야한다!
	@Override
	public void recoveryHP() {
		
	}


	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// skill()메소드는 abstract 메소드가 아닌 일반 메소드로 만들었기 때문에 Sub 클래스에서 반드시 함수를 재정의해서 구현할 필요가 없다.
}
