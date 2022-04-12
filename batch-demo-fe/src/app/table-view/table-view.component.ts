import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from '../services/api.service';
import { MatSort } from '@angular/material/sort';

export interface ExportData {
  id: number;
  color: string;
  date: Date;
  number: number;
}

@Component({
  selector: 'app-table-view',
  templateUrl: './table-view.component.html',
  styleUrls: ['./table-view.component.css']
})
export class TableViewComponent implements OnInit {
  displayedColumns: string[] = ['id', 'color', 'date', 'number'];
  dataSource = new MatTableDataSource<ExportData>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getApiData().subscribe((data) => {
      this.dataSource = new MatTableDataSource<ExportData>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  runBatchJob() {
    this.apiService.runBatchJob().subscribe(() => {
      this.retrieveTableData();
    });
  }

  retrieveTableData() {
    this.apiService.getApiData().subscribe((data) => {
      this.dataSource.data = data;
    });
  }

  deleteAll() {
    this.apiService.deleteAll().subscribe(() => {
      this.dataSource.data = [];
    });
  }

}