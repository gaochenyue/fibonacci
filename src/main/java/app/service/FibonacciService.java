package app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.model.FibonacciNumber;
import app.model.FibonacciSequence;

@Service
public class FibonacciService {

	// public interface to get Fibonacci Sequence
	public FibonacciSequence getFibonacciSequence(Integer n) {
		FibonacciSequence fibonacciSequence = new FibonacciSequence();
		for (Integer i = 0; i <= n; i++) {
			FibonacciNumber newFibonacciNumber = getFibonacciNumber(i);
			fibonacciSequence.addFibonacciNumber(newFibonacciNumber);
		}

		return fibonacciSequence;
	}

	// public interface to get Fibonacci Number
	public FibonacciNumber getFibonacciNumber(Integer n) {
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		Integer value = fibonacci(n, cache);
		FibonacciNumber fibonacciNumber = new FibonacciNumber(n, value);
		return fibonacciNumber;

	}

	// get the fibonacci number at position n
	private Integer fibonacci(Integer n, Map<Integer, Integer> cache) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		Integer fn1 = cache.containsKey(n - 1) ? cache.get(n - 1) : fibonacci(n - 1, cache);
		Integer fn2 = cache.containsKey(n - 2) ? cache.get(n - 2) : fibonacci(n - 2, cache);
		Integer fn = fn1 + fn2;
		cache.put(n, fn);
		return fn;
	}
}
