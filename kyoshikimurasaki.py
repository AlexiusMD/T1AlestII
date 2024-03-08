def readMap(path):
    caminho = []
    file = open(path, "r")
    next(file)
    next(file)
    for x in file:
        if x != '':
            for letter in x:
                caminho.append(letter)
                print(letter)
    return caminho

def readMapSize(path):
    file = open(path, "r")
    size = file.readline().split(" ")
    return size

def printMatrix(matrix):
    for row in matrix:
        print(row)

path = "map.txt"

caminho = readMap(path)
ySize = int(readMapSize(path)[0])
xSize = int(readMapSize(path)[1])
matrix = []

for x in range(xSize): ##cria a fucking matrix
    row = []
    for y in range(ySize):
        #print("adding " + str(caminho[(x + y * ySize) - 1]) + " to position " + str(x) + ", " + str(y))
        row.append(caminho[(x + y * xSize) - 2])
    matrix.append(row)

    printMatrix(matrix)

xPosition = 0
yPosition = getYPos(matrix)

xVelocity = 1
yVelocity = 0

total = 0
toAdd = ""
while (yPosition < ySize and xPosition < xSize):
    currentChar = matrix[xPosition][yPosition]

    #print("Character in position " + str(xPosition) + ", " + str(yPosition) + " is " + currentChar)

    if (currentChar.isdigit()):
        toAdd += currentChar
    elif (toAdd != ""):
        total += int(toAdd)
        toAdd = ""

    if (currentChar == '#'): ##fim
        break
    elif (currentChar == '/'):
        xAux = xVelocity
        yAux = yVelocity

        xVelocity = yAux
        yVelocity = xAux
    elif (currentChar == '\\'):
        xAux = xVelocity
        yAux = yVelocity

        xVelocity = -yAux
        yVelocity = -xAux

    xPosition += xVelocity
    yPosition -= yVelocity ##velocidade pra baixo significa aumentar o y da matriz

print("Total de dinheiro coletado foi " + str(total))