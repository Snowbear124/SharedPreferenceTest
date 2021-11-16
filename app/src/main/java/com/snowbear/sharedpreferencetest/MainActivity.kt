package com.snowbear.sharedpreferencetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but_save = findViewById<Button>(R.id.but_save)
        val but_read = findViewById<Button>(R.id.but_read)
        val but_delete = findViewById<Button>(R.id.but_delete)

        val edit_1 = findViewById<EditText>(R.id.edit_1)
        val edit_2 = findViewById<EditText>(R.id.edit_2)
        val edit_3 = findViewById<EditText>(R.id.edit_3)

        val but_data_1 = findViewById<Button>(R.id.but_data_1)
        val but_data_2 = findViewById<Button>(R.id.but_data_2)
        val but_data_3 = findViewById<Button>(R.id.but_data_3)
        val tV_dataName = findViewById<TextView>(R.id.tV_data_name)

        val dataName_1 = "Data 1"
        val dataName_2 = "Data 2"
        val dataName_3 = "Data 3"

        //設定要存取的SharedPreferences資料名稱與模式，模式呼叫系統內建的MODE
        //一般常用MODE_PRIVATE，意思是這些資料只有這著APP可以使用
//        val shareData1 = getSharedPreferences("DataItem", MODE_PRIVATE)
//        shareData1
//            .edit()     //設定編輯器(輸入資料用)
//            .putString("key1", "data1") //設定寫入的資料型態
//            .apply()    //執行上述的設定
//
//        shareData1.edit().putBoolean("first_lognin", true).apply()   //這是判斷APP是否第一次登入

//        Log.d(TAG, "key1: " + shareData1.getString("key1", null))
//        Log.d(TAG, "first_lognin: " + shareData1.getBoolean("first_lognin", false))

        val shareData1 = getSharedPreferences("Data_1", MODE_PRIVATE)
        val shareData2 = getSharedPreferences("Data_2", MODE_PRIVATE)
        val shareData3 = getSharedPreferences("Data_3", MODE_PRIVATE)

        but_save.setOnClickListener {
            Log.d(TAG, "Save button test.")
            if(tV_dataName.text == dataName_1) {
                Log.d(TAG, "Data 1 save.")
                shareData1.edit()
                    .putString("Item_1", edit_1.text.toString())
                    .putString("Item_2", edit_2.text.toString())
                    .putString("Item_3", edit_3.text.toString())
                    .apply()

            }else if(tV_dataName.text == dataName_2) {
                Log.d(TAG, "Data 2 save.")
                shareData2.edit()
                    .putString("Item_1", edit_1.text.toString())
                    .putString("Item_2", edit_2.text.toString())
                    .putString("Item_3", edit_3.text.toString())
                    .apply()

            }else if(tV_dataName.text == dataName_3) {
                Log.d(TAG, "Data 3 save.")
                shareData3.edit()
                    .putString("Item_1", edit_1.text.toString())
                    .putString("Item_2", edit_2.text.toString())
                    .putString("Item_3", edit_3.text.toString())
                    .apply()
            }

        }

        but_read.setOnClickListener {
            Log.d(TAG, "Data 1: edit_1 = " + shareData1.getString("Item_1", null))
            Log.d(TAG, "Data 1: edit_2 = " + shareData1.getString("Item_2", null))
            Log.d(TAG, "Data 1: edit_3 = " + shareData1.getString("Item_3", null))
            Log.d(TAG, "Data 2: edit_1 = " + shareData2.getString("Item_1", null))
            Log.d(TAG, "Data 2: edit_2 = " + shareData2.getString("Item_2", null))
            Log.d(TAG, "Data 2: edit_3 = " + shareData2.getString("Item_3", null))
            Log.d(TAG, "Data 3: edit_1 = " + shareData3.getString("Item_1", null))
            Log.d(TAG, "Data 3: edit_2 = " + shareData3.getString("Item_2", null))
            Log.d(TAG, "Data 3: edit_3 = " + shareData3.getString("Item_3", null))
        }

        but_delete.setOnClickListener {
            edit_1.setText("")
            edit_2.setText("")
            edit_3.setText("")
        }

        but_data_1.setOnClickListener {
            val editText_1 = shareData1.getString("Item_1", null)
            val editText_2 = shareData1.getString("Item_2", null)
            val editText_3 = shareData1.getString("Item_3", null)

            tV_dataName.setText(dataName_1)
            edit_1.setText(editText_1)
            edit_2.setText(editText_2)
            edit_3.setText(editText_3)
        }

        but_data_2.setOnClickListener {
            val editText_1 = shareData2.getString("Item_1", null)
            val editText_2 = shareData2.getString("Item_2", null)
            val editText_3 = shareData2.getString("Item_3", null)

            tV_dataName.setText(dataName_2)
            edit_1.setText(editText_1)
            edit_2.setText(editText_2)
            edit_3.setText(editText_3)
        }

        but_data_3.setOnClickListener {
            val editText_1 = shareData3.getString("Item_1", null)
            val editText_2 = shareData3.getString("Item_2", null)
            val editText_3 = shareData3.getString("Item_3", null)

            tV_dataName.setText(dataName_3)
            edit_1.setText(editText_1)
            edit_2.setText(editText_2)
            edit_3.setText(editText_3)
        }
    }
}