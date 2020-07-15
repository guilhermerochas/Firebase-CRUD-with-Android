package com.example.mvp_crud_livros.data.model

import java.io.Serializable
import java.util.*

data class Livro(
  var nome: String = "",
  var autor: String = "",
  var descricao: String = ""
): Serializable{

  var id: String = UUID.randomUUID().toString()
}
