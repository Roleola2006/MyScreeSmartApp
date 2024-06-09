package za.ac.iie.myscreensmart

import android.content.Intent

import android.os.Bundle

import android.widget.Button

import android.widget.EditText

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {

    private val dates = ArrayList<String>()

    private val morningScreenTimes = ArrayList<Int>()

    private val afternoonScreenTimes = ArrayList<Int>()

    private val activityNotes = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val dateEditText = findViewById<EditText>(R.id.dateEditText)

        val morningScreenTimeEditText = findViewById<EditText>(R.id.morningScreenTimeEditText)

        val afternoonScreenTimeEditText = findViewById<EditText>(R.id.afternoonScreenTimeEditText)

        val activityNotesEditText = findViewById<EditText>(R.id.activityNotesEditText)

        val addButton = findViewById<Button>(R.id.addButton)

        val clearButton = findViewById<Button>(R.id.clearButton)

        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)


        addButton.setOnClickListener {

            val date = dateEditText.text.toString()

            val morningScreenTime = morningScreenTimeEditText.text.toString().toIntOrNull()

            val afternoonScreenTime = afternoonScreenTimeEditText.text.toString().toIntOrNull()

            val activityNote = activityNotesEditText.text.toString()



            if (date.isNotEmpty() && morningScreenTime != null && afternoonScreenTime != null && activityNote.isNotEmpty()) {

                dates.add(date)

                morningScreenTimes.add(morningScreenTime)

                afternoonScreenTimes.add(afternoonScreenTime)

                activityNotes.add(activityNote)

                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()

                clearFields(dateEditText, morningScreenTimeEditText, afternoonScreenTimeEditText, activityNotesEditText)

            } else {

                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()

            }

        }

//The code that is commented out below will clear all data saved in the arraylists!

        clearButton.setOnClickListener {

            //dates.clear()

            // morningScreenTimes.clear()

            //afternoonScreenTimes.clear()

            // activityNotes.clear()

            // Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()

            clearFields(dateEditText, morningScreenTimeEditText, afternoonScreenTimeEditText, activityNotesEditText)



        }

        class DetailedViewActivity {

        }

        viewDetailsButton.setOnClickListener {

            val intent = Intent(this, DetailedViewActivity::class.java)

            intent.putStringArrayListExtra("dates", dates)

            intent.putIntegerArrayListExtra("morningScreenTimes", morningScreenTimes)

            intent.putIntegerArrayListExtra("afternoonScreenTimes", afternoonScreenTimes)

            intent.putStringArrayListExtra("activityNotes", activityNotes)

            startActivity(intent)

        }

    }



    private fun clearFields(vararg fields: EditText) {

        for (field in fields) {

            field.text.clear()

        }

    }

}





