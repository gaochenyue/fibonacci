package app.model;

public class FibonacciNumber {
	int position;
	int value;
	public FibonacciNumber(int position, int value){
		this.position=position;
		this.value=value;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
