package com.trojans.iwannabe.onboarding

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.trojans.iwannabe.R
import com.trojans.iwannabe.data.Domain
import com.trojans.iwannabe.data.Domains
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class BubblesAdapter(private val context: Context, private val domains: List<Domain>) :
    RecyclerView.Adapter<BubbleViewHolder>() {

    val selectedOptions = arrayListOf<String>()

    @RequiresApi(Build.VERSION_CODES.M)
    private val onClickListener = View.OnClickListener { view ->
        view.foreground = context.getDrawable(R.drawable.ic_done)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BubbleViewHolder =
        BubbleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bubble, parent, false))

    override fun onBindViewHolder(holder: BubbleViewHolder, position: Int) {
        holder.textView.text = domains[position].name
        Picasso.get()
            .load(getBubbleDrawableRes(domains[position].name))
            .fit()
            .transform(CropCircleTransformation())
            .into(holder.imageView)

        holder.imageView.setOnClickListener(onClickListener, holder.textView.text as String)
    }

    override fun getItemCount() = domains.size

    private fun getBubbleDrawableRes(name: String): Int {
        return when {
            name.contains(Domains.Engineering.name) -> R.drawable.engineering
            name.contains(Domains.Medicine.name) -> R.drawable.physics
            name.contains(Domains.Sports.name) -> R.drawable.sports
            name.contains(Domains.Mathematics.name) -> R.drawable.mathematics
            name.contains(Domains.Literature.name) -> R.drawable.literature
            name.contains(Domains.Physics.name) -> R.drawable.physics
            name.contains(Domains.Programming.name) -> R.drawable.programming
            name.contains(Domains.Acting.name) -> R.drawable.acting
            name.contains(Domains.Music.name) -> R.drawable.music
            name.contains("Video games") -> R.drawable.video_games
            name.contains("Reading books") -> R.drawable.reading
            name.contains("Cooking") -> R.drawable.cooking
            name.contains("Party") -> R.drawable.party
            name.contains("Very active") -> R.drawable.very_active
            name.contains("Medium") -> R.drawable.active
            name.contains("A little") -> R.drawable.sedentar
            else -> R.drawable.question
        }
    }

    private fun ImageView.setOnClickListener(onClickListener: View.OnClickListener, text: String) {
        setOnClickListener(onClickListener)
        selectedOptions.add(text)
    }
}
