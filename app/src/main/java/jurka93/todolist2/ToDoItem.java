package jurka93.todolist2;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "ToDoItems")
public class ToDoItem extends Model {
    @Column(name = "item")
    public String data;

    public ToDoItem() {
        super();
    }

    public ToDoItem(String s) {
        super();
        data = s;
    }

    String getText() {
        return data;
    }

    void setText(String text) {
        data = text;
    }
}
