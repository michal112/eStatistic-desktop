package app.estat.desktop.view

import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class HeaderView : View() {
    companion object {
        const val PHOTO_PATH = "/farm_photo.jpg"
    }

    override val root = stackpane {
        alignment = Pos.BOTTOM_CENTER
        vbox {
            imageview(PHOTO_PATH)
            rectangle {
                fill = Color.color(0.0082352941, 0.396078431, 0.752941176)
                width = 512.0
                height = 45.0
            }
        }
        stackpane {
            maxWidth = 42.5
            maxHeight = 42.5
            circle {
                fill = Color.color(0.0082352941, 0.396078431, 0.752941176)
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
