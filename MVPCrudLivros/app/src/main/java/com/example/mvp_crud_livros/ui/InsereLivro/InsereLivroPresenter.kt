package com.example.mvp_crud_livros.ui.InsereLivro

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.example.mvp_crud_livros.data.FirebaseRepo
import com.example.mvp_crud_livros.data.model.Livro

class InsereLivroPresenter: InsereLivroContract.Presenter {

    var repo: FirebaseRepo = FirebaseRepo()

    override fun validadeInput(nome: String, autor: String, descricao: String): Boolean {

        return !(nome.isEmpty() || autor.isEmpty() || descricao.isEmpty())

    }

    override fun insertLivro(nome: String, autor: String, descricao: String)  {
        val livro: Livro = Livro(nome, autor, descricao)
        repo.insertLivro(livro)
    }

    override fun handleDisplayDialog(context: Context): AlertDialog.Builder {
        val displayDialog  = AlertDialog.Builder(context)
        displayDialog.setTitle("Todos os campos precisam ser preenchidos")
        displayDialog.setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, id ->
            dialog.cancel()
        })
        displayDialog.create()
        return displayDialog
    }
}