package com.example.projectwork.dictionary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.projectwork.App
import com.example.projectwork.database.PolyglotData
import com.example.projectwork.database.PolyglotDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DictionaryViewModel(application: Application) : AndroidViewModel(application) {

    private val myApp = application as App
    private val database : PolyglotDatabaseDao = myApp.database.polyglotDatabaseDao
    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val stub : LiveData<List<PolyglotData>> = liveData {
        emit(listOf(PolyglotData(1, originalWord = "word1"), PolyglotData(2, originalWord = "word2")))
    }
    val okWords = stub//database.getStudiedWords(myApp.currentLanguage)

}
