package com.module.dialog.widget


import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentManager
import com.module.dialog.R
import top.limuyang2.ldialog.base.BaseLDialog
import top.limuyang2.ldialog.base.ViewHandlerListener
import top.limuyang2.ldialog.base.ViewHolder

/**
 * iOS Style Dialog
 * Date 2018/6/26
 * @author limuyang
 */
class CustomDialog : BaseLDialog<CustomDialog>() {

    /**
     * 是否显示标题
     */
    private var isShowTitle = false
    /**
     * 是否显示确定按钮
     */
    private var isShowPosBtn = false
    /**
     * 是否显示取消按钮
     */
    private var isShowNegBtn = false

    /**
     * 标题
     */
    private var titleText: CharSequence = ""

    /**
     * 内容
     */
    private var messageText: CharSequence = ""

    /**
     * 取消按钮文案
     */
    private var negativeButtonText: CharSequence = ""
    /**
     * 取消按钮点击事件
     */
    private var negativeButtonClickListener: View.OnClickListener? = null
    /**
     * 取消按钮字体颜色
     */
    private var negativeButtonColor: Int = Color.BLACK
    /**
     * 取消按钮背景颜色
     */
    private var negativeButtonBackground: Int = Color.WHITE
    /**
     * 确定按钮文案
     */
    private var positiveButtonText: CharSequence = ""
    /**
     * 确定按钮点击事件
     */
    private var positiveButtonClickListener: View.OnClickListener? = null
    /**
     * 确定按钮文字颜色
     */
    private var positiveButtonColor: Int = Color.BLACK
    /**
     * 取消按钮背景颜色
     */
    private var positiveButtonBackground: Int = Color.WHITE
    /**
     * View Handler
     * The management of the relevant state of the view is written here
     */
    override fun viewHandler(): ViewHandlerListener? {
        return object : ViewHandlerListener() {
            override fun convertView(holder: ViewHolder, dialog: BaseLDialog<*>) {
                holder.getView<TextView>(R.id.custom_dialog_title).apply {
                    visibility = if (isShowTitle) View.VISIBLE else View.GONE
                    text = titleText
                }

                holder.getView<TextView>(R.id.custom_dialog_content).apply {
                    text = messageText
                }

                holder.getView<Button>(R.id.custom_dialog_left_btn).apply {
                    visibility = if (isShowNegBtn) View.VISIBLE else View.GONE
                    text = negativeButtonText
                    setTextColor(negativeButtonColor)
                    setBackgroundColor(negativeButtonBackground)
                    setOnClickListener {
                        negativeButtonClickListener?.onClick(it)
                        dialog.dismiss()
                    }
                }

                holder.getView<Button>(R.id.custom_dialog_right_btn).apply {
                    visibility = if (isShowPosBtn) View.VISIBLE else View.GONE
                    text = positiveButtonText
                    setTextColor(positiveButtonColor)
                    setBackgroundColor(positiveButtonBackground)
                    setOnClickListener {
                        positiveButtonClickListener?.onClick(it)
                        dialog.dismiss()
                    }
                }

            }
        }
    }

    override fun layoutRes(): Int = R.layout.layout_custom_dialog

    override fun layoutView(): View? = null


    /**
     * 设置title标题
     */
    fun setTitle(title: CharSequence): CustomDialog {
        isShowTitle = true
        titleText = title
        return this
    }

    /**
     * 设置内容content
     */
    fun setMessage(msg: CharSequence): CustomDialog {
        messageText = msg
        return this
    }

    /**
     * Left Button
     */
    @JvmOverloads
    fun setNegativeButton(text: CharSequence,
                          listener: View.OnClickListener? = null,
                          @ColorInt textColor: Int = negativeButtonColor,
                          @ColorInt buttonBackground: Int = negativeButtonBackground): CustomDialog {
        isShowNegBtn = true
        negativeButtonText = text
        negativeButtonClickListener = listener
        negativeButtonColor = textColor
        negativeButtonBackground = buttonBackground
        return this
    }

    /**
     * Right Button
     */
    @JvmOverloads
    fun setPositiveButton(text: CharSequence,
                          listener: View.OnClickListener? = null,
                          @ColorInt textColor: Int = positiveButtonColor,
                          @ColorInt buttonBackground: Int = positiveButtonBackground): CustomDialog {
        isShowPosBtn = true
        positiveButtonText = text
        positiveButtonClickListener = listener
        positiveButtonColor = textColor
        positiveButtonBackground = buttonBackground

        return this
    }

    companion object {
        fun init(fragmentManager: FragmentManager): CustomDialog {
            return CustomDialog().apply {
                setFragmentManager(fragmentManager)
                setBackgroundDrawableRes(R.drawable.custom_dialog_bg)
            }
        }
    }

}



