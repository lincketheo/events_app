package com.communeo.common.util

import kotlin.random.Random

val capitals = ('A'..'Z').toList()
val lowerCase = ('a'..'z').toList()
val nums = ('0'..'9').toList()

fun generateRandomString(
    length: Int,
    allowedChars: List<Char> = capitals + lowerCase + nums
): String {
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

fun generateRandomUpperCaseWord(length: Int): String {
    return generateRandomString(
        1,
        capitals
    ) + generateRandomString(
        length - 1,
        lowerCase
    )
}

fun generateRandomWord(length: Int): String {
    return generateRandomString(length, lowerCase)
}

fun generateRandomSentence(words: Int): String {
    return generateRandomUpperCaseWord(
        Random.nextInt(
            1,
            10
        )
    ) + (1..words).joinToString(separator = " ") {
        generateRandomWord(Random.nextInt(1, 10))
    }
}

fun generateRandomUniqueName(): String {
    val name = names.random()
    names.remove(name)
    return name
}

fun generateRandomStringFrom(g: Grammar) {
    TODO()
}

/**
 * TODO
 */

/**
 * ({S, A, B}, {a, b}, S, {S → AB, A → a, B → b})
 */
class Grammar {

}
