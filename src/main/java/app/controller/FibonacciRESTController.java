package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.FibonacciConstants;
import app.model.FibonacciError;
import app.model.FibonacciNumber;
import app.model.FibonacciSequence;
import app.service.FibonacciService;

@RestController
public class FibonacciRESTController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FibonacciService fibonacciService;

	// fibonacci sequence handler
	// return JSON representation of fibonacci sequence of n
	@RequestMapping(value = "/fibonacci/sequence/{n}")
	public Object getFibonacciSequence(@PathVariable String n) {
		FibonacciError fibonacciError = inputValidation(n);
		if (fibonacciError != null){
			return fibonacciError;
		}

		FibonacciSequence fibonacciSequence = fibonacciService.getFibonacciSequence(Integer.parseInt(n));

		return fibonacciSequence;
	}

	// fibonacci number handler
	// return JSON representation of fibonacci number of n
	@RequestMapping(value = "/fibonacci/number/{n}")
	public Object getFibonacciNumber(@PathVariable String n) {
		FibonacciError fibonacciError = inputValidation(n);
		if (fibonacciError != null)
			return fibonacciError;

		FibonacciNumber fibonacciNumber = fibonacciService.getFibonacciNumber(Integer.parseInt(n));

		return fibonacciNumber;
	}

	// valid the input value
	// if failed, return a FibonacciError, otherwise return null
	private FibonacciError inputValidation(String input) {
		Integer position;
		// Check if an integer
		try {
			position = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			logger.error(input+"|"+FibonacciConstants.ERROR_NON_INTEGER_INPUT);
			return new FibonacciError(input, FibonacciConstants.ERROR_NON_INTEGER_INPUT);
		}

		// Check if negative
		if (position < 0){
			logger.error(input+"|"+FibonacciConstants.ERROR_NEGATIVE_INPUT);
			return new FibonacciError(input, FibonacciConstants.ERROR_NEGATIVE_INPUT);
		}

		return null;
	}

}
