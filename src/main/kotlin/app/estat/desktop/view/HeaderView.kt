package app.estat.desktop.view

import app.estat.desktop.app.MyStyles
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class HeaderView : View() {
    companion object {
        const val PHOTO_PATH = "/farm_photo.jpg"
    }

    override val root = stackpane {
        addClass(MyStyles.header)
        alignment = Pos.BOTTOM_CENTER
        vbox {
            imageview(PHOTO_PATH) {
                addClass(MyStyles.headerImage)
            }
            rectangle {
                fill = AppColor.MAIN.color
                width = 512.0
                height = 45.0
            }
        }
        stackpane {
            addClass(MyStyles.headerCircle)
            circle {
                fill = AppColor.MAIN.color
                radius = 42.5
                alignment = Pos.CENTER
            }
            circle {
                fill = Color.WHITE
                radius = 32.5
                alignment = Pos.CENTER
            }
        }
    }
}
