package com.nubank.nubankclone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nubank.nubankclone.Util.Utilitarios
import com.nubank.nubankclone.databinding.ActivityLoginBinding
import java.util.concurrent.Executor

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val _biometrics = MutableLiveData<Boolean>()
    val biometrics: LiveData<Boolean> = _biometrics

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        observe()
    }

    @SuppressLint("SwitchIntDef")
    private fun observe() {
        val executor: Executor = ContextCompat.getMainExecutor(this)

        val biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
            })

        // Informações apresentadas no momento da autenticação
        val info: BiometricPrompt.PromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(getString(R.string.titile))
            // .setSubtitle("Subtítulo")
            // .setDescription("Descrição")
            //.setNegativeButtonText(getString(R.string.cancelar))
            .setAllowedAuthenticators(BIOMETRIC_WEAK or DEVICE_CREDENTIAL)
            .build()

        // Exibe para o usuário
        biometricPrompt.authenticate(info)
        _biometrics.value = Utilitarios.isBiometricAvailable(getApplication())
    }

}