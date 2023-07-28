package com.nubank.nubankclone.Util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.biometric.BiometricManager

object Utilitarios {

    @SuppressLint("SwitchIntDef")
    fun isBiometricAvailable(context: Context): Boolean {
        val biometricManager: BiometricManager = BiometricManager.from(context)
        when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK or BiometricManager.Authenticators.DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> return true
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> return true
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> return false
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> return false
        }
        return false
    }
}