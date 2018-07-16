package brunomb.github.com.kotlinServer.KotlinServer.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Recipe(val id: String = "",
                  val name: String = "")