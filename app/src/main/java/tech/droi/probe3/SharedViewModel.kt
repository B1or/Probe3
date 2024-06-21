package tech.droi.probe3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val axe: Axe
): ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count
    init {
        _count.value = 0
    }
    fun plus() {
        _count.value = _count.value?.plus(1)
    }
    fun minus() {
        _count.value = _count.value?.minus(1)
    }
    fun axeThrow() {
        _count.value = axe.value
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val axe = (this[APPLICATION_KEY] as MainApp).axe
                SharedViewModel(
                    axe = axe
                )
            }
        }
    }
}
