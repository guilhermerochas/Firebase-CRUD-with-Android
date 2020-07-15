package com.example.mvp_crud_livros.ui.InsereLivro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_crud_livros.R
import kotlinx.android.synthetic.main.activity_insere_livro.*

class InsereLivroActivity : AppCompatActivity(), InsereLivroContract.View {

    lateinit var mPresenter: InsereLivroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insere_livro)

        mPresenter = InsereLivroPresenter()
        setupConfig()
    }

    override fun setupConfig() {
        insere_livro_button.setOnClickListener {
            onButtonClicked()
        }

        appbar_insere_livro.setNavigationOnClickListener {
            onBackButtonClicked()
        }
    }

    override fun onButtonClicked() {

        val nome: String = livro_nome_input.text.toString()
        val autor: String = livro_autor_input.text.toString()
        val descricao: String = livro_descricao_input.text.toString()

        val inputIsValid = mPresenter.validadeInput(nome, autor, descricao)

        if(inputIsValid){
            mPresenter.insertLivro(nome, autor, descricao)
            finish()
        }
        else{
            displayDialog()
        }
    }

    override fun displayDialog() {
        val alertDialog : android.app.AlertDialog.Builder =  mPresenter.handleDisplayDialog(this)
        alertDialog.show()
    }

    override fun onBackButtonClicked() {
        finish()
    }
}
