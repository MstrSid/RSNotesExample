package by.kos.rsnotesexample.screens.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kos.rsnotesexample.databinding.NoteItemBinding
import by.kos.rsnotesexample.model.AppNote

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainViewHolder(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.itemNoteName.text = mListNotes[position].name
        holder.binding.itemNoteText.text = mListNotes[position].text
        var colorId = 0
        when(mListNotes[position].priority){
            1 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_red_light)
            2 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_orange_light)
            3 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_green_light)
        }
        holder.binding.itemNoteName.setBackgroundColor(colorId)
    }

    override fun getItemCount(): Int {
        return mListNotes.size
    }

    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }
}