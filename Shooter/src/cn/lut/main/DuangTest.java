package cn.lut.main;

public class DuangTest {

	public static void main(String[] args) {
		Airplane airplane=new Airplane();
		airplane.x = 48;
		airplane.y = 81;
		airplane.width = 87;
		airplane.height = 60;
		
		Bullet b1 = new Bullet(116, 126);
		Bullet b2 = new Bullet(71, 189);
		System.out.println(airplane.duang(b1));
		System.out.println(airplane.duang(b2));
	}

}
