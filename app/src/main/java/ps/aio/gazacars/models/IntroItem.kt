package ps.aio.gazacars.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class IntroItem {
    var title: String? = null
    var des: String? = null
    var img: Int? = null

    constructor(title: String?, des: String?, img: Int?) {
        this.title = title
        this.des = des
        this.img = img
    }

    constructor()

    companion object {
        @JvmStatic
        @BindingAdapter("setIntroImg")
        fun setIntroImg(img: ImageView, url: Int) {
            img.setImageResource(url)
        }
    }

}