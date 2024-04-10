package com.hardik.weapplinsetask

fun printSpiral(rows: Int, cols: Int): MutableList<Int> {
    var items: MutableList<Int> = mutableListOf()

    val matrix = Array(rows) { IntArray(cols) }
    var top = 0
    var bottom = rows - 1
    var left = 0
    var right = cols - 1
    var direction = 0 // 0 - right, 1 - down, 2 - left, 3 - up
    var count = 1

    while (top <= bottom && left <= right) {
        when (direction) {
            0 -> {
                for (i in left..right) {
                    matrix[top][i] = count++
                }
                top++
            }
            1 -> {
                for (i in top..bottom) {
                    matrix[i][right] = count++
                }
                right--
            }
            2 -> {
                for (i in right downTo left) {
                    matrix[bottom][i] = count++
                }
                bottom--
            }
            3 -> {
                for (i in bottom downTo top) {
                    matrix[i][left] = count++
                }
                left++
            }
        }
        direction = (direction + 1) % 4
    }

    // Print the matrix
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("${matrix[i][j]}\t")
            items.add(matrix[i][j])
        }
        println()
    }
    return items
}

//fun main() {
//    printSpiral(10, 7)
//}

