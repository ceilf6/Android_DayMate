# DayMate Monorepo 项目结构

```
DayMate/
│
├── apps/                                 # 应用层
│   ├── android-calendar/                # Android 原生日历应用
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/example/daymate/
│   │   │   │   │   ├── ui/             # UI 层（Activity, Fragment）
│   │   │   │   │   ├── viewmodel/      # ViewModel 层
│   │   │   │   │   ├── data/           # 数据层实现
│   │   │   │   │   └── di/             # 依赖注入
│   │   │   │   ├── res/                # 资源文件
│   │   │   │   └── AndroidManifest.xml
│   │   │   ├── test/                   # 单元测试
│   │   │   └── androidTest/            # 仪器测试
│   │   ├── build.gradle.kts
│   │   ├── proguard-rules.pro
│   │   └── lint-baseline.xml
│   │
│   └── rn-calendar/                     # React Native 跨平台应用
│       ├── src/
│       │   ├── screens/                # 屏幕组件
│       │   ├── components/             # UI 组件
│       │   ├── services/               # 业务服务
│       │   ├── models/                 # 数据模型（TS）
│       │   ├── utils/                  # 工具函数
│       │   └── native/                 # Native Module 桥接
│       ├── android/                    # Android 原生部分
│       │   ├── app/
│       │   │   ├── src/main/
│       │   │   └── build.gradle
│       │   ├── build.gradle
│       │   └── settings.gradle
│       ├── ios/                        # iOS 原生部分
│       │   ├── DayMate/
│       │   ├── DayMate.xcodeproj/
│       │   └── Podfile
│       ├── package.json
│       ├── tsconfig.json
│       ├── metro.config.js
│       ├── App.tsx
│       └── index.js
│
├── shared/                              # 共享模块
│   ├── core/                           # 核心业务逻辑（Android Library）
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   └── java/com/example/daymate/shared/core/
│   │   │   │       ├── models/         # 数据模型
│   │   │   │       │   └── CalendarModels.kt
│   │   │   │       ├── repository/     # Repository 接口
│   │   │   │       │   └── CalendarRepository.kt
│   │   │   │       ├── utils/          # 工具类
│   │   │   │       │   ├── DateUtils.kt
│   │   │   │       │   └── LunarCalendarUtils.kt
│   │   │   │       └── domain/         # 业务用例
│   │   │   │           └── CreateEventUseCase.kt
│   │   │   └── test/                   # 单元测试
│   │   ├── build.gradle.kts
│   │   ├── proguard-rules.pro
│   │   └── README.md
│   │
│   └── ui-android/                     # Android UI 组件库
│       ├── src/
│       │   └── main/
│       │       ├── java/com/example/daymate/shared/ui/
│       │       │   ├── components/     # 可复用组件
│       │       │   │   ├── CalendarMonthView.kt
│       │       │   │   ├── CalendarWeekView.kt
│       │       │   │   └── EventCardView.kt
│       │       │   ├── adapters/       # Adapter
│       │       │   └── utils/          # UI 工具
│       │       └── res/                # UI 资源
│       │           ├── layout/
│       │           ├── values/
│       │           └── drawable/
│       ├── build.gradle.kts
│       └── proguard-rules.pro
│
├── docs/                                # 文档
│   ├── ARCHITECTURE.md                 # 架构文档
│   ├── DEVELOPMENT.md                  # 开发指南
│   ├── MIGRATION.md                    # 迁移指南
│   └── PROJECT_STRUCTURE.md            # 本文件
│
├── .github/                            # GitHub 配置
│   └── workflows/                      # CI/CD
│       ├── android.yml                 # Android CI
│       └── rn.yml                      # React Native CI
│
├── gradle/                             # Gradle 配置
│   ├── libs.versions.toml              # 版本目录
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
│
├── build.gradle.kts                    # 根项目构建配置
├── settings.gradle.kts                 # Gradle 多项目配置
├── gradle.properties                   # Gradle 属性
├── gradlew                             # Gradle Wrapper (Unix)
├── gradlew.bat                         # Gradle Wrapper (Windows)
├── .gitignore                          # Git 忽略文件
└── README.md                           # 项目说明
```

## 模块说明

### apps/android-calendar
Android 原生应用的入口，包含所有应用特定的代码。

**关键依赖**:
- `shared:core` - 核心业务逻辑
- `shared:ui-android` - UI 组件库

### apps/rn-calendar
React Native 跨平台应用，支持 iOS 和 Android。

**特点**:
- 独立的 Node.js 项目
- 可选择通过 Native Module 调用 `shared:core`
- 或完全独立实现业务逻辑

### shared/core
跨平台的核心业务逻辑，使用 Kotlin 实现。

**包含**:
- 数据模型（Data Classes）
- Repository 接口定义
- 日期和农历计算工具
- 业务规则和用例

**不包含**:
- UI 代码
- Android 特定的实现（如 Activity, Fragment）
- 平台特定的 API 调用

### shared/ui-android
Android 平台的可复用 UI 组件。

**包含**:
- 自定义 View
- RecyclerView Adapter
- 通用的 Fragment
- UI 相关的工具类

**依赖**: `shared:core`

## 文件命名约定

### Kotlin
- 类文件: `PascalCase.kt` (如 `CalendarEvent.kt`)
- 接口: `PascalCase.kt` (如 `CalendarRepository.kt`)
- 工具类: `PascalCaseUtils.kt` (如 `DateUtils.kt`)

### TypeScript
- 组件: `PascalCase.tsx` (如 `HomeScreen.tsx`)
- 服务: `PascalCaseService.ts` (如 `EventService.ts`)
- 工具: `camelCase.ts` (如 `dateHelpers.ts`)
- 模型: `PascalCase.ts` (如 `CalendarEvent.ts`)

## 资源组织

### Android 资源前缀
为避免命名冲突，建议使用前缀：

- `shared:core`: 无 UI 资源
- `shared:ui-android`: `shared_`
- `apps:android-calendar`: `app_`

示例:
```xml
<!-- shared/ui-android/res/layout/shared_calendar_month_view.xml -->
<!-- apps/android-calendar/res/layout/app_main_activity.xml -->
```

## 构建顺序

Gradle 会按照依赖关系自动确定构建顺序：

1. `shared:core`
2. `shared:ui-android` (依赖 core)
3. `apps:android-calendar` (依赖 core 和 ui-android)
4. `apps:rn-calendar` (可选依赖)

## 版本管理

### Gradle 依赖版本
统一在 `gradle/libs.versions.toml` 中管理：

```toml
[versions]
kotlin = "1.9.0"
room = "2.6.1"

[libraries]
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
```

### React Native 依赖
在 `apps/rn-calendar/package.json` 中独立管理。

## 更新日志

- **2025-12-16**: 创建 Monorepo 架构
- 初始化 `apps/android-calendar`, `apps/rn-calendar`
- 创建 `shared/core`, `shared/ui-android`
- 配置 Gradle 多项目构建
