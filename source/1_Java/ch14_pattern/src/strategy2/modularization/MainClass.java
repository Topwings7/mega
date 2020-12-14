package strategy2.modularization;

import strategy2.inter.FuelHybrid;

public class MainClass {
	public static void main(String[] args) {
		Car[] cars = {new Genesis(), new Sonata(), new Accent()};
		cars[1].setFuel(new FuelHybrid()); // ���̺긮��� fuel ��ü
		for(Car car : cars) {
			System.out.println("=====================================");
			car.shape();
			car.drive();
			car.isEngine();
			car.isKmPerLitter();
			car.isFuel();
		}
	}
}
