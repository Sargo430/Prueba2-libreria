
package libreriaprueba;
public class LibreriaPrueba {
    
    public static void main(String[] args) {
        Biblioteca lib=new Biblioteca();
        //lib.anadirLibros(1);
        lib.anadirLibros(2);
//        lib.imprimirPorConsola(lib.buscarPorCriterio(7, "pdf"));
//        lib.eliminarLibro(7, "PDF");
//        lib.imprimirLista();
        lib.modificarLibro("tuve fe", "docx", 7);
        lib.imprimirPorConsola(lib.buscarPorCriterio(7, "pdf"));
        
    }
}
