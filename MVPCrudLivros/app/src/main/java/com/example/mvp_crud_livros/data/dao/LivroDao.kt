package com.example.mvp_crud_livros.data.dao

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_crud_livros.data.model.Livro
import com.example.mvp_crud_livros.ui.ListaLivros.ListaLivrosAdapter

interface LivroDao {
    fun insertLivro(livro: Livro)
    fun getLivros(recyclerView: RecyclerView, context: Context) : ListaLivrosAdapter
    fun editLivro(livro: Livro)
    fun deleteLivro(livro: Livro)
}