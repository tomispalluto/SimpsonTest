package com.ifp.simpsonapp.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ifp.simpsonapp.R
import com.ifp.simpsonapp.models.Characters

class CharacterAdapter (
    val context: Context,
    var listCharacters: List <Characters>
): RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){
    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val cvPersonaje = item.findViewById(R.id.cvPersonaje) as CardView
        val ivPersonaje = item.findViewById(R.id.ivPersonaje) as ImageView
        val tvNomPersonaje = item.findViewById(R.id.tvNomPersonaje) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_personajes, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = listCharacters[position]

        Glide
            .with(context)
            .load(personaje.image)
            .centerInside()
            .into(holder.ivPersonaje)

        holder.tvNomPersonaje.text = personaje.character

        holder.cvPersonaje.setOnClickListener{
            showPhrase(personaje.phrase)
        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }
    fun showPhrase(phrase: String){
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_phrase);

        val tvPhrase = bottomSheetDialog.findViewById<TextView>(R.id.tvFrase)
        tvPhrase!!.text = phrase

        bottomSheetDialog.show()
    }
}