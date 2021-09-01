package ps.aio.gazacars.ui.fragments.notifications

import android.content.Context
import androidx.annotation.RawRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONArray
import org.json.JSONException
import ps.aio.gazacars.models.NotificationModel
import java.util.*

class NotificationsViewModel : ViewModel() {
    val notificationsModel = MutableLiveData<MutableList<NotificationModel>>()

    @Throws(JSONException::class)
    fun getNotificationsFromDB(@RawRes resource: Int, mContext: Context) {
        val results: MutableList<NotificationModel> = ArrayList()
        val inputStream = mContext.resources.openRawResource(resource)
        val json = Scanner(inputStream).useDelimiter("\\A").next()
        val array = JSONArray(json)
        for (i in 0 until array.length()) {
            val `object` = array.getJSONObject(i)
            val id = `object`.getInt("notification_id")
            val title = `object`.getString("notification_Title")
            val imageUrl = `object`.getString("notification_image")
            val time = `object`.getString("notification_time")
//            val options= ArrayList<String>()
//            for (i in 0 until items.length()){
//                options.add(items.getString(i))
//            }
            results.add(NotificationModel(
                id,title,imageUrl,time

            ))
        }
        notificationsModel.value=results
    }
}