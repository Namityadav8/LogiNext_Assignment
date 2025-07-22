package com.example.loginext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val containerLayout = view.findViewById<LinearLayout>(R.id.order_container)
        val orders = listOf(
            FoodItem("Pizza", 8.99, R.drawable.ic_launcher_foreground),
            FoodItem("Burger", 5.49, R.drawable.ic_launcher_foreground),
            FoodItem("Sushi", 12.99, R.drawable.ic_launcher_foreground)
        )
        orders.forEach { item ->
            val tv = TextView(context)
            tv.text = "🍴 ${item.name} - $${item.price}"
            tv.textSize = 16f
            tv.setPadding(0, 8, 0, 8)
            containerLayout.addView(tv)
        }
        val total = orders.sumOf { it.price }
        val tvTotal = TextView(context)
        tvTotal.text = "🎉 Total: $${"%.2f".format(total)}"
        tvTotal.textSize = 18f
        tvTotal.setPadding(0, 16, 0, 16)
        containerLayout.addView(tvTotal)

        val btn = view.findViewById<Button>(R.id.btn_place_order)
        btn.setOnClickListener {
            Snackbar.make(view, "✅ Order placed!", Snackbar.LENGTH_SHORT).show()
        }
    }
}
