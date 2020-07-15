package com.example.mvp_crud_livros.ui.MostraLivro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvp_crud_livros.R
import com.example.mvp_crud_livros.data.model.Livro
import kotlinx.android.synthetic.main.activity_mostra_livro.*

class MostraLivroActivity : AppCompatActivity(), MostraLivroContract.View {

    lateinit var mPresenter : MostraLivroPresenter
    lateinit var livro: Livro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostra_livro)

        mPresenter = MostraLivroPresenter()

        setupConfig()
    }

    override fun setupConfig() {
        livro = intent?.getSerializableExtra("Livro") as Livro

        appbar_mostra_livro.setNavigationOnClickListener {
            finish()
        }

        Log.d("Nome do livro", livro.nome)

        appbar_mostra_livro.title = livro.nome
        appbar_mostra_livro.setTitleTextColor(Color.WHITE)
        appbar_mostra_livro.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.icone_deletar_livro -> {
                    displayConfirmDialog()
                    return@setOnMenuItemClickListener true
                }
                R.id.icone_editar_livro -> {
                    onEditButtonClicked()
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    return@setOnMenuItemClickListener false
                }
            }
        }

        mPresenter.displayInfo(livro, exibe_nome_livro, exibe_autor_livro, exibe_descricao_livro)
    }

    override fun onEditButtonClicked() {
        val intent = mPresenter.handleOnEditButtonClicked(this)
        intent.putExtra("UnicoLivro", livro)
        startActivity(intent)
    }

    override fun displayConfirmDialog() {
        mPresenter.setupDisplayConfirmDialog(this, livro, this).show()
    }
}
