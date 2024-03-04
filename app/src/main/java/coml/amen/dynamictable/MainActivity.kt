package coml.amen.dynamictable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonAdd: Button = findViewById(R.id.btnAdd)

        buttonAdd.setOnClickListener {
            var resourceName = findViewById<EditText>(R.id.water_resource_name)
            var locName = findViewById<EditText>(R.id.water_resource_location)
            var typeName = findViewById<EditText>(R.id.water_resource_type)
            if (resourceName.text.isBlank() || locName.text.isBlank() || typeName.text.isBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
            }
            else{
                addRow(resourceName.text.toString(), locName.text.toString(), typeName.text.toString())
                resourceName.setText("")
                locName.setText("")
                typeName.setText("")
            }

        }
    }
    fun addRow( resourceName:String, location:String, type:String){
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val tableRow = TableRow(this)

        val layoutParams = TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(1, 1, 1, 1)
        tableRow.layoutParams = layoutParams
        tableRow.setBackgroundResource(R.drawable.table_border)
        tableRow.setBackgroundResource(R.drawable.vertical_border)

        val nameTextView = TextView(this)
        nameTextView.text = resourceName
        nameTextView.gravity = Gravity.CENTER
        nameTextView.setPadding(5, 5, 5, 5)

        val locationTextView = TextView(this)
        locationTextView.text = location
        locationTextView.gravity = Gravity.CENTER
        locationTextView.setPadding(5, 5, 5, 5)

        val typeTextView = TextView(this)
        typeTextView.text = type
        typeTextView.gravity = Gravity.CENTER
        typeTextView.setPadding(5, 5, 5, 5)

        tableRow.addView(nameTextView)
        tableRow.addView(locationTextView)
        tableRow.addView(typeTextView)

        tableLayout.addView(tableRow)
    }
}