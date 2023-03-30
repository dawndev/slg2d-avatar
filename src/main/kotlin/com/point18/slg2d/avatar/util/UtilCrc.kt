package com.point18.slg2d.avatar.util

@Volatile
var utilCrc = UtilCrc()

@ExperimentalUnsignedTypes
class UtilCrc {
    //CRC16多项式
    val polynomial = 0x1021
    val initialValue = 0xFFFF

    //CRC16查找表
    val crc16List: Array<UShort>

    init {
        //初始化
        val crcList = Array<UShort>(256) { UShort.MIN_VALUE }

        for (i in 0 until 256) {
            var crc = 0
            var c = i shl 8
            for (j in 0 until 8) {
                if ((crc xor c) and 0x8000 != 0) {
                    crc = (crc shl 1) xor polynomial
                } else {
                    crc = crc shl 1
                }
                c = c shl 1
            }
            crcList[i] = crc.toUShort()
        }

        crc16List = crcList
    }

    fun crc16(bytes: ByteArray): UShort {
        var crc = initialValue

        for (i in 0 until bytes.size) {
            crc = (crc shl 8 xor crc16List[(crc shr 8) xor (0xff and bytes[i].toInt())].toInt()).toUShort().toInt()
        }

        return crc.toUShort()
    }

    fun crc16Verify(bytes: ByteArray, crcCode: UShort): Boolean {
        val genCode = crc16(bytes)
        return genCode == crcCode
    }
}