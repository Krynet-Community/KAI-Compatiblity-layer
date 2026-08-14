# Krynet Compat

> **Unofficial community project**
>
> Krynet Compat is an independent, source-based Java compatibility layer for community-maintained Krynet ports, clients, integrations, experiments, and tooling.
>
> This project is **not affiliated with, endorsed by, maintained by, reviewed by, or used by Krynet, LLC or the Krynet Team.**

---

## ⚠️ Important

This repository is **not an official Krynet repository**.

The name "Krynet" is used only to describe the software and ecosystem this community project is built around. Nothing in this repository should be interpreted as an official Krynet release, API, SDK, compatibility guarantee, statement, or endorsement.

Krynet Compat is a **community-maintained project**. Its APIs, implementations, platform support, and compatibility behavior are determined by the community maintainers.

### ⚠️ Not Official Krynet Software

Krynet Compat does **not** represent:

* An official Krynet SDK
* An official Krynet API
* An official Krynet client
* An official Krynet runtime
* An official Krynet compatibility guarantee
* An official Krynet-supported development environment

For official Krynet software, documentation, and source code, use the official resources below.

### ⚠️ Review Source Before Importing

Krynet Compat is designed to be included directly in application source code.

**Do not blindly copy or update compatibility-layer code in security-sensitive applications.**

Review changes involving:

* Networking
* Authentication
* Cryptography
* Storage
* Filesystem access
* Platform permissions
* Clipboard access
* External URLs
* Platform backends

Compat can expose functionality that affects the security and privacy of the client using it.

### ⚠️ Platform Differences

Windows, Linux, macOS, Android, and iOS have different APIs, permissions, filesystem models, graphics systems, and security restrictions.

Compat provides a common API, but it does **not** make operating systems identical.

Applications should account for platform capabilities and restrictions when required.

---

## 🔗 Official Krynet Resources

