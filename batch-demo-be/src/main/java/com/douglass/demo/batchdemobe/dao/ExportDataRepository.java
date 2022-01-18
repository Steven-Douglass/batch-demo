package com.douglass.demo.batchdemobe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglass.demo.batchdemobe.model.ExportData;

public interface ExportDataRepository extends JpaRepository<ExportData, Integer> {

}
