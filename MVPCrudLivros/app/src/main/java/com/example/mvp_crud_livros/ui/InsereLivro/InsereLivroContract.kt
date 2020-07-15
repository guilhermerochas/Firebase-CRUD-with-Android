package com.example.mvp_crud_livros.ui.InsereLivro

import android.app.AlertDialog
import android.content.Context

interface InsereLivroContract {
    interface View{
        fun setupConfig()
        fun onButtonClicked()
        fun displayDialog()
        fun onBackButtonClicked()
    }
    interface Presenter{
        fun validadeInput(nome: String, autor: String, descricao: String): Boolean
        fun insertLivro(nome: String, autor: String, descricao: String)
        fun handleDisplayDialog(context: Context) : AlertDialog.Builder
    }
}