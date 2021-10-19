package com.douglass.demo.batchdemobe;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

import com.douglass.demo.batchdemobe.model.ExportData;
import com.douglass.demo.batchdemobe.model.ImportData;

public class ImportDataItemProcessor implements ItemProcessor<ImportData, ExportData>{

	@Override
	public ExportData process(ImportData item) throws Exception {
		Date date = new Date();
		return new ExportData(item.getColor(), item.getNumber(), date);
	}

}
