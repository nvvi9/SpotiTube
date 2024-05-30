import androidx.compose.ui.window.ComposeUIViewController
import com.nvvi9.spotitube.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
