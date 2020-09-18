package com.linkpocket.ui.links

sealed class MyLinksUiState {
    object Success : MyLinksUiState()
    object Loading : MyLinksUiState()
    object Error : MyLinksUiState()
}