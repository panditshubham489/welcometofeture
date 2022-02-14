package edu.Knoldus

import java.nio.file.{FileSystems, Files}
import scala.concurrent.{Await, Future}
import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


case class Directory(sourceOfPath: String) {
  val result: List[String] = Await.result(Directory(sourceOfPath), 1 second)

  def Directory(pathOfDirectory: String): Future[List[String]] = Future {
    val path = FileSystems.getDefault.getPath(pathOfDirectory)
    if (path.toFile.isDirectory || path.toFile.exists()) {
      List(Files.walk(path).iterator().asScala.foreach(println).toString)
    } else {
      List("Path doesn't exists !")
    }
  }
}



