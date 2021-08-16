package by.kos.rsnotesexample.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import by.kos.rsnotesexample.R
import by.kos.rsnotesexample.databinding.FragmentMainBinding
import by.kos.rsnotesexample.model.AppNote
import by.kos.rsnotesexample.screens.pref.PreferenceActivity
import by.kos.rsnotesexample.utils.*

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<AppNote>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(APP_ACTIVITY)
        CRITERIA = prefs.getString("prefSortKey", ORDER_BY_TITLE).toString()
        setHasOptionsMenu(true)
        mAdapter = MainAdapter()
        mBinding.rvNotes.adapter = mAdapter
        mObserverList = Observer {
            mAdapter.submitList(it)
        }
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this, mObserverList)
        mBinding.fabAdd.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_addNoteFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnSort -> {
                val intent = Intent(APP_ACTIVITY, PreferenceActivity::class.java)
                startActivity(intent)
                APP_ACTIVITY.finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.allNotes.removeObserver(mObserverList)
        mBinding.rvNotes.adapter = null
        _binding = null
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }
}