import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ruta-aprendizaje',
  templateUrl: './ruta-aprendizaje.component.html',
  styleUrls: ['./ruta-aprendizaje.component.css'],
})
export class RutaAprendizajeComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
}
