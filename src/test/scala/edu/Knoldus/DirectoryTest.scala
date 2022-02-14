package edu.Knoldus

import org.scalatest.flatspec.AnyFlatSpec
import java.nio.file.FileSystems
import scala.language.postfixOps

class DirectoryTest extends AnyFlatSpec {
  " Directory(\"./sr\")" should "give List(./sr) because path doesn't exists " in {
    val obj: Directory = Directory("./sr")
    assert(obj.result == List("Path doesn't exists !"))
  }
  "Directory(\"./src\")" should "give List(())" in {
    val obj = Directory("./src")
    assert(obj.result == List("()"))
  }

  "Path Valid or not " should "give" in {
    val path = FileSystems.getDefault.getPath("./src")
    assert(path.toFile.isDirectory && path.toFile.exists())


  }
}


