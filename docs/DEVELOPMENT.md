# DayMate 开发指南

## 🚀 快速开始

### 环境要求

#### Android 开发
- JDK 17 或更高版本
- Android Studio Hedgehog (2023.1.1) 或更高版本
- Android SDK 34
- Gradle 8.5+

#### React Native 开发
- Node.js 16+ 
- npm 或 yarn
- Xcode 14+ (iOS 开发)
- CocoaPods (iOS 依赖管理)

### 初始化项目

```bash
# 克隆仓库
git clone https://github.com/yourusername/DayMate.git
cd DayMate

# Android: 同步 Gradle
./gradlew build

# React Native: 安装依赖
cd apps/rn-calendar
npm install
cd ios && pod install && cd ..
```

## 📱 运行应用

### Android 原生应用

```bash
# 方式 1: 使用 Gradle
./gradlew :apps:android-calendar:installDebug

# 方式 2: 使用 Android Studio
# 打开项目，选择 apps:android-calendar 运行配置
```

### React Native 应用

```bash
cd apps/rn-calendar

# Android
npm run android

# iOS
npm run ios

# 或手动启动 Metro
npm start
```

## 🛠️ 开发工作流

### 1. 创建新功能

#### 在 shared/core 中添加业务逻辑

```kotlin
// shared/core/src/main/java/com/example/daymate/shared/core/domain/
package com.example.daymate.shared.core.domain

class CreateEventUseCase(
    private val repository: CalendarRepository
) {
    suspend operator fun invoke(event: CalendarEvent): Result<CalendarEvent> {
        // 业务逻辑
        return repository.createEvent(event)
    }
}
```

#### 在 Android 应用中使用

```kotlin
// apps/android-calendar/src/main/java/com/example/daymate/
class EventViewModel : ViewModel() {
    private val createEventUseCase = CreateEventUseCase(repository)
    
    fun createEvent(event: CalendarEvent) {
        viewModelScope.launch {
            createEventUseCase(event).onSuccess {
                // 处理成功
            }
        }
    }
}
```

#### 在 React Native 中使用

```typescript
// apps/rn-calendar/src/services/EventService.ts
export class EventService {
  async createEvent(event: CalendarEvent): Promise<CalendarEvent> {
    // 使用 AsyncStorage 或 SQLite
    // 或通过 Native Module 调用 shared:core
  }
}
```

### 2. 添加 UI 组件

#### Android 共享组件

```kotlin
// shared/ui-android/src/main/java/com/example/daymate/shared/ui/
class CalendarMonthView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {
    // 可复用的月视图实现
}
```

#### React Native 组件

```typescript
// apps/rn-calendar/src/components/MonthView.tsx
export const MonthView: React.FC<MonthViewProps> = ({date, events}) => {
  // React Native 日历组件
}
```

### 3. 数据库迁移

当修改 Room 数据库结构时：

```kotlin
// shared/core/src/main/java/com/example/daymate/shared/core/data/
@Database(
    entities = [EventEntity::class],
    version = 2,  // 增加版本号
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    // ...
    
    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // 迁移逻辑
            }
        }
    }
}
```

## 🧪 测试

### 运行单元测试

```bash
# Android
./gradlew :shared:core:test
./gradlew :apps:android-calendar:test

# React Native
cd apps/rn-calendar
npm test
```

### 运行 Android 仪器测试

```bash
./gradlew :apps:android-calendar:connectedAndroidTest
```

### 代码覆盖率

```bash
./gradlew jacocoTestReport
open apps/android-calendar/build/reports/jacoco/test/html/index.html
```

## 📐 代码规范

### Kotlin 代码风格

使用 ktlint 检查和格式化：

```bash
./gradlew ktlintCheck
./gradlew ktlintFormat
```

### TypeScript 代码风格

```bash
cd apps/rn-calendar
npm run lint
npm run lint:fix
```

### Commit 规范

遵循 Conventional Commits：

```
feat: 添加事件重复规则支持
fix: 修复日历视图跨月显示问题
docs: 更新架构文档
refactor: 重构日期计算逻辑
test: 添加 DateUtils 单元测试
chore: 升级 Room 依赖到 2.6.1
```

## 🔍 调试技巧

### Android 调试

1. **Logcat 过滤**
   ```
   tag:DayMate level:debug
   ```

2. **数据库检查**
   - 使用 Android Studio 的 Database Inspector
   - 或通过 adb 导出数据库

3. **Layout Inspector**
   - 查看视图层级和属性

### React Native 调试

1. **Chrome DevTools**
   - 在模拟器中按 `Cmd+D` (iOS) 或 `Cmd+M` (Android)
   - 选择 "Debug"

2. **Flipper**
   ```bash
   npx flipper-server
   ```

3. **日志输出**
   ```typescript
   console.log('[EventService]', data);
   ```

## 📦 依赖管理

### 添加 Android 依赖

在 `gradle/libs.versions.toml` 中添加：

```toml
[versions]
retrofit = "2.9.0"

[libraries]
retrofit = { group = "com.squareup.retrofit2", name = "retrofit", version.ref = "retrofit" }
```

在模块的 `build.gradle.kts` 中使用：

```kotlin
dependencies {
    implementation(libs.retrofit)
}
```

### 添加 React Native 依赖

```bash
cd apps/rn-calendar
npm install --save react-native-vector-icons
npx pod-install  # iOS
```

## 🚢 发布流程

### Android 应用

1. **更新版本号**
   ```kotlin
   // apps/android-calendar/build.gradle.kts
   versionCode = 2
   versionName = "1.1.0"
   ```

2. **生成签名 APK**
   ```bash
   ./gradlew :apps:android-calendar:assembleRelease
   ```

3. **上传到 Google Play**

### React Native 应用

1. **更新版本**
   ```json
   // apps/rn-calendar/package.json
   "version": "1.1.0"
   ```

2. **构建**
   ```bash
   # Android
   cd android && ./gradlew assembleRelease
   
   # iOS
   xcodebuild -workspace ios/DayMate.xcworkspace -scheme DayMate -configuration Release
   ```

## 🤝 贡献指南

1. Fork 项目
2. 创建功能分支 (`git checkout -b feature/amazing-feature`)
3. 提交更改 (`git commit -m 'feat: add amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 创建 Pull Request

## 📞 获取帮助

- 查看 [架构文档](./ARCHITECTURE.md)
- 阅读 [迁移指南](./MIGRATION.md)
- 提交 Issue
- 加入讨论组

## 📚 参考资料

### Android
- [Android 开发文档](https://developer.android.com/)
- [Kotlin 协程指南](https://kotlinlang.org/docs/coroutines-guide.html)
- [Room 数据库](https://developer.android.com/training/data-storage/room)

### React Native
- [React Native 文档](https://reactnative.dev/)
- [React Navigation](https://reactnavigation.org/)
- [Native Modules 指南](https://reactnative.dev/docs/native-modules-intro)
