package strategy2.modularization;
import strategy2.inter.*;
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());//engine = new EngineHigh();
		setKm(new Km10());//km     = new Km10();
		setFuel(new FuelGasoline());//fuel   = new FuelGasoline();
	}
	
	@Override
	public void shape() {
		// "���׽ý� �� ����� door, sheet, handle�� �̷���� �ִ�"
		System.out.print("���׽ý� ");
		super.shape();
	} 
}
