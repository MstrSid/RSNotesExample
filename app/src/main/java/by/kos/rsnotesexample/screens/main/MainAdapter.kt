package by.kos.rsnotesexample.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kos.rsnotesexample.databinding.NoteItemBinding
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.NoteItemDiffUtil

class MainAdapter: ListAdapter<AppNote, MainAdapter.MainViewHolder>(NoteItemDiffUtil()) {

    class MainViewHolder(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(currentList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.itemNoteName.text = getItem(position).name
        holder.binding.itemNoteText.text = getItem(position).text
        var colorId = 0
        when(getItem(position).priority){
            1 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_red_light)
            2 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_orange_light)
            3 ->  colorId = ContextCompat.getColor(holder.binding.root.context, android.R.color.holo_green_light)
        }
        holder.binding.itemNoteName.setBackgroundColor(colorId)
    }
}