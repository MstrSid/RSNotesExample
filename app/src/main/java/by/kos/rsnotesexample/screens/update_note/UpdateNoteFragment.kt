package by.kos.rsnotesexample.screens.update_note

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kos.rsnotesexample.R
import by.kos.rsnotesexample.databinding.UpdateNoteFragmentBinding
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateNoteFragment : Fragment() {

    private var _binding: UpdateNoteFragmentBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: UpdateNoteViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UpdateNoteFragmentBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(UpdateNoteViewModel::class.java)
        mBinding.inputNameNote.setText(mCurrentNote.name)
        mBinding.inputTextNote.setText(mCurrentNote.text)
        (mBinding.rgPriority.getChildAt(mCurrentNote.priority-1) as RadioButton).isChecked = true

        mBinding.btnUpdate.setOnClickListener {
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
                mCurrentNote.name = name
                mCurrentNote.text = text
                mCurrentNote.priority = priority
                mViewModel.update(mCurrentNote) {
                    lifecycleScope.launch(Dispatchers.Main) {
                        APP_ACTIVITY.navController.navigate(R.id.action_updateNoteFragment_to_mainFragment)
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