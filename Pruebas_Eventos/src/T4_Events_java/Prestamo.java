public class Prestamo {
  private double tipoInteresAnual;
  private int numeroAnios;
  private double importePrestamo;
  private java.util.Date fechaPrestamo;

  /** Constructor por defecto */
  public Prestamo() {
    this(2.5, 1, 1000);
  }

  /** Construye un préstamo con un tipo de interés anual,
	    número de años y un importe 
    */
  public Prestamo(double tipoInteresAnual, int numeroAnios,
      double importePrestamo) {
    this.tipoInteresAnual = tipoInteresAnual;
    this.numeroAnios = numeroAnios;
    this.importePrestamo = importePrestamo;
    fechaPrestamo = new java.util.Date();
  }

  public double getTipoInteresAnual() {  // Getter
    return tipoInteresAnual;
  }

  public void setTipoInteresAnual(double tipoInteresAnual) {  // Setter
    this.tipoInteresAnual = tipoInteresAnual;
  }  

  public int getNumeroAnios() {  // Getter
    return numeroAnios;
  }

  public void setNumeroAnios(int numeroAnios) {  // Setter
    this.numeroAnios = numeroAnios;
  }

  public double getImportePrestamo() {  // Getter
    return importePrestamo;
  }

  public void setImportePrestamo(double importePrestamo) {  // Setter
    this.importePrestamo = importePrestamo;
  }

  /** Calcula la cuota mensual */
  public double getCuotaMensual() {
    double tipoInteresMensual = tipoInteresAnual / 1200;
    double cuotaMensual = importePrestamo * tipoInteresMensual / (1 -
      (Math.pow(1 / (1 + tipoInteresMensual), numeroAnios * 12)));
    return cuotaMensual;    
  }

  /** Calcula el importe total */
  public double getImporteTotal() {
    double importeTotal = getCuotaMensual() * numeroAnios * 12;
    return importeTotal;    
  }

  public java.util.Date getFechaPrestamo() {
    return fechaPrestamo;
  }
}
