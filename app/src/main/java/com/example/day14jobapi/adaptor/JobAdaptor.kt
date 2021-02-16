package com.example.day14jobapi.adaptor

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.day14jobapi.R
import com.example.day14jobapi.databinding.JobRecyclerBinding
import com.example.day14jobapi.model.JobResponse
import com.example.day14jobapi.view.MainActivity
import com.example.day14jobapi.view.SearchFragment

class JobAdaptor(val jobResponseList: JobResponse) : RecyclerView.Adapter<JobAdaptor.JobViewHolder>() {

    lateinit var binding: JobRecyclerBinding

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdaptor.JobViewHolder {
        // Create a new view, which defines the UI of the list item
        binding = JobRecyclerBinding.inflate(LayoutInflater.from(parent.context))

        return JobViewHolder(binding)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return jobResponseList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: JobAdaptor.JobViewHolder, position: Int) {

        holder.setTextViews(jobResponseList[position].title,jobResponseList[position].company,jobResponseList[position].location)
        holder.setImageUrl(jobResponseList[position].company_url)

        /*
            createdAt: String,
    type: String,
    jobUrl: String,
    company: String,
    companyUrl: String,
    title: String,
    location: String,
    description: String



         */


        holder.jobIntentForFragment(jobResponseList[position].created_at,
            jobResponseList[position].type,
            jobResponseList[position].url,
            jobResponseList[position].company,
            jobResponseList[position].company_url,
            jobResponseList[position].title,
            jobResponseList[position].location,
            jobResponseList[position].description,
            jobResponseList[position].how_to_apply
            )
    }

    class JobViewHolder(private val binding: JobRecyclerBinding ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {





        fun setTextViews(title: String, company:String, location:String){

            binding.nameText.text = company
            binding.titleText.text = title
            binding.locationText.text = location

            initViews()

            //binding.companyUrlText.text= companyUrl
        }

        fun initViews(){
            binding.button.setOnClickListener(this)
           /* binding.titleText.setOnClickListener(this)
            binding.locationText.setOnClickListener(this)*/

            //binding.companyUrlText.setOnClickListener(this)

        }



        fun setImageUrl(logoUrl: String){

            //GlideToVectorYou.justLoadImage(activity, IMAGE_URI, targetImageView)
            //GlideToVectorYou.justLoadImage(binding.root, logoUrl, binding.flagImage);

           Glide.with(binding.root)
                .load(logoUrl)
                .into(binding.logoImage)
        }

        fun jobIntentForFragment(createdAt: String, type: String, jobUrl: String, company: String, companyUrl: String, title: String, location: String, description : String, how_to_apply:String){

            val intent = Intent(binding.root.context,SearchFragment::class.java)
            intent.putExtra("title", title)
            intent.putExtra("createdAt",createdAt)
            intent.putExtra("type",type)
            intent.putExtra("jobUrl",jobUrl)
            intent.putExtra("company",company)
            intent.putExtra("location",location)
            intent.putExtra("description",description)
            intent.putExtra("companyUrl",companyUrl)
            intent.putExtra("how_to_apply",how_to_apply)

            startActivity(binding.root.context)


        }


        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        override fun onClick(view: View?) {

            if (view != null) {
                /*if (view.id == R.id.companyUrlText){
                    var intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(binding.companyUrlText.text.toString())
                    )

                }*/

                if (view.id == R.id.button){

                    val intent = Intent(binding.root.context,SearchFragment::class.java)
                    startActivity(intent)
                }




            }
        }

        fun goToLocationOnMap(longitude: Float, latitdue: Float ){

        }

    }
}