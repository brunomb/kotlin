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

    val json = """{"id": "Kolineer", "name": "26"}"""
    val json2 = """{"id":1,"name":"Goldina","author":"Booley","email":"gbooley0@mozilla.org","origin_country_lat":32.297028,"origin_country_long":35.10999," ingredients":["Pasta","Beans","Egg","Salt"],"creation_date":"10/31/2017","avatar":"https://robohash.org/sedeteaque.png?size=64x64&set=set1","category_name":"Starling, red-shouldered glossy","category_color":"#42b79b","recipe":"Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus."}"""
    val mapper = jacksonObjectMapper()

    println("=== JSON to Kotlin Object ===")
    println("1- read String")
    var recipe: Recipe = mapper.readValue<Recipe>(json)
    println(recipe)

    println("2- read URL")
    var recipe2: List<Recipe> = mapper.readValue<List<Recipe>>(URL("https://raw.githubusercontent.com/brunomb/kotlin/master/kotlin-recipe-book/MOCK_DATA.json"))
    println(recipe)

    println("=== Kotlin Object to JSON ===")
    recipe = Recipe("Kolineer Master", "Bracchi")

    println("1- String")
    var jsonStr = mapper.writeValueAsString(recipe)
    println(jsonStr)

    println("2- Formatted String")
    jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recipe)
    println(jsonStr)

    println("3- File -> manually check file for result")
    mapper.writerWithDefaultPrettyPrinter().writeValue(File("newPerson.json"), recipe)
}