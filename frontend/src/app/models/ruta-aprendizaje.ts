export class RutaAprendizaje {
  id?: string;
  nombre: string;
  descripcion: string;
  nivel: number;
  //curso: Curso;
  prerrequisito: string;

  constructor(nombre: string, descripcion: string, nivel: number, prerrequisito: string) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.nivel = nivel;
    this.prerrequisito = prerrequisito;
  }
}
