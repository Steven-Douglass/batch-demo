import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

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
  data: ExportData[] = [];
  testData: ExportData[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getApiData().subscribe((data) => this.data = data);
  }

}