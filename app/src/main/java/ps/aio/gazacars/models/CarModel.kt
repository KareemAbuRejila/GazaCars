package ps.aio.gazacars.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import ps.aio.gazacars.R

class CarModel {
     var id:String?=null
     var name:String?="null"
     @SerializedName("brand")
     var brand:String?="null"
     var model:String?="null"
     var modelYear:String?="null"
     var sellerName:String?="null"
     var details:String?="null"
     var images:List<String>?=ArrayList()
     var numberOfImages=images?.size
     var urlImage:String?=if (images?.isNotEmpty()!!){
          images!![0]
     }else{
          null
     }
     var mills:Int?=0
     var ger:Ger?=Ger.AUTOMATIC
     var status:Status?=Status.GOOD
     var liked:Boolean?=false
     var price:Double?=0.00
     var color:String?="null"
     var trimType:Trims?=Trims.TWO_DOORS
     var pushType:PushTypes?=PushTypes.TWO_WHEEL



     constructor()
      constructor(brand: String?, model: String?, sellerName: String?, urlImage: String) {
          this.brand = brand
          this.model = model
          this.sellerName = sellerName
          this.urlImage = urlImage
     }

     constructor(
          brand: String?,
          model: String?,
          modelYear: String?,
          sellerName: String?,
          details: String?,
          images: List<String>?,
          urlImage: String?,
          mills: Int?,
          ger: Int?,
          status: Int?,
          liked: Boolean?,
          price: Double?,
          color: String?,
          numberOfDoors: Int?,
          pushType: Int?,
     ) {
          this.brand = brand
          this.model = model
          this.modelYear = modelYear
          this.sellerName = sellerName
          this.details = details
          this.images = images
          this.urlImage = urlImage
          this.mills = mills
          this.ger = when (ger) {
              0 -> {
                   Ger.NORMAL
              }
              else -> {
                   Ger.AUTOMATIC
              }
          }
          this.status = when (status) {
              0 -> {
                   Status.GOOD
              }
              1 -> {
                   Status.VERY_GOOD
              }
              else -> Status.EXCELLENT
          }
          this.liked = liked
          this.price = price
          this.color = color
          this.trimType = when (numberOfDoors){
               0->Trims.TWO_DOORS
               else->Trims.FOUR_DOORS
          }
          this.pushType = when(pushType){
               0->PushTypes.TWO_WHEEL
               else->PushTypes.FOURTH_WHEEL
          }
     }


     enum class Ger{
          AUTOMATIC,NORMAL
     }
     enum class Status{
          EXCELLENT,VERY_GOOD,GOOD,
     }
     enum class Trims{
          TWO_DOORS,FOUR_DOORS,SEDAN
     }
     enum class PushTypes{
          TWO_WHEEL,FOURTH_WHEEL
     }


     companion object{
          @JvmStatic
          @BindingAdapter("setImg")
          fun setImg(imageView: ImageView,img: Int){
               imageView.setImageResource(img)
          }
          @JvmStatic
          @BindingAdapter("setImgUrl")
          fun setImgUrl(imageView: ImageView,imgUrl: String){
               Picasso.get().load(imgUrl).placeholder(R.drawable.progress_animation)
                    .error(android.R.color.holo_red_dark).into(imageView)
          }
     }

}