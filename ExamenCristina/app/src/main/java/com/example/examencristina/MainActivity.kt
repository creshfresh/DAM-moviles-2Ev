package com.example.examencristina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.data.database.Database
import com.example.data.database.StudentEntity
import com.example.data.database.toDataBase
import com.example.examencristina.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var room : Database
    private lateinit var adapter: StudentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        room = Room.databaseBuilder(this, Database::class.java, "students").build()
        setContentView(binding.root)


        fillDatabase()
        initUi()
    }


private fun searchAll(){

    binding.progressBar.isVisible = true

    CoroutineScope(Dispatchers.IO).launch {

        val myResponse : List<StudentEntity> =
            room.gestStudentDato().getAll()
        Log.i("Boton todos",myResponse.toString())
        runOnUiThread {
            adapter.updateList(myResponse)
            binding.progressBar.isVisible = false;
        }

    }
}
    private fun searchFail() {
        binding.progressBar.isVisible = true

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse : List<StudentEntity> =
                room.gestStudentDato().getselectFail()
            runOnUiThread { adapter.updateList(myResponse)
                binding.progressBar.isVisible = false;
        }
    }}
    private fun searchPass () {
        binding.progressBar.isVisible = true

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse : List<StudentEntity> =
                room.gestStudentDato().getselectPass()
            runOnUiThread { adapter.updateList(myResponse)
                binding.progressBar.isVisible = false;
            }
        }
    }
    private fun initUi() {
        adapter = StudentAdapter()
        binding.rvStudents.setHasFixedSize(true)
        binding.rvStudents.layoutManager = LinearLayoutManager(this)
        binding.rvStudents.adapter = adapter

        CoroutineScope(Dispatchers.IO).launch {
            val listEntity: List<StudentEntity> = room.gestStudentDato().getAll()
            runOnUiThread { adapter.updateList(listEntity)
                binding.progressBar.isVisible = false
            }
        }
        binding.tvHeaderStudent.setOnClickListener(){
            searchAll()
}
        binding.tvFail.setOnClickListener(){
            searchFail()
        }
        binding.tvPass.setOnClickListener(){
            searchPass()
        }
    }

    private fun fillDatabase(){

        //LLenar una lista de students
        CoroutineScope(Dispatchers.IO).launch {
            val names: List<String> = listOf(
                "Briseida", "Anacleto", "Macaria", "Uldarico", "Pascasia",
                "Inolfo", "Pancracio", "Espaminondo", "Gervasio", "Patrocinio", "Hermenegilda",
                "Crescencio", "Cristobalina", "Agapito", "Tesifonte", "Petronila", "Torcuato",
                "Vitorio", "Isidra", "Sibilia", "Ambrosio", "Delfina", "Tiburcio", "Margarito",
                "Filemón", "Crisóloga", "Casimiro", "Cananea", "Felipa", "Cojoncio"
            )
            val grades: List<Double> = listOf(
                5.2, 4.3, 9.8, 6.7, 7.8, 5.0, 8.9, 9.7, 10.0, 2.3,
                3.5, 6.4, 8.4, 9.2, 1.3, 4.9, 5.7, 6.2, 8.5, 9.9, 2.5, 4.6, 5.8, 9.7, 6.8, 8.2,
                8.9, 6.4, 4.0, 10.0
            )

            val studentProvider = mutableListOf<Student>()

            //Llenar la lista de studentProvider
            for (i in names.indices) {
                studentProvider.add(Student(names[i], grades[i]))
            }
            //LLenar room con esa lista
            if (studentProvider.isNotEmpty()) {
                Log.i("", studentProvider.toString())
                CoroutineScope(Dispatchers.IO).launch {
                    room.gestStudentDato().deleteAll()
                    room.gestStudentDato().insertAll(studentProvider.map { it.toDataBase() })
                    Log.i("", room.gestStudentDato().getAll().toString())
                }
            }
        }
        }

}