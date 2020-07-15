package com.example.mvp_crud_livros.ui.MostraLivro

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.mvp_crud_livros.data.FirebaseRepo
import com.example.mvp_crud_livros.data.model.Livro
import com.example.mvp_crud_livros.ui.EditarLivro.EditarLivroActivity

class MostraLivroPresenter : MostraLivroContract.Presenter{

    val repo: FirebaseRepo = FirebaseRepo()

    @SuppressLint("SetTextI18n")
    override fun displayInfo(livro: Livro, nome: TextView, autor: TextView, descricao: TextView) {
        nome.text = "${nome.text} ${livro.nome}"
        autor.text = "${autor.text} ${livro.autor}"
        descricao.text = "${descricao.text} ${livro.descricao}"
    }

    override fun handleOnEditButtonClicked(context: Context) : Intent {
        return Intent(context, EditarLivroActivity::class.java)
    }

    override fun setupDisplayConfirmDialog(context: Context, livro: Livro, activity: Activity): AlertDialog.Builder {

        val displayDialog = AlertDialog
            .Builder(context)
            .setTitle("Tem certeza que deseja excluir este livro?")
            .setPositiveButton("Sim"){ _, _ ->
                repo.deleteLivro(livro)
                activity.finish()
            }
            .setNegativeButton("Cancelar"){ dialog, _ ->
                dialog.dismiss()
            }
        return displayDialog
    }

}