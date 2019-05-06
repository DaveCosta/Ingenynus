package org.mephys.scala.ingenyus

import java.net.URL

import org.mephys.ingenyus.Record

import scala.collection.mutable._
import scala.io.Source

object Ingenyus {

  val MAU_GENIO = "http://www.maugenio.com/data/"
  val MAU_GENIO_CD = "cd.txt"
  val MAU_GENIO_DVD = "dvd.txt"
  val MAU_GENIO_BOOK = "livro.txt"
  val MAU_GENIO_VINIL = "lp.txt"

  def main(args: Array[String]): Unit = {

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


}
