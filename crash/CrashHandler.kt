package example.com.kotlin.crash

import android.app.Application
import android.util.Log

/**
 * 捕捉应用程序异常
 */
object CrashHandler : Thread.UncaughtExceptionHandler {


    private var mApplication: Application? = null

    override fun uncaughtException(t: Thread?, e: Throwable?) {
        val result = CrashInfo.getAll(mApplication)
        Log.d("CrashHandler", "uncaughtException-->result$result")
    }

    fun init(application: Application) {
        mApplication = application
        Thread.setDefaultUncaughtExceptionHandler(this)
        CrashInfo.track(application)
    }
}