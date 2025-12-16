# 📚 DayMate Monorepo 使用指南

快速参考指南，帮助你高效使用 DayMate Monorepo。

## 🎯 常用命令

### Gradle 命令

```bash
# 查看所有模块
./gradlew projects

# 查看可用任务
./gradlew tasks

# 构建所有模块
./gradlew build

# 清理构建
./gradlew clean

# 构建特定模块
./gradlew :shared:core:build
./gradlew :apps:android-calendar:assembleDebug

# 运行测试
./gradlew test
./gradlew :shared:core:test

# 安装 Android 应用
./gradlew :apps:android-calendar:installDebug

# 运行 Lint
./gradlew lint

# 刷新依赖
./gradlew --refresh-dependencies
```

### React Native 命令

```bash
# 进入 RN 目录
cd apps/rn-calendar

# 安装依赖
npm install

# 启动 Metro
npm start

# 运行 Android
npm run android

# 运行 iOS
npm run ios

# 运行测试
npm test

# 代码检查
npm run lint

# 构建 Android APK
cd android && ./gradlew assembleDebug
```

## 📂 目录导航

```bash
# 快速进入各模块
cd apps/android-calendar    # Android 应用
cd apps/rn-calendar         # RN 应用
cd shared/core              # 核心逻辑
cd shared/ui-android        # Android UI
cd docs                     # 文档
```

## 🔧 开发工作流

### 1. 修改共享代码

```bash
# 1. 修改 shared/core 中的代码
vim shared/core/src/.../models/CalendarModels.kt

# 2. 构建验证
./gradlew :shared:core:build

# 3. 测试影响的应用
./gradlew :apps:android-calendar:build
```

### 2. 开发 Android 应用

```bash
# 使用 Android Studio 打开项目根目录

# 或使用命令行
./gradlew :apps:android-calendar:installDebug
adb logcat | grep DayMate
```

### 3. 开发 React Native

```bash
# Terminal 1: 启动 Metro
cd apps/rn-calendar
npm start

# Terminal 2: 运行应用
npm run android
# 或打开 Android Studio 运行 apps/rn-calendar/android
```

## 🐛 调试技巧

### Android 调试

```bash
# 查看日志
adb logcat -s DayMate

# 清除应用数据
adb shell pm clear com.example.daymate

# 查看数据库
adb shell "run-as com.example.daymate cat databases/daymate.db" > local.db
```

### React Native 调试

```bash
# 重新加载
# 在模拟器中: Cmd+R (iOS) / RR (Android)

# 打开开发菜单
# Cmd+D (iOS) / Cmd+M (Android)

# 清除缓存
cd apps/rn-calendar
npm start -- --reset-cache
```

## 🧪 测试

### 运行所有测试

```bash
# Android
./gradlew test

# React Native
cd apps/rn-calendar && npm test
```

### 运行特定模块测试

```bash
# 共享核心
./gradlew :shared:core:test

# Android 应用
./gradlew :apps:android-calendar:testDebugUnitTest

# RN (单个文件)
cd apps/rn-calendar
npm test -- HomeScreen.test.tsx
```

## 📦 构建发布版本

### Android Release

```bash
# 构建 Release APK
./gradlew :apps:android-calendar:assembleRelease

# 生成的文件位置
# apps/android-calendar/build/outputs/apk/release/
```

### React Native Release

```bash
cd apps/rn-calendar

# Android
cd android
./gradlew assembleRelease
# 输出: android/app/build/outputs/apk/release/

# iOS
cd ios
xcodebuild -workspace DayMate.xcworkspace \
  -scheme DayMate \
  -configuration Release
```

## 🔍 查找代码

### 搜索文件

```bash
# 查找 Kotlin 文件
find . -name "*.kt" | grep -i event

# 查找 TypeScript 文件
find apps/rn-calendar -name "*.tsx" | grep -i screen
```

### 搜索内容

