package com.example.mvp_crud_livros.ui.MostraLivro

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.mvp_crud_livros.data.model.Livro

interface MostraLivroContract {
    interface View{
        fun setupConfig()
        fun onEditButtonClicked()
        fun displayConfirmDialog()
    }
    interface Presenter{
        fun displayInfo(livro: Livro, nome: TextView, autor: TextView, descricao: TextView)
        fun handleOnEditButtonClicked(context: Context) : Intent
        fun setupDisplayConfirmDialog(context: Context, livro: Livro, activity: Activity) : AlertDialog.Builder
    }
}