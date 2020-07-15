package com.example.mvp_crud_livros.ui.EditarLivro

import android.app.AlertDialog
import android.content.Context
import com.example.mvp_crud_livros.data.model.Livro
import com.google.android.material.textfield.TextInputEditText

interface EditarLivroContract {
    interface View{
        fun setupConfig()
        fun onBackButtonClicked()
        fun onButtonClicked()
        fun displayDialog()
    }
    interface Presenter{
        fun updateValuesLivro(id: String, nome: String, autor: String, descricao: String) : Livro
        fun validadeInput(nome: String, autor: String, descricao: String): Boolean
        fun editarLivro(livro: Livro)
        fun handleDisplayDialog(context: Context) : AlertDialog.Builder
        fun setInputValues(livro: Livro, nome: TextInputEditText, autor: TextInputEditText, descricao: TextInputEditText)
    }
}