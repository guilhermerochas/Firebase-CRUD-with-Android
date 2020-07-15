package com.example.mvp_crud_livros.ui.ListaLivros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvp_crud_livros.R
import kotlinx.android.synthetic.main.activity_lista_livros.*

class ListaLivrosActivity : AppCompatActivity(), ListaLivrosContract.View {

    private lateinit var mPresenter: ListaLivrosPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_livros)

        mPresenter = ListaLivrosPresenter()
    }

    override fun onStart() {
        super.onStart()
        setupConfig()
        mPresenter.setAdapterToListen(lista_recycler_view)
    }

    override fun setupConfig() {
        setRecyclerView()

        adiciona_item_lista.setOnClickListener {
            onFabClick(it)
        }
    }

    override fun setRecyclerView() {
        mPresenter.setList(lista_recycler_view, this)
    }

    override fun onFabClick(view: View) {
        val intent: Intent = mPresenter.handleFabClick(view)
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stopAdapterFromListening(lista_recycler_view)
    }
}
