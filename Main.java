public class Main {
    public static void main (String args[]) {
        String caminho = "";
        int xSize = 10;
        int ySize = 10;
        char[][] matrix = new char[xSize][ySize];

        for (int x = 0; x < xSize; x++) { //cria a fucking matrix
            for (int y = 0; y < ySize; y++) {
                matrix[x][y] = caminho.charAt(x + y * ySize);
            }
        }

        int xPosition = 0;
        int yPosition = 0;

        int xVelocity = 1;
        int yVelocity = 0;

        char lastCharacter = matrix[0][0];
        while (true) {
            xPosition += xVelocity;
            yPosition += yVelocity;
            
            char currentChar = matrix[xPosition][yPosition];

            if (currentChar == '#') { //fim
                break;
            } else if (currentChar == '/') {
                int xAux = xVelocity;
                int yAux = yVelocity;

                xVelocity = yAux;
                yVelocity = xAux;
            } else if (currentChar == '\\') {
                int xAux = xVelocity;
                int yAux = yVelocity;

                xVelocity = -yAux;
                yVelocity = -xAux;
            }

            currentChar = lastCharacter;

            System.out.println(currentChar);
        }
    }
}
