
package libreriaprueba;

public class LibroDigital extends Libro {
    
    private String formato;
    private String tamanio;
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
    public String getFormato(){
        return this.formato;
    }
    public void setFormato(String nuevoF){
        this.formato=nuevoF;
    }
    public String getTamanio(){
        return this.tamanio;
    }
    public void setTamanio(String nuevoF){
        this.tamanio=nuevoF;
    }
    
}
