package tech.droi.probe3

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComp {
    fun inject(activity: MainActivity)
    val computer: Computer
    val axe: Axe
//    val model: SharedViewModel
}
