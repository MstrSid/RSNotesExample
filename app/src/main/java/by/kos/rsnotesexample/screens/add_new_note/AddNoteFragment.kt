package by.kos.rsnotesexample.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import by.kos.rsnotesexample.R
import by.kos.rsnotesexample.databinding.FragmentAddNoteBinding
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAdd.setOnClickListener {
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            var priority = 0
            when (mBinding.rgPriority.checkedRadioButtonId) {
                mBinding.rbPriority1.id -> {
                    priority = PRIORITY_HIGHT
                }
                mBinding.rbPriority2.id -> {
                    priority = PRIORITY_NORMAL
                }
                mBinding.rbPriority3.id -> {
                    priority = PRIORITY_LOW
                }
            }
            if (name.isEmpty()) {
                showToast(getString(R.string.name_is_blank))
            } else {
                mViewModel.insert(AppNote(name = name, text = text, priority = priority)) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        APP_ACTIVITY.navController.navigate(R.id.action_addNoteFragment_to_mainFragment)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}