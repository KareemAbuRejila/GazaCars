package ps.aio.gazacars.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.ItemCarImageBinding
import ps.aio.gazacars.databinding.ItemIntroBinding
import ps.aio.gazacars.models.IntroItem


class AdapterIntroViewPager2 : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var mContext: Context? = null
    private var items: List<IntroItem>? = ArrayList()
    private var carImages: List<String>? = ArrayList()

    constructor(carImages: List<String>) : super() {
        this.carImages = carImages
    }

    constructor(mContext: Context?, items: List<IntroItem>?) : super() {
        this.mContext = mContext
        this.items = items
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (items!!.isNotEmpty()) {
            val itemIntroBinding = ItemIntroBinding.inflate(inflater, parent, false)
            IntroItemHolder(itemIntroBinding)
        } else {
            val itemCarImageBinding = ItemCarImageBinding.inflate(inflater, parent, false)
            CarImageItemHolder(itemCarImageBinding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items!!.isNotEmpty()) {
            (holder as IntroItemHolder).bind(item = items!![position])
        } else {
            (holder as CarImageItemHolder).bind(carImage = carImages!![position])


        }

    }

    override fun getItemCount(): Int {
        return when {
            items!!.isNotEmpty() -> {
                items?.size!!
            }
            carImages!!.isNotEmpty() -> {
                carImages?.size!!
            }
            else -> 0
        }
    }

    inner class IntroItemHolder(private val itemIntroBinding: ItemIntroBinding) :
        RecyclerView.ViewHolder(itemIntroBinding.root) {
        fun bind(item: IntroItem) {
            itemIntroBinding.introItem = item
            itemIntroBinding.executePendingBindings()
        }
    }

    inner class CarImageItemHolder(private val itemCarImageBinding: ItemCarImageBinding) :
        RecyclerView.ViewHolder(itemCarImageBinding.root) {
        fun bind(carImage: String) {
//            itemCarImageBinding.carImageUrl=carImage
            Picasso.get().load(carImage).placeholder(R.color.grayStroke)
                .into(itemCarImageBinding.carImageItem)

            var scalFactore=1.0f
            val scaleGestureDetector=ScaleGestureDetector(itemCarImageBinding.root.context,
            object : SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector?): Boolean {
                    scalFactore=detector?.scaleFactor!!
                    scalFactore= 0.1f.coerceAtLeast(scalFactore.coerceAtMost(10.0f))
                    itemCarImageBinding.carImageItem.scaleX=scalFactore
                    itemCarImageBinding.carImageItem.scaleY=scalFactore
                    return true
                }
            })
            itemCarImageBinding.root.setOnTouchListener { v, event ->
                scaleGestureDetector.onTouchEvent(event)
                true
            }

            itemCarImageBinding.executePendingBindings()
        }
    }


}