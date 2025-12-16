# DayMate Monorepo 检查清单

使用此清单验证 Monorepo 架构设置是否完整。

## 📁 目录结构检查

- [x] `apps/android-calendar/` - Android 原生应用
- [x] `apps/rn-calendar/` - React Native 应用
- [x] `shared/core/` - 共享核心逻辑
- [x] `shared/ui-android/` - Android UI 组件
- [x] `docs/` - 项目文档
- [x] `.github/workflows/` - CI/CD 配置

## 📄 配置文件检查

### Gradle 配置
- [x] `settings.gradle.kts` - 多项目配置
- [x] `build.gradle.kts` - 根项目构建配置
- [x] `gradle/libs.versions.toml` - 版本管理
- [x] `gradle.properties` - Gradle 属性

### 模块构建配置
- [x] `apps/android-calendar/build.gradle.kts`
- [x] `shared/core/build.gradle.kts`
- [x] `shared/ui-android/build.gradle.kts`

### React Native 配置
- [x] `apps/rn-calendar/package.json`
- [x] `apps/rn-calendar/tsconfig.json`
- [x] `apps/rn-calendar/metro.config.js`
- [x] `apps/rn-calendar/babel.config.js`

### Android RN 配置
- [x] `apps/rn-calendar/android/build.gradle`
- [x] `apps/rn-calendar/android/settings.gradle`
- [x] `apps/rn-calendar/android/app/build.gradle`

## 📝 文档检查

- [x] `README.md` - 项目概述（已更新为 Monorepo）
- [x] `docs/ARCHITECTURE.md` - 架构文档
- [x] `docs/DEVELOPMENT.md` - 开发指南
- [x] `docs/MIGRATION.md` - 迁移指南
- [x] `docs/PROJECT_STRUCTURE.md` - 项目结构
- [x] `docs/QUICKSTART.md` - 快速开始
- [x] `docs/REFACTORING_SUMMARY.md` - 重构总结
- [x] `docs/CHECKLIST.md` - 本检查清单

## 🔧 共享模块文件

### shared/core
- [x] `src/main/java/.../models/CalendarModels.kt`
- [x] `src/main/java/.../repository/CalendarRepository.kt`
- [x] `src/main/java/.../utils/DateUtils.kt`
- [x] `build.gradle.kts`
- [x] `proguard-rules.pro`
- [x] `consumer-rules.pro`
- [x] `README.md`

### shared/ui-android
- [x] `build.gradle.kts`
- [x] `proguard-rules.pro`
- [x] `consumer-rules.pro`
- [x] 目录结构已创建

## 📱 React Native 文件

- [x] `App.tsx` - 应用入口
- [x] `index.js` - React Native 入口
- [x] `app.json` - 应用配置
- [x] `src/screens/HomeScreen.tsx` - 主屏幕
- [x] `README.md` - RN 应用文档

## 🚀 CI/CD 检查

- [x] `.github/workflows/android.yml` - Android CI
- [x] `.github/workflows/rn.yml` - React Native CI
- [x] `.gitignore` - Git 忽略规则（已更新）

## ✅ 构建验证

运行以下命令验证构建：

```bash
# 1. 查看项目结构
./gradlew projects
# 预期: 显示所有模块

# 2. 构建共享模块
./gradlew :shared:core:build
# 预期: BUILD SUCCESSFUL

./gradlew :shared:ui-android:build
# 预期: BUILD SUCCESSFUL

# 3. 构建 Android 应用
./gradlew :apps:android-calendar:assembleDebug
# 预期: BUILD SUCCESSFUL，生成 APK

# 4. React Native 依赖安装
cd apps/rn-calendar && npm install
# 预期: 成功安装所有依赖
```

## 🧪 功能验证

### Android 应用
- [ ] 应用可以编译
- [ ] 应用可以安装到设备
- [ ] 应用可以正常启动
- [ ] 可以跳转到 shared:core 的代码（在 IDE 中）

### React Native 应用
- [ ] Metro bundler 可以启动
- [ ] Android 应用可以运行
- [ ] 日历视图可以正常显示
- [ ] 可以选择日期

### 共享模块
- [ ] `shared:core` 可以独立构建
- [ ] `shared:ui-android` 可以独立构建
- [ ] 在 Android Studio 中可以导航到共享模块

## 📊 代码质量

### Kotlin
- [ ] 代码可以编译
- [ ] Lint 检查通过
- [ ] 单元测试通过（如有）

### TypeScript
- [ ] TypeScript 编译通过
- [ ] ESLint 检查通过
- [ ] 单元测试通过（如有）

## 🔍 依赖关系验证

### 模块依赖
```
apps:android-calendar
    → shared:ui-android
    → shared:core

shared:ui-android
    → shared:core

apps:rn-calendar
    → (可选) shared:core
```

验证方法：
```bash
./gradlew :apps:android-calendar:dependencies
```

## 📦 发布准备（可选）

- [ ] 版本号配置正确
- [ ] 签名配置完成（生产环境）
- [ ] ProGuard 规则配置
- [ ] 发布文档更新

## 🎓 团队准备

- [ ] 团队成员已了解 Monorepo 架构
- [ ] 开发环境配置文档已分享
- [ ] Git 工作流已确定
- [ ] Code Review 流程已建立

## 📈 性能基准

记录基准数据以便后续对比：

- [ ] Android 应用大小: _____ MB
- [ ] RN 应用大小: _____ MB
- [ ] 冷启动时间: _____ ms
- [ ] Gradle 全量构建时间: _____ s

## ✨ 完成标志

当所有上述检查项都完成后，Monorepo 架构就完全就绪了！

---

**检查日期**: ____________
**检查人**: ____________
**状态**: ⬜ 待检查 / ⬜ 进行中 / ⬜ 已完成
