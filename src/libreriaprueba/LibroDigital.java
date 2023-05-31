
package libreriaprueba;

public class LibroDigital extends Libro {
    
    String formato;
    String tamanio;
    public LibroDigital(String autor, String titulo, String anio, String editorial, String genero, String nPag,String formato, String tamanio) {
        
        super(autor, titulo, anio, editorial, genero, nPag);
        this.formato=formato;
        this.tamanio=tamanio;
        
    }

    @Override
    public String getDatos() {
        return super.getDatos()+ 
                "Formato: " +formato + "\n"+
                "Tamaño del archivo: " + tamanio + "\n";
    }
    
}
