package by.kos.rsnotesexample.utils

import androidx.recyclerview.widget.DiffUtil
import by.kos.rsnotesexample.model.AppNote

class NoteItemDiffUtil: DiffUtil.ItemCallback<AppNote>() {
    override fun areItemsTheSame(oldItem: AppNote, newItem: AppNote): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AppNote, newItem: AppNote): Boolean {
        return oldItem == newItem
    }
}