package com.example.mvp_crud_livros.data

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_crud_livros.data.dao.LivroDao
import com.example.mvp_crud_livros.data.model.Livro
import com.example.mvp_crud_livros.ui.ListaLivros.ListaLivrosAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlin.collections.HashMap

class FirebaseRepo() : LivroDao {

    private var firestoreDB: FirebaseFirestore = FirebaseFirestore.getInstance()
	private var databaseName: String = "livros"

    override fun insertLivro(livro: Livro) {

        val itemLivro: HashMap<String, Any> = hashMapOf()

        itemLivro.put("id", livro.id)
        itemLivro.put("nome", livro.nome)
        itemLivro.put("autor", livro.autor)
        itemLivro.put("descricao", livro.descricao)

        firestoreDB.collection(databaseName)
            .document(livro.id)
            .set(itemLivro)
    }

    override fun getLivros(recyclerView: RecyclerView, context: Context): ListaLivrosAdapter {

        val collection: CollectionReference = firestoreDB.collection(databaseName)
        val query: Query = collection.orderBy("nome")

        val options: FirestoreRecyclerOptions<Livro> = FirestoreRecyclerOptions
            .Builder<Livro>()
            .setQuery(query, Livro::class.java)
            .build()

        val adapter = ListaLivrosAdapter(options)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return adapter
    }

    override fun editLivro(livro: Livro) {

        firestoreDB = FirebaseFirestore.getInstance()

        val novoLivro: Map<String, Any> = hashMapOf(
            "id" to livro.id,
            "nome" to livro.nome,
            "autor" to livro.autor,
            "descricao" to livro.descricao
        )

        firestoreDB.collection(databaseName)
            .document(livro.id)
            .update(novoLivro)
    }

    override fun deleteLivro(livro: Livro) {
        firestoreDB.collection(databaseName)
            .document(livro.id)
            .delete()
    }
}