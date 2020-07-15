package com.example.mvp_crud_livros.ui.EditarLivro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvp_crud_livros.R
import com.example.mvp_crud_livros.data.model.Livro
import com.example.mvp_crud_livros.ui.ListaLivros.ListaLivrosActivity
import kotlinx.android.synthetic.main.activity_editar_livro.*

class EditarLivroActivity : AppCompatActivity(), EditarLivroContract.View {

    lateinit var mPresenter: EditarLivroPresenter
    lateinit var livro: Livro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_livro)

        mPresenter = EditarLivroPresenter()

        setupConfig()
    }

    override fun setupConfig() {
        livro = intent?.getSerializableExtra("UnicoLivro") as Livro

        mPresenter.setInputValues(livro, editar_nome_input, editar_autor_input, editar_descricao_input)

        appbar_editar_livro.setNavigationOnClickListener {
            onBackButtonClicked()
        }

        editar_livro_button.setOnClickListener {
            onButtonClicked()
        }
    }

    override fun onBackButtonClicked() {
        finish()
    }

    override fun onButtonClicked() {
        val nome = editar_nome_input.text.toString()
        val autor = editar_autor_input.text.toString()
        val descricao = editar_descricao_input.text.toString()

        val inputIsValid = mPresenter.validadeInput(nome, autor, descricao)

        val novoLivro = mPresenter.updateValuesLivro(livro.id, nome, autor, descricao)

        if(inputIsValid){
            mPresenter.editarLivro(novoLivro)
            val intent: Intent = Intent(this, ListaLivrosActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        else{
            displayDialog()
        }
    }

    override fun displayDialog() {
        mPresenter.handleDisplayDialog(this).show()
    }
}
