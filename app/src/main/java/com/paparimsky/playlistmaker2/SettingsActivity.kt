package com.paparimsky.playlistmaker2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paparimsky.playlistmaker2.databinding.ActivitySettingsBinding

class SettingsActivity: AppCompatActivity(){

    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backToMainFromSettings.setOnClickListener{
            finish()
        }
        binding.toShare.setOnClickListener{
            Intent(Intent.ACTION_SEND).apply{
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, getString(R.string.view_to_share))
                startActivity(this)
            }
        }
        binding.toSupport.setOnClickListener{
            Intent(Intent.ACTION_SENDTO).apply{
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.view_to_support_address)))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.view_to_support_subject))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.view_to_support_text))
                startActivity(this)
            }
        }
        binding.toAgreement.setOnClickListener{
            Intent(Intent.ACTION_VIEW).apply{
                data = Uri.parse(getString(R.string.view_to_agreement))
                startActivity(this)
            }
        }
        binding.changeTheme.setOnClickListener{
            binding.switchTheme.isChecked= !binding.switchTheme.isChecked
        }
    }
}