# DayMate Monorepo 架构文档

## 📁 目录结构

```
DayMate/
├── apps/                          # 应用层
│   ├── android-calendar/         # Android 原生日历应用
│   │   ├── src/
│   │   └── build.gradle.kts
│   └── rn-calendar/              # React Native 跨平台应用
│       ├── src/
│       ├── android/
│       ├── ios/
│       └── package.json
│
├── shared/                        # 共享模块
│   ├── core/                     # 核心业务逻辑（Android Library）
│   │   ├── models/               # 数据模型
│   │   ├── repository/           # 数据访问接口
│   │   ├── utils/                # 工具类
│   │   └── build.gradle.kts
│   └── ui-android/               # Android UI 组件库
│       ├── components/           # 可复用组件
│       └── build.gradle.kts
│
├── docs/                         # 文档
│   ├── architecture.md           # 架构说明
│   ├── development-guide.md      # 开发指南
│   └── migration-guide.md        # 迁移指南
│
├── .github/
│   └── workflows/                # CI/CD 配置
│       ├── android.yml
│       └── rn.yml
│
├── build.gradle.kts              # 根项目构建配置
├── settings.gradle.kts           # Gradle 多项目配置
├── gradle.properties             # Gradle 属性
└── README.md                     # 项目说明
```

## 🏗️ 架构设计

### 设计原则

1. **关注点分离**：应用层与共享逻辑分离
2. **代码复用**：核心业务逻辑在 `shared/core` 中统一管理
3. **平台特定**：UI 层根据平台特性独立实现
4. **渐进迁移**：支持逐步将代码迁移到共享模块

### 模块依赖关系

```
apps/android-calendar
    ↓
shared/ui-android → shared/core
    ↑
apps/rn-calendar/android (可选)
```

## 📦 模块说明

### shared/core

**职责**：提供跨平台的核心业务逻辑

- 数据模型定义（CalendarEvent, LunarDate 等）
- 日期计算工具（DateUtils）
- Repository 接口定义
- 业务规则（重复事件、提醒逻辑等）

**技术栈**：Kotlin, Room, Coroutines

### shared/ui-android

**职责**：提供 Android 平台的可复用 UI 组件

- 日历视图组件
- 事件编辑器
- 通用适配器
- 主题和样式

**技术栈**：Kotlin, ViewBinding, Material Design

### apps/android-calendar

**职责**：Android 原生应用的具体实现

- Activity / Fragment
- ViewModel
- 依赖注入配置
- 应用特定的业务逻辑

**依赖**：`shared:core`, `shared:ui-android`

### apps/rn-calendar

**职责**：React Native 跨平台应用

- React 组件
- JavaScript 业务逻辑
- Native Module 桥接（可选）

**技术栈**：React Native, TypeScript, React Navigation

## 🔄 数据流

### Android 应用数据流

```
UI (Activity/Fragment)
    ↓
ViewModel
    ↓
Repository (from shared:core)
    ↓
Room Database (from shared:core)
```

### React Native 数据流

```
React Component
    ↓
Service Layer (JS)
    ↓
AsyncStorage / SQLite
    ↓
(可选) Native Module → shared:core
```

## 🚀 开发工作流

### 构建 Android 应用

```bash
./gradlew :apps:android-calendar:assembleDebug
```

### 运行 React Native

```bash
cd apps/rn-calendar
npm install
npm run android  # 或 npm run ios
```

### 同时开发多个应用

```bash
# Terminal 1: Android
./gradlew :apps:android-calendar:installDebug

# Terminal 2: React Native
cd apps/rn-calendar && npm start
```

## 🧪 测试策略

### 单元测试

- **shared/core**: 测试业务逻辑和工具类
- **apps/**: 测试 ViewModel 和 UI 逻辑

### 集成测试

- 测试 Repository 与数据库的交互
- 测试跨模块的依赖关系

### E2E 测试

- Android: Espresso
- React Native: Detox

## 📝 代码规范

### Kotlin

- 遵循 [Kotlin 官方风格指南](https://kotlinlang.org/docs/coding-conventions.html)
- 使用 ktlint 进行代码格式化

### TypeScript

- 遵循 Airbnb JavaScript 风格指南
- 使用 ESLint + Prettier

## 🔧 常见问题

### Q: 如何在 React Native 中使用共享的 Android 代码？

A: 有两种方案：
1. 在 RN 中重新实现业务逻辑（推荐，保持跨平台纯粹性）
2. 通过 Native Module 桥接调用 shared:core（适合复杂计算）

### Q: shared/core 可以用于 iOS 吗？

A: 当前 shared/core 是 Android Library，如需支持 iOS，建议：
1. 使用 Kotlin Multiplatform Mobile (KMM)
2. 或在 React Native 层重新实现

### Q: 如何管理不同应用的版本号？

A: 每个应用在自己的 build.gradle.kts / package.json 中独立管理版本号。

## 🎯 未来规划

- [ ] 迁移更多核心逻辑到 shared/core
- [ ] 探索 Kotlin Multiplatform 支持 iOS
- [ ] 完善 CI/CD 流程
- [ ] 建立组件文档站点
- [ ] 性能优化和监控

## 📚 参考资料

- [Gradle Multi-Project Builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)
- [React Native Native Modules](https://reactnative.dev/docs/native-modules-intro)
- [Android Architecture Components](https://developer.android.com/topic/architecture)
