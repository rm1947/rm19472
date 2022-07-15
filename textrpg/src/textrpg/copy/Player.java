package textrpg.copy;


public abstract class Player {
	String playerName;
	int hp;
	int recovery;
	int blending;
	boolean isLive = true;
	int damage;
	int saveskill;
	int level;
	int exp;
	int isAlive;
	
	// abstract Ŭ������ ����ٰ� 
	public String toString() {
		System.out.print(" HP: " + this.hp);
		return "";
	}
	
	public abstract int attack();
	
	public abstract void checkHP();
	
	public abstract void recoveryHP();
	
	// abstract �޼ҵ带 ����� ��� �ݵ�� �� Ŭ���� ���� abstract Ŭ������ ���������Ѵ�.
	public abstract int skill();
	
	// abstractŬ������� �Ϲ� �޼ҵ带 �ƿ� �� ���°� �ƴϴ�.
//	public int skill() {
//		return 0;		
//	}
}
