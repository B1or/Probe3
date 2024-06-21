package tech.droi.probe3

import android.app.Application

class MainApp: Application() {
    val appComp = DaggerAppComp.create()
    val axe = Axe()
}
