//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
}
fun isSudokuValid(sudoku: Any?): Boolean {

    if(sudoku !is List<*> || sudoku.isEmpty()) return false
    if(sudoku.any { it !is List<*> }) return false
    val sudokuBoard = sudoku as List<List<*>>

    val size = sudokuBoard.size
    for(i in 0 until size) {
        if (size != sudokuBoard[i].size) return false
    }


    for(i in 0 until size) {
        for(j in 0 until size) {
            if(sudokuBoard[i][j] !is Char) return false
            val currentChar = sudokuBoard[i][j] as Char
            if (!isValidSudokuChar(currentChar, size)) return false
        }
    }

    for(i in 0 until size) {
        val rowSet = mutableSetOf<Char>()
        for(j in 0 until size) {
            val current = sudokuBoard[i][j] as Char
            if(current != '-') {
                if(rowSet.contains(current)) return false
                rowSet.add(current)
            }
        }
    }

    for(j in 0 until size) {
        val colSet = mutableSetOf<Char>()
        for(i in 0 until size) {
            val current = sudokuBoard[i][j] as Char
            if(current != '-') {
                if(colSet.contains(current)) return false
                colSet.add(current)
            }
        }
    }
    val subgridSize =getSubGridSize(size)?:return false

    for(boxRow in 0 until size step subgridSize) {
        for(boxCol in 0 until size step subgridSize) {
            val boxSet = mutableSetOf<Char>()
            for(i in 0 until subgridSize) {
                for(j in 0 until subgridSize) {
                    val current = sudokuBoard[boxRow + i][boxCol + j] as Char
                    if(current != '-') {
                        if(boxSet.contains(current)) return false
                        boxSet.add(current)
                    }
                }
            }
        }
    }

    return true
}

fun isValidSudokuChar(currentChar: Char, size: Int): Boolean {
    return when(size) {
        4 -> currentChar == '-' || currentChar in '1'..'4'
        9 -> currentChar == '-' || currentChar in '1'..'9'
        16 -> currentChar == '-' || currentChar in '1'..'9' || currentChar in 'A'..'G'
        else -> false
    }
}

fun getSubGridSize(boardSize:Int):Int? =
    when(boardSize) {
        4 -> 2
        9 -> 3
        16 -> 4
        else ->  null
    }
