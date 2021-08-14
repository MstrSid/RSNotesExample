package by.kos.rsnotesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kos.rsnotesexample.database.room.AppRoomDatabase
import by.kos.rsnotesexample.database.room.AppRoomRepository
import by.kos.rsnotesexample.databinding.ActivityMainBinding
import by.kos.rsnotesexample.utils.APP_ACTIVITY
import by.kos.rsnotesexample.utils.REPOSITORY

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar
    lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolbar = mBinding.toolbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        setSupportActionBar(mToolbar)
        title = getString(R.string.title)
        val dao =  AppRoomDatabase.getInstance(APP_ACTIVITY.applicationContext).getAppRoomDao()
        REPOSITORY = AppRoomRepository(dao)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}