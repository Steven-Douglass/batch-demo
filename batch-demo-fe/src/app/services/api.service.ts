import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { ExportData } from '../table-view/table-view.component';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ApiService {
  private runBatchJobUrl = 'http://localhost:8080/api/runBatchJob';
  private getExportDataUrl = 'http://localhost:8080/api/getExportData';
  private deleteAllUrl = 'http://localhost:8080/api/deleteAll';

  constructor(private httpClient: HttpClient) {

  }

  getApiData(): Observable<ExportData[]> {
    return this.httpClient.get<ExportData[]>(this.getExportDataUrl);
  }

  runBatchJob() {
    return this.httpClient.get(this.runBatchJobUrl);
  }

  deleteAll() {
    return this.httpClient.get(this.deleteAllUrl, {responseType: 'text'});
  }

}