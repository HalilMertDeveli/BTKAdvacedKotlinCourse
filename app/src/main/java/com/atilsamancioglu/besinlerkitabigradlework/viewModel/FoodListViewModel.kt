package com.atilsamancioglu.besinlerkitabigradlework.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atilsamancioglu.besinlerkitabigradlework.model.Food
import com.atilsamancioglu.besinlerkitabigradlework.service.FoodApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FoodListViewModel : ViewModel() {
    val foodList = MutableLiveData<List<Food>>()
    val foodErrorMessage = MutableLiveData<Boolean>()
    val foodIsLoading = MutableLiveData<Boolean>()

    private val foodApiService = FoodApiService()//we get an instance from api service
    private val disposable =
        CompositeDisposable()//it is use and delete structure , we use this struct when we need to send request and after that delete,it comes form RXJava

    fun refreshData() {
        getDataFromEthernet()

        disposable.add(//we are adding to disposable to our composite
            foodApiService.getData()
                .subscribeOn(Schedulers.newThread())//we are subscribe to Single observable(created new thread fot schedulers)
                .observeOn(AndroidSchedulers.mainThread())//we need to observe android(we need to see in andorid main thread )
                .subscribeWith(object : DisposableSingleObserver<List<Food>>() {
                    //We use for single observable
                    override fun onSuccess(foodListInstance: List<Food>) {
                        //we the operation is success
                        foodList.value = foodListInstance
                        foodIsLoading.value = false
                        foodErrorMessage.value = false


                    }

                    override fun onError(e: Throwable) {
                        //when the operation has error
                        foodIsLoading.value = false
                        foodErrorMessage.value = true
                        e.printStackTrace()


                    }

                }

                )
        )
    }

    private fun getDataFromEthernet() {
        foodIsLoading.value = true//we set the loading bar visible for loading

    }
}