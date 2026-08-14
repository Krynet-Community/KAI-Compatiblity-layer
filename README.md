# Krynet Compat

> **Unofficial community project**
>
> Krynet Compat is an independent Java compatibility layer for community-maintained Krynet ports, clients, integrations, and experiments.
>
> This project is **not affiliated with, endorsed by, maintained by, reviewed by, or used by Krynet, LLC or the Krynet Team.**

---

## ⚠️ Important

This repository is **not an official Krynet repository**.

The name "Krynet" is used only to describe the software and ecosystem this community project is built around. Nothing in this repository should be interpreted as an official Krynet release, statement, or endorsement.

Krynet Compat is specifically intended for **Krynet Community** projects and independent developers who want a common Java API across supported platforms.

For official Krynet software, documentation, and source code, use the resources below.

## 🔗 Official Krynet Resources

| Resource                 | Link                            |
| ------------------------ | ------------------------------- |
| 🌐 Website               | https://krynet.ai               |
| 📦 Codeberg Organization | https://codeberg.org/Krynet-LLC |
| 💻 GitLab Organization   | https://gitlab.com/Krynet-Team  |

> [!NOTE]
> Krynet Compat is a **community-maintained compatibility layer** and is separate from the official Krynet project.

---

## 🧩 What This Project Is

Krynet Compat provides a common Java API that community Krynet clients can import directly into their source code.

The goal is to let a community client use the same compatibility API across:

* Windows
* Linux
* macOS
* Android
* iOS

Compat provides common interfaces for functionality such as:

* 🪟 Windows and application lifecycle
* 🎨 Graphics
* 🌐 Networking
* 💾 Storage
* 📁 Filesystem access
* 📋 Clipboard
* 🖱️ Events
* ⚙️ Platform detection
* 🔧 Krynet runtime options

Platform-specific implementations are kept behind the Compat API so community clients do not need to duplicate their application logic for every operating system.

---

## 📁 Folder Structure

```text
krynet-compat/
│
├── LICENSE
├── README.md
│
└── compat/
    └── community/
        └── krynet/
            └── compat/
                │
                ├── Compat.java
                ├── Krynet.java
                ├── Window.java
                ├── Application.java
                ├── Platform.java
                ├── Graphics.java
                ├── Network.java
                ├── Storage.java
                ├── FileSystem.java
                ├── Clipboard.java
                ├── Events.java
                │
                ├── graphics/
                │   ├── Graphics.java
                │   ├── Renderer.java
                │   ├── Surface.java
                │   └── Image.java
                │
                ├── network/
                │   ├── Network.java
                │   ├── Socket.java
                │   ├── Http.java
                │   └── WebSocket.java
                │
                ├── storage/
                │   ├── Storage.java
                │   └── SecureStorage.java
                │
                ├── filesystem/
                │   ├── FileSystem.java
                │   ├── File.java
                │   └── Directory.java
                │
                ├── events/
                │   ├── Events.java
                │   ├── Event.java
                │   ├── KeyboardEvent.java
                │   ├── MouseEvent.java
                │   └── WindowEvent.java
                │
                └── platform/
                    ├── PlatformBackend.java
                    ├── WindowBackend.java
                    ├── GraphicsBackend.java
                    ├── NetworkBackend.java
                    ├── StorageBackend.java
                    ├── Windows.java
                    ├── Linux.java
                    ├── MacOS.java
                    ├── Android.java
                    └── IOS.java
```

> [!NOTE]
> The `compat/` directory is designed to be imported directly into a community client. Krynet Compat does not require the client to depend on a separate executable or runtime.

---

## 💻 Basic Usage

A community client can import Compat directly:

```java
import community.krynet.compat.*;
```

A basic Krynet-style application can then look like:

