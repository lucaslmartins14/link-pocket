package com.linkpocket.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.linkpocket.model.Preview
import com.linkpocket.R

class MainViewModel : ViewModel() {

    private val previewSet = arrayListOf(
        Preview("Bar Do Chucrutes", "picapau", R.drawable.ic_launcher_background),
        Preview("Rafinhas", "chaves", R.drawable.ic_launcher_background),
        Preview("Samuquinha", "samurai", R.drawable.ic_launcher_background),
        Preview("Fêzinho", "pensando no frango", R.drawable.ic_launcher_background),
        Preview("Charleston", "10", R.drawable.ic_launcher_background)
    )

    private val mainViewStateMutableLiveData = MutableLiveData<MainUiState>()
    val mainViewStateLiveData: LiveData<MainUiState> = mainViewStateMutableLiveData

    init {
        mainViewStateMutableLiveData.postValue(MainUiState.Loading)
    }

}