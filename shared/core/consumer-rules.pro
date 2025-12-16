# Consumer ProGuard rules for shared:core
# These rules will be applied to consumers of this library

# Keep all public classes and methods
-keep public class com.example.daymate.shared.core.** { public *; }

# Keep data classes
-keep class com.example.daymate.shared.core.models.** { *; }

# Keep repository interfaces
-keep interface com.example.daymate.shared.core.repository.** { *; }
