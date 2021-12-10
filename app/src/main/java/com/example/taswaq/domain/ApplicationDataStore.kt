package com.example.taswaq.domain

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.taswaq.domain.DataStoreKeys.AUTH_TOKEN
import com.example.taswaq.domain.DataStoreKeys.EMAIL
import com.example.taswaq.domain.DataStoreKeys.ID
import com.example.taswaq.domain.DataStoreKeys.IS_AUTHENTICATED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_defaults")

private object DataStoreKeys {
    val IS_AUTHENTICATED = booleanPreferencesKey("IS_AUTHENTICATED")
    val AUTH_TOKEN = stringPreferencesKey("AUTH_TOKEN")
    val ID = stringPreferencesKey("ID")
    val EMAIL = stringPreferencesKey("EMAIL")
}

val Context.isUserAuthenticated: Flow<Boolean>
    get() = this.dataStore.data.map { it[IS_AUTHENTICATED] ?: true }

suspend fun Context.setUserAuthenticated(newValue: Boolean) =
    this.dataStore.edit { it[IS_AUTHENTICATED] = newValue }


val Context.userAuthToken: Flow<String?>
    get() = this.dataStore.data.map { it[AUTH_TOKEN] }

suspend fun Context.setUserAuthToken(newValue: String) =
    this.dataStore.edit { it[AUTH_TOKEN] = newValue }


val Context.UID: Flow<String?>
    get() = this.dataStore.data.map { it[ID] }

suspend fun Context.setUID(newValue: String) =
    this.dataStore.edit { it[ID] = newValue }


val Context.userEmail: Flow<String?>
    get() = this.dataStore.data.map { it[EMAIL] }

suspend fun Context.setUserEmail(newValue: String) =
    this.dataStore.edit { it[EMAIL] = newValue }


