package com.example.moviesapp.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.model.Result
import com.example.moviesapp.model.ResultX
import com.example.moviesapp.model.State
import com.example.moviesapp.ui.actors.adapter.PersonAdapter
import com.example.moviesapp.ui.home.adapter.MovieAdapter

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> ShowWhenLoading(view : View, State :State<T>?){
    if(State is State.Loading){
        view.visibility= View.VISIBLE
    }else {view.visibility= View.GONE}

}
@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> ShowWhenSuccess(view : View, State :State<T>?){
    if(State is State.Success){
        view.visibility= View.VISIBLE
    }else {view.visibility= View.GONE}

}
@BindingAdapter(value = ["app:showWhenError"])
fun <T> ShowWhenError(view : View, State :State<T>?) {
    if (State is State.Error) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

    @BindingAdapter(value = ["app:imageUrl"])
fun setImage(view : ImageView , url :String?){
    Glide.with(view).load("url").centerCrop().into(view)
}

@BindingAdapter(value = ["app:fuck"])
fun setRecycleItems(view :RecyclerView, items : List<Result>?){
    if(items != null){
        (view.adapter as MovieAdapter).setItem(items)
    }else{
        (view.adapter as MovieAdapter).setItem(emptyList())
    }
}

@BindingAdapter(value = ["app:fucke"])
fun setRecycleItemse(view :RecyclerView, items : List<ResultX>?){
    if(items != null){
        (view.adapter as PersonAdapter).setIteme(items)
    }else{
        (view.adapter as PersonAdapter).setIteme(emptyList())
    }
}