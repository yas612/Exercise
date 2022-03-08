package com.q3.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;



public class BikeChunkCounter implements ChunkListener {

	private static final Logger log = LoggerFactory.getLogger(BikeChunkCounter.class);

	@Override
	public void beforeChunk(ChunkContext context) {
	}

	@Override
	public void afterChunk(ChunkContext context) {

		int readCount = context.getStepContext().getStepExecution().getReadCount();
		System.out.println("Total Items Read from DB: " + readCount);
		log.info("Total Items Read from DB: " + readCount);

		int writeCount = context.getStepContext().getStepExecution().getWriteCount();
		System.out.println("Total Items Write to XML: " + writeCount);
		log.info("Total Items Write to DB: " + writeCount);
	}

	@Override
	public void afterChunkError(ChunkContext context) {
	}
}