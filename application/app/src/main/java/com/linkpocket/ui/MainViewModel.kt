package com.linkpocket.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.GetListUseCase
import com.domain.model.Preview
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val getListUseCase: GetListUseCase) : ViewModel() {

    private val mainViewStateMutableLiveData = MutableLiveData<MainUiState>()
    val mainViewStateLiveData: LiveData<MainUiState> = mainViewStateMutableLiveData

    init {
        initList()
    }

    private fun initList() {
        getListUseCase.getPreview()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Preview>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    // Inscrever para receber a lista

                    // Iniciar Loading
                    mainViewStateMutableLiveData.postValue(MainUiState.Loading)
                }

                override fun onNext(previewList: List<Preview>) {
                    // Enviar a lista

                    // Retorno da Lista
                    mainViewStateMutableLiveData.postValue(MainUiState.Success(previewList))
                }

                override fun onError(e: Throwable) {
                    // Tratar os erros

                    mainViewStateMutableLiveData.postValue(MainUiState.Error)
                }
            })
    }

}