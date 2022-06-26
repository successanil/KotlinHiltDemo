package com.relsellglobal.kotlinhiltdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.relsellglobal.kotlinhiltdemo.repositories.network.BookListModel
import javax.inject.Inject
class DefaultFragmentFactory @Inject constructor(
    val bookListModel: BookListModel
) : FragmentFactory() {
    override fun instantiate(
        classLoader: ClassLoader,
        className: String): Fragment {

        return when (className) {
            ComposeDemoFrgment::class.java.name ->
                ComposeDemoFrgment(bookListModel)
            else -> super.instantiate(classLoader, className)
        }
    }

}