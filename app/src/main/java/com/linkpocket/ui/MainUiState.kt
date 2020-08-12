package com.linkpocket.ui

import com.linkpocket.model.Preview

sealed class MainUiState {
    class Success(val list: List<Preview>) : MainUiState()
    object Loading : MainUiState()
    object Error : MainUiState()
}