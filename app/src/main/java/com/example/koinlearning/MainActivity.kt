package com.example.koinlearning

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.compose.setContent
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity() : AppCompatActivity(), AndroidScopeComponent {

//    private val viewModel by viewModel<MainViewModel>()


    // activityRetainedScope() like viewmodel scope, it will keep hello string even when your activity rotates, survive, now it will be destroyed
    override val scope: Scope by activityScope()
    private val hello by inject<String>(named("bye"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(hello)
        setContent {
            val viewModel = getViewModel<MainViewModel>()
            viewModel.doNetworkCall()
        }
    }
}