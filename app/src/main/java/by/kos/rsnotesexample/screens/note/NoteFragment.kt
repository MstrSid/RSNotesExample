package by.kos.rsnotesexample.screens.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kos.rsnotesexample.R
import by.kos.rsnotesexample.databinding.FragmentNoteBinding
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.screens.add_new_note.AddNewNoteViewModel
import by.kos.rsnotesexample.utils.APP_ACTIVITY
import by.kos.rsnotesexample.utils.PRIORITY_HIGHT
import by.kos.rsnotesexample.utils.PRIORITY_LOW
import by.kos.rsnotesexample.utils.PRIORITY_NORMAL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: NoteFragmentViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        mBinding.noteName.text = mCurrentNote.text
        mBinding.noteText.text = mCurrentNote.text
        var colorId = 0
        when (mCurrentNote.priority) {
            PRIORITY_HIGHT -> {
                mBinding.notePriority.text = getString(R.string.priority_hight)
                colorId =
                    ContextCompat.getColor(mBinding.root.context, android.R.color.holo_red_light)
            }
            PRIORITY_NORMAL -> {
                mBinding.notePriority.text = getString(R.string.priority_normal)
                colorId =
                    ContextCompat.getColor(mBinding.root.context, android.R.color.holo_orange_light)
            }
            PRIORITY_LOW -> {
                mBinding.notePriority.text = getString(R.string.priority_low)
                colorId =
                    ContextCompat.getColor(mBinding.root.context, android.R.color.holo_green_light)
            }
        }
        mBinding.notePriority.setBackgroundColor(colorId)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnDelete -> {
                mViewModel.delete(mCurrentNote) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment)
                    }
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}