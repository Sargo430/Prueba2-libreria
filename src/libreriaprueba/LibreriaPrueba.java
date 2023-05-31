
package libreriaprueba;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
public class LibreriaPrueba {
    ArrayList<Libro> lista_de_libros = new ArrayList<>();
    public static void main(String[] args) {
        LibreriaPrueba lib=new LibreriaPrueba();
        Libro[] lb = new Libro[5];
        Libro libro1 = new Libro("juan","ahadha","2000","perro","comedia","100");
        LibroDigital libro2= new LibroDigital("juan","Perro bomba galactico","1570","Toyota","Romance","222","PDF","25mb");
        Libro libro3 = new Libro("MR juriprudecendia","Juriprudencia para la vida cotidiana","2020","Sacro imperio romano","legal","345");
        LibroDigital libro4= new LibroDigital("Vin diesel","Tuve fe","2015","gato en un zapato","Biografia","123","PDF","17mb");
        lb[0]=libro1;
        lb[1]=libro2;
        lb[2]=libro3;
        lb[3]=libro4;
        lib.anadirLibros(lb);
        lib.imprimirLista();
        lib.buscarPorCriterio(2, "juan");
        lib.buscarPorCriterio(1, "Tuve fe");
    }
    public void anadirLibros(Libro[] l){
        for(Libro i:l){
            if(i!=null){
                lista_de_libros.add(i);
            }
            
        }
    }public void imprimirLista(){
        try{
           String ruta="C:/Users/Sebastian/Desktop/Lista_de_Libros.txt";
            File archivo = new File(ruta);
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            FileWriter escritura =new FileWriter(archivo);
            BufferedWriter escritor= new BufferedWriter(escritura);
            for(Libro i:lista_de_libros){
                escritura.write("///////////////////////////////////////////////\n");
                escritura.write(i.getDatos());
                
            } 
            escritura.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public ArrayList<Integer> buscarPorCriterio(int tipoCriterio, String criterio){
        ArrayList<Integer>indices = new ArrayList<Integer>();
        indices.clear();
        switch(tipoCriterio){
            case 1: //busqueda por titulo
                for(Libro i:lista_de_libros){
                    if(i.titulo.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
             case 2: //busqueda por autor
                for(Libro i:lista_de_libros){
                    if(i.autor.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
             case 3: //busqueda por año de publicacion
                for(Libro i:lista_de_libros){
                    if(i.anio.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
             case 4: //busqueda por genero
                for(Libro i:lista_de_libros){
                    if(i.genero.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
            case 5: //busqueda por numero de paginas
                for(Libro i:lista_de_libros){
                    if(i.nPag.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
            case 6: //busqueda por editorial
                for(Libro i:lista_de_libros){
                    if(i.editorial.equalsIgnoreCase(criterio)){
                        indices.add(lista_de_libros.indexOf(i));
                    }
                }
                break;
        }
        return indices;
    }
    public void imprimirPorConsola(ArrayList<Integer> indices){
        for(Integer i:indices){
            System.out.println("//////////////////////////////////////////");
            System.out.println(lista_de_libros.get(i).getDatos());
        }
        System.out.println("//////////////////////////////////////////");
    }
    
}
