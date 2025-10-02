package com.example.daymate

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.daymate.ui.calendar.CalendarFragment
import com.example.daymate.utils.DebugHelper
import com.example.daymate.utils.PermissionManager

class MainActivity : AppCompatActivity() {
    
    private lateinit var debugHelper: DebugHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        debugHelper = DebugHelper(this)
        
        // 检查并请求通知权限
        checkAndRequestPermissions()
        
        // 处理从通知启动的情况
        handleNotificationIntent(intent)
        
        // 如果这是首次创建，添加CalendarFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CalendarFragment.newInstance())
                .commitNow()
        }
    }
    
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleNotificationIntent(intent)
    }
    
    private fun handleNotificationIntent(intent: Intent) {
        val eventId = intent.getLongExtra("event_id", -1)
        if (eventId != -1L) {
            // TODO: 导航到特定事件的详情页面
            Toast.makeText(this, "打开事件 ID: $eventId", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun checkAndRequestPermissions() {
        if (!PermissionManager.hasNotificationPermission(this)) {
            if (PermissionManager.shouldShowNotificationPermissionRationale(this)) {
                // 显示权限说明
                Toast.makeText(
                    this,
                    "需要通知权限来提醒您即将到来的日程事件",
                    Toast.LENGTH_LONG
                ).show()
            }
            PermissionManager.requestNotificationPermission(this)
        }
    }
    
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        if (PermissionManager.checkNotificationPermissionResult(requestCode, grantResults)) {
            Toast.makeText(this, "通知权限已授予", Toast.LENGTH_SHORT).show()
            // 权限授予后重新安排提醒
            debugHelper.rescheduleAllReminders()
        } else {
            Toast.makeText(this, "未授予通知权限，将无法接收日程提醒", Toast.LENGTH_LONG).show()
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_debug_reminders -> {
                debugHelper.checkPendingReminders()
                Toast.makeText(this, "检查提醒任务，请查看日志", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_check_permissions -> {
                debugHelper.checkNotificationPermission()
                Toast.makeText(this, "检查权限状态，请查看日志", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_reschedule_reminders -> {
                debugHelper.rescheduleAllReminders()
                Toast.makeText(this, "重新安排所有提醒", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}