| Resource                 | Link                                                               |
| ------------------------ | ------------------------------------------------------------------ |
| 🌐 Website               | [https://krynet.ai](https://krynet.ai)                             |
| 📦 Codeberg Organization | [https://codeberg.org/Krynet-LLC](https://codeberg.org/Krynet-LLC) |
| 💻 GitLab Organization   | [https://gitlab.com/Krynet-Team](https://gitlab.com/Krynet-Team)   |

> [!NOTE]
> The repositories in this organization are **community-maintained** and separate from the official Krynet project.

---

## 🧩 What This Project Is

Krynet Compat provides a common Java API for community-built Krynet software.

The goal is:

```text
Community Client
       │
       ▼
Krynet Compat
       │
       ├── Windows
       ├── Linux
       ├── macOS
       ├── Android
       └── iOS
```

Instead of every community client implementing its own platform handling, it can use the Compat API.

Compat provides common APIs for:

* 🪟 Application and window management
* 🎨 Graphics
* 🌐 Networking
* 💾 Storage
* 📁 Filesystem access
* 📋 Clipboard
* 🖱️ Events
* ⚙️ Platform detection
* 🔧 Krynet runtime options

---

## 🚫 What This Project Is Not

Krynet Compat is **not**:

* An official Krynet product
* A standalone application
* An executable
* A separate runtime
* A JAR distribution
* A package manager
* A server
* A replacement for the Java runtime

Krynet Compat is intended to be **included as Java source code inside the client using it**.

---

## 📦 Importing Compat Into Your Client

Krynet Compat is designed to be imported directly from its GitHub repository.

### Clone the Repository

```bash
git clone https://github.com/Krynet-Community/krynet-compat.git
```

Then include the `compat/` directory in your client source tree.

> [!NOTE]
> If the repository is hosted under a different GitHub organization or repository name, use the actual repository URL.

### Import the Java Source

The Compat source tree can be included directly in a client:

```text
your-krynet-client/
│
├── src/
│
└── compat/
    └── community/
        └── krynet/
            └── compat/
                ├── Compat.java
                ├── Krynet.java
                ├── Platform.java
                └── ...
```

Then import the API:

```java
import community.krynet.compat.*;
```

Additional APIs can be imported from their respective packages:

```java
import community.krynet.compat.graphics.*;
import community.krynet.compat.network.*;
import community.krynet.compat.storage.*;
import community.krynet.compat.filesystem.*;
import community.krynet.compat.clipboard.*;
import community.krynet.compat.events.*;
```

### Raw GitHub Source

Individual Java files can also be retrieved directly from GitHub's raw content endpoint:

```text
https://raw.githubusercontent.com/<organization>/<repository>/main/compat/community/krynet/compat/Compat.java
```

For production clients, **including the complete Compat source tree is recommended** rather than downloading individual files.

### Pin Your Version

Do not blindly track `main` in production.

Prefer a tagged version:

```text
v1.0.0
v1.1.0
v1.2.0
```

or a specific commit.

This prevents a client from silently changing compatibility code when the repository is updated.

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
                ├── Platform.java
                ├── Application.java
                ├── Window.java
                │
                ├── graphics/
                │   └── Graphics.java
                │
                ├── network/
                │   └── Network.java
                │
                ├── storage/
                │   └── Storage.java
                │
                ├── filesystem/
                │   └── FileSystem.java
                │
                ├── clipboard/
                │   └── Clipboard.java
                │
                ├── events/
                │   └── Events.java
                │
                ├── internal/
                │   ├── Backend.java
                │   ├── BackendRegistry.java
                │   ├── PlatformDetector.java
                │   └── RuntimeState.java
                │
                └── backend/
                    │
                    ├── windows/
                    │   ├── WindowsBackend.java
                    │   ├── WindowsWindow.java
                    │   ├── WindowsGraphics.java
                    │   ├── WindowsNetwork.java
                    │   ├── WindowsStorage.java
                    │   └── WindowsClipboard.java
                    │
                    ├── linux/
                    │   ├── LinuxBackend.java
                    │   ├── LinuxWindow.java
                    │   ├── LinuxGraphics.java
                    │   ├── LinuxNetwork.java
                    │   ├── LinuxStorage.java
                    │   └── LinuxClipboard.java
                    │
                    ├── macos/
                    │   ├── MacOSBackend.java
                    │   ├── MacOSWindow.java
                    │   ├── MacOSGraphics.java
                    │   ├── MacOSNetwork.java
                    │   ├── MacOSStorage.java
                    │   └── MacOSClipboard.java
                    │
                    ├── android/
                    │   ├── AndroidBackend.java
                    │   ├── AndroidWindow.java
                    │   ├── AndroidGraphics.java
                    │   ├── AndroidNetwork.java
                    │   ├── AndroidStorage.java
                    │   └── AndroidClipboard.java
                    │
                    └── ios/
                        ├── IOSBackend.java
                        ├── IOSWindow.java
                        ├── IOSGraphics.java
                        ├── IOSNetwork.java
                        ├── IOSStorage.java
                        └── IOSClipboard.java
```

---

## 🏗️ Architecture

```text
                  Krynet Community Client
                            │
                            ▼
                 community.krynet.compat
                            │
        ┌───────────────────┼───────────────────┐
        │                   │                   │
        ▼                   ▼                   ▼
     Graphics            Network             Storage
        │                   │                   │
        └───────────────────┼───────────────────┘
                            │
                            ▼
                     Compat Backend
                            │
        ┌──────────┬────────┼────────┬──────────┐
        ▼          ▼        ▼        ▼          ▼
     Windows    Linux     macOS   Android     iOS
```

The application interacts with the public Compat API.

The backend handles platform-specific implementation details.

---

## ☕ Java API

Initialize Compat:

```java
import community.krynet.compat.*;

if (!Compat.initialize()) {
    return;
}
```

Use platform-neutral APIs:

```java
Clipboard.setText("Hello");

String text = Clipboard.getText();

Network.get("https://krynet.ai");

Storage.set("username", "community-user");
```

Shut down Compat when the client exits:

```java
Compat.shutdown();
```

---

## 🪟 Window

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

---

## 🎨 Graphics

```java
Krynet.setOption(
    Krynet.SET_GFX_LAYER,
    Krynet.GFX_AUTO
);
```

Available modes:

```java
Krynet.GFX_SOFTWARE
Krynet.GFX_HARDWARE
Krynet.GFX_AUTO
```

The platform backend determines how the selected mode is implemented.

---

## 🌐 Networking

```java
Network.get(
    "https://krynet.ai"
);
```

Applications should use secure networking where appropriate.

Compat does not bypass TLS, certificate validation, operating-system networking restrictions, or application-level authentication.

---

## 💾 Storage

```java
Storage.set(
    "username",
    "community-user"
);

String username =
    Storage.get("username");
```

Do not use ordinary storage for passwords, private keys, tokens, or other sensitive secrets.

Use secure storage where supported.

---

## 📋 Clipboard

```java
Clipboard.setText(
    "Hello from Krynet Community"
);

String value =
    Clipboard.getText();
```

Clipboard behavior can vary between platforms and may be restricted by the operating system.

---

## 🌍 Supported Platforms

| Platform   | Status    |
| ---------- | --------- |
| 🪟 Windows | Supported |
| 🐧 Linux   | Supported |
| 🍎 macOS   | Supported |
| 🤖 Android | Supported |
| 📱 iOS     | Supported |

> [!WARNING]
> Supported platforms do not necessarily provide identical functionality. Platform-specific limitations may apply.

---

## 🔐 Security

Krynet Compat can provide access to networking, storage, filesystem, clipboard, graphics, and other platform functionality.

Community clients should:

* Review Compat source before incorporating updates
* Pin Compat versions for production builds
* Use HTTPS/TLS for network communication
* Never hard-code private credentials
* Avoid storing secrets in ordinary storage
* Request only required platform permissions
* Validate untrusted network input
* Validate filesystem paths
* Avoid unnecessary clipboard access
* Avoid unnecessary network requests
* Review platform backend changes carefully

### Compat Does Not Automatically Secure Your Client

Using Compat does **not** automatically make an application secure.

The client remains responsible for:

* Authentication
* Authorization
* Encryption
* Key management
* Certificate validation
* Input validation
* Secure storage
* Session management
* Server-side security

---

## 🔄 API Stability

Compat aims to maintain a stable public API for community clients.

Public APIs are primarily located under:

```text
community.krynet.compat
community.krynet.compat.graphics
community.krynet.compat.network
community.krynet.compat.storage
community.krynet.compat.filesystem
community.krynet.compat.clipboard
community.krynet.compat.events
```

The following are implementation details:

```text
community.krynet.compat.internal
community.krynet.compat.backend
```

Community clients should avoid depending directly on internal or backend classes unless platform-specific behavior is intentionally required.

---

## 🚧 Experimental Features

Some APIs may be experimental, incomplete, or subject to change.

A feature being present in the source tree does not necessarily mean it is stable across every supported platform.

Experimental functionality should be clearly documented before being used in production clients.

---

## 🤝 Contributing

Contributions are welcome.

You can contribute by:

* Opening issues
* Reporting bugs
* Reporting platform compatibility problems
* Improving documentation
* Submitting pull requests
* Improving platform backends
* Adding platform support
* Improving API compatibility
* Reviewing security-sensitive changes
* Testing community clients

When adding platform-specific functionality, keep it inside the appropriate backend whenever possible.

Please keep contributions focused, readable, documented, and compatible with the existing API.

---

## 📜 License

Krynet Compat is a **Krynet Community project**.

See the `LICENSE` file for the terms that apply to this project.

---

## ⚠️ Final Disclaimer

Krynet Compat is an **independent community project**.

It does not represent the official Krynet project and should not be treated as an official Krynet SDK, API, client, runtime, or compatibility guarantee.

Use community software at your own discretion and review source code before incorporating it into applications that handle sensitive data.

---

### Community Project · Not Official Krynet Software

**Krynet Compat is maintained independently by the community.**
