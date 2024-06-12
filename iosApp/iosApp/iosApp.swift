import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    init() {
        InitKoinKt.doInitKoin { _ in }
    }

    var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea()
    }
}
