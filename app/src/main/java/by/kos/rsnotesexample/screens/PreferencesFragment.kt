package by.kos.rsnotesexample.screens

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import by.kos.rsnotesexample.R

class PreferencesFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }



}