package com.example.mvp_crud_livros.ui.EditarLivro

import android.app.AlertDialog
import android.content.Context
import com.example.mvp_crud_livros.data.FirebaseRepo
import com.example.mvp_crud_livros.data.model.Livro
import com.google.android.material.textfield.TextInputEditText

class EditarLivroPresenter : EditarLivroContract.Presenter {

    private val repo: FirebaseRepo = FirebaseRepo()
    override fun updateValuesLivro(
        id: String,
        nome: String,
        autor: String,
        descricao: String
    ): Livro {
        val novoLivro: Livro = Livro(nome, autor, descricao)
        novoLivro.id = id
        return novoLivro
    }

    override fun validadeInput(nome: String, autor: String, descricao: String): Boolean {
        return !(nome.isEmpty() || autor.isEmpty() || descricao.isEmpty())
    }

    override fun editarLivro(livro: Livro) {
        repo.editLivro(livro)
    }

    override fun handleDisplayDialog(context: Context): AlertDialog.Builder {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Todos os campos precisam ser preenchidos")
        dialog.setPositiveButton("Ok"){ dialog, _ ->
            dialog.dismiss()
        }
        return dialog
    }

    override fun setInputValues(
        livro: Livro,
        nome: TextInputEditText,
        autor: TextInputEditText,
        descricao: TextInputEditText
    ) {
        nome.setText(livro.nome)
        autor.setText(livro.autor)
        descricao.setText(livro.descricao)
    }
}