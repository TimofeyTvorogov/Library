package com.example.tproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
ListView bookList;
Button del,add;
static String KEY_N;
static String KEY_A;
static String KEY_Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookList = findViewById(R.id.book_list);
        add = findViewById(R.id.add);
        del = findViewById(R.id.del_button);
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("Идиот", "Достоевский",2004,R.drawable.filler));
        bookLinkedList.add(new Book("Преступление и наказание", "Достоевский",2008,R.drawable.prestuplenie));
        bookLinkedList.add(new Book("Шинель", "Гоголь",2012,R.drawable.shinel));
        bookLinkedList.add(new Book("Основание", "Азимов", 2013, R.drawable.filler));


String[] keyArray = {"title", "author", "year", "cover"};
int[] idArray = {R.id.item_title, R.id.item_author, R.id.item_year, R.id.item_cover};



LinkedList<HashMap<String, Object>> listForAdapter = new LinkedList<>();
        for (int i = 0; i < bookLinkedList.size(); i++) {
            HashMap<String,Object> bookMap = new HashMap<>();
            bookMap.put(keyArray[0],bookLinkedList.get(i).BookTitle);
            bookMap.put(keyArray[1],bookLinkedList.get(i).BookAuthor);
            bookMap.put(keyArray[2],bookLinkedList.get(i).BookYear);
            bookMap.put(keyArray[3],bookLinkedList.get(i).BookCover);
            listForAdapter.add(bookMap);
        }
      //  ArrayAdapter<Book> adapter = new ArrayAdapter<>(this,R.layout.list_item,bookLinkedList);
       SimpleAdapter simpleAdapter = new SimpleAdapter(this,listForAdapter,R.layout.list_item,keyArray,idArray);
        bookList.setAdapter(simpleAdapter);

        ArrayList<String> annotations = new ArrayList<>();
        annotations.add("Сам ты идиот");
        annotations.add("Тварь ли я дрожащая или право имею?");
        annotations.add("Пожалейте маленького человека");
        annotations.add("Нет блин кислота");
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < bookLinkedList.size(); i++) {
map.put(bookLinkedList.get(i).BookTitle,annotations.get(i));

        }
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, AnnotationActivity.class);
                String sendAn = map.get(i).toString();
                intent.putExtra(AnnotationActivity.KEY_STRING,sendAn);


            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                String getName = getIntent().getStringExtra(KEY_N);
                String getAuthor = getIntent().getStringExtra(KEY_A);
                int getYear = getIntent().getIntExtra(KEY_Y,-1);
                bookLinkedList.add(new Book(getName,getAuthor,getYear,R.drawable.filler));
                simpleAdapter.notifyDataSetChanged();


            }
        });
        //удаление первого по списку произведения
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookLinkedList.remove(0);
                annotations.remove(0);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        simpleAdapter.notifyDataSetChanged();


    }
}