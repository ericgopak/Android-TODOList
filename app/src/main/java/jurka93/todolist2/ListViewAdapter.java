package jurka93.todolist2;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ToDoItem> {

    public ListViewAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    private void deleteItem(View v) {
        int position = (int)v.getTag();
        deleteItem(position);
    }

    public void deleteItem(int position) {
        if (position < 0 || position >= getCount())
            return;

        // Remove from ListView
        ToDoItem item = getItem(position);
        remove(item);
        notifyDataSetChanged();

        // Delete from DB
        item.delete();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_element, parent, false);
            vh.putViewFromParent(convertView, R.id.textView);
            vh.putViewFromParent(convertView, R.id.deleteButton);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Button deleteButton = vh.<Button>get(R.id.deleteButton);
        deleteButton.setTag(position);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(v);
            }
        });

        ToDoItem item = getItem(position);
        vh.<TextView>get(R.id.textView).setText(item.getText());

        return convertView;
    }

    public class ViewHolder {

        private SparseArray<View> holder = new SparseArray<View>();

        public <T extends View> T get(Integer id) {
            return (T) holder.get(id);
        }

        public void put(View view) {
            put(view, view.getId());
        }

        public void put(View view, Integer id) {
            holder.put(id, view);
        }

        public void putViewFromParent(View parent, Integer id) {
            View view = parent.findViewById(id);
            put(view, id);
        }

        public void clear() {
            holder.clear();
        }
    }
}