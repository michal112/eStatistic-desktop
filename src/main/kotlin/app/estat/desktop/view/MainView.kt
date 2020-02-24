package app.estat.desktop.view

import app.estat.desktop.view.dashboard.DashboardView
import tornadofx.*

class MainView : View() {

    val dashboardView: DashboardView by inject()
    val headerView: HeaderView by inject()

    override val root = borderpane {
        top = headerView.root
        center = dashboardView.root
    }
}
