import time as time

def mapToMatrix(path):
    mapa = []
    file = open(path, "r")
    next(file)
    for line in file:
        if len(line.strip()) != 0:
            mapa.append(line)

    file.close()
    return mapa
    
def getMapDimensionsFromFile(path):
    file = open(path, "r")
    return file.readline().split(" ")

def getMapDimensionsFromMap(matrix):
    x = 1
    y = 0
    size = []
    for line in matrix:
        y += 1
        x = len(line) - 1

    size.append(y)
    size.append(x)

    return size


def getStartingYPosition(map):
    yCounter = 0
    for line in map:
        element = line[0]
        if element == '-':
            return yCounter
        yCounter += 1

def printMap(map):
    for line in map:
        print(line)


start_time = time.time()
path = "testes/casoA2000.txt"
map = mapToMatrix(path)
#dimensions = getMapDimensionsFromFile(path) -- doesnt exclude empty lines/just read top of file
dimensions = getMapDimensionsFromMap(map) #excludes empty lines from the map and reads all path lines
ySize = dimensions[0]
xSize = dimensions[1]

# printMap(map)
# print("Y size = " + str(ySize) + " X size = " + str(xSize))
# print(str(getStartingYPosition(map)))

xPosition = 0
yPosition = getStartingYPosition(map)

xVelocity = 1
yVelocity = 0

total = 0
toAdd = ""

while (yPosition < ySize and xPosition < xSize):
    currentChar = map[yPosition][xPosition]

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
end_time = time.time()
print("Time elapsed:" + str(end_time - start_time))
