package app.model;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
	public List<FibonacciNumber> getFibonacciSequence() {
		return fibonacciSequence;
	}

	public void setFibonacciSequence(List<FibonacciNumber> fibonacciSequence) {
		this.fibonacciSequence = fibonacciSequence;
	}

	List<FibonacciNumber> fibonacciSequence;

	public FibonacciSequence() {
		fibonacciSequence = new ArrayList<FibonacciNumber>();
	}
	
	public void addFibonacciNumber(FibonacciNumber fibonacciNumber){
		this.fibonacciSequence.add(fibonacciNumber);
	}
}
