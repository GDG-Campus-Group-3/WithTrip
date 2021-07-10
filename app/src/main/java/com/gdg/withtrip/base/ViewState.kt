package com.gdg.withtrip.base

sealed class ViewState<out T> {
  object Loading : ViewState<Nothing>()
  data class Success<out T>(val result: T) : ViewState<T>()
  data class Failure(val errorMsg: String) : ViewState<Nothing>()
}