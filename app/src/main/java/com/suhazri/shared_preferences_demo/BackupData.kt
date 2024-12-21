package com.suhazri.shared_preferences_demo

import android.app.backup.BackupAgentHelper
import android.app.backup.SharedPreferencesBackupHelper

class BackupData: BackupAgentHelper() {
    companion object {
        val PREFS_TEST = "testprefs"
        val MY_PREFS_BACKUP_KEY = "myprefs"
    }

    override fun onCreate() {
        super.onCreate()
        var helper = SharedPreferencesBackupHelper(
            this, PREFS_TEST)
        addHelper(MY_PREFS_BACKUP_KEY, helper)
    }
}