```bash
# 在 Kotlin 代码中搜索
grep -r "CalendarEvent" shared/core/src

# 在 TS 代码中搜索
grep -r "CalendarService" apps/rn-calendar/src
```

## 📊 代码统计

```bash
# 统计代码行数
# Kotlin
find shared apps -name "*.kt" | xargs wc -l

# TypeScript
find apps/rn-calendar/src -name "*.ts*" | xargs wc -l

# 统计文件数
find shared/core -name "*.kt" | wc -l
```

## 🔄 Git 工作流

### 分支策略

```bash
# 功能分支
git checkout -b feature/event-reminder
git checkout -b fix/calendar-crash

# 提交更改
git add .
git commit -m "feat: add event reminder support"

# 推送
git push origin feature/event-reminder
```

### 提交消息规范

```
feat: 新功能
fix: 修复 bug
docs: 文档更新
style: 代码格式（不影响功能）
refactor: 重构
test: 测试
chore: 构建/工具相关
```

## 🚀 性能优化

### Gradle 构建优化

```bash
# 并行构建
./gradlew build --parallel

# 使用构建缓存
./gradlew build --build-cache

# 守护进程
./gradlew build --daemon
```

### 配置 gradle.properties

```properties
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.configureondemand=true
kotlin.incremental=true
android.useAndroidX=true
```

## 📱 设备管理

### ADB 命令

```bash
# 列出设备
adb devices

# 安装 APK
adb install apps/android-calendar/build/outputs/apk/debug/*.apk

# 卸载应用
adb uninstall com.example.daymate

# 截屏
adb shell screencap -p /sdcard/screen.png
adb pull /sdcard/screen.png
```

## 🆘 故障排查

### 常见问题

**问题**: "Cannot resolve symbol"
```bash
# 解决方案
./gradlew clean
./gradlew --refresh-dependencies
# 在 Android Studio: File → Invalidate Caches / Restart
```

**问题**: Metro bundler 错误
```bash
# 解决方案
cd apps/rn-calendar
rm -rf node_modules
npm install
npm start -- --reset-cache
```

**问题**: Gradle 构建失败
```bash
# 解决方案
./gradlew clean
rm -rf .gradle
./gradlew build --refresh-dependencies
```

## 📚 学习资源

### 文档链接

- [架构文档](./ARCHITECTURE.md)
- [开发指南](./DEVELOPMENT.md)
- [迁移指南](./MIGRATION.md)
- [快速开始](./QUICKSTART.md)

### 外部资源

- [Gradle 用户指南](https://docs.gradle.org/current/userguide/userguide.html)
- [React Native 文档](https://reactnative.dev/docs/getting-started)
- [Android 开发指南](https://developer.android.com/guide)
- [Kotlin 文档](https://kotlinlang.org/docs/home.html)

## 🎓 快捷键（Android Studio）

```
Cmd+N        - 快速打开类
Cmd+Shift+N  - 快速打开文件
Cmd+E        - 最近的文件
Cmd+B        - 跳转到定义
Cmd+Alt+L    - 格式化代码
Cmd+/        - 注释/取消注释
Shift+Shift  - 全局搜索
```

## 💡 最佳实践

1. **经常同步**: 定期运行 `git pull` 和 `./gradlew --refresh-dependencies`
2. **模块化开发**: 优先修改 `shared` 模块，保持应用层轻量
3. **测试驱动**: 修改代码后立即运行相关测试
4. **文档更新**: 重大变更后更新文档
5. **代码审查**: 提交前自我审查，使用 lint 工具

## 🔗 快速链接

- **报告问题**: [GitHub Issues](https://github.com/ceilf6/Android_DayMate/issues)
- **讨论**: [GitHub Discussions](https://github.com/ceilf6/Android_DayMate/discussions)
- **Wiki**: [项目 Wiki](https://github.com/ceilf6/Android_DayMate/wiki)

---

**提示**: 将此文件加入书签，作为日常开发参考！
