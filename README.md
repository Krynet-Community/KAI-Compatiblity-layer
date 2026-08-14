# 🧩 Krynet Compat

> **Unofficial community project**
>
> Krynet Compat is an independent, source-based Java compatibility layer for community-maintained Krynet ports, clients, integrations, experiments, and tooling.
>
> This project is **not affiliated with, endorsed by, maintained by, reviewed by, partnered with, or used by Krynet, LLC or the Krynet Team.**

---

## ⚠️ Important

This repository is **not an official Krynet repository**.

The name **"Krynet"** is used only to describe the software and ecosystem this community project is built around. Nothing in this repository should be interpreted as an official Krynet release, API, SDK, compatibility guarantee, statement, security recommendation, or endorsement.

Krynet Compat is maintained independently by **Krynet Community**.

> [!CAUTION]
> 🔐 **Different Security & Quality Practices**
>
> Krynet Community does **not** follow the same security practices, development processes, review standards, testing procedures, release processes, or quality practices as the official Krynet Team.
>
> Community software should **not** be assumed to have received the same security review, auditing, testing, or quality assurance as official Krynet software.

> [!WARNING]
> 🧪 **Review Source Before Importing**
>
> Compat is designed to be included directly in application source code and can provide access to networking, storage, filesystem, clipboard, graphics, and platform functionality.
>
> Review changes involving:
>
> * 🌐 Networking
> * 🔑 Authentication
> * 🔐 Cryptography
> * 💾 Storage
> * 📁 Filesystem access
> * 📱 Platform permissions
> * 📋 Clipboard access
> * 🔗 External URLs
> * ⚙️ Platform backends
>
> Do not blindly import or update community code in security-sensitive applications.

> [!IMPORTANT]
> 🧩 **Not Part of the Krynet UGC Program**
>
> Krynet Community is **not part of Krynet, LLC's UGC Program**.
>
> The official UGC Program allows creators to make content and extensions for Krynet, including:
>
> * 🧩 Plugins
> * 🎨 Themes
> * 🔌 Extensions
> * 🛠️ Other community content
> * 🛒 Store listings
>
> Depending on the official program's terms, creators may be able to list content for free or receive payment for eligible content.
>
> **Krynet Compat is not an official UGC Program project, submission, listing, or participant.**

> [!NOTE]
> 🤝 **Not a Krynet Partner**
>
> Krynet Community is **not a Krynet, LLC partner**.
>
> Nothing published under this organization should be interpreted as a partnership, sponsorship, endorsement, commercial relationship, or official collaboration unless explicitly confirmed by Krynet, LLC through an official channel.

---

## 🌍 About

Krynet Compat exists to give community developers a **shared Java compatibility layer** for building Krynet-related software across multiple platforms.

The basic idea:

```text
        👤 Community Client
                 │
                 ▼
          🧩 Krynet Compat
                 │
       ┌─────────┼─────────┐
       │         │         │
       ▼         ▼         ▼
    🖥️ Desktop  📱 Mobile  ⚙️ Platform
       │         │         │
   ┌───┼───┐   ┌─┴────┐    │
   ▼   ▼   ▼   ▼      ▼    ▼
  🪟  🐧  🍎  🤖     📱   APIs
 Win Linux macOS Android iOS
```

Compat provides common APIs for:

* 🪟 Application and window management
* 🎨 Graphics
* 🌐 Networking
* 💾 Storage
* 📁 Filesystem access
* 📋 Clipboard
* 🖱️ Events
* 📱 Platform detection
* ⚙️ Runtime options
* 🔌 Platform backends

---

## 🚫 What This Project Is Not

Krynet Compat is **not**:

* ❌ An official Krynet product
* ❌ An official Krynet SDK
* ❌ An official Krynet API
* ❌ An official Krynet client
* ❌ An official Krynet runtime
* ❌ An official Krynet compatibility guarantee
* ❌ A Krynet UGC Program project
* ❌ A Krynet Store submission
* ❌ A Krynet partner project
* ❌ A standalone application
* ❌ An executable
* ❌ A separate runtime
* ❌ A JAR distribution
* ❌ A package manager
* ❌ A server
* ❌ A replacement for Java

Krynet Compat is intended to be **included as Java source code inside the client using it**.

---

## 🔗 Official Krynet Resources

