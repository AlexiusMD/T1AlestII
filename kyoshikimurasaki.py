caminho = open("map.txt").read()
xSize = 67
ySize = 12
matrix = []

print("size of file is" + str(len(caminho)))

for x in range(xSize): ##cria a fucking matrix
    row = []
    linha = open("map.txt").readline()
    for y in range(ySize):
        ##print("adding " + str(caminho[x + y * xSize]) + " to position " + str(x) + ", " + str(y))
        row.append(linha[x])
    matrix.append(row)

xPosition = 0
yPosition = 0

xVelocity = 1
yVelocity = 0

total = 0
toAdd = ""
while (yPosition <= ySize and xPosition <= xSize):
    currentChar = matrix[xPosition][yPosition]

    print("Character in position " + str(xPosition) + ", " + str(yPosition) + " is " + currentChar)

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
