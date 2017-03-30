package josep.com.firebaseenintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Agafar_numero extends MenuMain {
    private DatabaseReference ultim_numero;
    private Button b_agafar;
    private TextView text_ultim_numero;
    private int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agafar_numero);
        FirebaseDatabase firebase=FirebaseDatabase.getInstance();
        ultim_numero=firebase.getReference("ultim_numero");
        b_agafar= (Button) findViewById(R.id.b_agafarNumero);
        text_ultim_numero= (TextView) findViewById(R.id.text_NumFb);
        //n=0;

        b_agafar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgafarNumero(view);
            }
        });

    }

    private void AgafarNumero(View view) {
        ultim_numero.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                n=Integer.parseInt(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        n++;
//        text_ultim_numero.setText(""+n);
//        ultim_numero.setValue(""+n);
        this.setN_ultim_numero(n);
        text_ultim_numero.setText(""+this.getN_ultim_numero());
        ultim_numero.setValue(""+this.getN_ultim_numero());
    }
}
