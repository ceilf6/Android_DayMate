package com.example.daymate.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class PermissionManager {
    
    companion object {
        const val NOTIFICATION_PERMISSION_REQUEST_CODE = 1001
        
        /**
         * 检查是否有通知权限
         */
        fun hasNotificationPermission(context: Context): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            } else {
                // Android 13以下版本不需要请求通知权限
                true
            }
        }
        
        /**
         * 请求通知权限 - 在Activity中使用
         */
        fun requestNotificationPermission(activity: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_REQUEST_CODE
                )
            }
        }
        
        /**
         * 请求通知权限 - 在Fragment中使用
         */
        fun requestNotificationPermission(fragment: Fragment) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                fragment.requestPermissions(
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_REQUEST_CODE
                )
            }
        }
        
        /**
         * 检查权限请求结果
         */
        fun checkNotificationPermissionResult(
            requestCode: Int,
            grantResults: IntArray
        ): Boolean {
            return requestCode == NOTIFICATION_PERMISSION_REQUEST_CODE && 
                    grantResults.isNotEmpty() && 
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
        }
        
        /**
         * 是否应该显示权限请求理由
         */
        fun shouldShowNotificationPermissionRationale(activity: Activity): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.POST_NOTIFICATIONS
                )
            } else {
                false
            }
        }
        
        /**
         * 是否应该显示权限请求理由 - Fragment版本
         */
        fun shouldShowNotificationPermissionRationale(fragment: Fragment): Boolean {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                fragment.shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                false
            }
        }
    }
}
