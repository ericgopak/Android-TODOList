package jurka93.todolist2;

import android.preference.PreferenceActivity;
import android.os.Bundle;


public class MyPreferenceActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings); // TODO: do not use deprecated functions

//        MyPersistedClass aClass = new MyPersistedClass();
//        aClass.setDescription(textView.getText().toString());
//        aClass.save(); // To save or update
//
//        new Select().from(MyPersistedClass.class).execute(); // To Select all
    }
}
