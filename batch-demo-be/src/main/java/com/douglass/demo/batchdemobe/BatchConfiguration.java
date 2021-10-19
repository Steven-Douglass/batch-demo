package com.douglass.demo.batchdemobe;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.douglass.demo.batchdemobe.model.ExportData;
import com.douglass.demo.batchdemobe.model.ImportData;

@EnableBatchProcessing
public class BatchConfiguration {

	private static final String JOB_NAME = "importDataJob";
	private static final String STEP_NAME = "importDataStep";
	private static final Integer AED_DATA_CHUNK_SIZE = 100;
	private static final String[] IMPORT_DATA_PARAMETERS = {"color", "number"};

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Autowired
	public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Job batchJob() {
		return jobBuilderFactory.get(JOB_NAME)
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get(STEP_NAME)
				.<ImportData, ExportData>chunk(AED_DATA_CHUNK_SIZE)
				.reader(reader())
				.writer(null)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<ImportData> reader() {
		BeanWrapperFieldSetMapper<ImportData> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(ImportData.class);

		return new FlatFileItemReaderBuilder<ImportData>()
				.name("importDataReader")
				.resource(new ClassPathResource("sample-data.csv"))
				.delimited()
				.names(IMPORT_DATA_PARAMETERS)
				.fieldSetMapper(beanWrapperFieldSetMapper)
				.build();
	}

}
