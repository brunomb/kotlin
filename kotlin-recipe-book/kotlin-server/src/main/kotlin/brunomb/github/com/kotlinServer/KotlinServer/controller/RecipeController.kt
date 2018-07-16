package brunomb.github.com.kotlinServer.KotlinServer.controller

import org.springframework.web.bind.annotation.*
import brunomb.github.com.kotlinServer.KotlinServer.model.Recipe

@RestController
@RequestMapping("recipes")
class NoteController {

    @GetMapping
    fun list(): List<Recipe> {
        return listOf(Recipe("Recipe test 1", "Pastel da liberdade"),
                      Recipe("Recipe test 2", "Pizza do paulista"))
    }

    @PostMapping
    fun add(@RequestBody recipe: Recipe): Recipe {
        return recipe
    }

}