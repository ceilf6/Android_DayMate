# 🚀 快速开始指南

本指南帮助你快速验证 DayMate Monorepo 架构的设置。

## ✅ 验证步骤

### 1. 检查 Gradle 配置

```bash
# 在项目根目录运行
./gradlew projects
```

**期望输出**:
```
Root project 'DayMate'
+--- Project ':apps:android-calendar'
+--- Project ':shared:core'
\--- Project ':shared:ui-android'
```

### 2. 构建共享模块

```bash
# 构建核心模块
./gradlew :shared:core:build

# 构建 UI 模块
./gradlew :shared:ui-android:build
```

### 3. 构建 Android 应用

```bash
# 清理并构建
./gradlew clean
./gradlew :apps:android-calendar:assembleDebug

# 安装到设备
./gradlew :apps:android-calendar:installDebug
```

### 4. 运行 React Native 应用

```bash
# 进入 RN 目录
cd apps/rn-calendar

# 安装依赖
npm install

# 启动 Metro bundler
npm start

# 在另一个终端运行
npm run android  # 或 npm run ios
```

## 🔧 常见问题排查

### 问题 1: Gradle 无法找到模块

**错误信息**: `Project ':shared:core' not found`

**解决方案**:
1. 检查 `settings.gradle.kts` 是否正确配置
2. 运行 `./gradlew --refresh-dependencies`

### 问题 2: Android 应用编译失败

**错误信息**: `Cannot resolve symbol 'core'`

**解决方案**:
1. 确保 `shared:core` 模块已构建
2. 检查 `apps/android-calendar/build.gradle.kts` 中的依赖配置
3. 同步 Gradle: `./gradlew --refresh-dependencies`

### 问题 3: React Native Metro 无法启动

**错误信息**: `Cannot find module 'react-native-calendars'`

**解决方案**:
```bash
cd apps/rn-calendar
rm -rf node_modules package-lock.json
npm install
```

### 问题 4: iOS Pod 安装失败

**解决方案**:
```bash
cd apps/rn-calendar/ios
pod deintegrate
pod install
```

## 📝 下一步

### 对于 Android 开发者

1. **打开项目**: 使用 Android Studio 打开根目录
2. **配置运行**: 选择 `apps:android-calendar` 运行配置
3. **开始开发**: 参考 [开发指南](./DEVELOPMENT.md)

### 对于 React Native 开发者

1. **配置 IDE**: 使用 VS Code 打开 `apps/rn-calendar`
2. **安装扩展**: React Native Tools, ESLint, Prettier
3. **开始开发**: 参考 `apps/rn-calendar/README.md`

### 迁移现有代码

如需将现有的 Android 代码迁移到共享模块，请参考 [迁移指南](./MIGRATION.md)。

## 🎯 验证清单

完成以下清单以确认 Monorepo 设置正确：

- [ ] `./gradlew projects` 显示所有模块
- [ ] `shared:core` 模块可以独立构建
- [ ] `shared:ui-android` 模块可以独立构建
- [ ] Android 应用可以正常编译和运行
- [ ] React Native 应用可以启动（至少 Android）
- [ ] 在 Android Studio 中可以跳转到 `shared:core` 的代码
- [ ] Lint 和测试可以正常运行

## 🛠️ 开发工具配置

### Android Studio

1. **导入项目**: File → Open → 选择项目根目录
2. **Gradle 同步**: 点击 "Sync Project with Gradle Files"
3. **运行配置**: 
   - 配置名称: "Android Calendar"
   - 模块: `apps.android-calendar.main`

### VS Code (React Native)

推荐安装以下扩展:
- React Native Tools
- ESLint
- Prettier - Code formatter
- TypeScript Hero

**配置文件** (`.vscode/settings.json`):
```json
{
  "editor.formatOnSave": true,
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "typescript.tsdk": "apps/rn-calendar/node_modules/typescript/lib"
}
```

## 📚 相关文档

- [架构文档](./ARCHITECTURE.md) - 了解整体架构
- [开发指南](./DEVELOPMENT.md) - 详细的开发流程
- [迁移指南](./MIGRATION.md) - 代码迁移步骤
- [项目结构](./PROJECT_STRUCTURE.md) - 目录结构说明

## 💡 提示

- 每次修改 Gradle 配置后，记得同步项目
- React Native 开发时，保持 Metro bundler 运行
- 使用 `./gradlew tasks` 查看所有可用任务
- 提交代码前运行 `./gradlew check` 确保质量

## 🎉 完成

如果所有验证步骤都通过，恭喜！你的 Monorepo 已经正确设置。可以开始开发了！

有问题？查看文档或提交 Issue。
