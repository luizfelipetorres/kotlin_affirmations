package com.lftf.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lftf.affirmations.R
import com.lftf.affirmations.model.Affirmation

/**
 * Classe responsável por adaptar os itens no RecyclerView.
 * Recete um contexto e um dataset.
 * Extende RecyclerView.Adapter do tipo ItemViewHolder (classe aninhada)
 *
 * Criamos a classe recebendo o dataset e o context, criamos a nested class com um atributo
 * e depois fazemos a extenção
 * Com a extenção feita, podemos implementar os métodos
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHoder>() {

    /**
     * Classe aninhada responsável pela criação e binding de dados na viewHolder
     * Recebe uma view e extende ViewHolder, passando essa view para o construtor do pai
     */
    class ItemViewHoder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Método executado ao criar o holder. adapterLayout guarda o layout que contem o textview
     * Ele retorna um ViewHolder com esse layout e preenche na tela
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHoder {
        val adapterLayout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHoder(adapterLayout)
    }

    /**
     * Colocar os dados no ViewHolder. Recebe um ViewHolder e a posição do item atual
     * Aqui acontece o binding
     */
    override fun onBindViewHolder(holder: ItemViewHoder, position: Int) {
        val item = dataset[position]

        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Método responsável por saber o tamanho do dataset
     */
    override fun getItemCount(): Int = dataset.size
}