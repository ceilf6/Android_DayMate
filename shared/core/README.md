# Shared Core Module

这是 DayMate Monorepo 的共享核心模块，包含跨平台的业务逻辑和数据模型。

## 模块职责

- **数据模型**：定义日历事件、提醒、农历等核心数据结构
- **业务逻辑**：日期计算、事件管理、重复规则处理
- **数据访问接口**：定义 Repository 接口，供各平台实现
- **工具类**：日期工具、农历转换、ICS 解析等

## 目录结构

```
shared/core/
├── src/main/java/com/example/daymate/shared/core/
│   ├── models/          # 数据模型
│   ├── repository/      # 数据访问接口
│   ├── utils/           # 工具类
│   └── domain/          # 业务逻辑（用例）
```

## 使用方式

在 Android 应用中引用：
```kotlin
dependencies {
    implementation(project(":shared:core"))
}
```

在 React Native 中通过桥接调用核心逻辑。
