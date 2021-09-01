package ps.aio.gazacars.ui.fragments.cars

import android.content.Context
import androidx.annotation.RawRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException
import ps.aio.gazacars.models.CarModel
import java.util.*

class MyGalleryViewModel : ViewModel(){
    val salesCars = MutableLiveData<MutableList<CarModel>>()

    @Throws(JSONException::class)
    fun getCarsFromDB(@RawRes resource: Int, mContext: Context) {
        val results: MutableList<CarModel> = ArrayList()
        val inputStream = mContext.resources.openRawResource(resource)
        val json = Scanner(inputStream).useDelimiter("\\A").next()
        val array = JSONArray(json)
        for (i in 0 until array.length()) {
            val `object` = array.getJSONObject(i)
            val brand = `object`.getString("brand")
            val model = `object`.getString("model")
            val sellerName = `object`.getString("sellerName")
            val urlImage = `object`.getString("urlImage")
//            val options= ArrayList<String>()
//            for (i in 0 until items.length()){
//                options.add(items.getString(i))
//            }
            results.add(CarModel(brand = brand,
                model = model,
                sellerName = sellerName,
                urlImage = urlImage
            ))
        }
        salesCars.value=results
    }
}