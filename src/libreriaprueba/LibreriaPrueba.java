
package libreriaprueba;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LibreriaPrueba {
    ArrayList<Libro> lista_de_libros = new ArrayList<>();
    String ruta="C:/Users/Sebastian/Desktop/Lista_de_Libros.txt";
    public static void main(String[] args) {
        LibreriaPrueba lib=new LibreriaPrueba();
        //lib.anadirLibros(1);
        lib.anadirLibros(2);
        lib.imprimirPorConsola(lib.buscarPorCriterio(7, "pdf"));
//        lib.eliminarPorCriterio(7, "PDF");
//        lib.imprimirLista();
        
    }
    public void anadirLibros(int tipo){
        ArrayList<Libro> lb = new ArrayList<Libro>();
        switch(tipo){ 
            case 1:// a mano
                Libro libro1 = new Libro("juan","ahadha","2000","perro","comedia","100");
                LibroDigital libro2= new LibroDigital("juan","Perro bomba galactico","1570","Toyota","Romance","222","PDF","25mb");
                Libro libro3 = new Libro("MR juriprudecendia","Juriprudencia para la vida cotidiana","2020","Sacro imperio romano","legal","345");
                LibroDigital libro4= new LibroDigital("Vin diesel","Tuve fe","2015","gato en un zapato","Biografia","123","PDF","17mb");
                lb.add(libro1);
                lb.add(libro2);
                lb.add(libro3);
                lb.add(libro4);
                break;
            case 2:{
                try {
                    ArrayList<Integer> lineas= new ArrayList<Integer>();
                    Scanner contador = new Scanner(new File(ruta));
                    int nLineas=0;
                    contador.nextLine();
                    while(contador.hasNextLine()){//encuentra el numero de lineas entre los libros
                        String line =contador.nextLine();
                        if(line.startsWith("/")){
                            lineas.add(nLineas);
                            nLineas=0;
                            if(contador.hasNextLine()){
                                contador.nextLine();   
                            }
                        }
                        nLineas++;
                    }
                    Scanner leer = new Scanner(new File(ruta));
                    for(Integer i:lineas){
                        leer.nextLine();
                        if(i==6){
                            String linea = leer.nextLine();
                            String titulo = linea.substring(8,linea.length());
                            linea= leer.nextLine();
                            String autor= linea.substring(7,linea.length());
                            linea= leer.nextLine();
                            String anio= linea.substring(19,linea.length());
                            linea= leer.nextLine();
                            String genero= linea.substring(8,linea.length());
                            linea= leer.nextLine();
                            String nPag= linea.substring(19,linea.length());
                            linea= leer.nextLine();
                            String editorial= linea.substring(11,linea.length());
                            Libro libro = new Libro(autor,titulo,anio,editorial,genero,nPag);
                            lb.add(libro);
                        }else if(i==8){
                            String linea = leer.nextLine();
                            String titulo = linea.substring(8,linea.length());
                            linea= leer.nextLine();
                            String autor= linea.substring(7,linea.length());
                            linea= leer.nextLine();
                            String anio= linea.substring(19,linea.length());
                            linea= leer.nextLine();
                            String genero= linea.substring(8,linea.length());
                            linea= leer.nextLine();
                            String nPag= linea.substring(19,linea.length());
                            linea= leer.nextLine();
                            String editorial= linea.substring(11,linea.length());
                            linea= leer.nextLine();
                            String formato= linea.substring(9,linea.length());
                            linea= leer.nextLine();
                            String tamanio= linea.substring(20,linea.length());
                            LibroDigital libro = new LibroDigital(autor,titulo,anio,editorial,genero,nPag,formato,tamanio);
                            lb.add(libro);
                        }
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LibreriaPrueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

        }
        for(Libro i:lb){
            if(i!=null){
                lista_de_libros.add(i);
            }
            
        }
        lb.clear();
    }
    public void imprimirLista(){
        try{
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
            escritura.write("///////////////////////////////////////////////\n");
            escritura.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public ArrayList<Integer> buscarPorCriterio(int tipoCriterio, String criterio){// retorna un array con los indices de los objetos 
        ArrayList<Integer>indices = new ArrayList<Integer>();//que cumplen el criterio
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
            case 7: //busqueda por formato
                for(Libro i:lista_de_libros){
                    if(i instanceof LibroDigital){
                        LibroDigital aux=(LibroDigital)i;
                        if(aux.formato.equalsIgnoreCase(criterio)){
                            indices.add(lista_de_libros.indexOf(i));
                        }
                    } 
                }
                break;
            case 8: //busqueda por tamaño, luego se puede modificar para buscar por menor o mayor al tamaño ingresado, de momento es solo igual
                for(Libro i:lista_de_libros){
                    if(i instanceof LibroDigital){
                        LibroDigital aux=(LibroDigital)i;
                        if(aux.tamanio.equalsIgnoreCase(criterio)){
                            indices.add(lista_de_libros.indexOf(i));
                        }
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
    public void eliminarPorCriterio(int tipoCriterio, String criterio){
        ArrayList<Integer> index = new ArrayList<Integer>();
        index=buscarPorCriterio(tipoCriterio,criterio);
        Collections.sort(index,Collections.reverseOrder());
        for(Integer i:index){
            int a=i;
            lista_de_libros.remove(a);
        }
    }
    
}
