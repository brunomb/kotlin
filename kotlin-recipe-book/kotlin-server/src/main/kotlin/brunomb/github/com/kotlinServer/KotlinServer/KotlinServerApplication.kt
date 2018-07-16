package brunomb.github.com.kotlinServer.KotlinServer

import brunomb.github.com.kotlinServer.KotlinServer.model.Recipe
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.net.URL

@SpringBootApplication
class KotlinServerApplication

fun main(args: Array<String>) {
    runApplication<KotlinServerApplication>(*args)

    val json = """{"title": "Kolineer", "description": "26"}"""
    val mapper = jacksonObjectMapper()

    println("=== JSON to Kotlin Object ===")
    println("1- read String")
    var person: Recipe = mapper.readValue<Recipe>(json)
    println(person)

    println("2- read URL")
    person = mapper.readValue<Recipe>(URL("https://github.com/brunomb/kotlin/blob/master/kotlin-recipe-book/MOCK_DATA.json"))
    println(person)

    println("3- read File")
    /* content of person.json
    {
      "name" : "Kolineer",
      "age" : 28,
      "messages" : [ "message AA", "message BB" ]
    }
    */
    person = mapper.readValue<Recipe>(File("MOCK_DATA.json"))
    println(person)
}