import java.util.HashMap;

public class Scramblies { 

    public static boolean scramble(String str1, String str2) { 
        if (str1.length() < str2.length()) return false;    //Verificar que la longitud de str1 sea mayor o igual a la de str2
        if (str2.length() = 0) return false;
            
        HashMap<Character, Integer> disponibles = new HashMap<>();    //Contar repeticiones en str1
        for (char c: str1.toCharArray()) {
            disponibles.put(c, disponibles.getOrDefault(c, 1) );//Procesa sólo los caracteres que ya existen en esa cadena y los cuenta, así que siempre habrá al menos 1 de cada
        }

        //Contar repeticiones en str2 y verificar que sean menores o iguales a las de str1
        for (char c: str2.toCharArray()) {
            if (!disponibles.containsKey(c) || disponibles.get(c) <= 0) {   //Comprobar si la letra no está en str1 o si ya no hay repeticiones disponibles
                return false; 
            }            
            disponibles.put(c, disponibles.get(c) - 1); // Disminuir la cantidad de repeticiones disponibles.Al valor actual de esa clave se le resta 1
        }
        return true;    
    }    

    public static void main(String[] args) {
        // Pruebas
        System.out.println(scramble("rkqodlw","world")); // true
        System.out.println(scramble("cedewaraaossoqqyt","codewars")); // true
        System.out.println(scramble("katas","steak")); // false
        System.out.println(scramble("scriptjavx","javascript")); // false
        System.out.println(scramble("samoc","commas")); // false        
    }
}
