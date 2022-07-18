package textrpg.copy;


public abstract class Monster {
	String mobName[] = {"켄타우로스","그리핀","케르베로스","인어","오거","바다뱀","스핑크스","트롤","유니콘","세스트랄","와이번","예티"};
	int hp;
	int recovery;
	int blending;
	boolean isLive = true;
	int damage;
	int hp_backup;
	
	public String toString() {
		System.out.print(" HP: " + this.hp + " / ");
		return "";
	}
	
	public abstract int attack();
	
	public abstract void checkHP();
	
	// 아래 public int skill()과 비교해보자.
	public abstract void recoveryHP();
	
	// public abstract skill()로 바꿀 경우 CommobMob 클래스에서 skill 메소드를 사용하지 않더라도 구현해줘야한다. 
	public int skill() {
		return 0;
	}

	public int attack(int player_level) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

	