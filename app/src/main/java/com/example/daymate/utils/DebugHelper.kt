package com.example.daymate.utils

import android.content.Context
import android.util.Log
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.daymate.service.ReminderManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 调试工具类，用于测试和调试提醒功能
 */
class DebugHelper(private val context: Context) {
    
    companion object {
        private const val TAG = "DebugHelper"
    }
    
    private val workManager = WorkManager.getInstance(context)
    
    /**
     * 检查所有待执行的提醒任务
     */
    fun checkPendingReminders() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val workInfos = workManager.getWorkInfosByTag("reminder").get()
                Log.d(TAG, "Found ${workInfos.size} reminder work(s)")
                
                workInfos.forEach { workInfo ->
                    Log.d(TAG, "Work ID: ${workInfo.id}")
                    Log.d(TAG, "State: ${workInfo.state}")
                    Log.d(TAG, "Tags: ${workInfo.tags}")
                    
                    // WorkInfo doesn't provide access to inputData, we'll log what we can
                    Log.d(TAG, "Progress: ${workInfo.progress}")
                    
                    if (workInfo.state == WorkInfo.State.FAILED) {
                        Log.e(TAG, "Work failed: ${workInfo.outputData}")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error checking pending reminders", e)
            }
        }
    }
    
    /**
     * 取消所有提醒任务（用于调试）
     */
    fun cancelAllReminders() {
        workManager.cancelAllWork()
        Log.d(TAG, "Cancelled all work")
    }
    
    /**
     * 检查通知权限状态
     */
    fun checkNotificationPermission() {
        val hasPermission = PermissionManager.hasNotificationPermission(context)
        Log.d(TAG, "Has notification permission: $hasPermission")
    }
    
    /**
     * 重新安排所有提醒（用于调试）
     */
    fun rescheduleAllReminders() {
        val reminderManager = ReminderManager(context)
        reminderManager.rescheduleReminders()
        Log.d(TAG, "Rescheduled all reminders")
    }
}
