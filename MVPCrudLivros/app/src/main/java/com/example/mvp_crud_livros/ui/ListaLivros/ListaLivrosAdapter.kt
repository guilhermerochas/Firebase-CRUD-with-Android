package com.example.mvp_crud_livros.ui.ListaLivros

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_crud_livros.R
import com.example.mvp_crud_livros.data.model.Livro
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import kotlinx.android.synthetic.main.livro_item.view.*

class ListaLivrosAdapter(options: FirestoreRecyclerOptions<Livro>) :
    FirestoreRecyclerAdapter<Livro, ListaLivrosAdapter.myViewHolder>(options){

    class myViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView){
        val nomeLivro: TextView = itemView.livro_nome
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.livro_item, parent ,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int, model: Livro) {
        holder.nomeLivro.text = model.nome
        val mPresenter = ListaLivrosPresenter()
        val context = holder.nomeLivro.context

        holder.itemView.setOnClickListener {
            val intent = mPresenter.handleItemClick(context, model)
            context.startActivity(intent)
        }
    }
}