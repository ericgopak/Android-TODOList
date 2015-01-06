package jurka93.todolist2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private int itemPosition = -1;
    private ToDoItem itemCopy;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        itemPosition = intent.getIntExtra("ITEM_POSITION", -1);
        itemCopy = MainActivity.listViewAdapter.getItem(itemPosition);
        TextView textDetails = (TextView) findViewById(R.id.textDetails);
        textDetails.setText(itemCopy.getText());

        // On button click - remove item, finish activity
        Button removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.listViewAdapter.deleteItem(itemPosition);
                finish();
            }
        });

        Button shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Message Body");
                startActivity(sharingIntent);
            }
        });
    }
}
