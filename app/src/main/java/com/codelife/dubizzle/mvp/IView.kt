package com.codelife.dubizzle.mvp

interface IView {

    fun showProgressDialog()

    fun dismissProgressDialog()

    fun showMessage(message: String)

}
