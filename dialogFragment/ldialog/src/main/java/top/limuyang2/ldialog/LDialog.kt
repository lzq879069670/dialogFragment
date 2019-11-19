package top.limuyang2.ldialog


import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentManager
import top.limuyang2.ldialog.base.BaseLDialog
import top.limuyang2.ldialog.base.ViewHandlerListener

/**
 *
 * Date 2018/6/27
 * @author limuyang
 */
class LDialog : BaseLDialog<LDialog>() {

    /**
     * 布局id
     */
    override fun layoutRes(): Int = 0

    /**
     * 布局view
     */
    override fun layoutView(): View? = null

    /**
     * 可以对view 做一系列操作
     */
    override fun viewHandler(): ViewHandlerListener? {
        return null
    }

    fun setLayoutRes(@LayoutRes layoutRes: Int): LDialog {
        baseParams.layoutRes = layoutRes
        return this
    }

    fun setLayoutView(view: View): LDialog {
        baseParams.view = view
        return this
    }

    fun setViewHandlerListener(viewHandlerListener: ViewHandlerListener): LDialog {
        this@LDialog.viewHandlerListener = viewHandlerListener
        return this
    }

    companion object {
        fun init(fragmentManager: FragmentManager): LDialog {
            return LDialog().apply { setFragmentManager(fragmentManager) }
        }
    }
}