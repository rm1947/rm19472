package textrpg.copy;

import java.util.Random;
import java.util.Scanner;



public class textrpg {
	
	public static void main(String[] args) {
		textrpg_main();
	}
	
	public static void textrpg_main() {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		

		int damageBar;
		int damageSor;
		int setBossStatus = 0;
		int level_backup = 0;
		int stamina = 10 + r.nextInt(5);
		boolean exceptionErrorFix = false; // 행동력이 음수일때 exception이 발생하면 지속적으로 데미지받는 현상 수정

		// Player 생성.
		Player[] player = new Player[2];
		player[0] = new Sorceress();
		player[1] = new Barbarian();

		moveEvent moveevent = new moveEvent();

		// System.out.println(player[0]);
		// System.out.println(player[1] + "\n");

		System.out.println("《 플레이어는 전투가 시작되면 마력 게이지를 100% 부여받고 이후 1턴마다 20%씩 부여받습니다.");
		System.out.println("  축적된 마력은 바로 해방할 수도 있지만 모아둘 경우 2배, 3배로 공격할 수 있습니다.");
		System.out.println("  대신 마력을 축적한 턴은 플레이어는 공격을 하지 않습니다. 》\n");

		 while (player[0].isAlive == 0) {

			System.out.println("[ LEVEL = " + player[0].level + " ] [ EXP = " + player[0].exp + " ] [ 공명도 = "
					+ setBossStatus * 10 + "% ] [ 행동력 = " + stamina + " ]");
			System.out.println("[ " + player[0].playerName + "의 HP = " + player[0].hp + " ] [ " + player[1].playerName
					+ "의 HP = " + player[1].hp + " ] ");
			System.out.println("[ " + player[0].playerName + "의 마력 = " + player[0].saveskill * 100 + "% ] [ "
					+ player[1].playerName + "의 마력 = " + player[1].saveskill * 100 + "% ] ");

			try {

				if (stamina < 0) {
					if (exceptionErrorFix == false) { // exceptionErrorFix체크해서 false일때만 데미지
						int tempdmgstm;
						double hardness = (player[0].level * 0.1) + 1;
						tempdmgstm = (int) Math.round((1000 + r.nextInt(500)) * hardness);
						System.out.println("");
						System.out.println("◎ 행동력이 모두 소진되어 역류한 마기에 의해 " + tempdmgstm + " 의 피해를 받습니다. ");
						player[0].hp = player[0].hp - tempdmgstm;
						player[1].hp = player[1].hp - tempdmgstm;
						System.out.println("");
						System.out.print("《 ");
						System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을 안 하는지
																// 순서가
						// 엉망이 되어 분리함.
						System.out.print(" ");
						System.out.print(player[1].toString());
						System.out.print(" 》");
						System.out.println("\n");

						if (player[0].hp < 0) { // 자기장 사망처리
							player[0].isAlive = 1;
							break;
						}
					}
				}

				System.out.println("[ 1.이동하기 ] [ 2.휴식하기 ]");
				System.out.println("");
				int yourDecision = s.nextInt();
				s.nextLine();

				if (yourDecision == 2) {
					exceptionErrorFix = false; // 정상적으로 진행되면 exceptionErrorFix를 false로 되돌림

					System.out.println("◎ 행동력을 1 소모하여 휴식을 취합니다. ");
					stamina = stamina - 1;
					double hardness = (player[0].level * 0.1) + 1;
					int temphp = (int) Math.round((200 + r.nextInt(400)) * hardness);
					System.out.println("◎ 휴식을 통해 체력을 " + temphp + "만큼 회복했습니다. ");
					player[0].recoveryHP(temphp);
					player[1].recoveryHP(temphp);

					System.out.println("");
					System.out.print("《 ");
					System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을 안 하는지 순서가
															// 엉망이 되어 분리함.
					System.out.print(" ");
					System.out.print(player[1].toString());
					System.out.print(" 》");
					System.out.println("\n");

				}

				else if (yourDecision == 1) {
					exceptionErrorFix = false; // 정상적으로 진행되면 exceptionErrorFix를 false로 되돌림

					System.out.println("◎ 행동력을 1 소모하여 이동합니다. ");
					stamina = stamina - 1;
					System.out.println("");
					int moveEventStatus = r.nextInt(9);

					if (moveEventStatus == 0) {
						
						moveevent.haegruid();
						
						
						int haegruidStatus = r.nextInt(2);
						if (haegruidStatus == 0) {
							System.out.println("체력강화 물약을 획득했습니다. ");

							double hardness = (player[0].level * 0.1) + 1;
							int temphp = (int) Math.round((2000 + r.nextInt(1000)) * hardness);
							player[0].recoveryHP(temphp);
							player[1].recoveryHP(temphp);

							System.out.println("◎ 체력강화 물약의 신비한 효과를 받아 체력을 " + temphp + "만큼 회복했습니다. ");
							System.out.println("");
							System.out.print("《 ");
							System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을 안
																	// 하는지 순서가
																	// 엉망이 되어 분리함.
							System.out.print(" ");
							System.out.print(player[1].toString());
							System.out.print(" 》");
							System.out.println("\n");
						}

						if (haegruidStatus == 1) {
							System.out.println("마력강화 물약을 획득했습니다. ");

							player[0].saveskill = player[0].saveskill + 2;
							player[1].saveskill = player[1].saveskill + 2;

							System.out.println("◎ 마력강화 물약의 신비한 효과를 받아 마력을 200%만큼 회복했습니다. ");

							System.out.println("[ " + player[0].playerName + "의 마력 = " + player[0].saveskill * 100
									+ "% ] [ " + player[1].playerName + "의 마력 = " + player[1].saveskill * 100 + "% ] ");
						}

						if (haegruidStatus == 2) {
							System.out.println("경험강화 물약을 획득했습니다. ");

							int tempexp = r.nextInt(200) + 100;
							System.out.println("◎ 경험강화 물약의 신비한 효과를 받아 경험치를" + tempexp + "획득했습니다.");
							player[0].exp = player[0].exp + tempexp;
							System.out.println("◎ 당신의 경험치는" + player[0].exp + "입니다.");

							if (level_backup != player[0].level) {
								for (int tempexpcheck = 0; tempexpcheck < player[0].level
										- level_backup; tempexpcheck++) {
									double temp_hardness = player[0].level * 0.1 + 1;
									int temphp = (int) Math.round((r.nextInt(400) + 200) * temp_hardness);
									System.out.println("◎ 레벨업을 통해 체력을 " + temphp + "만큼 회복했습니다.");
									player[0].recoveryHP(temphp);
									player[1].recoveryHP(temphp);
								}
								level_backup = player[0].level;

							}

						}
					}

					else if (moveEventStatus < 3) {
						
						moveevent.nohaegruid();
						
						
						int haegruidStatus = r.nextInt(2);
						if (haegruidStatus == 0) {
							System.out.println("체력강화 약초를 획득했습니다. ");

							double hardness = (player[0].level * 0.1) + 1;
							int temphp = (int) Math.round((2000 + r.nextInt(1000)) * hardness);
							player[0].recoveryHP(temphp);
							player[1].recoveryHP(temphp);

							System.out.println("◎ 체력강화 약초의 영험한 기운을 통해 체력을 " + temphp + "만큼 회복했습니다. ");
							System.out.println("");
							System.out.print("《 ");
							System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을 안
																	// 하는지 순서가
																	// 엉망이 되어 분리함.
							System.out.print(" ");
							System.out.print(player[1].toString());
							System.out.print(" 》");
							System.out.println("\n");
						}

						if (haegruidStatus == 1) {
							System.out.println("마력강화 약초를 획득했습니다. ");

							player[0].saveskill = player[0].saveskill + 1;
							player[1].saveskill = player[1].saveskill + 1;

							System.out.println("◎ 마력강화 약초의 영험한 기운을 통해 마력을 100%만큼 회복했습니다. ");

							System.out.println("[ " + player[0].playerName + "의 마력 = " + player[0].saveskill * 100
									+ "% ] [ " + player[1].playerName + "의 마력 = " + player[1].saveskill * 100 + "% ] ");
						}

						if (haegruidStatus == 2) {
							System.out.println("경험강화 약초를 획득했습니다. ");

							int tempexp = r.nextInt(100) + 50;
							System.out.println("◎ 경험강화 약초의 영험한 기운을 통해 경험치를" + tempexp + "획득했습니다.");
							player[0].exp = player[0].exp + tempexp;
							System.out.println("◎ 당신의 경험치는" + player[0].exp + "입니다.");

							if (level_backup != player[0].level) {
								for (int tempexpcheck = 0; tempexpcheck < player[0].level
										- level_backup; tempexpcheck++) {
									double temp_hardness = player[0].level * 0.1 + 1;
									int temphp = (int) Math.round((r.nextInt(400) + 200) * temp_hardness);
									System.out.println("◎ 레벨업을 통해 체력을 " + temphp + "만큼 회복했습니다.");
									player[0].recoveryHP(temphp);
									player[1].recoveryHP(temphp);
								}
								level_backup = player[0].level;

							}

						}
						
					}

					else {

						if (setBossStatus < 10) {

							// 일반몹 생성.
							// 방법 1.
							// CommonMob mob = new CommonMob(mobNum);
							//
							// Monster[] mob = new Monster[mobNum];
							//
							// for (int i = 0; i < mobNum; i++) {
							// mob[i] = new CommonMob(i);
							// }
							//
							// System.out.println(mob);

							// 방법 2.
							int mobNum = 5 + r.nextInt(6);
							mobNum = 1;
							Monster[] mob = new Monster[mobNum];

							System.out.print("△ ");
							for (int i = 0; i < mobNum; i++) {
								mob[i] = new CommonMob(player[0].level);
							}
							System.out.println("가 나타났습니다. [" + player[0].level + " 만큼 강화됨] ");

							// 일반몹과 전투 진행.
							for (int i = 0; i < 9999; i++) {
								if (i % 5 != 0) {
									System.out.println("[Enter]를 누르면 턴을 진행합니다. ");
									s.nextLine();
								}

								// 플레이어의 공격.
								if (i % 5 == 0) {
									damageSor = 0; // 최초 턴 이후 스킬을 모았을 때 이전에 턴에 저장된 값에 의해 일반 공격이 실행되지 않도록 초기화.
									damageBar = 0; // 최초 턴 이후 스킬을 모았을 때 이전에 턴에 저장된 일반 공격력 값에 의해 플레이어의 공격이 실행되지 않도록 초기화.
									damageSor = player[0].skill();
									damageBar = player[1].skill(player[0].level);
								} else {
									damageSor = player[0].attack();
									damageBar = player[1].attack(player[0].level);
								}

								if (player[0].isLive) { // Player 1이 살아있다면 실행.
									if (damageSor == 0) {
										System.out.println("◎ " + player[0].playerName + "은(는) 마력을 "
												+ player[0].saveskill * 100 + "% 만큼 축적했습니다.");
									} else {
										System.out.println(
												"◎ " + player[0].playerName + "이(가) 공격력 " + damageSor + "으로 공격합니다.");
									}
								}

								if (player[1].isLive) { // Player 2가 살아있다면 실행.
									if (damageBar == 0) {
										System.out.println("◎ " + player[1].playerName + "은(는) 마력을 "
												+ player[1].saveskill * 100 + "% 만큼 축적했습니다.");
									} else {
										System.out.println(
												"◎ " + player[1].playerName + "이(가) 공격력 " + damageBar + "으로 공격합니다.");
									}
								}
								System.out.println("");

								for (int j = 0; j < mobNum; j++) {
									if (mob[j].isLive) { // j번째 몹이 살아있다면
										// Player 1 Sorceress가 공격.
										mob[j].hp = mob[j].hp - damageSor;
										mob[j].checkHP();
									}
									if (mob[j].isLive) { // j번째 몹이 Player 1 Sorceress의 공격을 받고 살아있다면
										// Player 2 Barbarian이 공격.
										mob[j].hp = mob[j].hp - damageBar;
										mob[j].checkHP();

										System.out.print("△ "); // 몹체력표시
										System.out.println(mob[j].toString());

										if (mob[j].hp > 0) {
											int damage;
											// j번째 몹이 Player1, 2의 공격을 받고 살아있다면 몹이 플레이어를 공격.
											damage = mob[j].attack(player[0].level);
											int selectEnemy = r.nextInt(100);
											selectEnemy = selectEnemy % 2;
											System.out.print("△ ");
											System.out.println(mob[j] + "이(가) 공격력 " + damage + " 으로 "
													+ player[selectEnemy].playerName + "을(를) 공격합니다.");
											player[selectEnemy].hp = player[selectEnemy].hp - damage;
										}
									}

								}
								// System.out.println("");

								// 몹의 남은 체력 표시 및 종료 조건 생성.
								int remainTotalHP = 0; // 종료조건 생성용.
								for (int j = 0; j < mobNum; j++) {
									// System.out.print("△ ");
									// System.out.print( mob[j].toString());
									remainTotalHP = remainTotalHP + mob[j].hp;
								}
								System.out.println("\n");
								if (remainTotalHP != 0) {
									System.out.print("");
								} else {
									System.out.println("△ 적이 모두 죽었습니다.");
								}

								System.out.print("◎ ");
								System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을
																		// 안
																		// 하는지 순서가
																		// 엉망이 되어 분리함.
								System.out.print(" ");
								System.out.print(player[1].toString());

								System.out.println("\n");

								if (player[0].hp < 0) {
									player[0].isAlive = 1;
									break;
								}

								if (remainTotalHP == 0) {
									setBossStatus = setBossStatus + r.nextInt(2) + 1;
									System.out.println(
											"△ 불온한 기운이 흩뿌려지며  보스를 향한 공명의 기운이 " + setBossStatus * 10 + "% 만큼 차올랐습니다.");

									int tempexp = r.nextInt(100);
									System.out.println("◎ 경험치를" + tempexp + "획득했습니다.");
									player[0].exp = player[0].exp + tempexp;
									System.out.println("◎ 당신의 경험치는" + player[0].exp + "입니다.");

									player[0].level = player[0].exp / 100;

									System.out.println("◎ 현재 레벨은" + player[0].level + "입니다.");

									if (level_backup != player[0].level) {

										for (i = 0; i < player[0].level - level_backup; i++) {
											double temp_hardness = player[0].level * 0.1 + 1;
											int temphp = (int) Math.round((r.nextInt(400) + 200) * temp_hardness);
											System.out.println("◎ 레벨업을 통해 체력을 " + temphp + "만큼 회복했습니다.");
											player[0].recoveryHP(temphp);
											player[1].recoveryHP(temphp);
										}
										level_backup = player[0].level;

									}

									System.out.println("");
									System.out.println("--------------------------------------------");

									break;
								}

								// 플레이어는 살아있다면 매 턴마다 체력을 일정량 회복합니다.
								if (player[0].isLive) {
									double hardness = player[0].level * 0.1 + 1;
									player[0].recovery = (int) Math.round((30 + r.nextInt(30)) * hardness);
									player[0].recoveryHP();
									System.out.println("◎ " + player[0].playerName + "은(는) " + player[0].recovery
											+ "만큼 체력을 회복했습니다.");

								}
								if (player[1].isLive) {
									double hardness = player[0].level * 0.1 + 1;
									player[1].recovery = (int) Math.round((30 + r.nextInt(30)) * hardness);
									player[1].recoveryHP();
									System.out.println("◎ " + player[1].playerName + "은(는) " + player[1].recovery
											+ "만큼 체력을 회복했습니다.");
								}
								System.out.println("-------------------------------------------------");

							}

						}

						else {

							// 보스 공명의 기운 초기화
							setBossStatus = 0;

							System.out.println("\n\n");
							System.out.print("△ 공명의 기운이 엄습하여 보스 ");
							BossMob boss = new BossMob(player[0].level);
							System.out.println("가 나타났습니다. [" + player[0].level + " 만큼 강화됨] \n\n");

							// 보스몹 디아블로와 전투 진행.
							for (int i = 0; i < 9999; i++) {

								if (i % 5 != 0) {
									System.out.println("[Enter]를 누르면 턴을 진행합니다.");
									s.nextLine();
								}

								// 플레이어의 공격.
								if (i % 5 == 0) {
									damageSor = player[0].skill();
									damageBar = player[1].skill(player[0].level);
								} else {
									damageSor = player[0].attack();
									damageBar = player[1].attack(player[0].level);
								}

								if (player[0].isLive) { // Player 1이 살아있다면 실행.
									if (damageSor == 0) {
										System.out.println("◎ " + player[0].playerName + "은(는) 마력을 "
												+ player[0].saveskill * 100 + "%만큼 축적했습니다.");
									} else {
										System.out.println(
												"◎ " + player[0].playerName + "이(가) 공격력 " + damageSor + "으로 공격합니다.");
									}
									boss.hp = boss.hp - damageSor;
								}
								if (player[1].isLive) { // Player 2가 살아있다면 실행.
									if (damageBar == 0) {
										System.out.println("◎ " + player[1].playerName + "은(는) 마력을 "
												+ player[1].saveskill * 100 + "%만큼 축적했습니다.");
									} else {
										System.out.println(
												"◎ " + player[1].playerName + "이(가) 공격력 " + damageBar + "으로 공격합니다.");
									}
									boss.hp = boss.hp - damageBar;
								}
								System.out.println("");

								if (boss.isLive) {
									boss.checkHP();
								}

								if (boss.isLive) {
//				boss.hp = boss.hp - damageSor - damageBar;
									// boss.checkHP();
									// Player 1, 2의 공격을 받고 살아있다면 디아블로가 플레이어를 공격.
									int damage;
									damage = boss.attack(player[0].level);
									System.out.println("△ " + boss.bossName + "가 공격력 " + damage + "으로 공격합니다.");
									if (player[0].isLive) {
										player[0].hp = player[0].hp - damage;
									}
									if (player[1].isLive) {
										player[1].hp = player[1].hp - damage;
									}

								}

								// 디아블로의 남은 체력 표시 및 종료 조건 생성.
								System.out.print("△ ");
								System.out.println(boss.toString());

								System.out.println("\n");

								System.out.print("◎ ");
								System.out.print(player[0].toString()); // toString은 출력시 "다른 문장"이나 + " " + 와 결합하면 순서 인식을
																		// 안
																		// 하는지 순서가
																		// 엉망이 되어 분리함.
								System.out.print(" ");
								System.out.print(player[1].toString());

								System.out.println("\n");

								if (player[0].hp < 0) {
									player[0].isAlive = 1;
									break;
								}

								if (!boss.isLive) {
									System.out.println("△ 보스 " + boss.bossName + "을(를) 퇴치했습니다.");

									System.out.println("◎ 생명의 기운을 획득해 행동력을 회복했습니다.");
									double hardness = player[0].level * 0.1 + 1;
									if (stamina < 0) {
										stamina = 0;
									}
									stamina = (int) Math.round(stamina / 10)
											+ (int) Math.round((10 + r.nextInt(5)) * hardness);

									int tempexp = r.nextInt(200) + 100;
									System.out.println("◎ 경험치를" + tempexp + "획득했습니다.");
									player[0].exp = player[0].exp + tempexp;
									System.out.println("◎ 당신의 경험치는" + player[0].exp + "입니다.");

									player[0].level = player[0].exp / 100;

									System.out.println("◎ 현재 레벨은" + player[0].level + "입니다.");

									if (level_backup != player[0].level) {

										for (i = 0; i < player[0].level - level_backup; i++) {
											double temp_hardness = player[0].level * 0.1 + 1;
											int temphp = (int) Math.round((r.nextInt(400) + 200) * temp_hardness);
											System.out.println("◎ 레벨업을 통해 체력을 " + temphp + "만큼 회복했습니다.");
											player[0].recoveryHP(temphp);
											player[1].recoveryHP(temphp);
										}
										level_backup = player[0].level;

									}
									System.out.println("");
									System.out.println("--------------------------------------------");

									break;
								} else if (!player[0].isLive && !player[1].isLive) {
									System.out.println("◎ 플레이어는 졌습니다. 게임을 종료합니다.");
								}

								// 플레이어는 살아있다면 매 턴마다 체력을 일정량 회복합니다.
								if (player[0].isLive) {
									double hardness = player[0].level * 0.1 + 1;
									player[0].recovery = (int) Math.round((30 + r.nextInt(30)) * hardness);
									player[0].recoveryHP();
									System.out.println("◎ " + player[0].playerName + "은(는) " + player[0].recovery
											+ "만큼 체력을 회복했습니다.");
								}
								if (player[1].isLive) {
									double hardness = player[0].level * 0.1 + 1;
									player[1].recovery = (int) Math.round((30 + r.nextInt(30)) * hardness);
									player[1].recoveryHP();
									System.out.println("◎ " + player[1].playerName + "은(는) " + player[1].recovery
											+ "만큼 체력을 회복했습니다.");
								}

								// 디아블로 역시 살아있다면 매 턴마다 체력을 일정량 회복합니다.
								if (boss.isLive) {
									double hardness = player[0].level * 0.1 + 1;
									boss.recovery = (int) Math.round((100 + r.nextInt(100)) * hardness);
									boss.recoveryHP();
									System.out
											.println("△ " + boss.bossName + "은(는) " + boss.recovery + "만큼 체력을 회복했습니다.");
								}
								System.out.println("-------------------------------------------------");

							}

						}

						// 이동 > 1~20
						// 3 이벤트 : 7 몬스터 (보스는 그대로)
						// 총경험치량 레벨 > int 따로 생성 해그리드
					}
				}

				else {
					exceptionErrorFix = true; // exception에러가 발생하였을경우 데미지를 1회만 받기 위해 true로 변경

					System.out.println("다시 입력해주세요.");
					System.out.println("");
					System.out.println("============================================");
					System.out.println("");
					continue;
				}

			} catch (Exception e) {
				exceptionErrorFix = true; // exception에러가 발생하였을경우 데미지를 1회만 받기 위해 true로 변경

				System.out.println("다시 입력해주세요.");
				System.out.println("");
				System.out.println("============================================");
				System.out.println("");
				s.nextLine();
				continue;
			}

			if (player[0].hp < 0) {
				player[0].isAlive = 1;
				break;
			}

			System.out.println("============================================");
			System.out.println("");

		}

		System.out.println("◎ 패배했습니다. 최종결과 : 레벨[ " + player[0].level + " ] 점수 [ " + player[0].exp + " ]");
		s.close();
	}
}
