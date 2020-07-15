package com.example.mvp_crud_livros.ui.ListaLivros

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_crud_livros.data.model.Livro

interface ListaLivrosContract {
    interface View{
        fun setupConfig()
        fun onFabClick(view: android.view.View)
        fun setRecyclerView()
    }
    interface Presenter{
        fun setList(recyclerView: RecyclerView, context: Context)
        fun handleItemClick(context: Context,livro:Livro): Intent
        fun handleFabClick(view: android.view.View) : Intent
        fun setAdapterToListen(recyclerView: RecyclerView)
        fun stopAdapterFromListening(recyclerView: RecyclerView)
    }
}