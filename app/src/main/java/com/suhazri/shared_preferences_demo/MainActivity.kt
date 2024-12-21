package com.suhazri.shared_preferences_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suhazri.shared_preferences_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //declare constant/key where data will be saved
    private final val SAVED = "saved"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.readDataButton.isEnabled = false

        binding.saveDataButton.setOnClickListener {
            if (binding.saveDataEditText.text.isNotEmpty()) {
                savePreferences(binding.saveDataEditText.text.toString())
            }
            binding.readDataButton.isEnabled = true
        }

        binding.readDataButton.setOnClickListener {
            val savedData = loadPreferences(SAVED)
            binding.readDataEditText.setText(savedData)
        }
    }

    private fun savePreferences(value: String) {
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        //Enter edit mode SP
        val editor = sharedPreferences.edit()
        //Write the "key" and "value" in SP
        //Eg: Nama(key): Suhazri(value)
        editor.putString(SAVED, value)
        //Save the data
        editor.apply()
    }

    private fun loadPreferences(key: String): String? {
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        // Look for data saved with "SAVED" file name, if not found return ""
        val value = sharedPreferences.getString(SAVED, "")
        return value
    }
}