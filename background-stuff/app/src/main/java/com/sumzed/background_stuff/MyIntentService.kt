package com.sumzed.background_stuff

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

private const val ACTION_FOO = "com.sumzed.background_stuff.action.FOO"
private const val ACTION_BAZ = "com.sumzed.background_stuff.action.BAZ"

private const val EXTRA_PARAM1 = "com.sumzed.background_stuff.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.sumzed.background_stuff.extra.PARAM2"
private const val TAG = "MyIntentService"

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionFoo(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionBaz(param1, param2)
            }
        }
    }

    private fun handleActionFoo(param1: String?, param2: String?) {
        Log.i(TAG, "handleActionFoo: $param1, $param2")
    }

    private fun handleActionBaz(param1: String?, param2: String?) {
        TODO("Handle action Baz")
    }

    companion object {
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}