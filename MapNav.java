public class MapNav{
    
    private char[][] toNav;
    private MapReader mp;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    //private String up = "\u001B[A", down = "\u001B[B", right = "\u001B[C", left = "\u001B[D";

    /**
     * The constructor recieves a matrix with the map to navigate
     * @param matrix
     */
    public MapNav(String path){
        mp = new MapReader(path);
        toNav = mp.getMapFromFile(path);
    }


    public int navigateMap(){

        int[] dimensions = getMapDimensions();
        
        int ySize = dimensions[0];
        int xSize = dimensions[1];

        int xVelocity = 1;
        int yVelocity = 0;

        int yPos = getStartingPos();
        int xPos = 0;

        int total = 0;
        String toAdd = "";
        char currentChar;
        
        System.out.print("\r");
        System.out.print("\u001B[A");

        while(xPos < xSize && yPos < ySize){
           
            currentChar = toNav[yPos][xPos];

            if(Character.isDigit(currentChar))
                toAdd += currentChar;
            else if(toAdd != ""){
                total += Integer.parseInt(toAdd);
                toAdd = "";
            }

            if(currentChar == '#')
                break;
            else if(currentChar == '/'){
                int xAux = xVelocity;
                int yAux = yVelocity;

                xVelocity = yAux;
                yVelocity = xAux;
            }
            else if(currentChar == '\\'){
                int xAux = xVelocity;
                int yAux = yVelocity;

                xVelocity = -yAux;
                yVelocity = -xAux;
            }

            xPos += xVelocity;
            yPos -= yVelocity;

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\033[2H");
            printMap(xPos, yPos);
        }

        return total;
    }

    private Integer getStartingPos(){
        for(int i = 0; i < toNav.length; i++)
            if(toNav[i][0] == '-')
                return i;
        
        return null;
    }

    private int[] getMapDimensions(){
        int[] aux = new int[2];
        aux[0] = toNav.length;
        aux[1] = toNav[0].length;
        return aux;
    }

    private void printMap(int xPos, int yPos){
        for(int i = 0; i < toNav.length; i++){
            System.out.println();
            for(int j = 0; j < toNav[0].length; j++){
                if(i == yPos && j == xPos)
                    System.out.print(ANSI_RED_BACKGROUND + toNav[i][j] + ANSI_RESET);
                else
                    System.out.print(toNav[i][j] + ANSI_RESET);
            }
        }

        System.out.println();
    }
}
