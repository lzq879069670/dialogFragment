package com.module.dialog

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.module.dialog.widget.CustomDialog
import top.limuyang2.ldialog.LDialog
import top.limuyang2.ldialog.base.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.custom_dialog).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                showDialog()
            }
        })
        findViewById<View>(R.id.my_dialog).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog()
            }
        })

    }

    fun showDialog() {
        CustomDialog.init(supportFragmentManager)
            .setTitle("Title")
            .setMessage("This is iOS style dialog!")
            .setAnimStyle(R.style.customDialogAnimation)
            .setNegativeButton("取消", View.OnClickListener {
                Toast.makeText(this@MainActivity, "关闭了弹窗", Toast.LENGTH_SHORT).show()
            }, Color.RED)
            .setPositiveButton("确定", View.OnClickListener {
                Toast.makeText(this@MainActivity, "点击了确定", Toast.LENGTH_SHORT).show()
            }, buttonBackground = Color.RED)
            .setDismissListener(object : OnDialogDismissListener() {
                override fun onDismiss(dialog: DialogInterface?) {
                    Toast.makeText(this@MainActivity, "dialog dismiss", Toast.LENGTH_SHORT).show()
                }
            })
            .setCancelableOutside(true)
            .show()
    }

    fun dialog() {
        LDialog.init(supportFragmentManager)
            .setLayoutRes(R.layout.layout_my_dialog)
            .setGravity(Gravity.BOTTOM)
            .setWidthScale(0.95f)
            .setVerticalMargin(0.015f)
            .setViewHandlerListener(object : ViewHandlerListener() {
                override fun convertView(holder: ViewHolder, dialog: BaseLDialog<*>) {
                    holder.setOnClickListener(R.id.my_dialog_left_btn, View.OnClickListener {
                        dialog.dismiss()
                    })
                }
            })
            .show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("linzhiqiang", "activityDestory")
    }
}
