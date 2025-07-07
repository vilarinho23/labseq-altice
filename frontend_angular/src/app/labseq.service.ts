import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface LabseqResponse {
  n: number;
  value: string;
}

@Injectable({
  providedIn: 'root'
})
export class LabseqService {
  private apiUrl = 'http://localhost:8080/labseq';

  constructor(private http: HttpClient) {}

  getValue(n: number): Observable<LabseqResponse> {
    return this.http.get<LabseqResponse>(`${this.apiUrl}/${n}`);
  }
}

