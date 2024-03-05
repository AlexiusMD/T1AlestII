public class Main {
    public static void main (String args[]) {
        String caminho = "------26--\\          #";
        int xSize = 11;
        int ySize = 2;
        char[][] matrix = new char[xSize][ySize];

        for (int x = 0; x < xSize; x++) { //cria a fucking matrix
            for (int y = 0; y < ySize; y++) {
                System.out.println("adding " + caminho.charAt(x + y * ySize) + " to position " + x + ", " + y);
                matrix[x][y] = caminho.charAt(x + y * xSize);
            }
        }

        int xPosition = 0;
        int yPosition = 0;

        int xVelocity = 1;
        int yVelocity = 0;

        while (yPosition <= ySize && xPosition <= xSize) {
            //System.out.println(xPosition);
            //System.out.println(yPosition);

            char currentChar = matrix[xPosition][yPosition];

            System.out.println("Character in position " + xPosition + ", " + yPosition + " is " + currentChar);

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

            xPosition += xVelocity;
            yPosition -= yVelocity; //velocidade pra baixo significa aumentar o y da matriz
        }
    }
}
