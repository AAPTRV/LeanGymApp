package com.example.leangaingym.base.mvvm

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Outcome<T>>.loading(isLoading: Boolean) {
    this.value = Outcome.loading(isLoading)
}

fun <T> MutableLiveData<Outcome<T>>.success(t: T) {
    with(this) {
        loading(false)
        value = Outcome.success(t)
    }
}

fun <T> MutableLiveData<Outcome<T>>.next(t: T) {
    with(this) {
        loading(false)
        value = Outcome.next(t)
    }
}

fun <T> MutableLiveData<Outcome<T>>.failed(e: Throwable) {
    with(this) {
        loading(false)
        value = Outcome.failure(e)
    }
}