package ox

var arrOX = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)
var flag = true
var player = 'X';
fun main() {
    var turn = 0;
    showTable()
    while (flag) {
        showTurn(turn)
        val input = readLine()
        val rcList = input?.split(" ")
        val inputRow = rcList?.get(0)
        val inputCol = rcList?.get(1)
        if (inputCol != null) {
            if (inputRow != null) {
                setTable(inputRow, inputCol, player)
            }
        }
        showTable()
        checkHorizantal(player)
        checkVertical(player)
        chcekDiagonal(player)
        checkDraw(turn)
        turn++;
    }
}

fun showTurn(turn: Int) {
    if (turn % 2 == 0) {
        player = 'X'
        print("Turn X input row col : ")
    } else {
        player = 'O'
        print("Turn O input row col : ")
    }
}

fun setTable(row: String, col: String, player: Char) {
    try {
        if (arrOX[row.toInt()][col.toInt()] === '-') {
            arrOX[row.toInt()][col.toInt()] = player
        } else {
            flag = false;
            println("please input correct values!")
        }
    } catch (e: Throwable) {
        flag = false;
        println("please input correct values!")
    }
}

fun showTable() {
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            print(" ${arrOX[i][j]}")
        }
        println()
    }
}

fun checkHorizantal(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[i][j] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ! ")
        }
        count = 0;
    }
}

fun checkVertical(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[j][i] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ! ")
        }
        count = 0;
    }
}

fun chcekDiagonal(player: Char) {
    if (arrOX[1][1] === player && arrOX[2][2] === player && arrOX[3][3] === player) {
        println("${player} WIN ! ")
        flag = false;
    } else if (arrOX[1][3] === player && arrOX[2][2] === player && arrOX[3][1] === player) {
        println("${player} WIN !")
        flag = false;
    }
}

fun checkDraw(turn: Int) {
    if (turn == 8 && flag) {
        println("DRAW !")
        flag = false
    }
}

