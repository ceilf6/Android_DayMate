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

首次在本机运行 iOS 前，需要安装 CocoaPods（如果你还没有安装）：

```bash
brew install cocoapods
```

推荐使用脚本（会自动处理本机代理/证书差异，并默认禁用 Flipper 以提升稳定性）：

```bash
npm run ios:pods
npm run ios:run
```

## 提醒功能

- 在“添加日程”里填写 **开始时间（HH:mm）**，并在“提醒（提前分钟）”里填一个整数（例如 10），保存后会创建本地通知。
- 第一次使用提醒会触发系统通知权限弹窗；未授权时提醒不会创建。

或按传统方式：

```bash
cd ios
pod install
cd ..
npm run ios
```

## 报错端口已占用

```bash
pkill -f react-native
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