```java
import community.krynet.compat.*;

public class KrynetApp extends Window {

    public KrynetApp() {
        super(
            TITLEBAR |
            RESIZABLE |
            CONTROLS |
            MAIN
        );
    }

    public boolean init() {

        if (!Krynet.setOption(
            Krynet.SET_GFX_LAYER,
            Krynet.GFX_SOFTWARE
        )) {
            return false;
        }

        if (!Krynet.setOption(
            Krynet.SET_SCRIPT_RUNTIME_FEATURES,
            Krynet.ALLOW_SOCKET_IO
        )) {
            return false;
        }

        if (!loadUrl("https://krynet.ai")) {
            return false;
        }

        expand();

        return true;
    }

    public static void main(String[] args) {

        if (!Compat.initialize()) {
            return;
        }

        KrynetApp app = new KrynetApp();

        if (!app.init()) {
            Compat.shutdown();
            return;
        }

        app.runApp();

        Compat.shutdown();
    }
}
```

The same Compat-facing code can be used as the basis for community clients targeting different supported platforms.

---

## 🌍 Supported Platforms

| Platform   | Compat Support |
| ---------- | -------------- |
| 🪟 Windows | Supported      |
| 🐧 Linux   | Supported      |
| 🍎 macOS   | Supported      |
| 🤖 Android | Supported      |
| 📱 iOS     | Supported      |

Platform-specific functionality is implemented under:

```text
compat/community/krynet/compat/platform/
```

The public API remains platform-neutral.

---

## 🔧 Compatibility API

### Window

```java
Window window = new Window(
    Window.TITLEBAR |
    Window.RESIZABLE |
    Window.CONTROLS
);

window.loadUrl("https://krynet.ai");
window.expand();
window.runApp();
```

### Graphics

```java
Krynet.setOption(
    Krynet.SET_GFX_LAYER,
    Krynet.GFX_AUTO
);
```

Available graphics modes include:

```java
Krynet.GFX_SOFTWARE
Krynet.GFX_HARDWARE
Krynet.GFX_AUTO
```

### Networking

```java
Network.get(
    "https://krynet.ai"
);
```

### Storage

```java
Storage.set(
    "username",
    "community-user"
);

String username =
    Storage.get("username");
```

### Clipboard

```java
Clipboard.setText(
    "Hello from Krynet Community"
);

String text =
    Clipboard.getText();
```

These APIs are designed to avoid requiring the application itself to directly use platform-specific APIs.

---

## 🏗️ Architecture

```text
                 Community Krynet Client
                           │
                           ▼
                community.krynet.compat
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
       Window          Network          Storage
          │                │                │
          └────────────────┼────────────────┘
                           │
                           ▼
                   Platform Backend
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
        ▼                  ▼                  ▼
     Windows            Linux              macOS
        │                  │                  │
        └──────────────────┼──────────────────┘
                           │
                    Android / iOS
```

The public Compat API should remain independent from platform implementation details.

Platform-specific code belongs in the appropriate backend.

---

## 📦 Installation

Krynet Compat is intended to be imported as **source code**.

Copy or include the `compat/` directory in the community client project:

```text
your-krynet-client/
│
├── src/
│
└── compat/
    └── community/
        └── krynet/
            └── compat/
```

Then import the API:

```java
import community.krynet.compat.*;
```

No separate Compat executable is required.

No separate Compat runtime is required.

No JAR is required.

---

## 🔒 Security

Krynet Compat is intended for community software that may handle private or sensitive communications.

Implementations should:

* Avoid unnecessary telemetry
* Avoid hidden network communication
* Use secure networking where appropriate
* Avoid unnecessary permissions
* Keep platform-specific storage behavior explicit
* Avoid silently collecting application or user data
* Document security-sensitive behavior

Compat itself should not introduce advertising, analytics, tracking, or unrelated network requests.

> [!WARNING]
> Compat provides compatibility APIs. It does not automatically make an application secure. Community clients remain responsible for their own authentication, encryption, networking, storage, and application security.

---

## 🤝 Contributing

Contributions are welcome.

You can contribute by:

* Opening issues
* Reporting compatibility problems
* Improving documentation
* Submitting pull requests
* Improving platform backends
* Adding support for additional platforms
* Improving API compatibility
* Testing community clients

Please keep contributions focused, readable, documented, and compatible with the existing API.

---

## 📜 License

Krynet Compat is a **Krynet Community project**.

See the `LICENSE` file for the terms that apply to this project.

---

### Community Project · Not Official Krynet Software

**Krynet Compat is maintained independently by the community.**
