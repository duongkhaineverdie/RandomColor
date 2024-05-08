package com.smarttech.randomcolor.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.smarttech.randomcolor.utils.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onClickRandomColor() {
        val colorToShow = Constants.randomIntColor()
        _uiState.update {
            it.copy(
                colorInt = colorToShow.color,
                colorHex = colorToShow.colorHex
            )
        }
    }
}

data class HomeUiState(
    val colorInt: Int = 0,
    val colorHex: String = ""
)