package ps.aio.gazacars.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ps.aio.gazacars.databinding.*
import ps.aio.gazacars.models.CarModel
import ps.aio.gazacars.models.NotificationModel

class AdapterHomeRv : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var VIEW_TYPE:Int=0
    val POP_TYPE:Int=1
    val Latest_TYPE=2
    val Con_TYPE=3
    val Notification_TYPE=4
    val MY_SALES_TYPE=5
    val MY_Purchases_TYPE=6

    private var popCars:List<CarModel>?=ArrayList()
    private var itemCarListener:ItemCarListener?=null
    private var latestCars:List<CarModel>?=ArrayList()
    private var conCars:List<CarModel>?=ArrayList()
    private var notifications:List<NotificationModel>?=ArrayList()



    interface ItemCarListener{
        fun onCarClicked(carModel: CarModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return when(VIEW_TYPE){
            POP_TYPE->{
                ItemPopHolder(ItemPopularBinding.inflate(inflater))
            }
            Latest_TYPE->{
                ItemLatestHolder(ItemLatestBinding.inflate(inflater))
            }
            Con_TYPE->{
                ItemConHolder(ItemConBinding.inflate(inflater))
            }
            else -> {
                ItemNotificationHolder(ItemNotificationBinding.inflate(inflater))
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(VIEW_TYPE){
            POP_TYPE->{
                (holder as ItemPopHolder).bind(popCars!![position])
            }
            Latest_TYPE->{
                (holder as ItemLatestHolder).bind(latestCars!![position])
            }
            Con_TYPE->{
                (holder as ItemConHolder).bind(conCars!![position])
            }
            else -> {
                (holder as ItemNotificationHolder).bind(notifications!![position])

            }
        }
    }
    override fun getItemCount(): Int {
        return when(VIEW_TYPE){
            POP_TYPE->popCars!!.size
            Latest_TYPE->latestCars!!.size
            Con_TYPE->conCars!!.size
            Notification_TYPE->notifications!!.size
            else->0
        }
    }

    fun setViewType(viewType:Int){
        this.VIEW_TYPE=viewType
        notifyDataSetChanged()
    }
    fun setPopList(popCars:List<CarModel>){
        this.popCars=popCars
        notifyDataSetChanged()
    }
    fun setLatestList(latestCars:List<CarModel>){
        this.latestCars=latestCars
        notifyDataSetChanged()
    }
    fun setConList(conCars:List<CarModel>){
        this.conCars=conCars
        notifyDataSetChanged()
    }
    fun setNotiList(notifications:List<NotificationModel>){
        this.notifications=notifications
        notifyDataSetChanged()
    }

    fun setOnItemCarListener(itemCarListener: ItemCarListener){
        this.itemCarListener=itemCarListener
    }

    inner class ItemPopHolder(private val popularBinding: ItemPopularBinding)
        : RecyclerView.ViewHolder(popularBinding.root){
        fun bind(carModel: CarModel){
            popularBinding.car=carModel

            popularBinding.root.setOnClickListener {
                if (adapterPosition!=RecyclerView.NO_POSITION&& itemCarListener!=null){
                    itemCarListener?.onCarClicked(carModel = carModel)
                }
            }

            popularBinding.executePendingBindings()
        }

    }
    inner class ItemLatestHolder(private val latestBinding: ItemLatestBinding)
        : RecyclerView.ViewHolder(latestBinding.root){
        fun bind(carModel: CarModel){
            latestBinding.car=carModel
            latestBinding.executePendingBindings()
        }

    }
    inner class ItemConHolder(private val conBinding: ItemConBinding)
        : RecyclerView.ViewHolder(conBinding.root){

        fun bind(carModel: CarModel){
            conBinding.car=carModel
            conBinding.executePendingBindings()
        }

    }

    inner class ItemNotificationHolder(private val itemNotificationBinding: ItemNotificationBinding)
        :RecyclerView.ViewHolder(itemNotificationBinding.root){

        fun bind(notificationModel: NotificationModel){
            itemNotificationBinding.notificationModel=notificationModel
            itemNotificationBinding.executePendingBindings()
        }
    }
}