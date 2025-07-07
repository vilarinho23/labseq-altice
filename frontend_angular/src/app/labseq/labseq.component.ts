import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LabseqService, LabseqResponse } from '../labseq.service'; // ajusta caminho

@Component({
  selector: 'app-labseq',
  standalone: true,  // <== componente standalone
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './labseq.component.html',
  providers: [LabseqService]
})
export class LabseqComponent {
  n = 0;
  result = '';
  error = '';

  constructor(private labseqService: LabseqService) {}

  fetchValue(): void {
    this.result = '';
    this.error = '';
    const start = performance.now();
  
    this.labseqService.getValue(this.n).subscribe({
      next: (res: LabseqResponse) => {
        const end = performance.now();
        const duration = end - start;
  
        this.result = `${res.value} (calculado em ${duration.toFixed(2)} ms)`;
      },
      error: (err) => {
        this.error = err.error?.error || 'Erro desconhecido';
      }
    });
  }
  
}