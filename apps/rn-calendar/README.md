# React Native Calendar App

这是 DayMate Monorepo 中的 React Native 跨平台日历应用。

## 功能特性

- 跨平台支持（iOS / Android）
- 月视图、周视图、日视图
- 事件创建和管理
- 本地通知提醒
- 可选：通过 Native Module 调用共享的 Android 核心逻辑

## 开发指南

### 安装依赖

```bash
cd apps/rn-calendar
npm install
```

### 运行 Android

```bash
npm run android
```

### 运行 iOS

```bash
cd ios
pod install
cd ..
npm run ios
```

## 架构说明

- **src/screens**: UI 屏幕组件
- **src/components**: 可复用组件
- **src/services**: 业务逻辑和 API 调用
- **src/utils**: 工具函数
- **android/**: Android 原生代码
- **ios/**: iOS 原生代码

## 与 Android 核心模块的集成

如需使用共享的 Android 核心逻辑，可以：
1. 在 `android/app/build.gradle` 中添加 `implementation(project(":shared:core"))`
2. 创建 Native Module 桥接 Kotlin 代码
3. 在 React Native 中调用桥接方法
