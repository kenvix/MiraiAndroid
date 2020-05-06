//--------------------------------------------------
// Class AbstractAsmReplacer
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package io.github.mzdluo123.mirai.android.asm

import org.objectweb.asm.*;
import java.io.InputStream

abstract class AbstractAsmTransformer {
    protected abstract val classVisitor: (ClassWriter) -> ClassVisitor

    private val classWriter by lazy { ClassWriter(ClassWriter.COMPUTE_FRAMES) }
    private val classVisitorInstance by lazy { classVisitor(classWriter) }

    fun transform(inputStream: InputStream): ByteArray {
        val reader = ClassReader(inputStream)
        reader.accept(classVisitorInstance, ClassReader.EXPAND_FRAMES)
        return classWriter.toByteArray()
    }


    companion object {
        const val TARGET_ASM_VERSION = Opcodes.ASM8

        val ignorePrefixes = arrayOf(
            "java/lang",
            "android",
            "androidx"
        )
    }
}