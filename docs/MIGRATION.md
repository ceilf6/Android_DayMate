# 从单应用迁移到 Monorepo 指南

本文档指导你如何将现有的 Android 应用迁移到新的 Monorepo 架构。

## 🎯 迁移目标

将原有的单一 Android 应用重构为：
- ✅ `apps/android-calendar`: 原生 Android 应用
- ✅ `apps/rn-calendar`: React Native 跨平台应用
- ✅ `shared/core`: 共享核心业务逻辑
- ✅ `shared/ui-android`: Android UI 组件库

## 📋 迁移检查清单

### 阶段 1: 结构迁移 ✅

- [x] 创建 Monorepo 目录结构
- [x] 迁移 Android 应用到 `apps/android-calendar`
- [x] 创建共享模块 `shared/core` 和 `shared/ui-android`
- [x] 配置 Gradle 多项目构建
- [x] 创建 React Native 应用骨架

### 阶段 2: 代码重构

- [ ] 识别可共享的业务逻辑
- [ ] 提取数据模型到 `shared/core/models`
- [ ] 迁移 Repository 接口到 `shared/core/repository`
- [ ] 迁移工具类到 `shared/core/utils`
- [ ] 提取可复用的 UI 组件到 `shared/ui-android`

### 阶段 3: 依赖调整

- [ ] 更新 Android 应用的依赖关系
- [ ] 移除重复的依赖声明
- [ ] 配置共享模块的 API 暴露

### 阶段 4: 测试验证

- [ ] 运行单元测试
- [ ] 运行集成测试
- [ ] 手动测试核心功能
- [ ] 性能对比测试

## 🔄 详细迁移步骤

### 步骤 1: 分析现有代码结构

首先，分析原有应用的代码结构：

```bash
# 查看现有代码的目录结构
tree app/src/main/java/com/example/daymate

# 识别以下类型的代码：
# 1. 数据模型 (data class, entity)
# 2. Repository 层
# 3. ViewModel 层
# 4. UI 组件 (Activity, Fragment, View)
# 5. 工具类 (Utils)
```

### 步骤 2: 迁移数据模型

**原位置**: `app/src/main/java/com/example/daymate/data/model/`
**新位置**: `shared/core/src/main/java/com/example/daymate/shared/core/models/`

**示例**:

```kotlin
// 原代码 (app/src/.../model/Event.kt)
package com.example.daymate.data.model

data class Event(
    val id: String,
    val title: String,
    val startTime: LocalDateTime
)

// 迁移后 (shared/core/src/.../models/CalendarModels.kt)
package com.example.daymate.shared.core.models

data class CalendarEvent(
    val id: String,
    val title: String,
    val startDateTime: LocalDateTime,
    // ... 其他字段
)
```

**更新引用**:

```kotlin
// 在 apps/android-calendar 中
import com.example.daymate.shared.core.models.CalendarEvent
```

### 步骤 3: 迁移 Repository 接口

**原位置**: `app/src/main/java/com/example/daymate/data/repository/`
**新位置**: `shared/core/src/main/java/com/example/daymate/shared/core/repository/`

**迁移策略**:
1. 将接口定义移到 `shared/core`
2. 将具体实现保留在 `apps/android-calendar`

```kotlin
// shared/core: 接口定义
interface CalendarRepository {
    suspend fun getEventsForDay(date: LocalDate): List<CalendarEvent>
}

// apps/android-calendar: 具体实现
class CalendarRepositoryImpl(
    private val dao: EventDao
) : CalendarRepository {
    override suspend fun getEventsForDay(date: LocalDate): List<CalendarEvent> {
        return dao.getEventsForDay(date).map { it.toCalendarEvent() }
    }
}
```

### 步骤 4: 迁移工具类

**原位置**: `app/src/main/java/com/example/daymate/utils/`
**新位置**: `shared/core/src/main/java/com/example/daymate/shared/core/utils/`

工具类通常是无状态的纯函数，非常适合共享：

```kotlin
// 迁移前
package com.example.daymate.utils

object DateHelper {
    fun formatDate(date: LocalDate): String { }
}

// 迁移后
package com.example.daymate.shared.core.utils

object DateUtils {
    fun formatDate(date: LocalDate, pattern: String = "yyyy-MM-dd"): String { }
}
```

### 步骤 5: 提取可复用 UI 组件

**原位置**: `app/src/main/java/com/example/daymate/ui/components/`
**新位置**: `shared/ui-android/src/main/java/com/example/daymate/shared/ui/components/`

**适合迁移的组件**:
- 自定义 View (日历视图、事件卡片等)
- RecyclerView Adapter
- ViewHolder
- 通用的 Fragment

**示例**:

```kotlin
// shared/ui-android
package com.example.daymate.shared.ui.components

class EventCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : MaterialCardView(context, attrs) {
    // 可复用的事件卡片视图
}
```

### 步骤 6: 更新 ViewModel

ViewModel 通常保留在应用层，但应该使用共享的 Repository 接口：

