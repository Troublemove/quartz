package com.itstyle.quartz.othertest;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Test01 t = new Test01();
//		t.t13();
		
		int i = 0;
		i++;
		System.out.println("i=  " +i);
	}

	private void t13() {
		for (int x = 1; x < 100000; x++) {
			if (Math.sqrt(x + 100) % 1 == 0) {
				if (Math.sqrt(x + 168) % 1 == 0) {
					System.out.println(x + "加100是一个完全平方数，再加168又是一个完全平方数");
				}
			}
		}

	}
	
	private void t12() {
		double x = 0, y = 0;
		System.out.print("输入当月利润（万）：");
		Scanner s = new Scanner(System.in);
		x = s.nextInt();
		if (x > 0 && x <= 10) {
			y = x * 0.1;
		} else if (x > 10 && x <= 20) {
			y = 10 * 0.1 + (x - 10) * 0.075;
		} else if (x > 20 && x <= 40) {
			y = 10 * 0.1 + 10 * 0.075 + (x - 20) * 0.05;
		} else if (x > 40 && x <= 60) {
			y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (x - 40) * 0.03;
		} else if (x > 60 && x <= 100) {
			y = 20 * 0.175 + 20 * 0.05 + 20 * 0.03 + (x - 60) * 0.015;
		} else if (x > 100) {
			y = 20 * 0.175 + 40 * 0.08 + 40 * 0.015 + (x - 100) * 0.01;
		}
		System.out.println("应该提取的奖金是 " + y + "万");

	}

	private void t11() {
		int count = 0;
		for (int x = 1; x < 5; x++) {
			for (int y = 1; y < 5; y++) {
				for (int z = 1; z < 5; z++) {
					if (x != y && y != z && x != z) {
						count++;
						System.out.println(x * 100 + y * 10 + z);
					}
				}
			}
		}
		System.out.println("共有" + count + "个三位数");
	}

	private void t10() {
		double h = 100, s = 0;
		for (int i = 1; i <= 10; i++) {
			s = s + 2 * h;
			h = h / 2;
		}
		s = s - 100;
		System.out.println("经过路程：" + s);
		System.out.println("最后高度：" + h);

	}

	private void t9() {
		System.out.println("1到1000的完数有： ");
		for (int i = 1; i < 1000; i++) {
			int t = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					t = t + j;
				}
			}
			if (t == i) {
				System.out.print(i + "     ");
			}
		}
	}

	private void t8() {
		long a, b = 0, sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("输入数字a的值： ");
		a = s.nextInt();
		System.out.print("输入相加的项数：");
		int n = s.nextInt();
		int i = 0;
		while (i < n) {
			b = b + a;
			sum = sum + b;
			a = a * 10;
			++i;
		}
		System.out.println(sum);
	}

	private void t7() {
		int abcCount = 0;// 英文字母个数
		int spaceCount = 0;// 空格键个数
		int numCount = 0;// 数字个数
		int otherCount = 0;// 其他字符个数
		Scanner scan = new Scanner(System.in);// 扫描器接受控制台的输入信息
		System.out.println("输入一组字符");
		String str = scan.nextLine();// 取出控制台的一行信息,也就是你输入的信息
		char[] ch = str.toCharArray();// 把取道的字符串变成一个char数组
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetter(ch[i])) {
				// 判断是否字母
				abcCount++;
			} else if (Character.isDigit(ch[i])) {
				// 判断是否数字
				numCount++;
			} else if (Character.isSpaceChar(ch[i])) {
				// 判断是否空格键
				spaceCount++;
			} else {
				// 以上都不是则认为是其他字符
				otherCount++;
			}
		}
		System.out.println("字母个数：" + abcCount);
		System.out.println("数字个数：" + numCount);
		System.out.println("空格个数：" + spaceCount);
		System.out.println("其他字符个数：" + otherCount);
	}

	private int t6(int x, int y) {
		int t;
		if (x < y) {// 确保x > y
			t = x;
			x = y;
			y = t;
		}
		while (y != 0) {
			if (x == y)
				return x;
			else {
				int k = x % y;
				x = y;
				y = k;
			}
		}
		return x;
	}

	private void t5() {
		int x;
		char grade;
		Scanner s = new Scanner(System.in);
		System.out.print("请输入一个成绩: ");
		x = s.nextInt();
		grade = x >= 90 ? 'A' : x >= 60 ? 'B' : 'C';
		System.out.println("等级为：" + grade);
	}

	private void t4() {
		Scanner s = new Scanner(System.in);
		System.out.print("请键入一个正整数:     ");
		int n = s.nextInt();
		int k = 2;
		System.out.print(n + "=");
		while (k <= n) {
			if (k == n) {
				System.out.println(n);
				break;
			} else if (n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
			} else
				k++;
		}
	}

	private void t3() {
		int b1, b2, b3;
		for (int m = 101; m < 1000; m++) {
			b3 = m / 100;
			b2 = m % 100 / 10;
			b1 = m % 10;
			if ((b3 * b3 * b3 + b2 * b2 * b2 + b1 * b1 * b1) == m) {
				System.out.println(m + "是一个水仙花数");
			}
		}
	}

	private void t2() {
		int count = 0;
		for (int i = 101; i < 200; i += 2) {
			boolean b = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				} else {
					b = true;
				}
			}
			if (b == true) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("素数个数是: " + count);

	}

	private void t1() {
		System.out.println("第1个月的兔子对数:    1");
		System.out.println("第2个月的兔子对数:    1");
		int f1 = 1, f2 = 1, f, M = 24;
		for (int i = 3; i <= M; i++) {
			f = f2;
			f2 = f1 + f2;
			f1 = f;
			System.out.println("第" + i + "个月的兔子对数: " + f2);
		}
	}
}
