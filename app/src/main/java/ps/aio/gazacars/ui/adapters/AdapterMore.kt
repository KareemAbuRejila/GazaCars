package ps.aio.gazacars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.aio.gazacars.databinding.*
import ps.aio.gazacars.models.CarModel

class AdapterMore : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        val POP_TYPE = 1
        val LATEST_TYPE = 2
        val CON_TYPE = 3
        val GALLERY_TYPE=4
    }
    var HOLDER_TYPE = 0
    private var cars: List<CarModel>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (HOLDER_TYPE) {
            POP_TYPE -> ItemPopMoreHolder(ItemPopularMBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
            LATEST_TYPE -> ItemLATESTMoreHolder(ItemLatestMBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
            CON_TYPE -> ItemConMoreHolder(ItemConMBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
            else-> ItemCarGalleryHolder(ItemCarForGalleryBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (HOLDER_TYPE) {
            POP_TYPE -> (holder as ItemPopMoreHolder).bind(carModel = cars!![position])
            LATEST_TYPE -> (holder as ItemLATESTMoreHolder).bind(carModel = cars!![position])
            CON_TYPE -> (holder as ItemConMoreHolder).bind(carModel = cars!![position])
            else -> (holder as ItemCarGalleryHolder).bind(carModel = cars!![position])

        }
    }

    override fun getItemCount(): Int {
        return cars?.size!!
    }

    fun setHolderType(type:Int){
        this.HOLDER_TYPE=type
    }

    fun setList(cars: List<CarModel>) {
        this.cars = cars
        notifyDataSetChanged()
    }

    inner class ItemPopMoreHolder(private val itemPopularMBinding: ItemPopularMBinding) :
        RecyclerView.ViewHolder(itemPopularMBinding.root) {
        fun bind(carModel: CarModel) {
            itemPopularMBinding.car = carModel
            itemPopularMBinding.executePendingBindings()
        }
    }

    inner class ItemLATESTMoreHolder(private val itemLatestMBinding: ItemLatestMBinding) :
        RecyclerView.ViewHolder(itemLatestMBinding.root) {

        fun bind(carModel: CarModel) {
            itemLatestMBinding.car = carModel
            itemLatestMBinding.executePendingBindings()
        }
    }

    inner class ItemConMoreHolder(private val itemConMBinding: ItemConMBinding) :
        RecyclerView.ViewHolder(itemConMBinding.root) {

        fun bind(carModel: CarModel) {
            itemConMBinding.car = carModel
            itemConMBinding.executePendingBindings()
        }
    }

    inner class ItemCarGalleryHolder(private val itemCarForGalleryBinding: ItemCarForGalleryBinding) :
        RecyclerView.ViewHolder(itemCarForGalleryBinding.root) {

        fun bind(carModel: CarModel) {
            itemCarForGalleryBinding.car = carModel
            itemCarForGalleryBinding.executePendingBindings()
        }
    }
}