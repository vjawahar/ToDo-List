package varsha.jawahar.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        saveButton.setOnClickListener{
            var title : String = ""

            if(importantCheckBox.isChecked){
                title = "❗️" + titleEditText.text.toString()
            }

            else {
                title = titleEditText.text.toString()
            }


            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)

            //Check if there's anything in shared preferences
            //If there is, get those. Else create a new set

            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf())?.toMutableSet()


            if (todos != null) todos.add(title)
            prefs.edit().putStringSet("todostrings", todos).apply()

            finish()
        }
    }
}
