import { Component, OnInit } from '@angular/core';

export interface ExportData {
  id: number;
  color: string;
  date: Date;
  number: number;
}

const EXPORT_DATA: ExportData[] = [
  {id: 1, color: 'R', date: new Date("2019-01-16"), number: 5204},
  {id: 2, color: 'R', date: new Date("2014-10-04"), number: 17224},
  {id: 3, color: 'B', date: new Date("2019-01-16"), number: 615274},
  {id: 4, color: 'B', date: new Date("2019-01-16"), number: 204154},
  {id: 5, color: 'G', date: new Date("2019-01-16"), number: 18204},
  {id: 6, color: 'G', date: new Date("2019-01-16"), number: 85124},
  {id: 7, color: 'Y', date: new Date("2019-01-16"), number: 156824},
  {id: 8, color: 'Y', date: new Date("2019-01-16"), number: 3275124},
];

@Component({
  selector: 'app-table-view',
  templateUrl: './table-view.component.html',
  styleUrls: ['./table-view.component.css']
})
export class TableViewComponent implements OnInit {
  displayedColumns: string[] = ['id', 'color', 'date', 'number'];
  dataSource = EXPORT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
