import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MapReader {
    
    private char map[][];
    

    /**
     * Constructor takes in the path of the file that the map is stored in to make reading
     * @param path
     */
    public MapReader(String path){
        map = getMapFromFile(path);
    }

    protected char[][] getMapFromFile(String path){
        
        char[][] map = null;
        Path file = Paths.get(path);

        try(BufferedReader br = Files.newBufferedReader(file)){
            ArrayList<String> auxLines = new ArrayList<>();
            br.readLine();          
            String line = "";
            while((line = br.readLine()) != null){
                if(!line.isBlank())
                    auxLines.add(line);
            }
            
            String[] lines = auxLines.toArray(new String[0]);

            char[][] auxMap = new char[lines.length][lines[0].length()];
            for(int i = 0; i < lines.length; i++){
                for(int j = 0; j < lines[0].length(); j++){
                    char[] aux = lines[i].toCharArray();
                    auxMap[i][j] = aux[j];
                }
            }
            map = auxMap;

        }catch(IOException e){
            System.err.println("Erro de I/O de dados.");
        }
        return map;
    }

    public char[][] getMap(){
        return map;
    }
}
