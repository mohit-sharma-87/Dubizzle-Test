package com.codelife.dubizzle.mvp


interface IPresenter<V : IView> {

    fun start(view: V)

    fun stop()

}
