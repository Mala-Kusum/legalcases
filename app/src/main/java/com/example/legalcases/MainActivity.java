package com.example.legalcases;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.password);
        signIn=findViewById(R.id.signin);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,basicsearch.class);
                startActivity(i);
                //finish();
            }
        });
    }
}