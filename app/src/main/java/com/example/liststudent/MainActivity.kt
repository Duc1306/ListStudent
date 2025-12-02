package com.example.liststudent

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val students = mutableListOf<Student>()
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        listView = findViewById(R.id.listView)

        adapter = StudentAdapter(this, students, object : StudentAdapter.OnStudentClick {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, StudentDetailActivity::class.java)
                intent.putExtra("student", students[position])
                intent.putExtra("index", position)
                startActivityForResult(intent, 200)
            }

            override fun onDelete(position: Int) {
                students.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        })

        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, 100)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) return

        when (requestCode) {
            100 -> {
                val s = data?.getSerializableExtra("student") as Student
                students.add(s)
                adapter.notifyDataSetChanged()
            }
            200 -> {
                val updated = data?.getSerializableExtra("student") as Student
                val index = data.getIntExtra("index", -1)
                if (index != -1) {
                    students[index] = updated
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
