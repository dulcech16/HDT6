/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HDT6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 *
 * @author W
 */
public class SetFactory<T> {
    Set<T> set;
    
    public Set<T> getSet(int tipo){
        
        switch (tipo)
        {
            case 1: //opcion 1 para HashSet
                set = new HashSet<>();
                System.out.println("HashSet");
                break;
            case 2: //opcion 2 para TreeSet
                set = new TreeSet<>();                   
                System.out.println("TreeSet");
                break;
            case 3: //opcion 1 para LinkedHashSet
                set = new LinkedHashSet<>();
                System.out.println("LinkedHashSet");
                break;         
            default:
                System.out.println("Ha escogido una opción incorrecta");
                set =  null;
                break;
        }
        return set;
    }
}    