```kotlin
// apps/android-calendar/src/.../viewmodel/EventViewModel.kt
class EventViewModel(
    private val repository: CalendarRepository  // 来自 shared:core
) : ViewModel() {
    
    fun loadEvents(date: LocalDate) {
        viewModelScope.launch {
            val events = repository.getEventsForDay(date)
            _events.value = events
        }
    }
}
```

### 步骤 7: 配置依赖注入 (可选)

如果使用 Hilt/Dagger，需要调整模块配置：

```kotlin
// apps/android-calendar/src/.../di/RepositoryModule.kt
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    abstract fun bindCalendarRepository(
        impl: CalendarRepositoryImpl
    ): CalendarRepository  // 接口来自 shared:core
}
```

## 🎨 React Native 侧的实现

### 选项 1: 独立实现 (推荐)

在 React Native 中重新实现业务逻辑，保持跨平台的纯粹性：

```typescript
// apps/rn-calendar/src/models/CalendarEvent.ts
export interface CalendarEvent {
  id: string;
  title: string;
  startDateTime: Date;
  // 与 Kotlin 模型保持一致
}

// apps/rn-calendar/src/services/CalendarService.ts
export class CalendarService {
  async getEventsForDay(date: Date): Promise<CalendarEvent[]> {
    // 使用 SQLite 或 AsyncStorage
  }
}
```

### 选项 2: Native Module 桥接

如果需要复用 Android 的复杂逻辑（如农历计算），可以创建桥接：

```kotlin
// apps/rn-calendar/android/app/src/main/java/com/daymate/rn/
class CalendarModule(reactContext: ReactApplicationContext) 
    : ReactContextBaseJavaModule(reactContext) {
    
    @ReactMethod
    fun calculateLunarDate(date: String, promise: Promise) {
        // 调用 shared:core 的逻辑
        val lunarDate = LunarCalendarUtils.toLunar(LocalDate.parse(date))
        promise.resolve(lunarDate.toMap())
    }
}
```

```typescript
// apps/rn-calendar/src/native/CalendarNative.ts
import {NativeModules} from 'react-native';

const {CalendarModule} = NativeModules;

export const CalendarNative = {
  calculateLunarDate: (date: string): Promise<LunarDate> => {
    return CalendarModule.calculateLunarDate(date);
  },
};
```

## ⚠️ 常见问题和解决方案

### 问题 1: 循环依赖

**现象**: `shared:core` 和 `apps:android-calendar` 互相依赖

**解决方案**: 
- 确保依赖关系是单向的：`apps → shared`
- 使用依赖注入传递具体实现

### 问题 2: 资源文件冲突

**现象**: 多个模块定义了相同的资源 ID

**解决方案**:
- 为每个模块使用不同的资源前缀
- 在 `build.gradle.kts` 中配置：

```kotlin
android {
    resourcePrefix = "shared_"
}
```

### 问题 3: 版本冲突

**现象**: 不同模块依赖同一库的不同版本

**解决方案**:
- 使用统一的版本目录 (`gradle/libs.versions.toml`)
- 在根 `build.gradle.kts` 中配置版本解析策略

### 问题 4: 构建速度变慢

**现象**: Monorepo 构建时间增加

**优化方案**:
```kotlin
// gradle.properties
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.configureondemand=true
kotlin.incremental=true
```

## 📊 迁移进度追踪

使用这个表格追踪迁移进度：

| 模块/类               | 原位置      | 新位置          | 状态 | 备注 |
|----------------------|------------|----------------|------|------|
| Event 数据模型        | app/model  | shared/core    | ✅   |      |
| CalendarRepository   | app/repo   | shared/core    | ✅   |      |
| DateUtils            | app/utils  | shared/core    | ✅   |      |
| CalendarMonthView    | app/ui     | shared/ui-and  | 🔄   | 进行中 |
| EventViewModel       | app/vm     | app/vm         | ❌   | 保留 |

## ✅ 验证清单

迁移完成后，确保以下项都能正常工作：

- [ ] Android 应用可以正常编译和运行
- [ ] 所有单元测试通过
- [ ] 所有 UI 测试通过
- [ ] 性能没有明显下降
- [ ] APK 大小在合理范围内
- [ ] React Native 应用可以独立运行
- [ ] 文档已更新

## 🎓 最佳实践

1. **逐步迁移**: 不要一次性迁移所有代码，按模块逐步进行
2. **保持向后兼容**: 在迁移过程中保持应用可用
3. **充分测试**: 每迁移一个模块都要进行测试
4. **代码审查**: 对迁移的代码进行团队审查
5. **文档更新**: 及时更新文档和注释

## 📞 需要帮助？

如果在迁移过程中遇到问题：

1. 查看 [架构文档](./ARCHITECTURE.md)
2. 查看 [开发指南](./DEVELOPMENT.md)
3. 提交 Issue 描述问题
4. 联系团队成员

## 🎉 迁移完成后的收益

- ✅ 代码复用率提高
- ✅ 维护成本降低
- ✅ 支持多平台开发
- ✅ 模块化清晰
- ✅ 便于团队协作