| Resource        | Purpose                                                            |
| --------------- | ------------------------------------------------------------------ |
| 🌐 **Website**  | [https://krynet.ai](https://krynet.ai)                             |
| 📦 **Codeberg** | [https://codeberg.org/Krynet-LLC](https://codeberg.org/Krynet-LLC) |
| 💻 **GitLab**   | [https://gitlab.com/Krynet-Team](https://gitlab.com/Krynet-Team)   |

> [!NOTE]
> These links point to **official Krynet resources**. Krynet Compat remains completely independent.

---

## 📦 Importing Compat

Krynet Compat is designed to be imported directly into a Java client.

### 📥 Clone the Repository

```bash
git clone https://github.com/Krynet-Community/krynet-compat.git
```

Then include the `compat/` source directory in your client.

### ☕ Import the API

```java
import community.krynet.compat.*;
```

Additional APIs:

```java
import community.krynet.compat.graphics.*;
import community.krynet.compat.network.*;
import community.krynet.compat.storage.*;
import community.krynet.compat.filesystem.*;
import community.krynet.compat.clipboard.*;
import community.krynet.compat.events.*;
```

### 🔗 Import Directly From GitHub

Individual source files can be retrieved from GitHub's raw source endpoint:

```text
https://raw.githubusercontent.com/<organization>/<repository>/main/compat/community/krynet/compat/Compat.java
```

For production clients, **vendor the complete Compat source tree** rather than downloading individual files at runtime.

> [!WARNING]
> Do not make your client depend on a mutable `main` branch in production.
>
> Pin Compat to a release or commit so that compatibility code cannot silently change underneath your client.

### 🏷️ Recommended Version Pinning

```text
v1.0.0
v1.1.0
v1.2.0
```

Or pin to a specific commit:

```text
<commit-sha>
```

---

## 📁 Folder Structure

```text
krynet-compat/
│
├── 📄 LICENSE
├── 📄 README.md
│
└── 🧩 compat/
    └── community/
        └── krynet/
            └── compat/
                │
                ├── ⚙️ Compat.java
                ├── 🔧 Krynet.java
                ├── 📱 Platform.java
                ├── 🖥️ Application.java
                ├── 🪟 Window.java
                │
                ├── 🎨 graphics/
                │   └── Graphics.java
                │
                ├── 🌐 network/
                │   └── Network.java
                │
                ├── 💾 storage/
                │   └── Storage.java
                │
                ├── 📁 filesystem/
                │   └── FileSystem.java
                │
                ├── 📋 clipboard/
                │   └── Clipboard.java
                │
                ├── 🖱️ events/
                │   └── Events.java
                │
                ├── 🔒 internal/
                │   ├── Backend.java
                │   ├── BackendRegistry.java
                │   ├── PlatformDetector.java
                │   └── RuntimeState.java
                │
                └── ⚙️ backend/
                    │
                    ├── 🪟 windows/
                    │   ├── WindowsBackend.java
                    │   ├── WindowsWindow.java
                    │   ├── WindowsGraphics.java
                    │   ├── WindowsNetwork.java
                    │   ├── WindowsStorage.java
                    │   └── WindowsClipboard.java
                    │
                    ├── 🐧 linux/
                    │   ├── LinuxBackend.java
                    │   ├── LinuxWindow.java
                    │   ├── LinuxGraphics.java
                    │   ├── LinuxNetwork.java
                    │   ├── LinuxStorage.java
                    │   └── LinuxClipboard.java
                    │
                    ├── 🍎 macos/
                    │   ├── MacOSBackend.java
                    │   ├── MacOSWindow.java
                    │   ├── MacOSGraphics.java
                    │   ├── MacOSNetwork.java
                    │   ├── MacOSStorage.java
                    │   └── MacOSClipboard.java
                    │
                    ├── 🤖 android/
                    │   ├── AndroidBackend.java
                    │   ├── AndroidWindow.java
                    │   ├── AndroidGraphics.java
                    │   ├── AndroidNetwork.java
                    │   ├── AndroidStorage.java
                    │   └── AndroidClipboard.java
                    │
                    └── 📱 ios/
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
                 👤 Krynet Community Client
                            │
                            ▼
                  🧩 community.krynet.compat
                            │
       ┌────────────────────┼────────────────────┐
       │                    │                    │
       ▼                    ▼                    ▼
   🎨 Graphics          🌐 Network          💾 Storage
       │                    │                    │
       └────────────────────┼────────────────────┘
                            │
                            ▼
                     ⚙️ Compat Backend
                            │
       ┌──────────┬────────┼────────┬──────────┐
       ▼          ▼        ▼        ▼          ▼
     🪟 Win     🐧 Linux  🍎 macOS 🤖 Android 📱 iOS
```

The client communicates with the **public Compat API**.

The platform backend provides the implementation for the current operating system.

Platform implementations are included within Compat itself.

---

## ☕ Java API

### ⚙️ Initialize

```java
import community.krynet.compat.*;

if (!Compat.initialize()) {
    return;
}
```

### 🔌 Use Platform-Neutral APIs

```java
Clipboard.setText("Hello");

String text = Clipboard.getText();

Network.get("https://krynet.ai");

Storage.set("username", "community-user");
```

### 🛑 Shutdown

```java
Compat.shutdown();
```

Compat should be initialized before its APIs are used and shut down when the client exits.

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

The active platform backend determines how the selected graphics mode is implemented.

---

## 🌐 Networking

```java
Network.get(
    "https://krynet.ai"
);
```

Applications should use secure networking where appropriate.

Compat does **not** bypass:

* 🔐 TLS
* 📜 Certificate validation
* 🛡️ OS networking restrictions
* 🔑 Application authentication
* 🚧 Platform permissions

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

Do not store the following in ordinary storage:

* 🔑 Passwords
* 🔐 Private keys
* 🎫 Authentication tokens
* 🪪 Session secrets
* 🔒 Other sensitive credentials

Use secure platform storage where available.

---

## 📋 Clipboard

```java
Clipboard.setText(
    "Hello from Krynet Community"
);

String value =
    Clipboard.getText();
```

Clipboard behavior may vary between platforms and may be restricted by the operating system.

---

## 🌍 Platform Support

| Platform   | Status      |
| ---------- | ----------- |
| 🪟 Windows | ✅ Supported |
| 🐧 Linux   | ✅ Supported |
| 🍎 macOS   | ✅ Supported |
| 🤖 Android | ✅ Supported |
| 📱 iOS     | ✅ Supported |

> [!WARNING]
> Platform support does **not** mean identical behavior.
>
> Operating systems can differ in APIs, permissions, filesystem access, graphics capabilities, networking behavior, lifecycle management, and security restrictions.

---

## 🔐 Security

Krynet Compat can expose functionality involving:

* 🌐 Networking
* 💾 Storage
* 📁 Filesystem access
* 📋 Clipboard
* 🎨 Graphics
* ⚙️ Platform APIs

Community clients should:

* 🔎 Review Compat source before updates
* 📌 Pin production versions
* 🔐 Use HTTPS/TLS
* 🚫 Never hard-code credentials
* 🔑 Use secure storage for secrets
* 📱 Request only necessary permissions
* 🛡️ Validate untrusted network input
* 📁 Validate filesystem paths
* 📋 Minimize clipboard access
* 🌐 Minimize unnecessary network requests
* 🔍 Review platform backend changes
* 📦 Review dependencies independently

### 🛡️ Compat Does Not Secure Your Client

Using Compat does **not** automatically make a client secure.

The client remains responsible for:

* 🔑 Authentication
* 🛂 Authorization
* 🔐 Encryption
* 🗝️ Key management
* 📜 Certificate validation
* 🛡️ Input validation
* 💾 Secure storage
* 🎫 Session management
* 🖥️ Server-side security

### ⚠️ Community Security Standards

Krynet Community projects **do not claim to meet the same security standards, review requirements, development controls, testing procedures, or quality practices as the official Krynet Team**.

Being hosted by Krynet Community does not mean that Krynet, LLC has reviewed, audited, approved, or endorsed the project.

---

## 🔄 API Stability

Compat aims to maintain a stable public API for community clients.

### 🌐 Public APIs

```text
community.krynet.compat
community.krynet.compat.graphics
community.krynet.compat.network
community.krynet.compat.storage
community.krynet.compat.filesystem
community.krynet.compat.clipboard
community.krynet.compat.events
```

### 🔒 Internal APIs

```text
community.krynet.compat.internal
community.krynet.compat.backend
```

Applications should avoid directly depending on internal or backend classes unless platform-specific behavior is intentionally required.

---

## 🚧 Experimental Features

Some APIs may be:

* 🧪 Experimental
* 🚧 Incomplete
* 🔄 Subject to change
* ⚠️ Platform-dependent
* 📉 Not production-ready

A feature being present in the source tree does **not** mean it is stable across every supported platform.

Experimental functionality should be clearly identified before being used in production clients.

---

## 🤝 Contributing

Contributions are welcome.

You can contribute by:

* 🐛 Reporting bugs
* 📋 Opening issues
* 🖥️ Reporting platform problems
* 📚 Improving documentation
* 🔀 Submitting pull requests
* ⚙️ Improving platform backends
* 🌍 Adding platform support
* 🔧 Improving API compatibility
* 🔐 Reviewing security-sensitive changes
* 🧪 Testing community clients

When adding platform-specific functionality, keep it inside the appropriate backend whenever possible.

Please keep contributions:

* 📖 Readable
* 🧩 Focused
* 📝 Documented
* 🔄 Compatible with the existing API

---

## 📜 License

Krynet Compat is a **Krynet Community project**.

See the [`LICENSE`](LICENSE) file for the terms that apply to this project.

---

## ⚠️ Final Disclaimer

Krynet Compat is an **independent community project**.

It does not represent the official Krynet project and should not be treated as:

* ❌ Official Krynet software
* ❌ An official Krynet SDK
* ❌ An official Krynet API
* ❌ An official Krynet client
* ❌ An official Krynet runtime
* ❌ A Krynet UGC Program project
* ❌ A Krynet Store submission
* ❌ A Krynet partner project
* ❌ An officially reviewed or endorsed project

Krynet Community does **not** claim to follow the same security, development, testing, review, or quality practices as the official Krynet Team.

Use community software at your own discretion. Review the source code, permissions, dependencies, network behavior, and platform integrations before incorporating Compat into software that handles sensitive information.

---

<p align="center">
  🧩 <strong>Krynet Compat</strong> · Community Java Compatibility Layer
</p>

<p align="center">
  🛠️ Community Maintained · 🌍 Cross-Platform · ☕ Java Source
</p>

<p align="center">
  <strong>Not Official Krynet Software · Not a Krynet Partner · Not Part of the Krynet UGC Program</strong>
</p>
