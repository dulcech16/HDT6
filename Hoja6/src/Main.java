/*
 * Autores: William Orozco, 13386
 *          Dulce Chacon, 13
 *          Hoja de trabajo 5
 * 
 *      Codigo de ejemplo: http://www.discoduroderoer.es/formas-de-ordenar-un-array-en-java/
                        http://www.tutorialspoint.com/java/java_string_comparetoignorecase.htm
 */
package HDT6;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author W
 */
public class Main {    
               
    public static void main(String[] args) {
        Scanner entrada_datos = new Scanner(System.in);
        String nombre = "";
        int tipo = 0;
        
        //se crean tres arreglos para almacenar los datos 
        SetFactory factory=new SetFactory();   
        Set<String> setJava = null;
        Set<String> setWeb = null;
        Set<String> setCelulares = null;
         
        // Se pide el tipo de Set hasta que elija una opcion correcta
        while (setJava == null){
            System.out.println("Ingrese el tipo de Set");
            System.out.println("1. HashSet\n2. TreeSet\n3. LinkedHashSet\n");
            tipo = entrada_datos.nextInt();
            setJava = factory.getSet(tipo);
            setWeb = factory.getSet(tipo);
            setCelulares = factory.getSet(tipo);
        }
        
        /************************************************************************************/
        //se llena el arreglo
        tipo = 0;
        int salir = 0;
        while (salir != 2){
            System.out.println("Ingrese un nombre: ");
            nombre = entrada_datos.next();
            System.out.println("¿Desarrollador Java?  --  1. SI 2. NO");
            tipo = entrada_datos.nextInt();
            if (tipo == 1){
                setJava.add(nombre);
            }
            System.out.println("¿Desarrollador Web?  --  1. SI 2. NO");
            tipo = entrada_datos.nextInt();
            if (tipo == 1){
                setWeb.add(nombre);
            }
            System.out.println("¿Desarrollador Celulares? -- 1. SI 2. NO");
            tipo = entrada_datos.nextInt();
            if (tipo == 1){
                setCelulares.add(nombre);
            }
            
            System.out.println("¿CONTINUAR?  --  1. SI 2. NO");
            salir = entrada_datos.nextInt();
        }
        
        
        /************************************************************************************/
        // se muestran las respuestas a la hoja de trabajo
        Object arrayJava [] = setJava.toArray(); 
        Object arrayWeb [] = setWeb.toArray();
        Object arrayCelulares [] = setCelulares.toArray();
        
        //recursos necesarios para las preguntas
        int lengtJava = arrayJava.length;
        int lengtWeb = arrayWeb.length;
        int lengtCelulares = arrayCelulares.length;
        int menor = 0;  
        Object arreglo[];
        
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTA 1
        
        //se obtiene el arreglo de menor longitud
        if(lengtJava <= lengtWeb && lengtJava <= lengtCelulares){  
            menor = lengtJava;
            arreglo = arrayJava;
        }else{  
            if(lengtWeb <= lengtJava && lengtWeb <= lengtCelulares){  
            menor = lengtWeb;  
            arreglo = arrayWeb;
            }else{  
            menor = lengtCelulares; 
            arreglo = arrayCelulares;
            }
        }
        
        System.out.print("\n\n1. Personas en Java, Web y Celulares:\n");
        for (int i=0; i<menor; i++){
            if (setJava.contains(arreglo[i])&&setCelulares.contains(arreglo[i])&&setWeb.contains(arreglo[i])){
                //se imprime la interseccion de los tres conjuntos
                System.out.print(arreglo[i]+", ");
            }
        }
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTA 2
        System.out.print("\n\n2. Personas en Java, pero no en Web:\n");
        for (int i=0; i<lengtJava; i++){
            if (!setWeb.contains(arrayJava[i])){
                //se imprimen los que estan en java pero no en web
                System.out.print(arrayJava[i]+", ");
            }
        }
        
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTA 3
        Set<String> setG;
        if (lengtWeb<=lengtCelulares)
        {
            menor=lengtWeb;
            arreglo=arrayWeb;
            setG=setCelulares;
        }
        else{
            menor=lengtCelulares;
            arreglo=arrayCelulares;
            setG=setWeb;
        }
                
        
        System.out.print("\n\n3. Personas en Web y celulares, pero no en Java:\n");
        for (int i=0; i<menor; i++){
            if (!setJava.contains(arreglo[i])&&setG.contains(arreglo[i])){
                //se imprimen los que estan en web y celulares, pero NO en java
                System.out.print(arreglo[i]+", ");
            }
        }
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTA 4
        System.out.print("\n\n4. Personas en Web o celulares, pero no en Java:\n");
        for (int i=0; i<lengtWeb; i++){
            if (!setJava.contains(arrayWeb[i])){
                //se imprimen los que estan en web  pero NO en java
                System.out.print(arrayWeb[i]+", ");
            }
        }
        for (int i=0; i<lengtCelulares; i++){
            if (!setJava.contains(arrayCelulares[i])&&!setWeb.contains(arrayCelulares[i])){
                //se imprimen los que estan en celulares  que no esten en la interseccion con Web, y que NO esten en java
                System.out.print(arrayCelulares[i]+", ");
            }
        }
        
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTA 5
        String mensaje="\n\n5. El conjunto de Desarrolladores Java ";
        if (setWeb.containsAll(setJava)){
            mensaje+="SI";
        } 
        else {
            mensaje+="NO";
        }
        mensaje+=" es un subconjunto de Desarrolladores Web";
        System.out.print(mensaje);
        
        /************************************************************************************/
        //PARA RESPONDER PREGUNTAS 6 y 7
        //se obtiene el arreglo de mayor longitud
        int mayor=-1;
        if(lengtJava > lengtWeb && lengtJava > lengtCelulares){  
            mayor=lengtJava;
            arreglo=arrayJava;
            mensaje = "Java";
        }else{  
            if(lengtWeb > lengtJava && lengtWeb > lengtCelulares){  
            mayor=lengtWeb;  
            arreglo=arrayWeb;
            mensaje = "Web";
            }else{  
            mayor=lengtCelulares; 
            arreglo=arrayCelulares;
            mensaje = "Celulares";
            }
        }
        if (mayor == -1){
            //Si mas de una lista tiene el numero maximo de elementos, no se muestra nada
            System.out.print("\n\n6. Mas de un conjunto comparte el numero maximo de desarrolladores\n7. No puedo desplegar integrantes");
        }
        else {
            for(int i = 0; i < (arreglo.length-1); i++){
                for(int j = i+1; j < arreglo.length; j++){
                    if(arreglo[i].toString().compareToIgnoreCase(arreglo[j].toString())>0){
                        //Intercambiamos valores
                        Object variableauxiliar = arreglo[i];
                        arreglo[i] = arreglo[j];
                        arreglo[j] = variableauxiliar;
                    }
                }
            }
            System.out.print("\n\n6. El conjunto con mayor cantidad de desarrolladores es: "+mensaje+"\n7. Los integrantes son: \n ");
            for (int i=0; i<mayor; i++){
                System.out.print(arreglo[i]+", ");
            }
        }
    }
}
