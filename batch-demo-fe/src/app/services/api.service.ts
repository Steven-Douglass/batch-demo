import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { ExportData } from '../table-view/table-view.component';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

const EXPORT_DATA: ExportData[] = [
  { id: 1, color: 'R', date: new Date("2019-01-16"), number: 5204 },
  { id: 2, color: 'R', date: new Date("2014-10-04"), number: 17224 },
  { id: 3, color: 'B', date: new Date("2019-01-16"), number: 615274 },
  { id: 4, color: 'B', date: new Date("2019-01-16"), number: 204154 },
  { id: 5, color: 'G', date: new Date("2019-01-16"), number: 18204 },
  { id: 6, color: 'G', date: new Date("2019-01-16"), number: 85124 },
  { id: 7, color: 'Y', date: new Date("2019-01-16"), number: 156824 },
  { id: 8, color: 'Y', date: new Date("2019-01-16"), number: 3275124 },
];

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private runBatchJobUrl = 'localhost:8080/api/runBatchJob';
  private getExportDataUrl = 'localhost:8080/api/getExportData';
  constructor(private httpClient: HttpClient) {

  }

  getApiData() {
    fetch('localhost:8080/api/runBatchJob')
      .then(response => response.json())
      .then(data => console.log(data));
  }

  getApiData2(): ExportData[] {
    return EXPORT_DATA;
  }

  getApiData3(): Observable<ExportData[]> {
    return of(EXPORT_DATA);
  }

  getApiData4(): Observable<ExportData[]> {
    return this.httpClient.get<ExportData[]>(this.getExportDataUrl);
  }

}
