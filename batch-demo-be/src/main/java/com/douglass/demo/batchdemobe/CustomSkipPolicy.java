package com.douglass.demo.batchdemobe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.validator.ValidationException;

public class CustomSkipPolicy implements SkipPolicy {

	private static final Logger logger = LogManager.getLogger(CustomSkipPolicy.class);
	private static final int skipLimit = 5;

	@Override
	public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {
		logger.error("{} {} skipCount: {}", exception.getClass(), exception.getMessage(), skipCount);

		if (skipCount >= skipLimit) {
			logger.error("Too many input errors. Ending execution...");
			throw new SkipLimitExceededException(skipLimit, exception);
		}

		return (exception instanceof FlatFileParseException || exception instanceof ValidationException);
	}
}
