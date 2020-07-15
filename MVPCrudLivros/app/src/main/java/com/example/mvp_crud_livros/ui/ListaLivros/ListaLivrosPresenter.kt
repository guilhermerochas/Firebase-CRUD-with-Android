package com.example.mvp_crud_livros.ui.ListaLivros

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_crud_livros.data.FirebaseRepo
import com.example.mvp_crud_livros.data.model.Livro
import com.example.mvp_crud_livros.ui.InsereLivro.InsereLivroActivity
import com.example.mvp_crud_livros.ui.MostraLivro.MostraLivroActivity

class ListaLivrosPresenter: ListaLivrosContract.Presenter {

    private var repo: FirebaseRepo = FirebaseRepo()
    private lateinit var adapter: ListaLivrosAdapter

    override fun setList(recyclerView: RecyclerView, context: Context) {
        adapter = repo.getLivros(recyclerView, context)
    }

    override fun handleItemClick(context: Context ,livro: Livro) : Intent {
        val intent: Intent = Intent(context, MostraLivroActivity::class.java)
        intent.putExtra("Livro", livro)
        return intent
    }

    override fun handleFabClick(view: View): Intent {
        val intent: Intent = Intent(view.context , InsereLivroActivity::class.java)
        return intent
    }

    override fun setAdapterToListen(recyclerView: RecyclerView) {
        adapter.startListening()
    }

    override fun stopAdapterFromListening(recyclerView: RecyclerView) {
        adapter.stopListening()
    }
}