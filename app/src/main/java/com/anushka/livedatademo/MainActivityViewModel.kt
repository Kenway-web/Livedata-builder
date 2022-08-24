package com.anushka.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.anushka.livedatademo.model.User
import com.anushka.livedatademo.model.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel()  {

    private var usersRepository= UserRepository()

    // see how many less codes than viewModel observe
    // live data is the coroutine building block for livedata
    // this new block automatically execute when livedata become active

    val users= liveData(Dispatchers.IO) {
        val result=usersRepository.getUsers()
        emit(result)
    }

}