//--------------------------------------------------
// Class Replacement
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package io.github.mzdluo123.mirai.android.asm

data class Replacement (
    val fromClass: String,
    val fromMethod: String,
    val fromMethodSignature: String,
    val toClass: String,
    val toMethod: String,
    val toMethodSignature: String
)