fun main() {
    //region valid 4x4
    validateSudoku(
        name = "when 4x4 Sudoku is completely valid return true",
        result = isSudokuValid(
            listOf(
                listOf('1', '-', '-', '-'),
                listOf('-', '2', '-', '-'),
                listOf('-', '-', '3', '-'),
                listOf('-', '-', '-', '4')
            )
        ),
        correctResult = true
    )
    //endregion

    //region not valid 4x4
    validateSudoku(
        name = "when 4x4 Sudoku has duplicate in 2x2 subgrid return false",
        result = isSudokuValid(
            listOf(
                listOf('1', '-', '-', '-'),
                listOf('-', '5', '-', '-'), // invalid number
                listOf('-', '-', '3', '-'),
                listOf('-', '-', '-', '4')
            )
        ),
        correctResult = false
    )
    //endregion

    //region valid 9x9
    validateSudoku(
        name = "when Sudoku is completely filled with valid numbers return true",
        result = isSudokuValid(
            listOf(
                listOf('5','3','4','6','7','8','9','1','2'),
                listOf('6','7','2','1','9','5','3','4','8'),
                listOf('1','9','8','3','4','2','5','6','7'),
                listOf('8','5','9','7','6','1','4','2','3'),
                listOf('4','2','6','8','5','3','7','9','1'),
                listOf('7','1','3','9','2','4','8','5','6'),
                listOf('9','6','1','5','3','7','2','8','4'),
                listOf('2','8','7','4','1','9','6','3','5'),
                listOf('3','4','5','2','8','6','1','7','9')
            )
        ),
        correctResult = true
    )

    validateSudoku(
        name = "when Sudoku is completely valid return true",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = true
    )

    validateSudoku(
        name = "when Sudoku is completely empty return true",
        result = isSudokuValid(
            listOf(
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
            )
        ),
        correctResult = true
    )
    //end region

    //region not valid 9x9
    validateSudoku(
        name = "when Sudoku has duplicate in row return false",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '4', '8', '-', '3', '-', '-', '1'), // 2 fours in the same row
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku has duplicate in column return false",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '4', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '6', '-', '4', '1', '9', '-', '-', '6'), // 2 sixes in the same column
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku has duplicate in a 3x3 subgrid return false",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '7', '9', '-', '5'), // 2 nines in the subgrid
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku is null return false",
        result = isSudokuValid(null),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku is not a 2D nested list return false",
        result = isSudokuValid(listOf('1', '2', '3')),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku is completely filled with valid numbers but integers return false",
        result = isSudokuValid(
            listOf(
                listOf(5,3,4,6,7,8,9,1,2),
                listOf(6,7,2,1,9,5,3,4,8),
                listOf(1,9,8,3,4,2,5,6,7),
                listOf(8,5,9,7,6,1,4,2,3),
                listOf(4,2,6,8,5,3,7,9,1),
                listOf(7,1,3,9,2,4,8,5,6),
                listOf(9,6,1,5,3,7,2,8,4),
                listOf(2,8,7,4,1,9,6,3,5),
                listOf(3,4,5,2,8,6,1,7,9)
            )
        ),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku contains character values return false",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', 'A'), // A here
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )



    validateSudoku(
        name = "when Sudoku rows doesn't equals columns return false",
        result = isSudokuValid(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    validateSudoku(
        name = "when Sudoku has numbers less than 1 return false",
        result = isSudokuValid(
            listOf(
                listOf('0', '3', '-', '-', '7', '-', '-', '-', '-'), // 0 here
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )
    validateSudoku(
        name = "when no input and the cell is empty then return false",
        result = isSudokuValid(
            listOf(
                listOf('5','3','-','-','7','-','-','-','-'),
                listOf('6','-','-','1','9','5','-','-','-'),
                listOf('-','9','8','-','-','-','-','6','-'),
                listOf('8','-','-','-','6','-','-','-','3'),
                listOf('4','-','-','8','-','3','-','-','1'),
                listOf('7','-','-','-','2','-','-','-','6'),
                listOf('-','6','-','-',' ','-','2','8','-'), // empty space ' ' instead of '-'
                listOf('-','-','-','4','1','9','-','-','5'),
                listOf('-','-','-','-','8','-','-','7','9')
            )
        ),
        correctResult = false
    )
    //end region
    //region valid 16x16
    validateSudoku(
        name = "when 16x16 Sudoku is completely valid return true",
        result = isSudokuValid(
            listOf(
                listOf('1','2','3','4','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('3','4','1','2','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('2','1','4','3','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('4','3','2','1','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','5','6','7','8','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','7','8','5','6','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','6','5','8','7','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','8','7','6','5','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','9','A','B','C','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','B','C','9','A','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','A','9','C','B','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','C','B','A','9','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','D','E','F','G'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','F','G','D','E'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','E','D','G','F'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','G','F','E','D')
            )
        ),
        correctResult = true
    )
    //endregion

    //region not valid 16x16
    validateSudoku(
        name = "when 16x16 Sudoku has invalid character return false",
        result = isSudokuValid(
            listOf(
                listOf('1','2','3','4','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('3','4','1','2','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('2','1','4','3','-','-','-','-','-','-','-','-','-','-','-','-'),
                listOf('4','3','2','1','-','-','-','-','X','-','-','-','-','-','-','-'), // Invalid 'X'
                listOf('-','-','-','-','5','6','7','8','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','7','8','5','6','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','6','5','8','7','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','8','7','6','5','-','-','-','-','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','9','A','B','C','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','B','C','9','A','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','A','9','C','B','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','C','B','A','9','-','-','-','-'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','D','E','F','G'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','F','G','D','E'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','E','D','G','F'),
                listOf('-','-','-','-','-','-','-','-','-','-','-','-','G','F','E','D')
            )
        ),
        correctResult = false
    )
    //endregion


}

fun validateSudoku(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}