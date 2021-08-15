package by.kos.rsnotesexample.screens.pref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import by.kos.rsnotesexample.MainActivity
import by.kos.rsnotesexample.R
import by.kos.rsnotesexample.databinding.ActivityMainBinding
import by.kos.rsnotesexample.databinding.ActivityPreferenceBinding
import by.kos.rsnotesexample.utils.APP_ACTIVITY

class PreferenceActivity : AppCompatActivity() {
    private lateinit var mToolbar: Toolbar
    private var _binding: ActivityPreferenceBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mToolbar = mBinding.toolbar
        title = getString(R.string.settings)
        setSupportActionBar(mToolbar)
        supportFragmentManager.beginTransaction().replace(R.id.prefContent, PreferencesFragment()).commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}