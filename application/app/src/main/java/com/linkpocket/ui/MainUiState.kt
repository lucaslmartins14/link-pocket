package com.linkpocket.ui

sealed class MainUiState {
    object Success : MainUiState()
    object Loading : MainUiState()
    object Error : MainUiState()
}