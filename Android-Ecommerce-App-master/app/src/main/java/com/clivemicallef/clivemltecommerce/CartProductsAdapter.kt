package com.clivemicallef.clivemltecommerce

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.clivemicallef.clivemltecommerce.model.CartProduct
import com.clivemicallef.clivemltecommerce.model.Product
import com.squareup.picasso.Picasso

class CartProductsAdapter(private val products: List<CartProduct>) : RecyclerView.Adapter<CartProductsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: CartProductsAdapter.ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(product.imageUrl).into(holder.image)
        holder.title.text = product.name
        holder.price.text = product.price.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, ProductDetailsActivity::class.java)
            intent.putExtra("title", products[holder.adapterPosition].name)
            intent.putExtra("photo_url", products[holder.adapterPosition].imageUrl)
            intent.putExtra("price", products[holder.adapterPosition].price.toString())
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount() = products.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}