
package libreriaprueba;
public class Libro {
    String autor;
    String titulo;
    String anio;
    String editorial;
    String genero;
    String nPag;
    Libro(String autor,String titulo,String anio,String editorial,String genero,String nPag){
        this.autor=autor;
        this.titulo=titulo;
        this.anio=anio;
        this.editorial=editorial;
        this.genero=genero;
        this.nPag=nPag;
    }
    public String getDatos(){
        return "Titulo: "+titulo+"\n"+
                "Autor: "+autor+"\n"+
                "Año de publicacion: " + anio+"\n" +
                "Genero: "+genero+"\n"+
                "Numero de paginas: "+nPag+"\n"+
                "Editorial: "+editorial+"\n";
    }
}