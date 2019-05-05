# UI3
## UI3_ListView/AlertDialog/XMLMenu/ActionMode
## ListView
~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Simple_Adapter">

    <ListView
        android:id="@+id/mylist"
        android:layout_width="match_parent"
        android:layout_height="734dp"/>
</LinearLayout>
~~~

~~~
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.widget.AdapterView.OnItemClickListener;

public class Simple_Adapter extends Activity {
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            { R.drawable.lion , R.drawable.tiger , R.drawable.monkey ,
                    R.drawable.dog , R.drawable.cat , R.drawable.elephant};
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("personName", names[i]);
            listItem.put("header", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simple_item,
                new String[] { "personName" , "header" },
                new int[] { R.id.name ,R.id.header });
        ListView list = (ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getApplicationContext(), names[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}

![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/Sample_Adapter_result.png)
~~~
## AlertDialog
~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/header_logo" />

    <EditText
        android:id="@+id/username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="UserName"
        android:inputType="textPersonName" />

    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:ems="10"
        android:hint="Password"
        android:inputType="textPassword" />

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btn_login"
            android:layout_width="190dp"
            android:layout_height="wrap_content"
            android:text="Cancel" />

        <Button
            android:id="@+id/btn_cancel"
            android:layout_width="202dp"
            android:layout_height="wrap_content"
            android:text="sign in" />
    </LinearLayout>
</LinearLayout>
~~~

~~~
        // 创建对话框构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 获取布局
        View view = View.inflate(Alert_Dialog.this, R.layout.alert_view, null);
        // 获取布局中的控件
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        final EditText username = (EditText) view.findViewById(R.id.username);
        final EditText password = (EditText) view.findViewById(R.id.password);
        final Button button1 = (Button) view.findViewById(R.id.btn_login);
        final Button button2 = (Button) view.findViewById(R.id.btn_cancel);
        // 设置参数
        builder.setTitle("Login").setView(view);
        // 创建对话框
        final AlertDialog alertDialog = builder.create();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String uname = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                if (uname.equals("root") && psd.equals("123456")) {
                    Toast.makeText(Alert_Dialog.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(Alert_Dialog.this, "退出登录",Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();// 对话框消失
            }
        });
        alertDialog.show();
 ~~~
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/alertsuccee.png)
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/alertfailure.png)

## XML Menu
~~~
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/toast"
        android:icon="@mipmap/ic_launcher"
        android:title="普通菜单项"/>

    <item
        android:id="@+id/changecolor"
        android:title="change color">
        <menu>
            <item
                android:id="@+id/red"
                android:title="红"/>
            <item
                android:id="@+id/black"
                android:title="黑"/>
        </menu>
    </item>

    <item
        android:id="@+id/submenu"
        android:title="change size">
        <menu>
            <item
            android:id="@+id/big"
            android:title="大号字体"/>
            <item
                android:id="@+id/middle"
                android:title="中号字体"/>
            <item
                android:id="@+id/small"
                android:title="小号字体"/>
        </menu>
    </item>

</menu>
~~~
~~~
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class XML_menu extends AppCompatActivity {
    private EditText te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);
        te = (EditText) findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toast:
                Toast.makeText(this, "selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.red:
                te.setTextColor(Color.RED);
                return true;
            case R.id.black:
                te.setTextColor(Color.BLACK);
                return true;
            case R.id.big:
                te.setTextSize(30);
                return true;
            case R.id.middle:
                te.setTextSize(20);
                return true;
            case R.id.small:
                te.setTextSize(10);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
~~~
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/xmlmenuresult1.png)
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/xmlmenuresult2.png)
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/xmlmenuresult3.png)

## Action Mode
~~~
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">
<item
    android:id="@+id/item_delete"
    android:icon="@android:drawable/ic_menu_delete"
    android:title="Delete"
    android:titleCondensed="Delete"
    app:showAsAction="ifRoom|withText">
</item>
</menu>
~~~
~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <!-- 定义一个ImageView，用于作为列表项的一部分。 -->
        <ImageView
            android:id="@+id/header"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_gravity="right"
            android:paddingLeft="10dp" />
        <!-- 定义一个TextView，用于作为列表项的一部分。 -->
        <TextView
            android:id="@+id/name"
            android:layout_width="330dp"
            android:layout_gravity="center"
            android:layout_height="wrap_content"
            android:paddingLeft="10dp"
            android:textColor="#f0f"
            android:textSize="20dp" />

    </LinearLayout>
</LinearLayout>
~~~
~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout  xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Action_Mode">
    <ListView
        android:id="@android:id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout >
~~~
~~~
package com.example.ui3;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Set;

public class Action_Mode extends ListActivity {

    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
    private SelectionAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        mAdapter = new SelectionAdapter(this,
                R.layout.simple_item, R.id.name, data);
        setListAdapter(mAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int nr = 0;
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                mAdapter.clearSelection();
            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {
                    case R.id.item_delete:
                        nr = 0;
                        mAdapter.clearSelection();
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
                if (checked) {
                    nr++;
                    mAdapter.setNewSelection(position, checked);
                } else {
                    nr--;
                    mAdapter.removeSelection(position);
                }
                mode.setTitle(nr + "selected");
            }
        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {
                // TODO Auto-generated method stub
                getListView().setItemChecked(position, !mAdapter.isPositionChecked(position));
                return false;
            }
        });
    }

    private class SelectionAdapter extends ArrayAdapter<String> {
        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();
        public SelectionAdapter(Context context, int resource,
                                int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }
        public void setNewSelection(int position, boolean value) {
            mSelection.put(position, value);
            notifyDataSetChanged();
        }
        public boolean isPositionChecked(int position) {
            Boolean result = mSelection.get(position);
            return result == null ? false : result;
        }
        public Set<Integer> getCurrentCheckedPosition() {
            return mSelection.keySet();
        }
        public void removeSelection(int position) {
            mSelection.remove(position);
            notifyDataSetChanged();
        }
        public void clearSelection() {
            mSelection = new HashMap<Integer, Boolean>();
            notifyDataSetChanged();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);//let the adapter handle setting up the row views
            v.setBackgroundColor(getResources().getColor(android.R.color.background_light)); //default color
            if (mSelection.get(position) != null) {
                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));// this is a selected position so make it red
            }
            return v;
        }
    }

}
~~~
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/actionMode1.png)
![Image text](https://github.com/1158509577/UI3/blob/master/app/src/resultimage/actionMode2.png)
