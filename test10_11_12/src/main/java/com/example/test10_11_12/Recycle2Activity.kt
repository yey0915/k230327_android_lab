package com.example.test10_11_12

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.adapter.MyAdapter
import com.example.test10_11_12.adapter.MyAdapter2
import com.example.test10_11_12.databinding.ActivityRecycle2Binding
import com.example.test10_11_12.databinding.ActivityRecycleBinding

class Recycle2Activity : AppCompatActivity() {
    lateinit var binding : ActivityRecycle2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRecycle2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        

        val datas = mutableListOf<String>()
        for(i in 1..20){
            datas.add("Item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter2(datas)

        binding.recyclerView.addItemDecoration(MyDecoration(this))
//        binding.recyclerView.addItemDecoration(
//            DividerItemDecoration(this,
//                LinearLayoutManager.VERTICAL)
//        )
    }

    class MyDecoration(val context: Context): RecyclerView.ItemDecoration() {
        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
            c.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.a3), 0f,0f,null);
        }

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)
            //뷰 사이즈 계산
            val width = parent.width
            val height = parent.height
            //이미지 사이즈 계산
            val dr: Drawable? = ResourcesCompat.getDrawable(context.getResources(), R.drawable.a2, null)
            val drWidth = dr?.intrinsicWidth
            val drHeight = dr?.intrinsicHeight
            //이미지가 그려질 위치 계산
            val left = width / 2 - drWidth?.div(2) as Int
            val top = height / 2 - drHeight?.div(2) as Int
//            c.drawBitmap(
//                BitmapFactory.decodeResource(context.getResources(), R.drawable.a4),
//                left.toFloat(),
//                top.toFloat(),
//                null
//            )

        }

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            val index = parent.getChildAdapterPosition(view) + 1

            if (index % 3 == 0) //left, top, right, bottom
                outRect.set(10, 10, 10, 60)
            else
                outRect.set(10, 10, 10, 0)

            view.setBackgroundColor(Color.LTGRAY)
            ViewCompat.setElevation(view, 20.0f)

        }
    }
}