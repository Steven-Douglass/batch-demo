package com.douglass.demo.batchdemobe.controller;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglass.demo.batchdemobe.BatchConfiguration;

@RestController
@RequestMapping("/api")
public class BatchRestController {

	private final JobLauncher jobLauncher;
	private final ApplicationContext applicationContext;
	private final JobExplorer jobExplorer;

	@Autowired
	public BatchRestController(JobLauncher jobLauncher, ApplicationContext applicationContext,
			JobExplorer jobExplorer) {
		this.jobLauncher = jobLauncher;
		this.applicationContext = applicationContext;
		this.jobExplorer = jobExplorer;
	}

	@GetMapping("/runBatchJob")
	public ExitStatus runBatchJob() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Job importDataJob = this.applicationContext.getBean(BatchConfiguration.JOB_NAME, Job.class);
		JobParameters jobParameters = new JobParametersBuilder(this.jobExplorer)
				.getNextJobParameters(importDataJob)
				.toJobParameters();
		return this.jobLauncher.run(importDataJob, jobParameters).getExitStatus();
	}

}