package org.mephys.ingenyus.ingenyus

import org.mephys.ingenyus.Record
import java.net.URL
import java.io.InputStreamReader
import java.io.BufferedReader
import kotlin.system.measureTimeMillis


object Ingenyus {


    val MAU_GENIO = "http://www.maugenio.com/data/"
    val MAU_GENIO_CD = "cd.txt"
    val MAU_GENIO_DVD = "dvd.txt"
    val MAU_GENIO_BOOK = "livro.txt"
    val MAU_GENIO_VINIL = "lp.txt"
    val MAU_GENIO_LOCAL = true


    @JvmStatic
    fun main(args: Array<String>) {

        val milliseconds = measureTimeMillis {
            val records: ArrayList<Record> = ArrayList()
            val url = if (MAU_GENIO_LOCAL) {
                javaClass.getResource("/$MAU_GENIO_CD").toURI().toURL()
            } else URL(MAU_GENIO + MAU_GENIO_CD)

            val connection = url.openConnection()
            val buffer = BufferedReader(InputStreamReader(url.openConnection().getInputStream()))
            url.openStream().bufferedReader().use {
                it.forEachLine { line ->
                    val array = line.trim().split("\t")
                    val record =  Record(array.toTypedArray())
                    records += record
                    println(record)
                }
            }
        }

        print(milliseconds / 1000.0)

        //val file = File(url,"ISO-8859-1")
    }
}


/*object Ingenyus {



    val records: Buffer[Record] = Buffer()

    val url = new URL(MAU_GENIO + MAU_GENIO_CD)

    val buffer = Source.fromURL(url, "ISO-8859-1")

    for(line <- buffer.getLines) {
      val array = line.trim.split("\t")
      val record = new Record(array)
      records += record
      println(record)
    }

    println("\nTotal: " + records.length)
  }


}*/
