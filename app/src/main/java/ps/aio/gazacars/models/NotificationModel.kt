package ps.aio.gazacars.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ps.aio.gazacars.R
import java.text.SimpleDateFormat
import java.util.*


class NotificationModel {

    var id:Int?=null
    var title:String?=null
    var image:String?=null
    var time:String?=null
    var readed:Boolean?=null

    constructor()
    constructor(id: Int?, title: String?, image: String?, time: String?) {
        this.id = id
        this.title = title
        this.image = image
        this.time = time
    }

    val FORMAT_DATE: SimpleDateFormat = SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss", Locale.US)

    companion object{

        @JvmStatic
        @BindingAdapter("setNotiImage")
        fun setNotificationImage(imageView: ImageView,imageUrl:String){
            Picasso.get().load(imageUrl).placeholder(R.color.grayStroke).into(imageView)
        }

    }
}